package pages.ui;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import io.qameta.allure.Step;
import base.utils.WaitStatementUtils;

public class FooterComponentPage extends BasePage {

    // Footer Locators (from provided locators)
    public By aboutASTMFooterLink = By.linkText("About ASTM");
    public By governanceFooterLink = By.linkText("Governance");
    public By globalCooperationFooterLink = By.linkText("Global Cooperation");
    public By corporateCitizenshipFooterLink = By.linkText("Corporate Citizenship");
    public By historyFooterLink = By.linkText("History");
    public By regionalOfficesFooterLink = By.linkText("Regional Offices and Websites");
    public By diversityInclusionFooterLink = By.linkText("Diversity, Equity, Inclusion & Belonging");
    public By cultureCareersFooterLink = By.linkText("Culture & Careers");
    public By returnPolicyFooterLink = By.linkText("Return Policy");
    public By ipPolicyFooterLink = By.linkText("IP Policy");
    public By copyrightPermissionsFooterLink = By.linkText("Copyright & Permissions");

    public FooterComponentPage(WebDriver driver) {
        super(driver);
    }

    /**
     * Comprehensive method to validate the presence and visibility of all footer components as per INT-111.
     * Throws AssertionError if any footer component is not displayed.
     */
    @Step("Validate all footer components are visible and present")
    public void validateFooterComponents() {
        // About ASTM
        waitForElementPresent(aboutASTMFooterLink);
        if (!getElement(aboutASTMFooterLink).isDisplayed()) {
            throw new AssertionError("About ASTM footer link is not displayed");
        }
        // Governance
        waitForElementPresent(governanceFooterLink);
        if (!getElement(governanceFooterLink).isDisplayed()) {
            throw new AssertionError("Governance footer link is not displayed");
        }
        // Global Cooperation
        waitForElementPresent(globalCooperationFooterLink);
        if (!getElement(globalCooperationFooterLink).isDisplayed()) {
            throw new AssertionError("Global Cooperation footer link is not displayed");
        }
        // Corporate Citizenship
        waitForElementPresent(corporateCitizenshipFooterLink);
        if (!getElement(corporateCitizenshipFooterLink).isDisplayed()) {
            throw new AssertionError("Corporate Citizenship footer link is not displayed");
        }
        // History
        waitForElementPresent(historyFooterLink);
        if (!getElement(historyFooterLink).isDisplayed()) {
            throw new AssertionError("History footer link is not displayed");
        }
        // Regional Offices and Websites
        waitForElementPresent(regionalOfficesFooterLink);
        if (!getElement(regionalOfficesFooterLink).isDisplayed()) {
            throw new AssertionError("Regional Offices and Websites footer link is not displayed");
        }
        // Diversity, Equity, Inclusion & Belonging
        waitForElementPresent(diversityInclusionFooterLink);
        if (!getElement(diversityInclusionFooterLink).isDisplayed()) {
            throw new AssertionError("Diversity, Equity, Inclusion & Belonging footer link is not displayed");
        }
        // Culture & Careers
        waitForElementPresent(cultureCareersFooterLink);
        if (!getElement(cultureCareersFooterLink).isDisplayed()) {
            throw new AssertionError("Culture & Careers footer link is not displayed");
        }
        // Return Policy
        waitForElementPresent(returnPolicyFooterLink);
        if (!getElement(returnPolicyFooterLink).isDisplayed()) {
            throw new AssertionError("Return Policy footer link is not displayed");
        }
        // IP Policy
        waitForElementPresent(ipPolicyFooterLink);
        if (!getElement(ipPolicyFooterLink).isDisplayed()) {
            throw new AssertionError("IP Policy footer link is not displayed");
        }
        // Copyright & Permissions
        waitForElementPresent(copyrightPermissionsFooterLink);
        if (!getElement(copyrightPermissionsFooterLink).isDisplayed()) {
            throw new AssertionError("Copyright & Permissions footer link is not displayed");
        }
    }
}
