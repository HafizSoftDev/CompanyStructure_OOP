package com.hafizrsoftdev.classes;

import java.util.ArrayList;

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
        this.baseSalary = BusinessEmployee.baseSalary;
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
    		return (this.employeeID + " " + this.name + " with a budget of " + CurrencyConverter.convertToCurrency(this.bonusBudget) 
            		+ " is not supporting any Technical Lead" + "\n");
    	else
    		return (this.employeeID + " " + this.name + " with a budget of " + CurrencyConverter.convertToCurrency(this.bonusBudget) 
    				+ " is supporting the following Technical Lead's: " + this.getTeamSupported() + "\n");
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
	
//	ACCOUNTANT CLASS METHOD: TOTAL - 09
	public void supportTeam(TechnicalLead lead) {
		Accountant lead_FormerAccountant = lead.getAccountant();
		TechnicalLead currentTechLead = this.getTeamSupported();
		
		if(lead_FormerAccountant != null) { //exchange bonusBudget between Accountants
			double lead_FormerBonusBudget = lead_FormerAccountant.bonusBudget;
			this.teamSupported = lead;
			lead_FormerAccountant.bonusBudget = this.bonusBudget;
			this.bonusBudget = lead_FormerBonusBudget;
			lead.setAccountant(this);

			lead_FormerAccountant.teamSupported = currentTechLead;
			currentTechLead.setAccountant(lead_FormerAccountant);
			
		}else if(currentTechLead != null && !this.tallyAccountantBonusBudget()) { //Prevents dropping bonusBudget w existing transaction.
			System.out.println("\nTransactions have already been made to the existing bonusBudget account."
					+ "\nKindly assign a TechnicalLead that has an existing Accountant "
					+ "to facilitate swapping of bonusBudget account.");		
		}else {
			this.bonusBudget = 0;
			this.teamSupported = null;
			setupBonusBudgetAccount(lead,this.teamSupported == null);		
		}
	}
	
	public boolean approveBonus (double bonus) {
		boolean bonusApproved = true;
		double engineerBonusCap = this.getTeamSupported().getBaseSalary()/130 *110;
		TechnicalLead teamSupported = this.getTeamSupported();
		
		if(teamSupported == null) { 
			System.out.println("\nAccountant ID: " + this + "is not assigned any supportTeam." 
								+ "\nKindly consult Business Lead for official assignment of "
								+ "Technical Lead;support Team.");
			bonusApproved = false;
		}else if(engineerBonusCap < bonus) {
			System.out.println("Bonus amount proposed cannot exceed 110% of baseSalary");
			bonusApproved = false;
			
		}else{
			ArrayList<CanCheckInCode> engineers = this.getTeamSupported().getDirectReport();
			ArrayList<String> myString = new ArrayList<String>();
			boolean[] bonusEligible = new boolean[engineers.size()];
			
			System.out.println("\nValidate Bonus Eligibility for (SoftwareEngineer) teamSupported by (Accountant) " + this + ":");

			for(int i = 0; i < engineers.size(); i++) {
				String sample;
				double existingBonus = ((SoftwareEngineer)engineers.get(i)).getBonus();
				double eligibleBonusAmount = engineerBonusCap - existingBonus;
				
				
				if (eligibleBonusAmount < bonus) {
					sample = ((SoftwareEngineer)engineers.get(i)) + " (False) *Bonus_Limit: " + CurrencyConverter.convertToCurrency(eligibleBonusAmount);
					bonusEligible[i] = false;
				}else {
					sample = ((SoftwareEngineer)engineers.get(i)) + " (True)";
					bonusEligible[i] = true;
				}
					
				myString.add(sample);
			}
		
			for(String testString:myString) {
				if(myString.indexOf(testString) == 0) {
					System.out.print("[");
				}
				if(myString.indexOf(testString) == myString.size()-1)
					System.out.print(testString);
				else
					System.out.println(testString + ", ");
			}
			System.out.println("]");
			bonusApproved = true;
		}
		return bonusApproved;
	}
	
	public TechnicalLead getTeamSupported() {
		return (TechnicalLead) this.teamSupported;
	}
	
	public void setTeamSupported(TechnicalLead lead) {
		this.teamSupported = lead;
	}
	
	public void setBonusBudget(double bonusBudget) {
		this.bonusBudget = bonusBudget;	
	}
	
	public void setManager(BusinessLead manager) {
		this.manager = manager;
	}
	
	private void setupBonusBudgetAccount(TechnicalLead lead, boolean teamNotSupported) {
		if (teamNotSupported == true) {
			this.teamSupported = lead;
			lead.setAccountant(this);
			for(CanCheckInCode engineer:lead.getDirectReport()) 
				this.bonusBudget += ((SoftwareEngineer) engineer).getBaseSalary() *1.1;
		}else 
			System.out.println("Unable to Setup Bonus Budget Account. TechnicalTeam is already supported by another accountant.");
	}
	
	private boolean tallyAccountantBonusBudget() {
		double designatedBonusBudget = 0;									
		for(CanCheckInCode engineer: this.getTeamSupported().getDirectReport()) 
			designatedBonusBudget += ((SoftwareEngineer)engineer).getBaseSalary() * 1.1;
		System.out.println("\nTally Accountant's BonusBudget account: ");
		System.out.println("Designated Bonus Budget = " + CurrencyConverter.convertToCurrency(designatedBonusBudget));
		System.out.println("Current Bonus Budget = " + CurrencyConverter.convertToCurrency(this.bonusBudget));
		if (this.bonusBudget == designatedBonusBudget) {
			return true;
		}else		
			return false;
		
	}
}




