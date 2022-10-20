package com.hafizrsoftdev.classes;
import java.util.ArrayList;
import java.util.Collection;

import com.hafizrsoftdev.classes.interfaces.CanCheckInCode;

public class CompanyStructure extends EmployeeGenerator{

    public static void main(String[] args) {   			
    	printHeader("CREATE STRUCTURE AND ASSIGN RELATIONSHIPS WITH CLASS METHODS");
    	createReportingStructure();
    	setCodeAccessForReportingEngineers();
    	printHeader("SIMULATE CHECK-IN CODE ATTEMPT BY ENGINEERING TEAM");
    	simulateCheckInCode();
      	printHeader("SIMULATE BONUS REQUISITION FOR BLUE COLLARED EMPLOYEES");
      	simulateBonusRequest();
      	
      	System.out.println("\nFINANCE TEAM BONUS BUDGET");
      	System.out.println(CFO.getTeamStatus());
      	
      	System.out.println("SOFTWARE ENGINEER BONUSES");
      	for(var engineer: list_Of_SoftwareEngineers)
      		System.out.println(engineer + " " + CurrencyConverter.convertToCurrency(engineer.getBonus()));

      	System.out.println("\nACCOUNTANT BONUSES");
      	for(var accountant: list_Of_Accountants) 
      		System.out.println(accountant + " " + CurrencyConverter.convertToCurrency(accountant.getBonus()));
      	
    }
   
//	Functional Methods
    public static void setCodeAccessForReportingEngineers() {
		for (TechnicalLead lead:list_Of_TechnicalLeads)
			grantCodeAccess(lead);
	}    
    
    public static void simulateCheckInCode() {
    	for(var engineer:list_Of_SoftwareEngineers) {
    		for(int i = 0; i < NumberGenerator.generateByte_0_To_99(); i++) 
    			engineer.checkInCode();
    		((TechnicalLead)engineer.getManager()).setSuccessfulCheckIns(NumberGenerator.generateByte_0_To_99());
    	}
    	printTechnicalTeamStatuses();
    	printHorizontalRule();
	}
    
    public static void simulateBonusRequest() {
    	generateEngineerBonus(list_Of_SoftwareEngineers);
    	generateAccountantBonus(list_Of_Accountants);
    	printHorizontalRule();
    }

/*
 * Team Assignments 
 * 1. Assignment of Software Engineer to TechnicalLead. 
 * 2. Assign 01 x TechnicalLead to each Accountant.
 * 3. Assign Accountants to BusinessLead [head count = 10 max]
 */
    public static void createReportingStructure() {
//  Assignment of Software Engineer to Technical Leads
    	vpeOne.addReport(sweOne,sweTwo,sweThree,sweFour); //TechTeam One 
    	vpeTwo.addReport(sweFive, sweSix, sweSeven, sweEight);	//TechTeam Two
    	vpeThree.addReport(sweNine, sweTen, sweEleven, sweTwelve); //TechTeam Three
    	vpeFour.addReport(sweThirteen, sweFourteen, sweFifteen, sweSixteen); //TechTeam Four
    	
//  Assignment of Accountant to BusinessLead and (TechnicalLead)SupportTeam       
        CFO.addReport(acctA, vpeOne);
        CFO.addReport(acctB, vpeTwo);
        CFO.addReport(acctC, vpeThree);
        CFO.addReport(acctD, vpeFour);

//  Add to ArrayList of EmployeeTypes except for BusinessLead
        generateEmployeeTypeList();
        
//  Display Technical Team Assignments with .getTeamStatus() method.
    	System.out.println("ASSIGNMENT OF TECHNICAL TEAM:"); 
        printTechnicalTeamStatuses();
    
//  Display accountant.teamSupported assignments with .employeeStatus() method.
        System.out.println("\nASSIGNMENT OF ACCOUNTANT TO SUPPORT TEAM:");
        printAccountantEmployeeStatuses();
        
//  Display businessLead.directReport assignments with .getTeamStatus() method.
        System.out.println("\nASSIGNMENT OF ACCOUNTANT TO BUSINESSLEAD's DIRECT REPORT:");
        System.out.println("\n" + CFO.getTeamStatus());
        printHorizontalRule();
    }
    	    	    
	public static void grantCodeAccess(TechnicalLead lead) {
		boolean access;
		for(CanCheckInCode engineer:lead.getDirectReport()) {
			access = reportsToTechLead(((SoftwareEngineer)engineer), lead);
			((SoftwareEngineer)engineer).setCodeAccess(access);
		}
	}    
    
//	Auxiliary Methods	
	@SuppressWarnings("unchecked")
	public static void generateEmployeeTypeList() {    	
		var accountantList = CFO.getDirectReport();
//		ArrayList of Accountants
		list_Of_Accountants.addAll((Collection<? extends Accountant>) accountantList);

//		ArrayList of TechnicalLeads		
    	for(Accountant accountant:list_Of_Accountants)
    		list_Of_TechnicalLeads.add(accountant.getTeamSupported());
    	
//		ArrayList of SoftwareEngineers 	
    	for(TechnicalLead techLead:list_Of_TechnicalLeads)
    		list_Of_SoftwareEngineers.addAll((Collection<? extends SoftwareEngineer>)techLead.getDirectReport());	
    	
	}

	public static void generateEngineerBonus(ArrayList<SoftwareEngineer> engineers) {
		System.out.println("**BONUS REQUEST FOR SOFTWARE ENGINEERS\n");
		int bonusRequestCount = 0;
		boolean bonusRequested = true;
		double engineerBaseSalary = TechnicalEmployee.baseSalary;
		double engineerBonusCap = engineerBaseSalary/100 * 110; //
		
		while(bonusRequested == true) {
			for(int i=0; i < engineers.size(); i++) {
				bonusRequestCount += 1;
				double bonusGenerated = NumberGenerator.generateDouble_0_To_99000();
				Employee manager = engineers.get(i).getManager();
				
				while(bonusGenerated < engineerBaseSalary || bonusGenerated > engineerBonusCap)
					bonusGenerated = NumberGenerator.generateDouble_0_To_99000();
				
				System.out.println("(SoftwareEngineer) #Bonus_Request No. " + bonusRequestCount + "\n");
				System.out.println("Bonus Amount Requested : " + CurrencyConverter.convertToCurrency(bonusGenerated)
							+ "\nEmployee to receive bonus: (SoftwareEngineer) " + engineers.get(i));
	    		bonusRequested = ((TechnicalLead)manager).requestBonus(engineers.get(i), bonusGenerated);
	    		if(bonusRequested == false) {
	    			printTransactionDivider();
	    			break;
	    		}
	    		printTransactionDivider();
			}
		}
	}

	public static void generateAccountantBonus(ArrayList<Accountant> accountants) {
		System.out.println("**BONUS REQUEST FOR ACCOUNTANTS\n");
		int bonusRequestCount = 0;
		boolean bonusRequested = true;
		double accountantBaseSalary = BusinessEmployee.baseSalary;
		double accountantBonusCap = accountantBaseSalary/100 * 110;
		
		while(bonusRequested == true) {
			for(int i=0; i < accountants.size(); i++) {
				bonusRequestCount += 1;
				double bonusGenerated = NumberGenerator.generateDouble_0_To_99000();
				Employee manager = accountants.get(i).getManager();
				
				while(bonusGenerated < accountantBaseSalary || bonusGenerated > accountantBonusCap)
					bonusGenerated = NumberGenerator.generateDouble_0_To_99000();
				
				System.out.println("(Accountant) #Bonus_Request No. " + bonusRequestCount + "\n");
				System.out.println("Bonus Amount Requested : " + CurrencyConverter.convertToCurrency(bonusGenerated)
							+ "\nEmployee to receive bonus: (Accountants) " + accountants.get(i));
	    		bonusRequested = ((BusinessLead)manager).requestBonus(accountants.get(i), bonusGenerated);
	    		if(bonusRequested == false) {
	    			printTransactionDivider();
	    			break;
	    		}
	    		printTransactionDivider();
			}
		}
	}
   
	public static boolean reportsToTechLead(SoftwareEngineer engineer, TechnicalLead lead){
		if(engineer.getManager() == lead)
	 		return true;
	 	else
	 		return false;
	}
	
//  Printer Methods
    @SuppressWarnings("unused")
	public static void printHeader(String convertHeading) {
    	char[] heading = convertHeading.toCharArray();
    	for(var eachChar:heading)
    		System.out.print("-");
    	System.out.println("\n" + convertHeading);
    	
    	for(var eachChar:heading)
    		System.out.print("-");
    	System.out.println("\n");
    }
    
    public static void printHorizontalRule() {
    	short length = 120;
    	for(int i=0; i < length; i++) 
    		System.out.print("_");	
    	System.out.println();
    }
    
    public static void printTransactionDivider() {
    	System.out.println();
    	short length = 90;
    	for(int i=0; i < length; i++)
    		System.out.print("-");	
    	System.out.println("\n");
    }
    
    private static void printTechnicalTeamStatuses() {
        for(int i=0; i < list_Of_TechnicalLeads.size(); i++)
     	   System.out.println("Technical Team " + (i+1)
     			   + "\n" + list_Of_TechnicalLeads.get(i).getTeamStatus());
        
    }
	
    private static void printAccountantEmployeeStatuses() {
    	for(int i=0; i < list_Of_TechnicalLeads.size(); i++) 
      	   System.out.println("Accountant_SupportTeam " + (i+1)
      			   + "\n" + list_Of_Accountants.get(i).employeeStatus());
 
    }

}

