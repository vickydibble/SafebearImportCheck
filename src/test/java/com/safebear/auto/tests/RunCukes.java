package com.safebear.auto.tests;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions
        (
                plugin = {"pretty", "html:target/cucumber"},
                tags = "~to-do",
                glue = "com.safebear.auto.tests",
                features = "classpath:toolslist.features/login.feature"
        )

public class RunCukes extends AbstractTestNGCucumberTests {





    }

