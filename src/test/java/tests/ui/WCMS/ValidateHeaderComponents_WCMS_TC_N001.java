package tests.ui.WCMS;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import pages.ui.HeaderComponentPage;
import tests.ui.base.BaseTest;

public class ValidateHeaderComponents_WCMS_TC_N001 extends BaseTest {

    @BeforeMethod(alwaysRun = true)
    public void beforeTest() {
        // No URL or login steps specified in test data or requirements
        // If navigation is required, add here
    }

    @Test(description = "TC-N001: Validate header components are visible and correct")
    @Description("User should be able to see the header components successfully.")
    @Severity(SeverityLevel.NORMAL)
    public void validateHeaderComponents_TC_N001() {
        try {
            HeaderComponentPage headerComponentPage = page.getInstance(HeaderComponentPage.class);
            headerComponentPage.validateHeaderComponents();
        } catch (Exception e) {
            e.printStackTrace();
            assert false : "Exception occurred during header components validation: " + e.getMessage();
        }
    }
}
