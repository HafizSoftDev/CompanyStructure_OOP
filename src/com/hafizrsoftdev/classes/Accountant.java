package com.hafizrsoftdev.classes;

import com.hafizrsoftdev.classes.interfaces.CanBeSupported;
import com.hafizrsoftdev.classes.interfaces.CanCheckInCode;
import com.hafizrsoftdev.classes.interfaces.CanManageAccountant;
import com.hafizrsoftdev.classes.interfaces.CanSupportTeam;

public class Accountant extends BusinessEmployee implements CanSupportTeam{ 
	
//	CLASS FIELD
	private int employeeID;
	private String name;
	private double baseSalary;
	private double bonusBudget;
    private CanBeSupported teamSupported;
    private CanManageAccountant manager;

//  CONSTRUCTOR METHOD
    public Accountant (String name){
    	this.employeeID = Employee.assignID();
        this.name = name;
        this.baseSalary = super.baseSalary;
    }

//  EMPLOYEE INHERITED CLASS METHODS: TOTAL - 07 
    @Override
    public boolean equals(Employee other) {
        return this.employeeID == (other).getEmployeeID();
    }

    @Override
    public String toString() {
        return this.employeeID + " " + this.name;
    }

    @Override
    public String employeeStatus() {
    	if (this.getTeamSupported() == null)
    		return (this.employeeID + " " + this.name + " with a budget of " + this.bonusBudget 
            		+ " is not supporting any Technical Lead");
    	else
    		return (this.employeeID + " " + this.name + " with a budget of " + this.bonusBudget 
    				+ " is supporting the following Technical Lead's: " + this.getTeamSupported());
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
    
//	BUSINESS EMPLOYEE CLASS METHOD: TOTAL - 01
	@Override
	public double getBonusBudget() {
		return this.bonusBudget;	
	}
	
//	ACCOUNTANT CLASS METHOD: TOTAL - 05
	public void supportTeam(TechnicalLead lead) {
		if(this.getTeamSupported() == null) {
			this.teamSupported = lead;
			lead.setAccountant(this);
			for(CanCheckInCode engineer:lead.getDirectReport()) 
				this.bonusBudget += ((SoftwareEngineer) engineer).getBaseSalary() *1.1;	
		}else
			System.out.println("\n(" + this + ") is already supporting a Technical Lead."
					+ "\nKindly reassign to an available Accountant.");		
	}
	
	public boolean approveBonus (double bonus) {
		boolean bonusApproved = false;
		if(this.getTeamSupported() == null)
			System.out.println("\nAccountant ID: " + this + "is not assigned any supportTeam." 
								+ "\nKindly consult Business Lead for official assignment of "
								+ "Technical Lead;support Team.");
		else if (20%(this.getBonusBudget()) >= bonus) {
			System.out.println("Bonus Amount of " + bonus + " is approved by (" + this + ")");
			bonusApproved = true;
		}
		else {
			System.out.println("Max Bonus Amount allowed: 20% of bonusBudget.");
			bonusApproved = false;
		}
		return bonusApproved;
	}
	
	public TechnicalLead getTeamSupported() {
		return (TechnicalLead) this.teamSupported;
	}
	
	public void setBonusBudget(double bonusBudget) {
		this.bonusBudget = bonusBudget;	
	}
	
	public void setManager(BusinessLead manager) {
		this.manager = manager;
	}
}




