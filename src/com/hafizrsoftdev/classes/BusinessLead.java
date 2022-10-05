package com.hafizrsoftdev.classes;

import java.util.ArrayList;

import com.hafizrsoftdev.classes.interfaces.CanManageAccountant;
import com.hafizrsoftdev.classes.interfaces.CanSupportTeam;

public class BusinessLead extends BusinessEmployee implements CanManageAccountant {
	
//	CLASS FIELD
	private int employeeID;
	private String name;
	private double baseSalary;
    private final byte headCount;
    private double bonusBudget;
    private ArrayList<CanSupportTeam> directReport;
   
//	CONSTRUCTOR METHOD
    public BusinessLead (String name){
    	this.employeeID = Employee.assignID();
	    this.name = name;
	    this.baseSalary = super.baseSalary*(2);
	    this.headCount = 10;
	    this.directReport = new ArrayList<>();
    }

//  EMPLOYEE INHERITED CLASS METHODS: 05 
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
    
//  BUSINESS LEAD CLASS METHODS: TOTAL - 07
    public boolean hasHeadCount() {
        return (directReport.size() < headCount);
    }
	
    @Override
	public boolean addReport(Accountant e, TechnicalLead supportTeam) {
    	if(this.hasHeadCount()) {
    		this.directReport.add(e);
    		this.bonusBudget += e.getBaseSalary()/10 * 11;
    		e.supportTeam(supportTeam);
    	return true;	
    	}else
    		return false;
    }
    
    public boolean requestBonus(Employee e, double bonus) {
        boolean reqBonus;
        if(e.getManager().equals(this)) {
        	if(20%(this.getBonusBudget()) >= bonus) {
                this.setBonusBudget(this.bonusBudget-=bonus);
                e.setBonus(bonus);
                reqBonus = true;
                System.out.println("Bonus Budget have been Approved by Business Lead ID: " 
        				+ this + "\nThank you!");
            } else {
            	System.out.println("Max Bonus Amount allowed: 20% of bonusBudget.");
            	reqBonus = false;
            }
        }else {
        	System.out.println("Employee does not report to " + this);
        	reqBonus = false;
        }
        return reqBonus;
    }
      
    public boolean approveBonus(Employee e,double bonus) {
    	Accountant e_Accountant = (((TechnicalLead) e.getManager()).getAccountant());
    	boolean bonusApproved = e_Accountant.approveBonus(bonus);
    	double bonusBudget_Pre_Deduction = e_Accountant.getBonusBudget();
    	
    	if(this.directReport.contains(e_Accountant) 
    			&& bonusApproved == true) {
    		double bonusAwarded = e.getBonus() + bonus;
			double bonusBudget_Post_Deduction = (bonusBudget_Pre_Deduction - bonus);
			e.setBonus(bonusAwarded);
			e_Accountant.setBonusBudget(bonusBudget_Post_Deduction);
    		System.out.println("Bonus have been Approved by Business Lead: (" + this + ")"
    				+ "\n (" + e + ") awarded" + e.getBonus() 
    				+ "\nRevised Bonus Budget of (" + e_Accountant + ") from" 
    				+ bonusBudget_Pre_Deduction + " to: " + e_Accountant.getBonusBudget()  
    				+ "\nThank you!");
    		
    	}else if(bonusApproved == false) 
    		System.out.println("Bonus Budget was not Approved by Business Lead (" 
    				+ this + ") \nMax Bonus Amount allowed is 20% of accountant's bonusBudget: "
    				+ 20%(bonusBudget_Pre_Deduction));
    	
    	else
    		System.out.println("Bonus Budget not managed by this Finance Team.");
    	
    	return bonusApproved;
    }
    
    public StringBuffer getTeamStatus() {
    	StringBuffer toPrint = new StringBuffer();
    	if (!this.directReport.isEmpty()){
    		toPrint.append(this.employeeStatus() + " and is managing:\n");
    		for(CanSupportTeam accountant:directReport) {
    			toPrint.append(((Accountant)accountant).employeeStatus() + "\n");
    		}
    	}else {
    		toPrint.append(this.employeeStatus() + " and no direct reports yet.");
    	}	
    	return toPrint;
    }
	
    @Override
    public double getBonusBudget () {
    	return this.bonusBudget;
    }
    
    public void setBonusBudget(double bonusBudget){
        this.bonusBudget = bonusBudget;
    }
    
}
