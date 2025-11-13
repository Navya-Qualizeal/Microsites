package tests.ui.WCMS;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import java.io.FileReader;
import pages.ui.FooterComponentPage;
import tests.ui.base.BaseTest;
import base.utils.JsonFileReader;

public class ValidateHeaderAndFooterComponents_INT_111 extends BaseTest {

    private String baseUrl;
    private JSONObject testData;
    private static final String TEST_DATA_PATH = "src/main/resources/Jsons/validate-header-and-footer-components-INT-111.json";
    private static final String TEST_CASE_ID = "INT-111";

    @BeforeMethod(alwaysRun = true)
    public void beforeMethod() {
        try {
            // Load test data for INT-111
            testData = JsonFileReader.getTestData(TEST_DATA_PATH, TEST_CASE_ID);
            JSONObject urlObj = (JSONObject) testData.get("TestData");
            // If URL is present in testData, use it
            if (urlObj != null && urlObj.get("URL") != null) {
                baseUrl = (String) urlObj.get("URL");
            } else {
                baseUrl = "https://stage-www.astm.org/";
            }
            driver.get(baseUrl);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test(description = "INT-111: Validate header and footer components")
    @Description("Validate that the user can see the footer components successfully on the ASTM homepage.")
    @Severity(SeverityLevel.NORMAL)
    public void validateHeaderAndFooterComponents_INT_111() {
        try {
            FooterComponentPage footerComponentPage = page.getInstance(FooterComponentPage.class);
            // Validate presence and visibility of all main footer components
            footerComponentPage.validateFooterComponents();
            // Validate presence and visibility of all deep footer links
            footerComponentPage.validateAllFooterDeepLinks();
            // If needed, add assertions for specific footer data from testData
            // Example: Validate copyright text
            // String expectedCopyright = ((JSONObject) testData.get("FooterComponents")).get("Copyright").toString();
            // ... (custom assertion if required)
        } catch (Exception e) {
            e.printStackTrace();
            assert false : "Exception occurred during footer validation: " + e.getMessage();
        }
    }
}
