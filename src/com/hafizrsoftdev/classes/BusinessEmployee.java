package com.hafizrsoftdev.classes;

public abstract class BusinessEmployee extends Employee{
	
//  CLASS FIELD
	protected double baseSalary = 50000;
    
//	BUSINESS EMPLOYEE CLASS METHODS: TOTAL - 01
	abstract double getBonusBudget();
	
//  EMPLOYEE INHERITED CLASS METHODS: TOTAL - 01
    @Override
    public String employeeStatus() {
    	return (this.getEmployeeID() + " " + this.getName() 
    			+ " with a budget of " +  this.getBonusBudget());	
    }
}

