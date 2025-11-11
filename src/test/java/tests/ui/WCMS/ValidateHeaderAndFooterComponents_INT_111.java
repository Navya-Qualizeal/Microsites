package tests.ui.WCMS;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import tests.ui.base.BaseTest;
import pages.ui.HeaderComponentPage;
import pages.ui.FooterComponentPage;
import base.utils.JsonFileReader;
import org.json.simple.JSONObject;
import org.testng.Assert;

public class ValidateHeaderAndFooterComponents_INT_111 extends BaseTest {

    private HeaderComponentPage headerComponentPage;
    private FooterComponentPage footerComponentPage;
    private static final String TEST_DATA_PATH = "src/main/resources/Jsons/validate-header-and-footer-components-INT-111.json";

    @BeforeMethod(alwaysRun = true)
    public void beforeTest() {
        // No URL provided in test data, so no navigation here.
    }

    @Test(description = "INT-111: Validate header and footer components are visible")
    @Description("User should be able to see the header and footer components successfully.")
    @Severity(SeverityLevel.NORMAL)
    public void validateHeaderAndFooterComponents_INT_111() {
        try {
            // Load test data (if needed for future expansion)
            JSONObject testData = JsonFileReader.getTestData(TEST_DATA_PATH, "INT-111");

            headerComponentPage = page.getInstance(HeaderComponentPage.class);
            footerComponentPage = page.getInstance(FooterComponentPage.class);

            // Call comprehensive Page Object methods
            boolean isHeaderValid = headerComponentPage.validateHeaderComponents();
            boolean isFooterValid = footerComponentPage.validateFooterComponents();

            Assert.assertTrue(isHeaderValid, "Header components are not displayed as expected.");
            Assert.assertTrue(isFooterValid, "Footer components are not displayed as expected.");
        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail("Exception occurred during header and footer validation: " + e.getMessage());
        }
    }
}
