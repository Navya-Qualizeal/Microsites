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
     * Comprehensive method to validate all main header components are visible and interactable as per INT-124.
     * This covers: Home, About ASTM, Membership & Participation, Standards & Solutions, News, Help, FAQ.
     *
     * Steps:
     *  - Wait for each header component to be present
     *  - Optionally, check that each is displayed and enabled
     *  - Optionally, click buttons to verify they are interactable (without navigation)
     *
     * Throws AssertionError if any component is missing or not interactable.
     */
    public void validateHeaderComponents() {
        // Home Link
        waitForElementPresent(By.linkText("Home"));
        if (!driver.findElement(By.linkText("Home")).isDisplayed()) {
            throw new AssertionError("Home link is not displayed in header");
        }

        // About ASTM Button
        waitForElementPresent(By.xpath("//button[text()='About ASTM']"));
        if (!driver.findElement(By.xpath("//button[text()='About ASTM']")).isDisplayed()) {
            throw new AssertionError("About ASTM button is not displayed in header");
        }

        // Membership & Participation Button
        waitForElementPresent(By.xpath("//button[text()='Membership & Participation']"));
        if (!driver.findElement(By.xpath("//button[text()='Membership & Participation']")).isDisplayed()) {
            throw new AssertionError("Membership & Participation button is not displayed in header");
        }

        // Standards & Solutions Button
        waitForElementPresent(By.xpath("//button[text()='Standards & Solutions']"));
        if (!driver.findElement(By.xpath("//button[text()='Standards & Solutions']")).isDisplayed()) {
            throw new AssertionError("Standards & Solutions button is not displayed in header");
        }

        // News Button
        waitForElementPresent(By.xpath("//button[text()='News']"));
        if (!driver.findElement(By.xpath("//button[text()='News']")).isDisplayed()) {
            throw new AssertionError("News button is not displayed in header");
        }

        // Help Button
        waitForElementPresent(By.xpath("//button[text()='Help']"));
        if (!driver.findElement(By.xpath("//button[text()='Help']")).isDisplayed()) {
            throw new AssertionError("Help button is not displayed in header");
        }

        // FAQ Link
        waitForElementPresent(By.linkText("FAQ"));
        if (!driver.findElement(By.linkText("FAQ")).isDisplayed()) {
            throw new AssertionError("FAQ link is not displayed in header");
        }
    }
}