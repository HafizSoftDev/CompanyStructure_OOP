package com.hafizrsoftdev.classes;

import com.hafizrsoftdev.classes.interfaces.CanCheckInCode;
import com.hafizrsoftdev.classes.interfaces.CanManageEngineer;

public class SoftwareEngineer extends TechnicalEmployee implements CanCheckInCode{

//  CLASS FIELD
	private int employeeID;
	private String name;
	private double baseSalary;
	private int successfulCheckIns;
    private boolean codeAccess;
    private CanManageEngineer manager;

//  CONSTRUCTOR METHOD
    public SoftwareEngineer(String name) {
        this.name = name;
        this.baseSalary = TechnicalEmployee.baseSalary;
        this.employeeID = Employee.assignID();
    }

    
//  EMPLOYEE INHERITED CLASS METHODS: TOTAL - 06
    @Override
    public boolean equals(Employee other) {
        return this.employeeID == other.getEmployeeID();
    }

    @Override
    public String toString() {
        return this.employeeID + " " + this.name;
    }

    @Override
    public int getEmployeeID() {
    	return this.employeeID;
    }

    @Override
    public String getName() {
    	return this.name;
    }
    
    @Override
    public double getBaseSalary() {
    	return this.baseSalary;
    }
    
    @Override
    public Employee getManager() {
        return (Employee)this.manager;
    }
    
    
//  SOFTWARE ENGINEER CLASS METHODS: TOTAL - 06
    @Override
    public boolean checkInCode() {
    	if(this.manager.approveCheckIn(this)) {
    		this.setSuccessfulCheckIns(getSuccessfulCheckIns() + 1);;
    		return true;
    	}else {
    		this.setCodeAccess(false);
    		return false;
    	}
    }
	
    @Override
	public int getSuccessfulCheckIns() {
        return this.successfulCheckIns;
    }
        
    public boolean getCodeAccess() {
        return this.codeAccess;
    }
    
    public void setManager(TechnicalLead manager) {
		this.manager = manager;
	}

    /*
	 * setCodeAccess(boolean access) 
	 * Should allow an external piece of code to update the SoftwareEngineer's code privileges 
	 * to either true or false
	 */
    public void setCodeAccess(boolean access) {
        if (access) 
        	this.codeAccess = true;
        else
        	this.codeAccess = false;
    }

    private void setSuccessfulCheckIns(int successfulCheckIns) {
    	this.successfulCheckIns = successfulCheckIns;
    }
    
}
