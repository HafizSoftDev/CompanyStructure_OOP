package com.hafizrsoftdev.classes;

public abstract class TechnicalEmployee extends Employee{
	
//  CLASS FIELD
	final static double baseSalary = 75000;
    
//	TECHNICAL EMPLOYEE CLASS METHODS: TOTAL - 01	
    abstract int getSuccessfulCheckIns();
    
//  EMPLOYEE INHERITED CLASS METHODS: TOTAL - 01
    @Override
    public String employeeStatus() {
    	return (this.getEmployeeID() + " " + this.getName() + " has " 
			+  this.getSuccessfulCheckIns() + " successful check ins");
    }
}