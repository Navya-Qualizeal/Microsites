package tests.ui;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.Assert;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import pages.ui.HeaderComponentPage;
import base.utils.JsonFileReader;
import org.json.simple.JSONObject;
import tests.ui.base.BaseTest;

public class VerifyHeaderComponent_INT_555 extends BaseTest {

    private HeaderComponentPage headerComponentPage;
    private static final String testDataPath = "src/main/resources/Jsons/validate-header-components-INT-555.json";

    @BeforeMethod(alwaysRun = true)
    public void setUp() {
        // No URL provided in test data, so nothing to navigate
    }

    @Test(description = "INT-555: Validate header components are visible and correct")
    @Description("INT-555: User should be able to see the header components successfully.")
    @Severity(SeverityLevel.NORMAL)
    public void validateHeaderComponents_INT_555() {
        try {
            headerComponentPage = page.getInstance(HeaderComponentPage.class);

            // Load test data (if needed for future extensibility)
            JSONObject testData = JsonFileReader.getTestData(testDataPath, "INT-555");
            // No specific data items required for this test as per requirements

            // Call the comprehensive method to validate header components
            boolean isHeaderValid = headerComponentPage.validateHeaderComponents();
            Assert.assertTrue(isHeaderValid, "Header components are not displayed as expected.");
        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail("Exception occurred during header component validation: " + e.getMessage());
        }
    }
}
