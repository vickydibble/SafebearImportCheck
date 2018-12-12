package com.safebear.auto.Locators;

import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.openqa.selenium.By;
@Data
//@RequiredArgsConstructor

public class ToolsPageLocators {
//@NonNull
    private By sucessfulLoginMsg = By.xpath("//p[2]/b");
}
