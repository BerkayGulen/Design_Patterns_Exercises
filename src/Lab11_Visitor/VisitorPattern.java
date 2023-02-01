package Lab11_Visitor;

import java.util.ArrayList;

public class VisitorPattern {
    public static void main(String[] args) {
        Visitor taxVisitor = new TaxVisitor();
        Visitor incomePerBranchVisitor = new IncomePerBranchVisitor();
        Companies companies = new Companies();

        companies.addCompany(new HomeImprovement("h1",200000,20));
        companies.addCompany(new Electronics("e1",150000,40));
        companies.addCompany(new Logistics("l1",500000,80));
        companies.addCompany(new MobilePhone("m1",300000,70));


        companies.accept(taxVisitor);
        companies.accept(incomePerBranchVisitor);

    }
}

interface Element {
    void accept(Visitor v);
}

interface Visitor {
    void visit(HomeImprovement homeImprovement);

    void visit(Electronics electronics);

    void visit(Logistics logistics);

    void visit(MobilePhone mobilePhone);


}

class TaxVisitor implements Visitor {

    @Override
    public void visit(HomeImprovement homeImprovement) {
        double tax = homeImprovement.getYearlyIncome() * 0.18;
        homeImprovement.setTax(tax);

    }

    @Override
    public void visit(Electronics electronics) {
        double tax = electronics.getYearlyIncome() * 0.36;
        electronics.setTax(tax);
    }

    @Override
    public void visit(Logistics logistics) {
        double tax = logistics.getYearlyIncome() * 0.8;
        logistics.setTax(tax);
    }

    @Override
    public void visit(MobilePhone mobilePhone) {
        double tax = mobilePhone.getYearlyIncome() * 0.42;
        mobilePhone.setTax(tax);
    }
}

class IncomePerBranchVisitor implements Visitor {

    @Override
    public void visit(HomeImprovement homeImprovement) {
        double employeeWages = homeImprovement.getYearlyIncome() * 0.2;
        double yearlyNetIncome = homeImprovement.getYearlyIncome() - (employeeWages + homeImprovement.getTax());
        double avgIncome = yearlyNetIncome / homeImprovement.getNoOfBranches();
        System.out.println(homeImprovement.getName()+" avg Income: "+avgIncome);
    }

    @Override
    public void visit(Electronics electronics) {
        double employeeWages = electronics.getYearlyIncome() * 0.2;
        double yearlyNetIncome = electronics.getYearlyIncome() - (employeeWages + electronics.getTax());
        double avgIncome = yearlyNetIncome / electronics.getNoOfBranches();
        System.out.println(electronics.getName()+" avg Income: "+avgIncome);

    }

    @Override
    public void visit(Logistics logistics) {
        double employeeWages = logistics.getYearlyIncome() * 0.2;
        double yearlyNetIncome = logistics.getYearlyIncome() - (employeeWages + logistics.getTax());
        double avgIncome = yearlyNetIncome / logistics.getNoOfBranches();
        System.out.println(logistics.getName()+" avg Income: "+avgIncome);

    }

    @Override
    public void visit(MobilePhone mobilePhone) {
        double employeeWages = mobilePhone.getYearlyIncome() * 0.22;
        double yearlyNetIncome = mobilePhone.getYearlyIncome() - (employeeWages + mobilePhone.getTax());
        double avgIncome = yearlyNetIncome / mobilePhone.getNoOfBranches();
        System.out.println(mobilePhone.getName()+" avg Income: "+avgIncome);
    }
}


abstract class Company implements Element {
    private String name;
    private double yearlyIncome;
    private int noOfBranches;
    private double tax;

    public Company(String name, double yearlyIncome, int noOfBranches) {
        this.name = name;
        this.yearlyIncome = yearlyIncome;
        this.noOfBranches = noOfBranches;
        this.tax = 0;

    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getYearlyIncome() {
        return yearlyIncome;
    }

    public void setYearlyIncome(double yearlyIncome) {
        this.yearlyIncome = yearlyIncome;
    }

    public int getNoOfBranches() {
        return noOfBranches;
    }

    public void setNoOfBranches(int noOfBranches) {
        this.noOfBranches = noOfBranches;
    }

    public double getTax() {
        return tax;
    }

    public void setTax(double tax) {
        this.tax = tax;
        System.out.println(getName()+" :"+tax);
    }

}

class Companies {
    private ArrayList<Company> companies = new ArrayList<>();

    public void addCompany(Company c) {
        companies.add(c);
    }

    public void accept(Visitor v) {
        for (Company c : companies) {
            c.accept(v);
        }
    }

}
class MobilePhone extends Company {
    public MobilePhone(String name, double yearlyIncome, int noOfBranches) {
        super(name, yearlyIncome, noOfBranches);
    }

    @Override
    public void accept(Visitor v) {
        v.visit(this);

    }
}


class HomeImprovement extends Company {
    public HomeImprovement(String name, double yearlyIncome, int noOfBranches) {
        super(name, yearlyIncome, noOfBranches);
    }

    @Override
    public void accept(Visitor v) {
        v.visit(this);

    }
}

class Electronics extends Company {

    public Electronics(String name, double yearlyIncome, int noOfBranches) {
        super(name, yearlyIncome, noOfBranches);
    }

    @Override
    public void accept(Visitor v) {
        v.visit(this);

    }
}

class Logistics extends Company {

    public Logistics(String name, double yearlyIncome, int noOfBranches) {
        super(name, yearlyIncome, noOfBranches);
    }

    @Override
    public void accept(Visitor v) {
        v.visit(this);
    }
}

