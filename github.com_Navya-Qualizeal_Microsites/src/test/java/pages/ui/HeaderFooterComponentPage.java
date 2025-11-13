package pages.ui;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import io.qameta.allure.Step;
import base.utils.WaitStatementUtils;

public class HeaderFooterComponentPage extends BasePage {

    // Header Locators
    private By homeLink = By.linkText("Home");
    private By aboutASTMButton = By.xpath("//button[text()='About ASTM']");
    private By membershipParticipationButton = By.xpath("//button[text()='Membership & Participation']");
    private By standardsSolutionsButton = By.xpath("//button[text()='Standards & Solutions']");
    private By newsButton = By.xpath("//button[text()='News']");
    private By helpButton = By.xpath("//button[text()='Help']");
    private By faqLink = By.linkText("FAQ");

    // Footer Locators
    private By astmFooterLogo = By.xpath("//a[@aria-label='ASTM Footer Logo']");
    private By aboutASTMFooterLink = By.linkText("About ASTM");
    private By governanceFooterLink = By.linkText("Governance");
    private By globalCooperationFooterLink = By.linkText("Global Cooperation");
    private By corporateCitizenshipFooterLink = By.linkText("Corporate Citizenship");
    private By historyFooterLink = By.linkText("History");
    private By regionalOfficesFooterLink = By.linkText("Regional Offices and Websites");
    private By diversityInclusionFooterLink = By.linkText("Diversity, Equity, Inclusion & Belonging");
    private By cultureCareersFooterLink = By.linkText("Culture & Careers");
    private By logoPolicyFooterLink = By.linkText("Logo Policy");
    private By privacyPolicyFooterLink = By.linkText("Privacy Policy");
    private By ipPolicyFooterLink = By.linkText("IP Policy");
    private By returnPolicyFooterLink = By.linkText("Return Policy");
    private By copyrightPermissionsFooterLink = By.linkText("Copyright & Permissions");

    public HeaderFooterComponentPage(WebDriver driver) {
        super(driver);
    }

    @Step("Validate header and footer components on the ASTM homepage")
    public void validateHeaderAndFooterComponents() {
        // Header validation
        WaitStatementUtils.explicitWaitForVisibility(driver, driver.findElement(homeLink), 10);
        getElement(homeLink).isDisplayed();
        getElement(aboutASTMButton).isDisplayed();
        getElement(membershipParticipationButton).isDisplayed();
        getElement(standardsSolutionsButton).isDisplayed();
        getElement(newsButton).isDisplayed();
        getElement(helpButton).isDisplayed();
        getElement(faqLink).isDisplayed();

        // Footer validation
        WaitStatementUtils.explicitWaitForVisibility(driver, driver.findElement(astmFooterLogo), 10);
        getElement(astmFooterLogo).isDisplayed();
        getElement(aboutASTMFooterLink).isDisplayed();
        getElement(governanceFooterLink).isDisplayed();
        getElement(globalCooperationFooterLink).isDisplayed();
        getElement(corporateCitizenshipFooterLink).isDisplayed();
        getElement(historyFooterLink).isDisplayed();
        getElement(regionalOfficesFooterLink).isDisplayed();
        getElement(diversityInclusionFooterLink).isDisplayed();
        getElement(cultureCareersFooterLink).isDisplayed();
        getElement(logoPolicyFooterLink).isDisplayed();
        getElement(privacyPolicyFooterLink).isDisplayed();
        getElement(ipPolicyFooterLink).isDisplayed();
        getElement(returnPolicyFooterLink).isDisplayed();
        getElement(copyrightPermissionsFooterLink).isDisplayed();
    }

}
