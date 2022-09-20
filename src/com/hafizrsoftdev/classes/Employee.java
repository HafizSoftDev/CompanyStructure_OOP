package com.hafizrsoftdev.classes;

import java.util.ArrayList;

/**
 * Created by Hafiz on 3/4/2022.
 */
public abstract class Employee {
    ArrayList<Employee> directReport;
    ArrayList<TechnicalLead>accountSupportList;
    String name;
    int ID;
    double baseSalary;
//  Constructor Method
//    public Employee(String n, int i, double sal, String mgmt) {
//    this.name = n;
//    this.ID = i;
//    this.baseSalary = sal;
//    this.manager = mgmt;
//    }
//    Overall SuperClass Methods : 7 total
    abstract double getBaseSalary();
    abstract double setBaseSalary(double amendBaseSalary);
    abstract String getName();
    abstract int getEmployeeID();
    abstract Employee getManager();
    abstract boolean equals (Employee other);
    abstract public String toString();
    abstract String employeeStatus();
//    End of SuperClass Methods

}
