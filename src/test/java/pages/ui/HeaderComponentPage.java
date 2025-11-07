package pages.ui;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import io.qameta.allure.Step;
import base.utils.WaitStatementUtils;

public class HeaderComponentPage extends BasePage {

    // Locators for header components
    public By homeLink = By.linkText("Home");
    public By aboutASTMButton = By.xpath("//button[contains(text(), 'About ASTM')]");
    public By membershipParticipationButton = By.xpath("//button[contains(text(), 'Membership & Participation')]");
    public By standardsSolutionsButton = By.xpath("//button[contains(text(), 'Standards & Solutions')]");
    public By newsButton = By.xpath("//button[contains(text(), 'News')]");
    public By helpButton = By.xpath("//button[contains(text(), 'Help')]");
    public By faqLink = By.linkText("FAQ");

    // Locators for login
    public By usernameInput = By.id("userName");
    public By passwordInput = By.id("encPass");
    public By signInButton = By.xpath("//button[text()='Sign In']");

    public HeaderComponentPage(WebDriver driver) {
        super(driver);
    }

    @Step("Login and validate header components are visible")
    public void loginAndValidateHeaderComponents(String username, String password) {
        // Wait for username field and enter username
        WaitStatementUtils.explicitWaitForVisibility(driver, driver.findElement(usernameInput), 20);
        driver.findElement(usernameInput).clear();
        driver.findElement(usernameInput).sendKeys(username);

        // Wait for password field and enter password
        WaitStatementUtils.explicitWaitForVisibility(driver, driver.findElement(passwordInput), 20);
        driver.findElement(passwordInput).clear();
        driver.findElement(passwordInput).sendKeys(password);

        // Click Sign In
        WaitStatementUtils.waitForElementToBeClickable(driver, driver.findElement(signInButton), 10);
        driver.findElement(signInButton).click();

        // Validate header components
        WaitStatementUtils.explicitWaitForVisibility(driver, driver.findElement(homeLink), 20);
        if (!driver.findElement(homeLink).isDisplayed())
            throw new AssertionError("Home link is not visible in header");
        if (!driver.findElement(aboutASTMButton).isDisplayed())
            throw new AssertionError("About ASTM button is not visible in header");
        if (!driver.findElement(membershipParticipationButton).isDisplayed())
            throw new AssertionError("Membership & Participation button is not visible in header");
        if (!driver.findElement(standardsSolutionsButton).isDisplayed())
            throw new AssertionError("Standards & Solutions button is not visible in header");
        if (!driver.findElement(newsButton).isDisplayed())
            throw new AssertionError("News button is not visible in header");
        if (!driver.findElement(helpButton).isDisplayed())
            throw new AssertionError("Help button is not visible in header");
        if (!driver.findElement(faqLink).isDisplayed())
            throw new AssertionError("FAQ link is not visible in header");
    }
}
