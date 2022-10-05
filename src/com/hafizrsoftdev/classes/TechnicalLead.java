package com.hafizrsoftdev.classes;

import java.util.ArrayList;

import com.hafizrsoftdev.classes.interfaces.CanBeSupported;
import com.hafizrsoftdev.classes.interfaces.CanCheckInCode;
import com.hafizrsoftdev.classes.interfaces.CanManageEngineer;

public class TechnicalLead extends TechnicalEmployee implements CanManageEngineer, CanBeSupported{ 
	
//  CLASS FIELD
	private int employeeID;
	private String name;
	private double baseSalary;
	private int successfulCheckIns;
	private final byte headCount;
	private Accountant accountant;
    private ArrayList<CanCheckInCode> directReport;

//  CONSTRUCTOR METHOD
    public TechnicalLead(String name) {
        this.name = name;
        this.employeeID = Employee.assignID();
        this.baseSalary = super.baseSalary * 1.3;
        this.headCount = 4;
        this.directReport = new ArrayList<>(4);
    }
    
//  EMPLOYEE INHERITED CLASS METHODS: TOTAL - 05
    @Override
    public boolean equals(Employee other) {
        return this.employeeID == (other).getEmployeeID();
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
    	return name;
    }
    
    @Override
    public double getBaseSalary() {
    	return baseSalary;
    }

//  TECHNICAL EMPLOYEE INHERITED CLASS METHODS: TOTAL - 01    
    @Override
	public int getSuccessfulCheckIns() {
		return this.successfulCheckIns;
	}
    
//  TECHNICAL LEAD CLASS METHODS: TOTAL - 09
    public boolean hasHeadCount() {
        return (directReport.size() < headCount);
    }
    
    @Override
    public boolean addReport(SoftwareEngineer e) {
    	boolean addedToReport = false;
    	if (e.getManager() == null && this.hasHeadCount()) {
        	directReport.add(e);
        	e.setManager(this);
            addedToReport = true;
            
        }else if(e.getManager() != null)
        	System.out.println("Software Engineer (" + e + ")  has already been assigned to manager; "
        					+ "(" + e.getManager() + ").");
        else
        	System.out.println(this.toString() + " has reached max headcount of " + this.headCount
        					+	"\nUnable to add [" + e + "] as Direct Report to Technical Lead."); 	
    	
    	return addedToReport;
    }
    
    public boolean approveCheckIn(SoftwareEngineer e) {
        return (directReport.contains(e) && e.getCodeAccess());
    }
	
    public boolean requestBonus(Employee e, double bonus) {
    	boolean bonusGranted = false;
    	BusinessLead businessManager = (BusinessLead) this.getAccountant().getManager();
    	bonusGranted = businessManager.approveBonus(e, bonus);
    	return bonusGranted;
    }
    
    public StringBuffer getTeamStatus() {
    	StringBuffer toPrint = new StringBuffer();
    	if (!this.directReport.isEmpty()){
    		toPrint.append(this.employeeStatus() + " and is managing:\n");
    		for(CanCheckInCode engineer:directReport)
    			toPrint.append(((SoftwareEngineer)engineer).employeeStatus() + "\n");
    	
    	}else
    		toPrint.append(this.employeeStatus() + " and no direct reports yet.");
    		
    	return toPrint;
    }    
        
    public ArrayList<CanCheckInCode> getDirectReport() {
        return this.directReport;
    }

    public Accountant getAccountant() {
        return this.accountant;	
    } 
    
    public void setSuccessfulCheckIns(int successfulCheckIns) {
    	this.successfulCheckIns = successfulCheckIns;
    }

    public void setAccountant(Accountant accountant) {
    	this.accountant = accountant;
    }
}
