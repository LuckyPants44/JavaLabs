package com.company;

import java.math.BigDecimal;
import java.util.Date;

public class Schedule {
    private Date date;
    private BigDecimal amount;
    private BigDecimal payment;

    public Schedule(Date date, BigDecimal amountOd, BigDecimal amountPvc) {
        this.date = date;
        this.amount = amountOd;
        this.payment = amountPvc;
    }

    public Date getDate() {
        return date;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public BigDecimal getPayment() {
        return payment;
    }
}
