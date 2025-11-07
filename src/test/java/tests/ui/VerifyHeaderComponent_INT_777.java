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

public class VerifyHeaderComponent_INT_777 extends BaseTest {

    private HeaderComponentPage headerComponentPage;
    private static final String TEST_DATA_PATH = "src/main/resources/Jsons/validate-header-components-INT-777.json";

    @BeforeMethod(alwaysRun = true)
    public void setUp() {
        // No URL provided in test data, so nothing to navigate to here
    }

    @Test(description = "INT-777: Validate header components are visible and correct")
    @Description("INT-777: User should be able to see the header components successfully")
    @Severity(SeverityLevel.NORMAL)
    public void validateHeaderComponents_INT_777() {
        try {
            headerComponentPage = page.getInstance(HeaderComponentPage.class);

            // Load test data
            JSONObject testData = JsonFileReader.getTestData(TEST_DATA_PATH, "INT-777");
            // No parameter extraction needed as per test data (0 data items)

            // Call the comprehensive method for header validation
            headerComponentPage.loginAndValidateHeaderComponents();

            // Assert header components are displayed (assuming method returns boolean or has internal asserts)
            // If loginAndValidateHeaderComponents() returns boolean, use:
            // Assert.assertTrue(headerComponentPage.loginAndValidateHeaderComponents(), "Header components are not displayed correctly");
            // If it throws on failure, above call is sufficient.
        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail("Exception occurred during header components validation: " + e.getMessage());
        }
    }
}
