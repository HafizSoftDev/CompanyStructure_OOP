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
	    this.baseSalary = BusinessEmployee.baseSalary*(2);
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
    	boolean directReportAdded = false;
    	if(this.hasHeadCount() && !(this.directReport.contains(e))) {
    		this.directReport.add(e);
    		this.bonusBudget += e.getBaseSalary()/100 * 110;
    		e.supportTeam(supportTeam);
    		e.setManager(this);
    		directReportAdded = true;	
    	}else if(this.hasHeadCount() && this.directReport.contains(e)) {
    		System.out.println("Unable to addReport: Accountant exists in BuinessLead's DirectReport List!"
    				+ "\nAssignment of supportTeam to Accountant is still in effect.");
    		e.supportTeam(supportTeam);
    		directReportAdded = false;
    	}else
    		System.out.println("HeadCount Avaibility => " + this.hasHeadCount());
    	return directReportAdded;
    }
        
    public boolean requestBonus(Employee e, double bonus) {
        boolean reqBonus;
        double bonusBudget_Pre_Deduction = this.getBonusBudget();
        
        if(e.getManager().equals(this)) {
        	double accountantBonusCap = e.getBaseSalary()/100 *110;
        	double existingBonus = e.getBonus();
			double eligibleBonusAmount = accountantBonusCap - existingBonus;
        	
        	if(eligibleBonusAmount >= bonus) {
                this.setBonusBudget(this.bonusBudget-=bonus);
                e.setBonus(e.getBonus() + bonus);
                reqBonus = true;
                
                System.out.println("\n(Accountant) " + e + " awarded bonus amount of " 
        				+ CurrencyConverter.convertToCurrency(e.getBonus()) + " [Bonus granted by (BusinessLead) " + this + "]"
        				+ "\n(BusinessLead) " + this 
        				+ " [Revised Bonus Budget: " + CurrencyConverter.convertToCurrency(bonusBudget_Pre_Deduction) 
        				+ " => " + CurrencyConverter.convertToCurrency(this.getBonusBudget()) + "]");
            } else {
            	System.out.println("\nRequest of Bonus Amount of " + CurrencyConverter.convertToCurrency(bonus) 
        		+ " rejected. \nEmployee's Bonus Amount accrued cannot exceed 110% of baseSalary.");
            	reqBonus = false;
            }
        }else {
        	System.out.println("/nEmployee does not report to " + this);
        	reqBonus = false;
        }
        return reqBonus;
    }
      
    public boolean approveBonus(Employee e,double bonus) {
    	boolean bonusGranted = false;
    	double engineerBonusCap = e.getBaseSalary()/100 *110;
    	
    	if(engineerBonusCap < e.getBonus() + bonus)
    		System.out.println("\nRequest of Bonus Amount of " + CurrencyConverter.convertToCurrency(bonus) 
    		+ " rejected. \nEmployee's Bonus Amount accrued cannot exceed 110% of baseSalary.");
    	
    	else if(e.getManager() != null) {
    		Accountant e_Accountant = (((TechnicalLead) e.getManager()).getAccountant());	
        	boolean bonusApproved = e_Accountant.approveBonus(bonus);
        	double bonusBudget_Pre_Deduction = e_Accountant.getBonusBudget();    
        	
        	if(this.directReport.contains(e_Accountant) && bonusApproved == true) {
        		double bonusAwarded = e.getBonus() + bonus;
    			double bonusBudget_Post_Deduction = (bonusBudget_Pre_Deduction - bonus);
    			e.setBonus(bonusAwarded);
    			e_Accountant.setBonusBudget(bonusBudget_Post_Deduction);
    			
        		System.out.println("\n(SoftwareEngineer) " + e + " awarded bonus amount of " 
        				+ CurrencyConverter.convertToCurrency(e.getBonus()) + " [Bonus granted by (BusinessLead) " + this + "]"
        				+ "\n(Accountant) " + e_Accountant 
        				+ " [Revised Bonus Budget: " + CurrencyConverter.convertToCurrency(bonusBudget_Pre_Deduction) 
        				+ " => " + CurrencyConverter.convertToCurrency(e_Accountant.getBonusBudget()) + "]");
        		bonusGranted = true;        	
        	}
    	}else
    		System.out.println("\nBonus Budget not managed by this Finance Team.");
    	return bonusGranted;
    }
    
	public StringBuffer getTeamStatus() {
    	StringBuffer toPrint = new StringBuffer();
    	if (!this.directReport.isEmpty()){
    		toPrint.append(this.employeeStatus() + " and is managing:\n\n");
    		for(CanSupportTeam accountant:directReport) {
    			toPrint.append(((Accountant)accountant).employeeStatus()+"\n");
    		}
    	}else {
    		toPrint.append(this.employeeStatus() + " and no direct reports yet.");
    	}	
    	return toPrint;
    }
	
    public ArrayList<CanSupportTeam> getDirectReport() {
		return directReport;
	}
    
    @Override
    public double getBonusBudget () {
    	return this.bonusBudget;
    }
    
    public void setBonusBudget(double bonusBudget){
        this.bonusBudget = bonusBudget;
    }

}
