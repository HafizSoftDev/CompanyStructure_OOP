package com.hafizrsoftdev.classes;

import java.util.ArrayList;

public class EmployeeGenerator{
/*
 * TYPES OF PERSONNEL 
 * 1. Business Employee 
 * BusinessLead = CFO (Chief Financial Officer) [10 x headcount]  
 * Accountant = acct (Acronym to replace 'accountant') [01 x supportTeam | 01 x manager]
 * 
 * 2. Technical Employee 
 * TechnicalLead = VPE (VP of Engineering) [04 x headcount] 
 * SoftwareEngineer = SWE (Software Engineer) [01 x manager]
 */
	
//  MANAGEMENT STAFF
	public static BusinessLead CFO = new BusinessLead("Amy Hood");
    public static TechnicalLead vpeOne = new TechnicalLead("Bill Gates");
    public static TechnicalLead vpeTwo = new TechnicalLead("Satya Nadella");
    public static TechnicalLead vpeThree = new TechnicalLead("Elon Mull");
    public static TechnicalLead vpeFour = new TechnicalLead("Alex Stratos");
//  FINANCE  TEAM
    public static Accountant acctA = new Accountant("Nicky Rich");
    public static Accountant acctB = new Accountant("Andrew Balmond");
    public static Accountant acctC = new Accountant("Sia");
    public static Accountant acctD = new Accountant("Nadya Smithson");
    
//  ENGINEERING TEAM
    public static SoftwareEngineer sweOne = new SoftwareEngineer("Jack Black");
    public static SoftwareEngineer sweTwo = new SoftwareEngineer("Tom Fafua");
    public static SoftwareEngineer sweThree = new SoftwareEngineer("Ginyo Taku");
    public static SoftwareEngineer sweFour = new SoftwareEngineer("Kasey");
    public static SoftwareEngineer sweFive = new SoftwareEngineer("Breana");
    public static SoftwareEngineer sweSix = new SoftwareEngineer("Eric");
    public static SoftwareEngineer sweSeven = new SoftwareEngineer("Winter");
    public static SoftwareEngineer sweEight = new SoftwareEngineer("Libby");
    public static SoftwareEngineer sweNine = new SoftwareEngineer("Gizan");
    public static SoftwareEngineer sweTen = new SoftwareEngineer("Zaynah");
    public static SoftwareEngineer sweEleven = new SoftwareEngineer("Ando Soh");
    public static SoftwareEngineer sweTwelve = new SoftwareEngineer("Tommy Emanuel");
    public static SoftwareEngineer sweThirteen = new SoftwareEngineer("Jackson Five");
    public static SoftwareEngineer sweFourteen = new SoftwareEngineer("Olivia Ong");
    public static SoftwareEngineer sweFifteen = new SoftwareEngineer("Micheal Romeo");
    public static SoftwareEngineer sweSixteen = new SoftwareEngineer("Eric Cartman");
    
    public static ArrayList<SoftwareEngineer> list_Of_SoftwareEngineers = new ArrayList<>();
    public static ArrayList<TechnicalLead> list_Of_TechnicalLeads = new ArrayList<>();
    public static ArrayList<Accountant> list_Of_Accountants = new ArrayList<>();
    
}
