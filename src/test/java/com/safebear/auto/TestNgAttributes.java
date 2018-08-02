package com.safebear.auto;

import org.testng.annotations.Test;

public class TestNgAttributes {

    String message;

    // test case 1
    @Test(priority = 2)
    public void testCase1() {
        System.out.println("**This is Test Case 1, which has a priority of 2**");
    }

    // test case 2
    @Test(priority = 1, groups = {"test"})
    public void testCase2() {
        System.out.println("**This is Test Case 2, which has a priority of 1 and is in the 'test' group**");
    }

    // test case 3
    @Test(groups = {"test"})
    public void testCase3() {
        System.out.println("**This is Test Case 3, it's priority hasn't been set, which means it defaults to 0 and runs first. It's also in the 'test' group**");
    }

    // test case 4
    // you can also use a `dependsOnGroup` attribute
    @Test(dependsOnMethods = "testCase5")
    public void testCase4() {
        System.out.println(message);
    }

    // test case 5
    @Test(priority = 3)
    public void testCase5() {
        System.out.println("**This is Test Case 5, which will run before test case 4, despite being default priority 0, because of the 'dependsOnMethods' attribute in Test Case 4**");
        message = "**This is Test Case 4, it has a priority of 3, and its message was created in test case 5**";
    }

    // test case 6
    @Test(enabled = false)
    public void testCase6() {
        System.out.println("**This is Test Case 6, which will never run**");
    }

}
