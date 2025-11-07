package tests.ui.WCMS;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.Assert;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import pages.ui.SearchPage;
import base.utils.JsonFileReader;
import org.json.simple.JSONObject;
import tests.ui.base.BaseTest;

public class VerifySearchFunctionality_INT_666 extends BaseTest {

    private SearchPage searchPage;
    private static final String TEST_DATA_PATH = "src/main/resources/Jsons/VerifySearchFunctionality_INT-666.json";

    @BeforeMethod(alwaysRun = true)
    public void beforeTest() {
        // No specific preconditions or URL navigation required as per test data
    }

    @Test(description = "INT-666: Verify Search functionality displays results related to 'Standards'")
    @Description("Verify that searching for 'Standards' displays relevant search results as expected.")
    @Severity(SeverityLevel.NORMAL)
    public void verifySearchFunctionality_INT_666() {
        try {
            searchPage = page.getInstance(SearchPage.class);
            JSONObject testData = JsonFileReader.getTestData(TEST_DATA_PATH, "INT-666");

            // Extract search term from test data
            String searchTerm = testData.get("searchTerm") != null ? testData.get("searchTerm").toString() : "Standards";
            // Call the comprehensive Page Object method for search and result verification
            boolean isResultDisplayed = searchPage.searchAndVerifyResults(searchTerm);

            Assert.assertTrue(isResultDisplayed, "Search results related to '" + searchTerm + "' were not displayed as expected.");
        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail("Exception occurred during search functionality verification: " + e.getMessage());
        }
    }
}
