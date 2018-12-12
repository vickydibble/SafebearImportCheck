package com.safebear.auto.tests;

import com.safebear.auto.Pages.LoginPage;
import com.safebear.auto.Pages.ToolsPage;
import com.safebear.auto.utils.Util;
import cucumber.api.PendingException;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import static org.testng.AssertJUnit.assertEquals;

public class StepDefs {

    WebDriver driver;
LoginPage loginPage;
ToolsPage toolsPage;

    @Before
    public void setUp(){
        driver = Util.getDriver();
        loginPage = new LoginPage(driver);
        toolsPage = new ToolsPage(driver);
    }

    @After
    public void tearDown(){
        try
        {
                //Thread.sleep(2000);
                Thread.sleep(Integer.parseInt(System.getProperty("sleep", "2000")));
        }
        catch (InterruptedException e){
            e.printStackTrace();
        }
        //driver.close();
        driver.quit();
    }


    @Given("^I navigate to the login page$")
    public void i_navigate_to_the_login_page() throws Throwable {

        driver.get(Util.getUrl());
        assertEquals(loginPage.checkTitle(),"LoginPage","Login page not loaded sucessfully");





    }

    @When("^I enter the login details for a '(.+)'$")
    public void i_enter_the_login_details_for_a_user(String user) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Then("^I can see the following message: '(.+)'$")
    public void i_can_see_the_following_message(String message) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }



//    @Then("^I can see the following message: 'Login successful'$")
//    public void i_can_see_the_following_message_Login_successful() throws Throwable {
//        // Write code here that turns the phrase above into concrete actions
//        throw new PendingException();
//    }

}
