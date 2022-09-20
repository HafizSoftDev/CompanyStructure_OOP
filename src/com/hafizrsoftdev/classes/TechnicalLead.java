package com.hafizrsoftdev.classes;

import java.util.ArrayList;

/**
 * Created by Hafiz on 3/4/2022.
 */
public class TechnicalLead extends TechnicalEmployee implements ApproveCheckIn, GetAccountant {
    //
//
//  Class Field
    private final int headCount;
    public ArrayList<SoftwareEngineer> directReport;
    public ArrayList<Accountant> accountant;


    //
//
//  Constructor Method
    public TechnicalLead(String n, int i) {
        this.name = n;
        this.ID = i;
        this.baseSalary = 75000 * (1.3);
        this.checkIns = 0;
        this.headCount = 4;
        this.directReport = new ArrayList<>(4);
        this.accountant = new ArrayList<>(1);
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
        return null;
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

    //  TECHNICAL LEAD CLASS METHODS
    public boolean hasHeadCount() {
        return directReport.size() < headCount;
    }

    //  public boolean hasHeadCount()
//  Should return true if the number of direct reports this manager has is less
//  than their headcount.
    public boolean addReport(SoftwareEngineer e) {
        boolean result = false;
        if (e.getManager() == null) {
            if (directReport.size() < this.headCount) {
                directReport.add(e);
                e.manager.add(this);
                result = true;
            } else if ((directReport.size() == this.headCount)) {
                System.out.println("\nERROR!\nUnable to add " + e + " to " + this + " as direct report:\nHeadcount limit have been reached.");
            }
        } else if (e.getManager() != null) {
            System.out.println("\nERROR!\nUnable to add " + e + " to " + this + " as SWE is already assigned to the following Manager: \n" + e.getManager());
        }
        return result;
    }

    //  public boolean addReport(SoftwareEngineer e)
//  Should accept the reference to a SoftwareEngineer object, and if the TechnicalLead has head count
//  left should add this employee to their list of direct reports.
//  If the employee is successfully added to the TechnicalLead's direct reports
//  true should be returned, false should be returned otherwise
    public ArrayList<SoftwareEngineer> getDirectReport() {
        return directReport;
    }
    @Override
    public boolean approveCheckIn(SoftwareEngineer e) {
        return directReport.contains(e) && (e.getCodeAccess());
    }
    //public boolean approveCheckIn(SoftwareEngineer e)
//Should see if the employee passed in does report to this manager
// and if their code access is currently set to "true".
//If both those things are true, true is returned, otherwise false is returned


//    public void requestBonus(Employee e, double bonus){
//        boolean reqBonus;
//        if(accountant.accountSupportList == this){
//          e.setBaseSalary(++bonus);
//
//        }

//                .accountSupportList = accountant){}
////         accountant // CFO
//        accountant.accountSupportList.contains
//            this.setBonusBudget(--bonus);
//            e.setBaseSalary(++bonus);
//            reqBonus = true;
//        } else reqBonus = false;
//        return reqBonus;
//        return false;

    //public boolean requestBonus(Employee e, double bonus)
//Should check if the bonus amount requested would be approved
// by the BusinessLead supporting this TechnicalLead.
//If it is, that employee should get that bonus and true should be returned.
// False should be returned otherwise
    public String getTeamStatus() {
        StringBuilder teamStatus;
        if (!(directReport.isEmpty())) {
            teamStatus = new StringBuilder((ID + " " + name + " has " + checkIns + " successful check ins" + " and is managing:"));
            for (SoftwareEngineer engineer : this.directReport) {
                if (engineer != null) {
                    teamStatus.append("\n").append(engineer.employeeStatus());
                }
            }
            return teamStatus.toString();
        } else teamStatus = new StringBuilder((ID + " " + name + " has " + checkIns + " successful check ins"));
        return teamStatus.toString();
    }
    public boolean grantAccess (SoftwareEngineer e) {
        if (!(e.getManager() == null)) {
            return true;
        } else {
            return false;
        }
    }
//public String getTeamStatus()
//Should return a String that gives insight into this Manager and all their direct reports.
// It should return a string that is a combination of the TechnicalLead's employee status
// followed by each of their direct employee's status on subsequent lines.
//If the TechnicalLead has no reports it should print their employee status followed by the text
// " and no direct reports yet ".
//Example: "10 Kasey has 5 successful check ins and no direct reports yet".
//
//If the TechnicalLead does have reports it might look something
//like => Example: "10 Kasey has 5 successful check ins and is managing:
//          /n 5 Niky has 2 successful check ins"
public Accountant getAccountant(SoftwareEngineer engineer) {
    if (engineer.accountant.isEmpty()) {
        return null;
    } else return engineer.accountant.get(0);
}
}
