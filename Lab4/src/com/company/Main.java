package com.company;
import java.math.BigDecimal;
import java.util.*;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import java.io.*;

public class Main {

    public static void main(String[] args) {
        int month;
        int amount;
        double procent;
        Calendar date = Calendar.getInstance();
        Scanner reader = new Scanner(System.in);  // Reading from System.in

        System.out.println("Введите количество месяцев:");
        month = reader.nextInt();
        System.out.println("Введите сумму кредита:");
        amount = reader.nextInt();
        System.out.println("Введите процентную ставку:");
        procent = reader.nextDouble();
        Schedule[] schedules = AddInShedule(month, amount, procent, date);
        ArrayList<Schedule> scheduleArrayList = new ArrayList<>(Arrays.asList(schedules));
        ExportList(scheduleArrayList);
    }

    private static void ExportList(ArrayList<Schedule> scheduleArrayList){
        Workbook book = new HSSFWorkbook();
        Sheet sheet = book.createSheet();
        Row row = sheet.createRow(0);
        row.createCell(0).setCellValue("Date:");
        row.createCell(1).setCellValue("Amount");
        row.createCell(2).setCellValue("Payment:");

        for (int i=0;i<scheduleArrayList.size();i++) {
            row = sheet.createRow(i+1);

            row.createCell(0).setCellValue(scheduleArrayList.get(i).getDate().toString());
            row.createCell(1).setCellValue(scheduleArrayList.get(i).getAmount().floatValue());
            row.createCell(2).setCellValue(scheduleArrayList.get(i).getPayment().floatValue());
        }

        sheet.autoSizeColumn(0);
        sheet.autoSizeColumn(1);
        sheet.autoSizeColumn(2);

        try (FileOutputStream f = new FileOutputStream("Schedule.xls")) {
            book.write(f);
        }
        catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    private static Schedule[] AddInShedule(int month, int amount, double procent, Calendar date) {
        BigDecimal[] debt = new BigDecimal[month];
        BigDecimal[] debtProcents = new BigDecimal[month];
        BigDecimal[] mainDebt = new BigDecimal[month];
        BigDecimal[] payment = new BigDecimal[month];
        Calendar[] paymentDates = new Calendar[month];
        Schedule[] schedules = new Schedule[month];

        for (int i = 0; i < month; i++) {
            if (i == 0) {
                debt[i] = BigDecimal.valueOf(amount);
                debtProcents[i] = BigDecimal.valueOf(((double) amount / month) * procent);
                paymentDates[i] = date;

            } else {
                debt[i] = BigDecimal.valueOf(debt[i - 1].doubleValue() - mainDebt[i - 1].doubleValue());
                debtProcents[i] = BigDecimal.valueOf((debt[i].doubleValue() / month) * procent);
                paymentDates[i] = paymentDates[i - 1];
            }
            paymentDates[i].add(Calendar.MONTH, 1);
            mainDebt[i] = BigDecimal.valueOf((double) amount / month);
            payment[i] = BigDecimal.valueOf(mainDebt[i].doubleValue() + debtProcents[i].doubleValue());

            schedules[i] = new Schedule(paymentDates[i].getTime(),debt[i],payment[i]);
        }
        return schedules;
    }
}