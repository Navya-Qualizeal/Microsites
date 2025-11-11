package pages.ui;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import io.qameta.allure.Step;
import base.utils.WaitStatementUtils;

public class HeaderComponentPage extends BasePage {

    // Locators for header components
    public By homeLink = By.linkText("Home");

    public HeaderComponentPage(WebDriver driver) {
        super(driver);
    }

    /**
     * Comprehensive method to validate the presence and visibility of all header components as per TC-N001.
     * This method checks for Home, About ASTM, Membership & Participation, Standards & Solutions, News, Help, and FAQ header elements.
     * Throws AssertionError if any header component is not displayed.
     */
    public void validateHeaderComponents() {
        // Wait for and validate Home Link
        waitForElementPresent(By.linkText("Home"));
        if (!getElement(By.linkText("Home")).isDisplayed()) {
            throw new AssertionError("Home link is not displayed in the header");
        }

        // Wait for and validate About ASTM Button
        waitForElementPresent(By.xpath("//button[contains(text(),'About ASTM')]"));
        if (!getElement(By.xpath("//button[contains(text(),'About ASTM')]")).isDisplayed()) {
            throw new AssertionError("About ASTM button is not displayed in the header");
        }

        // Wait for and validate Membership & Participation Button
        waitForElementPresent(By.xpath("//button[contains(text(),'Membership & Participation')]"));
        if (!getElement(By.xpath("//button[contains(text(),'Membership & Participation')]")).isDisplayed()) {
            throw new AssertionError("Membership & Participation button is not displayed in the header");
        }

        // Wait for and validate Standards & Solutions Button
        waitForElementPresent(By.xpath("//button[contains(text(),'Standards & Solutions')]"));
        if (!getElement(By.xpath("//button[contains(text(),'Standards & Solutions')]")).isDisplayed()) {
            throw new AssertionError("Standards & Solutions button is not displayed in the header");
        }

        // Wait for and validate News Button
        waitForElementPresent(By.xpath("//button[contains(text(),'News')]"));
        if (!getElement(By.xpath("//button[contains(text(),'News')]")).isDisplayed()) {
            throw new AssertionError("News button is not displayed in the header");
        }

        // Wait for and validate Help Button
        waitForElementPresent(By.xpath("//button[contains(text(),'Help')]"));
        if (!getElement(By.xpath("//button[contains(text(),'Help')]")).isDisplayed()) {
            throw new AssertionError("Help button is not displayed in the header");
        }

        // Wait for and validate FAQ Link
        waitForElementPresent(By.linkText("FAQ"));
        if (!getElement(By.linkText("FAQ")).isDisplayed()) {
            throw new AssertionError("FAQ link is not displayed in the header");
        }
    }
}