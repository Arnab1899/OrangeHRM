package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.LogoutPage;
import pages.PIMPage;
import base.BaseTest;

public class HrmTest extends BaseTest {

    @Test (priority = 2)
    public void testLogout() throws InterruptedException {

        Thread.sleep(10000);
        // Perform Logout
        LogoutPage logoutPage = new LogoutPage(driver);
        logoutPage.logout();

        // Verify if redirected to login page after logout
        String expectedUrl = "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";
        String actualUrl = driver.getCurrentUrl();
        Assert.assertEquals(actualUrl, expectedUrl, "Logout failed!");
    }

    @Test (priority = 1, dependsOnMethods = "testLogin")
    public void testAddEmployee() throws InterruptedException {
        PIMPage pimPage = new PIMPage(driver);
        pimPage.addEmployeeWithLoginDetails("Demo", "MemberTwo", "12345", "demomember5", "passWord.123");


        //Assert.assertTrue(pimPage.isEmployeeAddedSuccessfully(), "Employee was not added successfully!");
    }

    @Test (priority = 0)
    public void testLogin() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("Admin", "admin123");

        // Verify login success by checking the URL or some dashboard element
        String expectedUrl = "https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index";
        String actualUrl = driver.getCurrentUrl();
        Assert.assertEquals(actualUrl, expectedUrl, "Login failed!");

    }
}
