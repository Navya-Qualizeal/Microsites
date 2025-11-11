package pages.ui;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import io.qameta.allure.Step;
import base.utils.WaitStatementUtils;

public class SignInPage extends BasePage {

    // Locators for Sign In page elements
    private By usernameField = By.id("userName");
    private By passwordField = By.id("encPass");
    private By signInButton = By.xpath("//button[text()='Sign In']");
    private By rememberMeCheckbox = By.id("rememberMe");
    private By forgotPasswordLink = By.linkText("Forgot Password?");
    private By contactSupportLink = By.linkText("Contact Support");

    public SignInPage(WebDriver driver) {
        super(driver);
    }

    /**
     * Complete Sign In flow as per test case INT-888: Launch page, enter username, enter password, click Sign In.
     * This method performs the entire user action for validating Sign In.
     *
     * @param username The username to enter
     * @param password The password to enter
     */
    @Step("Sign in with username and password")
    public void signIn(String username, String password) {
        waitForElementPresent(usernameField);
        WebElement usernameInput = getElement(usernameField);
        usernameInput.clear();
        usernameInput.sendKeys(username);

        waitForElementPresent(passwordField);
        WebElement passwordInput = getElement(passwordField);
        passwordInput.clear();
        passwordInput.sendKeys(password);

        waitForElementPresent(signInButton);
        WebElement signInBtn = getElement(signInButton);
        WaitStatementUtils.waitForElementToBeClickable(driver, signInBtn, 10);
        signInBtn.click();
    }
}
