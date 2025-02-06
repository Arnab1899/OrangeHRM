package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LogoutPage {
    private WebDriver driver;

    // Locators
    private By profileDropdown = By.className("oxd-userdropdown-name"); // Profile dropdown
    private By logoutButton = By.xpath("//a[text()='Logout']"); // Logout option

    ////*[@id="app"]/div[1]/div[1]/header/div[1]/div[3]/ul/li/ul/li[4]/a

    // Constructor
    public LogoutPage(WebDriver driver) {
        this.driver = driver;
    }

    // Method to click on the profile dropdown
    public void clickProfileDropdown() throws InterruptedException {
        driver.findElement(profileDropdown).click();
        Thread.sleep(2000);

    }

    // Method to click the logout button
    public void clickLogout() throws InterruptedException {
        driver.findElement(logoutButton).click();
        Thread.sleep(2000);
    }

    // Method to perform full logout
    public void logout() throws InterruptedException {
        clickProfileDropdown();
        clickLogout();
    }
}
