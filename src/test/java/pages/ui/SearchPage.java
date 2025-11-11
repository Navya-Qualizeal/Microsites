package pages.ui;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import base.utils.WaitStatementUtils;
import io.qameta.allure.Step;

public class SearchPage extends BasePage {

    // Locators
    public By searchInput = By.cssSelector("input.input-text");
    public By searchButton = By.cssSelector("button.astm-btn");
    public By searchResultTitle = By.cssSelector("h2.styles_mainTitle__RuNUL");

    public SearchPage(WebDriver driver) {
        super(driver);
    }

    /**
     * Complete search flow: enters keyword, submits search, and verifies result title.
     * @param keyword The search keyword to enter (e.g., "Standards").
     */
    @Step("Perform search for a keyword and verify search results are displayed")
    public void searchAndVerifyResults(String keyword) {
        // Wait for search input to be visible and enter keyword
        WebElement input = getElement(searchInput);
        input.clear();
        input.sendKeys(keyword);

        // Option 1: Click the search button
        clickOnMethod(searchButton);
        // Option 2: Alternatively, you could use input.sendKeys(Keys.ENTER);

        // Wait for the search result title to be visible
        WaitStatementUtils.explicitWaitForVisibility(driver, getElement(searchResultTitle), 15);
    }

    /**
     * Get the text of the search result title (e.g., "Search Result").
     * @return The search result title text.
     */
    public String getSearchResultTitleText() {
        return getElement(searchResultTitle).getText();
    }
}
