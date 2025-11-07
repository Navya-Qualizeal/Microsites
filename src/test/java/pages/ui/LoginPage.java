package pages.ui;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import base.utils.WaitStatementUtils;
import io.qameta.allure.Step;

public class LoginPage {
    private WebDriver driver;

    // Locators
    private By usernameInput = By.id("userName");
    private By passwordInput = By.id("encPass");
    private By signInButton = By.xpath("//button[text()='Sign In']");
    private By signInHeading = By.xpath("//h3[text()='Sign In']");
    private By forgotPasswordLink = By.linkText("Forgot Password?");
    private By rememberMeCheckbox = By.id("rememberMe");
    private By contactSupportLink = By.linkText("Contact Support");
    private By astmLogo = By.cssSelector("img.astm-logo");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Login to ASTM application with username and password, and verify header components after login")
    public void loginAndValidateHeader(String username, String password, HeaderComponentPage headerComponentPage) {
        // Wait for Sign In heading
        WaitStatementUtils.explicitWaitForVisibility(driver, driver.findElement(signInHeading), 10);
        // Enter username
        WebElement userField = driver.findElement(usernameInput);
        userField.clear();
        userField.sendKeys(username);
        // Enter password
        WebElement passField = driver.findElement(passwordInput);
        passField.clear();
        passField.sendKeys(password);
        // Click Sign In
        WaitStatementUtils.waitForElementToBeClickable(driver, driver.findElement(signInButton), 10);
        driver.findElement(signInButton).click();
        // Validate header components (delegated to HeaderComponentPage)
        headerComponentPage.validateHeaderComponents();
    }
}
