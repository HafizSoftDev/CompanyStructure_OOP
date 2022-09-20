package com.hafizrsoftdev.classes;

import java.util.ArrayList;

/**
 * Created by Hafiz on 3/4/2022.
 */
public class Accountant extends BusinessEmployee /*implements GetAccountant*/{
//    Class Field
    public ArrayList<TechnicalLead>accountSupportList;
    public int accountSupportLimit;
    public ArrayList<BusinessLead> manager;
    public double bonusBudget;
//    Constructor Method
    public Accountant (String n,int i){
        this.name = n;
        this.ID = i;
        this.baseSalary = 50000;
        this.bonusBudget = 0;
        this.accountSupportList = new ArrayList<>();
        this.accountSupportLimit = 2;
        manager = new ArrayList<>(1);
    }
//
    public double getBaseSalary(){
        return this.baseSalary;
    }
    public double setBaseSalary (double amendBaseSalary){
        this.baseSalary = amendBaseSalary;
        return amendBaseSalary;
    }
    public String getName(){
        return this.name;
    }
    public int getEmployeeID() {
        return this.ID;
    }
    public Employee getManager(){
        if (!this.manager.isEmpty())
        return manager.get(0);
        else return null;
    }
    public boolean equals (Employee other) {
        return this.ID == (other).ID;
    }
    public String toString(){
        return this.ID + " " + this.name ;
    }
    public String employeeStatus() {
        return ID + " " + name + " with a budget of " + bonusBudget + " is supporting the following Technical Lead's: " + this.accountSupportList ;
//        ID, name, the size of their currently managed budget and the name of the TechnicalLead they are currently supporting.
//        Example: "1 Kasey with a budget of 22500.0 is supporting Satya Nadella"
    }

//  Accountant Class Methods
    public double getBonusBudget () {
        return this.bonusBudget;
    }

    public void supportTeam(TechnicalLead lead) {
        if (accountSupportList.size() < accountSupportLimit) {
            accountSupportList.add(lead);
            lead.accountant.add(this);
            for (int i = 0; i < lead.directReport.size(); i++) {
                this.bonusBudget += lead.directReport.get(i).getBaseSalary() * 1.1;
                if (this.getManager() != null) {
                    var x = (BusinessLead) this.getManager();
                    double bonusBudgetGain = lead.directReport.get(i).getBaseSalary() * 1.1;
                    x.setBonusBudget(x.bonusBudget+=bonusBudgetGain);
                }
            }
        } else if (accountSupportList.size() == accountSupportLimit) {
            System.out.println("\nKindly reassigned to an available Accountant.\n-Accountant reached supportLimit.");
        }
    }
        //    public void supportTeam(TechnicalLead lead)
//Should allow a reference to a TechnicalLead to be passed and saved. Once this happens the Accountant's bonus budget
// should be updated to be the total of each SoftwareEngineer's base salary that reports to that TechnicalLead plus 10%.

//For example, if the TechnicalLead supports 2 SoftwareEngineers, each with a salary of 75000, the Accountant's budget
// should be 150000 + 15000 for a total of 165000

    public TechnicalLead[] getTeamSupported() {
        TechnicalLead[] teamSupported;
        if (this.accountSupportList.isEmpty()){
            return null;
        } else {
            teamSupported = new TechnicalLead[this.accountSupportList.size()];
            for (int i = 0; i < this.accountSupportList.size(); i++){
                teamSupported[i] = this.accountSupportList.get(i);
            }
        } return teamSupported;
    }
//
//    public TechnicalLead getTeamSupported()
//Should return a reference to the TechnicalLead that this Accountant is currently supporting.
// If they have not been assigned a TechnicalLead null should be returned
    public boolean approveBonus (double bonus) {
        boolean result = false;
        if(this.accountSupportList.isEmpty()){
            System.out.println("\nAccountant ID: " +this+ "is not assigned any supportTeam." +
                    "\nKindly consult Business Lead for official assignment of Technical Lead;support Team.");
        }else if (20%(this.getBonusBudget()) <= bonus){
            result = true;
            }
        return result;
    }
//  public boolean approveBonus(double bonus)
//Should take in a suggested bonus amount and check if there is still enough room in the budget.
//If the bonus is greater than the remaining budget, false should be returned, otherwise true.
//If the accountant is not supporting any team false should be returned.
//    public Accountant getAccountant() {
//    if (engineer.accountant.isEmpty()) {
//        return getAccountant();
//    } else return engineer.();
//    }
}




