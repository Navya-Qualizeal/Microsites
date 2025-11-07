package tests.ui.WCMS;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.Assert;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import pages.ui.HeaderComponentPage;
import base.utils.JsonFileReader;
import org.json.simple.JSONObject;

public class VerifyHeaderComponent_INT_777 {

    @BeforeMethod(alwaysRun = true)
    public void beforeTest() {
        // No URL provided in test data, so nothing to navigate
    }

    @Test(description = "INT-777: Validate header components are displayed successfully")
    @Description("INT-777: User should be able to see the header components successfully")
    @Severity(SeverityLevel.NORMAL)
    public void validateHeaderComponents_INT_777() {
        try {
            HeaderComponentPage headerComponentPage = page.getInstance(HeaderComponentPage.class);

            // If test data is needed in the future, load as below:
            // String testDataPath = "src/main/resources/Jsons/validate-header-components-INT-777.json";
            // JSONObject testData = JsonFileReader.getTestData(testDataPath, "INT-777");

            // Call the comprehensive method to validate header components
            boolean headerDisplayed = headerComponentPage.validateHeaderComponents();
            Assert.assertTrue(headerDisplayed, "Header components are not displayed as expected.");
        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail("Exception occurred in validateHeaderComponents_INT_777: " + e.getMessage());
        }
    }
}
