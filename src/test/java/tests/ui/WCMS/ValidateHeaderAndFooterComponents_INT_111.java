package tests.ui.WCMS;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.json.simple.JSONObject;
import base.utils.JsonFileReader;
import tests.ui.base.BaseTest;
import pages.ui.HeaderFooterComponentPage;

public class ValidateHeaderAndFooterComponents_INT_111 extends BaseTest {

    private static final String TEST_DATA_PATH = "src/main/resources/Jsons/validate-header-and-footer-components-INT-111.json";
    private static final String TEST_CASE_ID = "INT-111";
    private String baseUrl;

    @BeforeMethod(alwaysRun = true)
    public void beforeMethod() {
        try {
            JSONObject testData = JsonFileReader.getTestData(TEST_DATA_PATH, TEST_CASE_ID);
            if (testData != null && testData.containsKey("URL")) {
                baseUrl = (String) testData.get("URL");
                driver.get(baseUrl);
            } else {
                // Default to ASTM stage URL if not found
                baseUrl = "https://stage-www.astm.org/";
                driver.get(baseUrl);
            }
        } catch (Exception e) {
            e.printStackTrace();
            // Fallback to default URL
            baseUrl = "https://stage-www.astm.org/";
            driver.get(baseUrl);
        }
    }

    @Test(description = "INT-111: Validate header and footer components on ASTM homepage")
    @Description("Verify that all header and footer components are visible and correct on the ASTM homepage as per INT-111.")
    @Severity(SeverityLevel.NORMAL)
    public void validateHeaderAndFooterComponents_INT_111() {
        try {
            HeaderFooterComponentPage headerFooterComponentPage = page.getInstance(HeaderFooterComponentPage.class);
            headerFooterComponentPage.validateHeaderAndFooterComponents();
        } catch (Exception e) {
            e.printStackTrace();
            assert false : "Exception occurred during header/footer validation: " + e.getMessage();
        }
    }
}
