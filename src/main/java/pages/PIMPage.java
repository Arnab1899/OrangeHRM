package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PIMPage {
    private WebDriver driver;

    // Locators
    private By pimMenu = By.xpath("//span[text()='PIM']"); // Click on PIM menu
    private By addButton = By.xpath("//button[text()=' Add ']"); // Click Add Employee button
    private By firstNameField = By.name("firstName");
    private By lastNameField = By.name("lastName");
    private By employeeIdField = By.xpath("//label[text()='Employee Id']/following::input[1]");
    private By createLoginDetails = By.cssSelector("span.oxd-switch-input.oxd-switch-input--active"); // Toggle Login Details
    private By usernameField = By.xpath("//label[text()='Username']/following::input[1]");
    private By passwordField = By.xpath("//label[text()='Password']/following::input[1]");
    private By confirmPasswordField = By.xpath("//label[text()='Confirm Password']/following::input[1]");
    private By saveButton = By.xpath("//button[text()=' Save ']"); // Save Employee
    //private By successMessage = By.xpath("//div[contains(@class, 'oxd-toast-content-text')]");

    // Constructor
    public PIMPage(WebDriver driver) {
        this.driver = driver;
    }

    // Method to navigate to PIM section
    public void navigateToPIM() {
        driver.findElement(pimMenu).click();
    }

    // Method to click Add Employee
    public void clickAddEmployee() {
        driver.findElement(addButton).click();
    }

    // Method to enter employee details
    public void enterEmployeeDetails(String firstName, String lastName, String employeeId) {
        driver.findElement(firstNameField).sendKeys(firstName);
        driver.findElement(lastNameField).sendKeys(lastName);
        driver.findElement(employeeIdField).clear();
        driver.findElement(employeeIdField).sendKeys(employeeId);

    }

    // Method to create login details
    public void createLoginDetails(String username, String password) {
        driver.findElement(createLoginDetails).click(); // Enable login details
        driver.findElement(usernameField).sendKeys(username);
        driver.findElement(passwordField).sendKeys(password);
        driver.findElement(confirmPasswordField).sendKeys(password);
    }

    // Method to save the employee
    public void clickSave() {
        driver.findElement(saveButton).click();
    }

    // Method to add a new employee with login details
    public void addEmployeeWithLoginDetails(String firstName, String lastName, String employeeId, String username, String password) {
        navigateToPIM();
        clickAddEmployee();
        enterEmployeeDetails(firstName, lastName, employeeId);
        createLoginDetails(username, password);
        clickSave();
    }

//    public boolean isEmployeeAddedSuccessfully() {
//       return driver.findElement(successMessage).isDisplayed();
//    }
}
