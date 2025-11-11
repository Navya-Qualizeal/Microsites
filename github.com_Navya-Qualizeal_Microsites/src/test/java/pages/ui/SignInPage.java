package pages.ui;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import io.qameta.allure.Step;
import base.utils.WaitStatementUtils;

public class SignInPage extends BasePage {

    // Locators for Sign In page elements
    private By usernameInput = By.id("userName");
    private By passwordInput = By.id("encPass");
    private By signInButton = By.xpath("//button[text()='Sign In']");
    private By rememberMeCheckbox = By.id("rememberMe");
    private By forgotPasswordLink = By.linkText("Forgot Password?");
    private By contactSupportLink = By.linkText("Contact Support");

    public SignInPage(WebDriver driver) {
        super(driver);
    }

    /**
     * Complete Sign In flow: enters username, password, optionally toggles Remember Me, and clicks Sign In.
     * This is the comprehensive method for the Sign In scenario INT-888.
     *
     * @param username The username to enter
     * @param password The password to enter
     * @param rememberMe Whether to check the Remember Me box
     */
    @Step("Sign in as user with username and password, and click Sign In")
    public void completeSignInFlow(String username, String password, boolean rememberMe) {
        // Wait for username input and enter username
        waitForElementPresent(usernameInput);
        getElement(usernameInput).clear();
        getElement(usernameInput).sendKeys(username);

        // Wait for password input and enter password
        waitForElementPresent(passwordInput);
        getElement(passwordInput).clear();
        getElement(passwordInput).sendKeys(password);

        // Optionally check Remember Me
        if (rememberMe) {
            WebElement checkbox = getElement(rememberMeCheckbox);
            if (!checkbox.isSelected()) {
                checkbox.click();
            }
        }

        // Wait for and click Sign In button
        waitForElementPresent(signInButton);
        clickOnMethod(signInButton);
    }
}
