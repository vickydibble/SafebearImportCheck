package com.safebear.auto.Locators;

import com.safebear.auto.utils.Util;
import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

@Data // this creates the equivalent of auto implemented properites
@RequiredArgsConstructor // this allows us to pass in a parameter withour needing a constructor when we
// insantiate this class
public class LoginPageLocators

{
@NonNull // this MUST be used with RequiredArgsConstuctor
WebDriver driver;
//private WebDriver driver = Util.getDriver();
//    //locators

    private By userNameFieldLocator= By.xpath("//input[@name='uname']");
    private By passwordFieldLocator = By.xpath("//input[@name='psw']");
    private By loginButtonLocator = By.xpath("//button[@type='submit']");
    private By failedLoginMsgLocator = By.xpath("//p[@id='rejectLogin']");


    // find the element in this class
    private WebElement userNameField = driver.findElement(userNameFieldLocator);
    private WebElement passwordField = driver.findElement(passwordFieldLocator);
    private WebElement loginButton = driver.findElement(loginButtonLocator);
    private WebElement failedLoginMsg = driver.findElement(failedLoginMsgLocator);






    }
