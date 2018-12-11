package com.safebear.auto.syntax;

public class Employee {


    private boolean employed;
     private int salary;

    public void fire(){
        employed = false;
    }

    public void employ(){
        employed = true;
    }

    public void givePayRise(){
        salary = salary +10;
    }

    public boolean getEmploymentStatus(){
        return employed;
    }

    public void setEmploymentStatus(boolean employed){
        this.employed = employed;
    }

    public int getSalary(){
        return salary;
    }

    public void setSalary(int salary){

        this.salary= salary;

    }

}
