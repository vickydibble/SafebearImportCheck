package com.safebear.auto.Pages;

import com.safebear.auto.Locators.ToolsPageLocators;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.openqa.selenium.WebDriver;

@RequiredArgsConstructor
public class ToolsPage {
    @NonNull
    WebDriver driver;
    ToolsPageLocators locators = new ToolsPageLocators();
    public String getPageTitle(){

        return driver.getTitle().toString();
    }

    public String checkLoginSucessful(){
    return
            driver.findElement(locators.getSucessfulLoginMsg()).getText();
    }
}
