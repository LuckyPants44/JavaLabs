package com.company;


import java.util.Comparator;

public class Person {
    private String firstName;
    private String lastName;
    private int age;

    public Person(String firstName, String lastName, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    public String GetFirstName() {
        return firstName;
    }

    public String GetLastName() {
        return lastName;
    }

    public int GetAge() {
        return age;
    }

    public String ToString() {
        return firstName + " " + lastName + " " + age;
    }

    public static class AgeComparator implements Comparator<Person> {
        public int compare(Person p1, Person p2) {
            return p1.GetAge() - p2.GetAge();
        }
    }

    public static class NameComparator implements Comparator<Person> {
        public int compare(Person p1, Person p2) {
            return (p1.GetFirstName() + p1.GetLastName()).compareTo((p2.GetFirstName() + p2.GetLastName()));
        }
    }
}
