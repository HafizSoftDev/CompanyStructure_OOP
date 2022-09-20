package com.hafizrsoftdev.classes;

import java.util.ArrayList;

/**
 * Created by Hafiz on 3/4/2022.
 */
public class SoftwareEngineer extends TechnicalEmployee implements ApproveCheckIn, GetAccountant {
    //
//
//  Class Field
    private final String name;
    private double baseSalary;
    private int checkIns;
    private boolean codeAccess;
    public ArrayList<TechnicalLead> manager;
    public ArrayList<Accountant> accountant;
    public ArrayList<BusinessLead> CFO;

    //
//
//  Constructor Method
    public SoftwareEngineer(String n, int i) {
        this.name = n;
        this.ID = i;
        this.baseSalary = 75000;
        this.checkIns = 0;
        this.codeAccess = false;
        this.manager = new ArrayList<>(1);
        this.accountant = new ArrayList<>(1);
        this.CFO = new ArrayList<>(1);
    }

    //
//
//  Employee Inherited Class Methods
    public double getBaseSalary() {
        return baseSalary;
    }

    public double setBaseSalary(double amendBaseSalary) {
        this.baseSalary = amendBaseSalary;
        return amendBaseSalary;
    }

    public String getName() {
        return name;
    }

    public int getEmployeeID() {
        return ID;
    }

    public Employee getManager() {
        if (manager.isEmpty()) {
            return null;
        } else return manager.get(0);
    }

    public boolean equals(Employee other) {
        return this.ID == (other).ID;
    }

    public String toString() {
        return this.ID + " " + this.name;
    }

    public String employeeStatus() {
        return (ID + " " + name + " has " + checkIns + " successful check ins");
    }

    //
//
//  SoftwareEngineer Class Methods
    public boolean getCodeAccess() {
        return this.codeAccess;
    }

    //    public boolean getCodeAccess()
//    Should return whether or not this SoftwareEngineer has access to make changes
//    to the code base\
//
    //
    public void setCodeAccess(boolean access) {
        if (access = true) {
            boolean b;
            if (!(this.manager.isEmpty())){
            var a = this.manager.get(0);

                if ((a.grantAccess(this)) == true) {
                    b = (this.codeAccess = true);
                }
            } else b = (this.codeAccess = false);
        }
    }

    //    public void setCodeAccess(boolean access)
//    Should allow an external piece of code to update the SoftwareEngineer's code privileges
//    to either true or false
    public int getSuccessfulCheckIns() {
        return this.checkIns;
    }
    //  public int getSuccessfulCheckIns()
//  Should return the current count of how many times this SoftwareEngineer has
//  successfully checked in code
    //
    //
    //!!REVISION REQUIRED  //!!REVISION REQUIRED //!!REVISION REQUIRED //!!REVISION REQUIRED //!!REVISION REQUIRED
    public boolean checkInCode() {
        boolean checkInResult = false;
        if (!this.manager.isEmpty()) {
            var x = this.manager.get(0);
            if (x.approveCheckIn(this) == true) {
                checkInResult = true;
                this.checkIns += 1;
                System.out.println(this + " CheckIn is approved by " + x + "checkIns count => +1.");
            }
        }else{
            this.codeAccess = false;
            checkInResult = false;
            }
        return checkInResult;
    }


    public boolean approveCheckIn(SoftwareEngineer e) {
        e = this;
        if ((this.getManager().directReport.contains(this) && (this.getCodeAccess() == true))) {
            return true;
        } else return false;
    }

    public Accountant getAccountant(SoftwareEngineer engineer) {
        if (engineer.accountant.isEmpty()) {
            return null;
        } else return engineer.accountant.get(0);
    }
}
//    public boolean checkInCode()
//  Should check if this SoftwareEngineer's manager approves of their check in.
//  If the check in is approved their successful checkin count should be increased and the method
//  should return "true".
//  If the manager does not approve the check in the SoftwareEngineer's code access
//  should be changed to false and the method should return "false"
