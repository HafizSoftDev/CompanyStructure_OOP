package com.hafizrsoftdev.classes;

import java.util.ArrayList;

/**
 * Created by Hafiz on 3/4/2022.
 */
public class BusinessLead extends BusinessEmployee implements GetAccountant{
//    Class Field
    //
    private final int headCount;
    public ArrayList<Employee> directReport;
    //    Constructor Method
    public BusinessLead (String n,int i){
    this.name = n;
    this.ID = i;
    this.baseSalary = 50000*(2);
    this.bonusBudget = 0;
    this.headCount = 10;
    this.directReport = new ArrayList<>();

}
    //
    public double getBaseSalary(){
        return baseSalary;
    }
    public double setBaseSalary (double amendBaseSalary){
        this.baseSalary = amendBaseSalary;
        return amendBaseSalary;
    }
    public String getName(){
        return name;
    }
    public int getEmployeeID() {
        return ID;
    }
    public Employee getManager(){
        return null;
    }
    public boolean equals (Employee other) {
        return this.ID == (other).ID;
    }
    public String toString(){
        return this.ID + " " + this.name ;
    }
    public String employeeStatus() {
        return ID + " " + name + " with a budget of " + bonusBudget + " ." ;
//        ID, name, the size of their currently managed budget and the name of the TechnicalLead they are currently supporting.
//        Example: "1 Kasey with a budget of 22500.0 is supporting Satya Nadella"
    }
//    BUSINESS LEAD CLASS METHODS!!
    public double getBonusBudget () {
    return bonusBudget;
}
    public double setBonusBudget(double bonusBudget){
        this.bonusBudget = bonusBudget;
        return bonusBudget;
    }
    public boolean hasHeadCount() {
        return directReport.size() < headCount;
    }

//    public boolean hasHeadCount()
//Should return true if the number of direct reports this manager has is less than their headcount.
    public boolean addReport(Accountant e,TechnicalLead supportTeam) {
        boolean result = false;
        if (!(this.directReport.contains(e))) {
            if (this.directReport.size() < headCount) {
//
//          Add Accountant to Business Lead's Direct Report with accruement of bonusBudget.
                if (e.accountSupportList.contains(supportTeam)) {
                    System.out.println("TechnicalLead: " + supportTeam
                            + " have already been assigned to supportTeam for this accountant => ID: " + e);
                    directReport.add(e);
                    e.manager.add(this);
                    double myBonusBudget = 0;
                    double myDirectReport = 0;
                    myDirectReport += e.getBaseSalary() * 1.1;
                    this.setBonusBudget(this.bonusBudget+=myDirectReport);
                    for (int i = 0; i < e.accountSupportList.size(); i++) {
                        System.out.println(e.accountSupportList.get(i)
                                + " is pre-assigned to supportTeam for this accountant => ID: " + e);
                        var x = e.accountSupportList.get(i);
                        for (int j = 0; j < (x.directReport.size()); j++) {
                            myBonusBudget += x.directReport.get(j).getBaseSalary() * 1.1;
                        }
                        double revisedBonusBudget = myBonusBudget + this.getBonusBudget();
                        this.setBonusBudget(this.bonusBudget+=revisedBonusBudget);
                        System.out.println("The following amount have been added to " + this
                                + " addedBonusBudget => " + revisedBonusBudget);
                        result = true;
                    }
                } else if (!e.accountSupportList.contains(supportTeam)) {
                    if (e.accountSupportList.size() == e.accountSupportLimit) {
                        System.out.println("Error!:  Accountant supportTeam have already reached Max Capacity." +
                                "\nKindly reassign " + supportTeam + " to another available Accountant.\nThank You!" +
                                "\nList of " + this + "Support Team for Reference:\n" + e.accountSupportList);
                        directReport.add(e);
                        e.manager.add(this);
                        double myBonusBudget = 0;
                        double myDirectReport = 0;
                        myDirectReport += e.getBaseSalary() * 1.1;
                        this.setBonusBudget(this.bonusBudget+=myDirectReport);
                        for (int i = 0; i < e.accountSupportList.size(); i++) {
                            System.out.println(e.accountSupportList.get(i)
                                    + " is assigned to supportTeam for this accountant => ID: " + e);
                            var x = e.accountSupportList.get(i);
                            for (int j = 0; j < (x.directReport.size()); j++) {
                                myBonusBudget += x.directReport.get(j).getBaseSalary() * 1.1;
                            }
                            double revisedBonusBudget = myBonusBudget + this.getBonusBudget();
                            this.setBonusBudget(this.bonusBudget+=revisedBonusBudget);
                            System.out.println("The following amount have been added to " + this
                                    + " addedBonusBudget => " + revisedBonusBudget);
                            result = true;
                        }
                    } else if ((e.accountSupportList.size() < e.accountSupportLimit) && (supportTeam.accountant.isEmpty())) {
                        directReport.add(e);
                        e.supportTeam(supportTeam);
                        supportTeam.accountant.add(e);
                        e.manager.add(this);
                        double myBonusBudget = 0;
                        double myDirectReport = 0;
                        myDirectReport += e.getBaseSalary() * 1.1;
                        this.setBonusBudget(this.bonusBudget+=myDirectReport);
                        for (int i = 0; i < e.accountSupportList.size(); i++) {
                            System.out.println(e.accountSupportList.get(i)
                                    + " is assigned to supportTeam for this accountant => ID: " + e);
                            var x = e.accountSupportList.get(i);
                            for (int j = 0; j < (x.directReport.size()); j++) {
                                myBonusBudget += x.directReport.get(j).getBaseSalary() * 1.1;
                            }
                            double revisedBonusBudget = myBonusBudget + this.getBonusBudget();
                            this.setBonusBudget(this.bonusBudget+=revisedBonusBudget);
                            System.out.println("The following amount have been added to " + this
                                    + " addedBonusBudget => " + revisedBonusBudget);
                            result = true;
                        }

                    } else if ((e.accountSupportList.size() < e.accountSupportLimit) && (!supportTeam.accountant.isEmpty())) {
                        System.out.println("Error!:  Technical Lead ID: " + supportTeam +" have already been assigned to existing supportTeam." +
                                "\nKindly allocate an unassigned Technical Lead to Accountant's Support Team.\nThank You! " +
                                "\nList of ID: " + e + " Support Team for Reference:\n" + e.accountSupportList);
                        directReport.add(e);
                        e.manager.add(this);
                        double myBonusBudget = 0;
                        double myDirectReport = 0;
                        myDirectReport += e.getBaseSalary() * 1.1;
                        this.setBonusBudget(this.bonusBudget+=myDirectReport);
                        for (int i = 0; i < e.accountSupportList.size(); i++) {
                            System.out.println(e.accountSupportList.get(i)
                                    + " is assigned to supportTeam for this accountant => ID: " + e);
                            var x = e.accountSupportList.get(i);
                            for (int j = 0; j < (x.directReport.size()); j++) {
                                myBonusBudget += x.directReport.get(j).getBaseSalary() * 1.1;
                            }
                            double revisedBonusBudget = myBonusBudget + this.getBonusBudget();
                            this.setBonusBudget(this.bonusBudget+=revisedBonusBudget);
                            System.out.println(" The following amount have been added to " + this
                                    + " addedBonusBudget => " + revisedBonusBudget);
                            result = true;
                        }
                    }
                } else {
                    System.out.println("\nTechnical Lead: " + supportTeam + " was already assigned as a Direct Report " +
                            " to this manager => " + supportTeam.getManager());
                }

            }
        }
        return result;
    }
//
//    public boolean addReport(Accountant e, TechnicalLead supportTeam)
//    Should accept the reference to an Accountant object, and if the BusinessLead has head count left should add this employee
//    to their list of direct reports. If the employee is successfully added to the BusinessLead's direct reports true
//    should be returned, false should be returned otherwise.
//    Each time a report is added the BusinessLead's bonus budget should be increased by 1.1 times that new employee's base salary.
//    That employee's team they are supporting should be updated to reflect the reference to the TechnicalLead given.
//    If the employee is successfully added true should be returned, false otherwise.
    public boolean approveBonus(Employee e,double bonus) {
        boolean approveBonusResult = false;
        if (!this.directReport.isEmpty()) {
            for (int i = 0; i < this.directReport.size(); i++) {
                for (int j = 0; j < directReport.get(i).accountSupportList.size(); j++) {
                    if (e == accountSupportList.get(j).directReport.get(j)) {
                        if (20 % (this.getBonusBudget()) >= bonus) {
                            approveBonusResult = true;
                            System.out.println("Bonus Budget have been Approved by Business Lead ID: " + this + "\nThank you!");
                        } else if ((20 % (this.getBonusBudget()) < bonus)) {
                            approveBonusResult = false;
                            System.out.println("Bonus Budget have been limited to (20% >= x) to uphold frugality." +
                                    "\nKindly consult with Business Lead ID: " + this + " to revise amount limit:");
                        }
                    }
                }
            }
        } else {
            System.out.println(this + "is not assigned ");
        }
        return approveBonusResult;
    }
//    public boolean approveBonus(Employee e, double bonus)
//    This function should look through the Accountants the BusinessLead manages, and if any of them are supporting
//    the TechnicalLead that is the manager of the Employee passed in then the Accountant's budget should be consulted
//    to see if the bonus could be afforded.
//    If the team can afford the bonus it should be rewarded and true returned, false otherwise

    public boolean requestBonus(Employee e, double bonus) {
        boolean reqBonus;
        if(20%(this.getBonusBudget()) <= bonus) {
            this.setBonusBudget(this.bonusBudget-=bonus);
            e.setBaseSalary(this.baseSalary+=bonus);
            reqBonus = true;
        } else reqBonus = false;
        return reqBonus;
    }
//public boolean requestBonus(Employee e, double bonus)
//Should check if the bonus amount requested would fit in current BusinessLead's budget.
// If it is, that employee should get that bonus, the BusinessLeader's budget should be deducted
// and true should be returned. False should be returned otherwise

    public Accountant getAccountant(SoftwareEngineer engineer) {
        if (engineer.accountant.isEmpty()) {
            return null;
        } else return engineer.accountant.get(0);
    }
}
