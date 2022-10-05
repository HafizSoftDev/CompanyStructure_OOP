package com.hafizrsoftdev.classes;

public class CompanyStructure {
    public static void main(String[] args) {
        createStructure();
        basicMethods();
        employeeStatus();
        getBonusBudgetAndHeadCount();
        softwareEngineerMethods();
        approveAndRequestBonus();
    }

    public static void createStructure() {

/*
 * TYPES OF PERSONNEL 
 * 1. Business Employee 
 * BusinessLead = CFO (Chief Financial Officer) [10 x headcount] [ID: 1 to 10] 
 * Accountant = acct (Acronym to replace 'accountant') [ID: 11 to 50 ]
 * 
 * 2. Technical Employee 
 * TechnicalLead = VPE (VP of Engineering) [04 x headcount] [ID: 51 to 60] 
 * SoftwareEngineer = SWE (Software Engineer) [ID: 61 to 100] 
 */
    	
//  MANAGEMENT STAFF
        System.out.println("\nCREATE STRUCTURE AND ASSIGN RELATIONSHIPS WITH CLASS METHODS");
        BusinessLead CFO = new BusinessLead("Amy Hood");
        TechnicalLead vpeOne = new TechnicalLead("Bill Gates");
        TechnicalLead vpeTwo = new TechnicalLead("Satya Nadella");
        TechnicalLead vpeThree = new TechnicalLead("Elon Mull");
        TechnicalLead vpeFour = new TechnicalLead("Alex Stratos");

//  FINANCE  TEAM
        Accountant acctA = new Accountant("Nicky Rich");
        Accountant acctB = new Accountant("Andrew Balmond");
        Accountant acctC = new Accountant("Sia");

//  ENGINEERING TEAM
        SoftwareEngineer sweOne = new SoftwareEngineer("Jack Black");
        SoftwareEngineer sweTwo = new SoftwareEngineer("Tom Fafua");
        SoftwareEngineer sweThree = new SoftwareEngineer("Ginyo Taku");
        SoftwareEngineer sweFour = new SoftwareEngineer("Kasey");
        SoftwareEngineer sweFive = new SoftwareEngineer("Breana");
        SoftwareEngineer sweSix = new SoftwareEngineer("Eric");
        SoftwareEngineer sweSeven = new SoftwareEngineer("Winter");
        SoftwareEngineer sweEight = new SoftwareEngineer("Libby");
        SoftwareEngineer sweNine = new SoftwareEngineer("Gizan");
        SoftwareEngineer sweTen = new SoftwareEngineer("Zaynah");
        SoftwareEngineer sweEleven = new SoftwareEngineer("Ando Soh");
        SoftwareEngineer sweTwelve = new SoftwareEngineer("Tommy Emanuel");
        SoftwareEngineer sweThirteen = new SoftwareEngineer("Jackson Five");
        SoftwareEngineer sweFourteen = new SoftwareEngineer("Olivia Ong");
        SoftwareEngineer sweFifteen = new SoftwareEngineer("Micheal Romeo");
        SoftwareEngineer sweSixteen = new SoftwareEngineer("Eric Cartman");
		
/*
 * TEAM ASSIGNMENTS 
 * 1. Assignment of Software Engineer to TechnicalLead. 
 * 2.Assign 01 x TechnicalLead to each Accountant (02 x MaxLimit for
 * TechLead/Team, assignment.)
 */
        
//      Technical Team One
        vpeOne.addReport(sweOne);
        vpeOne.addReport(sweTwo);
        vpeOne.addReport(sweThree);
        vpeOne.addReport(sweFour);
        
/*
 * Verified code function:Boolean Expression => Headcount Limitation < ArrayList
 * Size Unable to add 65 Breana as direct report: Headcount limit have been
 * reached.
 */
        
//      Technical Team Two
        vpeOne.addReport(sweFive);
        vpeTwo.addReport(sweFive);
        vpeTwo.addReport(sweSix);
        vpeTwo.addReport(sweSeven);
        vpeTwo.addReport(sweEight);
/*
 *	Verified code function: Boolean Expression => Software Engineer have been assigned Manager
 *	Unable to add Jack Black as SWE is already assigned to the following Manager: 51 Bill Gates
 */
        
//		Technical Team Three
        vpeThree.addReport(sweOne);
        vpeThree.addReport(sweNine);
        vpeThree.addReport(sweTen);
        vpeThree.addReport(sweEleven);
        vpeThree.addReport(sweTwelve);

//      Technical Team Four
        vpeFour.addReport(sweThirteen);
        vpeFour.addReport(sweFourteen);
        vpeFour.addReport(sweFifteen);
        vpeFour.addReport(sweSixteen);

//		Display Technical Team Assignments with .getTeamStatus() method.
        System.out.println("\nASSIGNMENT OF TECHNICAL TEAM:");
        System.out.println("\nTechnical Team One\n" + vpeOne.getTeamStatus());
        System.out.println();
        System.out.println("Technical Team Two\n" + vpeTwo.getTeamStatus());
        System.out.println();
        System.out.println("Technical Team Three\n" + vpeThree.getTeamStatus());
        System.out.println();
        System.out.println("Technical Team Four\n" + vpeFour.getTeamStatus());

//		ASSIGNMENT OF ACCOUNTANTS TO TECHNICAL LEADS
        System.out.println();
        acctA.supportTeam(vpeOne);
        System.out.println("\nAssigning vpeOne to acctA");
        acctB.supportTeam(vpeTwo);
        System.out.println("\nAssigning vpeTwo to acctB");
        acctC.supportTeam(vpeThree);
        System.out.println("\nAssigning vpeThree to acctC");
        acctC.supportTeam(vpeFour);
        System.out.println("\nAssigning vpeFour to acctC");

/*
 * ADD REPORT FUNCTION FOR BUSINESSLEAD CLASS OBJECT Verified code function: if
 * (!(this.directReport.contains(e))) Unable to trigger double entry of existing
 * DirectReport.
 */
        CFO.addReport(acctA, vpeOne);
        CFO.addReport(acctB, vpeTwo);
        CFO.addReport(acctC, vpeThree);
        CFO.addReport(acctC, vpeFour);
        System.out.println("CFO ID: " + CFO.employeeStatus());
    }

    public static void basicMethods() {
        System.out.println("\nUTILIZATION OF GENERAL CLASS METHODS");
        BusinessLead CFO = new BusinessLead("Amy Hood");
        TechnicalLead vpeOne = new TechnicalLead("Bill Gates");
        Accountant acctA = new Accountant("Nicky Rich");
        SoftwareEngineer sweOne = new SoftwareEngineer("Jack Black");
        SoftwareEngineer sweTwo = new SoftwareEngineer("Tom Fafua");
        vpeOne.addReport(sweOne);
        vpeOne.addReport(sweTwo);
        CFO.addReport(acctA, vpeOne);


        System.out.println("\nCFO BASE SALARY: " + CFO.getBaseSalary());
        System.out.println("Name of acctA => " + acctA.getName());
        System.out.println("VP of Engineering;Employee ID: " + vpeOne.getEmployeeID());
        System.out.println("Manager of acctA => ID:" + acctA.getManager());
        System.out.println("Similar ID between SWE's; return true => " + sweOne.equals(sweTwo));
        System.out.println("Different ID between SWE's; return false => " + sweOne.equals(acctA));
        System.out.println("Obtain CFO ID & Name with toString function => ID:" + CFO);

    }

    public static void employeeStatus() {
        System.out.println("\nCREATE STRUCTURE AND ASSIGN RELATIONSHIPS WITH CLASS METHODS");
        BusinessLead CFO = new BusinessLead("Amy Hood");
        TechnicalLead vpeOne = new TechnicalLead("Bill Gates");
        Accountant acctA = new Accountant("Nicky Rich");
        SoftwareEngineer sweOne = new SoftwareEngineer("Jack Black");
        SoftwareEngineer sweTwo = new SoftwareEngineer("Tom Fafua");
        SoftwareEngineer sweThree = new SoftwareEngineer("Ginyo Taku");
        SoftwareEngineer sweFour = new SoftwareEngineer("Kasey");
        vpeOne.addReport(sweOne);
        vpeOne.addReport(sweTwo);
        vpeOne.addReport(sweThree);
        vpeOne.addReport(sweFour);
        CFO.addReport(acctA, vpeOne);

        System.out.println("BusinessLead Employee Status => " + CFO.employeeStatus());
        System.out.println("Accountant Employee Status => " + acctA.employeeStatus());
        System.out.println("TechnicalLead Employee Status => " + vpeOne.employeeStatus());
        System.out.println("SoftwareEng1 Employee Status => " + sweOne.employeeStatus());
        System.out.println("SoftwareEng2 Employee Status => " + sweTwo.employeeStatus());
        System.out.println("SoftwareEng3 Employee Status => " + sweThree.employeeStatus());
        System.out.println("SoftwareEng4 Employee Status => " + sweFour.employeeStatus());
    }

    public static void getBonusBudgetAndHeadCount() {
        BusinessLead CFO = new BusinessLead("Amy Hood");
        TechnicalLead vpeOne = new TechnicalLead("Bill Gates");
        Accountant acctA = new Accountant("Nicky Rich");
        SoftwareEngineer sweOne = new SoftwareEngineer("Jack Black");
        SoftwareEngineer sweTwo = new SoftwareEngineer("Tom Fafua");
        SoftwareEngineer sweThree = new SoftwareEngineer("Ginyo Taku");
        SoftwareEngineer sweFour = new SoftwareEngineer("Kasey");
        System.out.println("\nVERIFICATION OF GET_BONUS_BUDGET & HAS_HEADCOUNT METHOD: ");
        System.out.println("Accountant Bonus Budget Before Support Team Assignment => "
                + acctA.getBonusBudget());
        System.out.println("BusinessLead Bonus Budget Before Support Team Assignment => "
                + CFO.getBonusBudget());
        System.out.println("Before addReport function: TechnicalLead has HeadCount => " + vpeOne.hasHeadCount());
        System.out.println("Before addReport function: BusinessLead has HeadCount => " + CFO.hasHeadCount());

        vpeOne.addReport(sweOne);
        vpeOne.addReport(sweTwo);
        vpeOne.addReport(sweThree);
        vpeOne.addReport(sweFour);
        CFO.addReport(acctA, vpeOne);

        Accountant acctB = new Accountant("Nicky Rich");
        Accountant acctC = new Accountant("Andrew Balmond");
        Accountant acctD = new Accountant("Sia");
        Accountant acctE = new Accountant("Nicky Rich");
        Accountant acctF = new Accountant("Andrew Balmond");
        Accountant acctG = new Accountant("Sia");
        Accountant acctH = new Accountant("Nicky Rich");
        Accountant acctI = new Accountant("Andrew Balmond");
        Accountant acctJ = new Accountant("Sia");

        CFO.addReport(acctB, vpeOne);
        CFO.addReport(acctC, vpeOne);
        CFO.addReport(acctD, vpeOne);
        CFO.addReport(acctE, vpeOne);
        CFO.addReport(acctF, vpeOne);
        CFO.addReport(acctG, vpeOne);
        CFO.addReport(acctH, vpeOne);
        CFO.addReport(acctI, vpeOne);
        CFO.addReport(acctJ, vpeOne);


        System.out.println("Accountant Bonus Budget After Support Team Assignment => "
                + acctA.getBonusBudget());
        System.out.println("BusinessLead Bonus Budget After Support Team Assignment => " +
                CFO.getBonusBudget());

        System.out.println("After addReport function: TechnicalLead has HeadCount => " + vpeOne.hasHeadCount());
        System.out.println("After addReport function: BusinessLead has HeadCount => " + CFO.hasHeadCount());

    }

    public static void softwareEngineerMethods() {
        TechnicalLead vpeOne = new TechnicalLead("Bill Gates");
        Accountant acctA = new Accountant("Nicky Rich");
        SoftwareEngineer sweOne = new SoftwareEngineer("Jack Black");
        SoftwareEngineer sweTwo = new SoftwareEngineer("Tom Fafua");
        SoftwareEngineer sweThree = new SoftwareEngineer("Ginyo Taku");
        SoftwareEngineer sweFour = new SoftwareEngineer("Kasey");

        System.out.println("\nBEFORE ADD REPORT: Set Code Access for sweOne to Four => ");
        System.out.println("SWEONE SET CODE ACCESS!");
        sweOne.setCodeAccess(true);
        System.out.println("SWETWO SET CODE ACCESS!");
        sweTwo.setCodeAccess(true);
        System.out.println("SWETHREE SET CODE ACCESS!");
        sweThree.setCodeAccess(true);
        System.out.println("SWEFOUR SET CODE ACCESS!");
        sweFour.setCodeAccess(true);

        System.out.println("\nBEFORE ADD REPORT: Get Code Access for sweOne to Four => " +
                "\nSWEONE: " + sweOne.getCodeAccess() +
                "\nSWETWO: " + sweTwo.getCodeAccess() +
                "\nSWETHREE: " + sweThree.getCodeAccess() +
                "\nSWEFOUR: " + sweFour.getCodeAccess());

        vpeOne.addReport(sweOne);
        vpeOne.addReport(sweTwo);
        vpeOne.addReport(sweThree);
        vpeOne.addReport(sweFour);

        System.out.println("\nAFTER ADD REPORT: Set Code Access for sweOne to Four => ");
        System.out.println("SWEONE SET CODE ACCESS!");
        sweOne.setCodeAccess(true);
        System.out.println("SWETWO SET CODE ACCESS!");
        sweTwo.setCodeAccess(true);
        System.out.println("SWETHREE SET CODE ACCESS!");
        sweThree.setCodeAccess(true);

        System.out.println("\nAFTER ADD REPORT: Get Code Access for sweOne to Four => " +
                "\nSWEONE: " + sweOne.getCodeAccess() +
                "\nSWETWO: " + sweTwo.getCodeAccess() +
                "\nSWETHREE: " + sweThree.getCodeAccess() +
                "\nSWEFOUR: " + sweFour.getCodeAccess());

        System.out.println("\nCheck-IN Code by SWEONE: ");
        sweOne.checkInCode();
        sweOne.checkInCode();
        sweOne.checkInCode();
        sweOne.checkInCode();

        System.out.println("\nGET SUCCESSFUL CHECKINS OF SWEONE: ");
        System.out.println(sweOne.getSuccessfulCheckIns());

        System.out.println("\nApproveCheckIn of SWEONE & SWEFOUR: ");
        System.out.println(vpeOne.approveCheckIn(sweOne));
        System.out.println(vpeOne.approveCheckIn(sweFour));
    }

    public static void approveAndRequestBonus() {
        System.out.println("\nCREATE STRUCTURE AND ASSIGN RELATIONSHIPS WITH CLASS METHODS");
        BusinessLead CFO = new BusinessLead("Amy Hood");
        TechnicalLead vpeOne = new TechnicalLead("Bill Gates");
        TechnicalLead vpeTwo = new TechnicalLead("Satya Nadella");
        TechnicalLead vpeThree = new TechnicalLead("Elon Mull");
        TechnicalLead vpeFour = new TechnicalLead("Alex Stratos");

//		FINANCE  TEAM
        Accountant acctA = new Accountant("Nicky Rich");
        Accountant acctB = new Accountant("Andrew Balmond");
        Accountant acctC = new Accountant("Sia");

//		ENGINEERING TEAM
        SoftwareEngineer sweOne = new SoftwareEngineer("Jack Black");
        SoftwareEngineer sweTwo = new SoftwareEngineer("Tom Fafua");
        SoftwareEngineer sweThree = new SoftwareEngineer("Ginyo Taku");
        SoftwareEngineer sweFour = new SoftwareEngineer("Kasey");
        SoftwareEngineer sweFive = new SoftwareEngineer("Breana");
        SoftwareEngineer sweSix = new SoftwareEngineer("Eric");
        SoftwareEngineer sweSeven = new SoftwareEngineer("Winter");
        SoftwareEngineer sweEight = new SoftwareEngineer("Libby");
        SoftwareEngineer sweNine = new SoftwareEngineer("Gizan");
        SoftwareEngineer sweTen = new SoftwareEngineer("Zaynah");
        SoftwareEngineer sweEleven = new SoftwareEngineer("Ando Soh");
        SoftwareEngineer sweTwelve = new SoftwareEngineer("Tommy Emanuel");
        SoftwareEngineer sweThirteen = new SoftwareEngineer("Jackson Five");
        SoftwareEngineer sweFourteen = new SoftwareEngineer("Olivia Ong");
        SoftwareEngineer sweFifteen = new SoftwareEngineer("Micheal Romeo");
        SoftwareEngineer sweSixteen = new SoftwareEngineer("Eric Cartman");

/*
 * TEAM ASSIGNMENTS 
 * 1. Assignment of Software Engineer to TechnicalLead. 
 * 2.Assign 01 x TechnicalLead to each Accountant (02 x MaxLimit for TechLead/Team, assignment.)
 */

//      Technical Team One
        vpeOne.addReport(sweOne);
        vpeOne.addReport(sweTwo);
        vpeOne.addReport(sweThree);
        vpeOne.addReport(sweFour);

/*
 * Verified code function:Boolean Expression => Headcount Limitation < ArrayList
 * Size Unable to add 65 Breana as direct report: Headcount limit have been reached.
 */

//      Technical Team Two
        vpeOne.addReport(sweFive);
        vpeTwo.addReport(sweFive);
        vpeTwo.addReport(sweSix);
        vpeTwo.addReport(sweSeven);
        vpeTwo.addReport(sweEight);

/*
 * Verified code function: Boolean Expression => Software Engineer have been
 * assigned Manager Unable to add Jack Black as SWE is already assigned to the
 * following Manager: 51 Bill Gates 
 */
        
//      Technical Team Three
        vpeThree.addReport(sweOne);
        vpeThree.addReport(sweNine);
        vpeThree.addReport(sweTen);
        vpeThree.addReport(sweEleven);
        vpeThree.addReport(sweTwelve);

//      Technical Team Four
        vpeFour.addReport(sweThirteen);
        vpeFour.addReport(sweFourteen);
        vpeFour.addReport(sweFifteen);
        vpeFour.addReport(sweSixteen);

//		Display Technical Team Assignments with .getTeamStatus() method.
        System.out.println("\nASSIGNMENT OF TECHNICAL TEAM:");
        System.out.println("\nTechnical Team One\n" + vpeOne.getTeamStatus());
        System.out.println();
        System.out.println("Technical Team Two\n" + vpeTwo.getTeamStatus());
        System.out.println();
        System.out.println("Technical Team Three\n" + vpeThree.getTeamStatus());
        System.out.println();
        System.out.println("Technical Team Four\n" + vpeFour.getTeamStatus());
        
//  	ASSIGNMENT OF ACCOUNTANTS TO TECHNICAL LEADS
        System.out.println();
        acctA.supportTeam(vpeOne);
        System.out.println("\nAssigning vpeOne to acctA");
        acctB.supportTeam(vpeTwo);
        System.out.println("\nAssigning vpeTwo to acctB");
        acctC.supportTeam(vpeThree);
        System.out.println("\nAssigning vpeThree to acctC");
        acctC.supportTeam(vpeFour);
        System.out.println("\nAssigning vpeFour to acctC");

/*
 * ADD REPORT FUNCTION FOR BUSINESSLEAD CLASS OBJECT 
 * Verified code function: if (!(this.directReport.contains(e))) 
 * - Unable to trigger double entry of existing DirectReport.
 */
    
        CFO.addReport(acctA, vpeOne);
        CFO.addReport(acctB, vpeTwo);
        CFO.addReport(acctC, vpeThree);
        CFO.addReport(acctC, vpeFour);
        System.out.println("CFO ID: " + CFO.employeeStatus());

        System.out.println("Approve Bonus & Request Bonus Incomplete.");
        sweOne.setBonus(10000);
        System.out.println(sweOne.getBonus());
        System.out.println(CFO.getBonus());
        
        
/*
 * NULL POINTER EXCEPTION; CODE NEEDS TO BE REVISED!
 * System.out.println(CFO.approveBonus(sweFive,200));
 * CFO.approveBonus(sweOne,20000);
 */

    }
}

