package pages.ui;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import io.qameta.allure.Step;
import base.utils.WaitStatementUtils;

public class HeaderComponentPage extends BasePage {

    // Locators for header components
    public By homeLink = By.linkText("Home");
    public By aboutASTMDropdown = By.xpath("//button[text()='About ASTM']");
    public By membershipParticipationDropdown = By.xpath("//button[text()='Membership & Participation']");
    public By standardsSolutionsDropdown = By.xpath("//button[text()='Standards & Solutions']");
    public By newsDropdown = By.xpath("//button[text()='News']");
    public By helpDropdown = By.xpath("//button[text()='Help']");
    public By faqLink = By.linkText("FAQ");
    
    public HeaderComponentPage(WebDriver driver) {
        super(driver);
    }

    @Step("Validate all header components are visible and interactable")
    public void validateHeaderComponents() {
        // Wait for and validate Home link
        WaitStatementUtils.explicitWaitForVisibility(driver, getElement(homeLink), 15);
        if (!getElement(homeLink).isDisplayed()) {
            throw new AssertionError("Home link is not visible in header");
        }
        // Wait for and validate About ASTM dropdown
        WaitStatementUtils.explicitWaitForVisibility(driver, getElement(aboutASTMDropdown), 15);
        if (!getElement(aboutASTMDropdown).isDisplayed()) {
            throw new AssertionError("About ASTM dropdown is not visible in header");
        }
        // Wait for and validate Membership & Participation dropdown
        WaitStatementUtils.explicitWaitForVisibility(driver, getElement(membershipParticipationDropdown), 15);
        if (!getElement(membershipParticipationDropdown).isDisplayed()) {
            throw new AssertionError("Membership & Participation dropdown is not visible in header");
        }
        // Wait for and validate Standards & Solutions dropdown
        WaitStatementUtils.explicitWaitForVisibility(driver, getElement(standardsSolutionsDropdown), 15);
        if (!getElement(standardsSolutionsDropdown).isDisplayed()) {
            throw new AssertionError("Standards & Solutions dropdown is not visible in header");
        }
        // Wait for and validate News dropdown
        WaitStatementUtils.explicitWaitForVisibility(driver, getElement(newsDropdown), 15);
        if (!getElement(newsDropdown).isDisplayed()) {
            throw new AssertionError("News dropdown is not visible in header");
        }
        // Wait for and validate Help dropdown
        WaitStatementUtils.explicitWaitForVisibility(driver, getElement(helpDropdown), 15);
        if (!getElement(helpDropdown).isDisplayed()) {
            throw new AssertionError("Help dropdown is not visible in header");
        }
        // Wait for and validate FAQ link
        WaitStatementUtils.explicitWaitForVisibility(driver, getElement(faqLink), 15);
        if (!getElement(faqLink).isDisplayed()) {
            throw new AssertionError("FAQ link is not visible in header");
        }
    }
}
