package tests.ui.WCMS;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.Assert;
import pages.ui.HeaderComponentPage;
import base.utils.JsonFileReader;
import org.json.simple.JSONObject;
import tests.ui.base.BaseTest;

public class ValidateHeaderComponents_INT_124 extends BaseTest {

    private String baseUrl;
    private JSONObject testData;

    @BeforeMethod(alwaysRun = true)
    public void setUp() {
        // Load test data for INT-124
        String testDataPath = "src/main/resources/Jsons/validate-header-components-INT-124.json";
        testData = JsonFileReader.getTestData(testDataPath, "INT-124");
        if (testData != null && testData.containsKey("TestData")) {
            JSONObject td = (JSONObject) testData.get("TestData");
            baseUrl = "https://stage-www.astm.org/"; // As per test data
        } else {
            baseUrl = "https://stage-www.astm.org/"; // fallback
        }
        driver.get(baseUrl);
    }

    @Test(description = "INT-124: Validate header components are visible and interactable on ASTM homepage")
    @Description("User should be able to see the header components successfully as per INT-124.")
    @Severity(SeverityLevel.NORMAL)
    public void validateHeaderComponents_INT_124() {
        try {
            HeaderComponentPage headerComponentPage = page.getInstance(HeaderComponentPage.class);
            headerComponentPage.validateHeaderComponents();
            // If no exception, test passes
            Assert.assertTrue(true, "All header components are visible and interactable.");
        } catch (AssertionError ae) {
            Assert.fail("Header component assertion failed: " + ae.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail("Exception occurred during header component validation: " + e.getMessage());
        }
    }
}
