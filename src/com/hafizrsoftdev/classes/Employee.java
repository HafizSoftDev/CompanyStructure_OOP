package com.hafizrsoftdev.classes;

public abstract class Employee {
	
//  CLASS FIELD
	private static int id;
	private double bonus;

//  EMPLOYEE CLASS METHODS: TOTAL - 10
    abstract boolean equals (Employee other);
    abstract public String toString();
    abstract String employeeStatus();
    abstract int getEmployeeID();
    abstract String getName();
    abstract double getBaseSalary();
    
	public Employee getManager() {
    	return null;
    }
	
    public double getBonus() {
		return bonus;
	}
    
	public void setBonus(double bonus) {
		this.bonus = bonus;
	}
	
	public static int assignID() {
		return Employee.id += 1;
	}

}
