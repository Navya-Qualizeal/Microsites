package pages.ui;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import base.utils.WaitStatementUtils;
import base.utils.ReusableMethods;
import java.util.List;
import io.qameta.allure.Step;

public class SearchPage {
    private WebDriver driver;

    // Locators for Search functionality (Desktop and Mobile)
    private By searchInputDesktop = By.xpath("//div[@class='d-md-block d-none']//input[@type='search']");
    private By searchInputMobile = By.xpath("//div[@class='searchbar_mobileSearchContainer__pk83R']//input[@type='search']");
    private By searchButtonDesktop = By.xpath("//div[@class='d-md-block d-none']//button[@type='submit' and contains(@class, 'main-search-submit')]");
    private By searchButtonMobile = By.xpath("//div[@class='searchbar_mobileSearchContainer__pk83R']//button[@type='submit' and contains(@class, 'main-search-submit')]");
    private By searchResultItems = By.xpath("//div[contains(@class,'search-results')]//*[contains(text(),'Standards')]"); // TODO: Replace with actual locator for search results

    public SearchPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Perform search for keyword '{0}' and verify results related to 'Standards' are displayed")
    public void searchAndVerifyResults(String keyword) {
        boolean isDesktop = driver.findElements(searchInputDesktop).size() > 0;
        if (isDesktop) {
            WebElement input = driver.findElement(searchInputDesktop);
            WaitStatementUtils.explicitWaitForVisibility(driver, input, 10);
            input.clear();
            input.sendKeys(keyword);
            WebElement btn = driver.findElement(searchButtonDesktop);
            WaitStatementUtils.waitForElementToBeClickable(driver, btn, 10);
            btn.click();
        } else {
            WebElement input = driver.findElement(searchInputMobile);
            WaitStatementUtils.explicitWaitForVisibility(driver, input, 10);
            input.clear();
            input.sendKeys(keyword);
            WebElement btn = driver.findElement(searchButtonMobile);
            WaitStatementUtils.waitForElementToBeClickable(driver, btn, 10);
            btn.click();
        }
        // Wait for results to load (adjust as needed)
        ReusableMethods.waitForSec(3);
        List<WebElement> results = driver.findElements(searchResultItems);
        if (results == null || results.isEmpty()) {
            throw new AssertionError("No search results related to 'Standards' were displayed.");
        }
    }
}
