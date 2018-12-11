package com.safebear.auto.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class Util {




    private static final String URL = System.getProperty("url","http://toolslist.safebear.co.uk/8080");
    private static final String BROWSER = System.getProperty("browser", "chrome");

//    private ChromeOptions chromeOptions = new ChromeOptions();
//    private FirefoxOptions ffOptions = new FirefoxOptions();


    public static String getUrl(){
        return URL;
    }

    public static WebDriver getDriver(){

        System.setProperty("webdriver.chrome.driver","src/test/resources/drivers/chromedriver.exe");
        System.setProperty("webdriver.gecko.driver","src/test/resources/drivers/geckodriver.exe");

        ChromeOptions chrOptions = new ChromeOptions();
        chrOptions.addArguments("window-size = 1366,768");

        FirefoxOptions ffoptions = new FirefoxOptions();
        ffoptions.addArguments("window-size = 1366,768");



        switch (BROWSER) {

            case "chrome":

                return new ChromeDriver(chrOptions);


            case "firefox":
                return new FirefoxDriver(ffoptions);

                default:

                    return  new ChromeDriver(chrOptions);


        }



    }
}
