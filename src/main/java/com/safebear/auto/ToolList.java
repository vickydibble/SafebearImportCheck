package com.safebear.auto;

import java.util.ArrayList;
import java.util.List;


public class ToolList {
    private static final List<Tool> TOOL_LIST = new ArrayList();
    
    private ToolList(){
    }
    
    static{
        TOOL_LIST.add(new Tool("Selenium","Web Test Automation","www.seleniumhq.org"));
        TOOL_LIST.add(new Tool("TestCafe","Web Test Automation","devexpress.github.io/testcafe"));
        TOOL_LIST.add(new Tool("Appium","Mobile Test Automation","appium.io"));
        TOOL_LIST.add(new Tool("JMeter","Performance Test","jmeter.apache.org"));
        TOOL_LIST.add(new Tool("Protractor","Angular Web Test Automation","www.protractortest.org"));
        TOOL_LIST.add(new Tool("Postman","API Testing","www.getpostman.com"));
    }
    
    public static List <Tool> getInstance(){
        return TOOL_LIST;
    }
}
