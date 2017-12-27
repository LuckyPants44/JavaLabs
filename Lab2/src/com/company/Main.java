package com.company;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        ArrayList<Person> people = new ArrayList<>();
        people.add(new Person("Alexander","Ivanov",34));
        people.add(new Person("Alexander","Baranov",35));
        people.add(new Person("Vladislav","Abaramov",22));

        Person.AgeComparator ageComparator = new Person.AgeComparator();
        Person.NameComparator nameComparator = new Person.NameComparator();

        people.sort(nameComparator);
        Show(people);
        people.sort(ageComparator);
        Show(people);
    }

    public static void Show(ArrayList<Person> p){
        for(int i=0;i<p.size();i++){
            System.out.println(p.get(i).ToString());
        }
        System.out.println();
    }
}
