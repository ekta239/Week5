package com.advanceproblems.validatecsvdata;

import com.opencsv.bean.CsvBindByName;

public class Student   {
    @CsvBindByName(column = "ID")
private int id;

@CsvBindByName(column = "Name")
private String name;

@CsvBindByName(column = "Age")
private int age;

@CsvBindByName(column = "Marks")
private int marks;

public String toString() {
    return "Student{ID=" + id + ", Name='" + name + "', Age=" + age + ", Marks=" + marks + "}";
}
}{
}
