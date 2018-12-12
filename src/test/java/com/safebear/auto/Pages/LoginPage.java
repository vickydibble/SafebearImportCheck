package com.safebear.auto.Pages;

import com.safebear.auto.Locators.LoginPageLocators;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.openqa.selenium.WebDriver;

@RequiredArgsConstructor

public class LoginPage {

    @NonNull
    WebDriver driver;

    /**
     * you notice the loginpagelocators class does NOT have ANY constructor
     * the reason we are able to pass in a driver parameter is because we are
     * using Lombok with annotations @NonNull and @RequiredArgsConstructor which
     * passes in the constructor.
     */
    LoginPageLocators locators = new LoginPageLocators(driver);

//
//    public void test(){
//
//        locators.getFailedloginMsgLocator(){
//    }

    public String checkTitle(){
        return
        driver.getTitle();
    }

   public void login(String uName, String pWord){
        locators.getUserNameField().sendKeys(uName);
        locators.getPasswordField().sendKeys(pWord);
        locators.getLoginButton().click();


   }

   public String getFailedLoginMessage(){
     String message = locators.getFailedLoginMsg().getText();
     return message;

   }

}
