package com.safebear.auto.syntax;

import org.testng.annotations.Test;

public  class EmployeeTest {

    @Test
    public void testEmployee(){

        //create objects
        Employee hanna = new Employee();
        Employee bob = new Employee();
        SalesEmployee jim = new SalesEmployee();


        // call methods

        hanna.employ();
        bob.fire();
        jim.employ();
        jim.changeCar("nissan micra");

        System.out.println("hanna employment state " + hanna.getEmploymentStatus());
        System.out.println("hanna employment state " + bob.getEmploymentStatus());

        System.out.println("jims employment state is " + jim.getEmploymentStatus() + " and his car is a " + jim.car);

        System.out.println(Accounts.calcTurnover());
        System.out.println(Accounts.countEmployees());

}



}
