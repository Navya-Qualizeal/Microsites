package tests.ui;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Step;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.ui.HomePage_WCMS;
import pages.ui.CommonPage_WCMS;
import pages.ui.AgendasPage;
import base.utils.PublicCommon;

public class VerifyLeftNavigationListingPages_INT_8688 extends base.ui.BaseTest {
    private HomePage_WCMS homePageWCMS;
    private CommonPage_WCMS commonPageWCMS;
    private AgendasPage agendasPage;

    @BeforeMethod
    public void setUpPages() {
        homePageWCMS = page.getInstance(HomePage_WCMS.class);
        commonPageWCMS = page.getInstance(CommonPage_WCMS.class);
        agendasPage = page.getInstance(AgendasPage.class);
    }

    @Test(description = "INT-8688: Validate navigation to listing pages in left side menu")
    @Description("User should be able to open the links in left side navigation menu successfully. System should navigate to the Agendas list page successfully without any errors.")
    @Severity(SeverityLevel.NORMAL)
    public void testLeftNavigationToListingPages() {
        openHomePage();
        openLeftNavigationMenu();
        clickAgendasLink();
        verifyAgendasListPageNavigation();
    }

    @Step("Open the Home Page")
    public void openHomePage() {
        try {
            homePageWCMS.navigateToHomePage();
            PublicCommon.reportPass("Home page opened successfully");
        } catch (Exception e) {
            PublicCommon.reportFailAssert("Failed to open Home page: " + e.getMessage());
        }
    }

    @Step("Open the left side navigation menu")
    public void openLeftNavigationMenu() {
        try {
            commonPageWCMS.openLeftNavigationMenu();
            PublicCommon.reportPass("Left side navigation menu opened successfully");
        } catch (Exception e) {
            PublicCommon.reportFailAssert("Failed to open left navigation menu: " + e.getMessage());
        }
    }

    @Step("Click on 'Agendas' link in the left navigation menu")
    public void clickAgendasLink() {
        try {
            commonPageWCMS.clickAgendasLink();
            PublicCommon.reportPass("Clicked on 'Agendas' link successfully");
        } catch (Exception e) {
            PublicCommon.reportFailAssert("Failed to click on 'Agendas' link: " + e.getMessage());
        }
    }

    @Step("Verify navigation to Agendas list page")
    public void verifyAgendasListPageNavigation() {
        try {
            Assert.assertTrue(agendasPage.isAtAgendasListPage(), "System should navigate to the Agendas list page successfully");
            PublicCommon.reportPass("Navigated to Agendas list page successfully");
        } catch (AssertionError | Exception e) {
            PublicCommon.reportFailAssert("Navigation to Agendas list page failed: " + e.getMessage());
        }
    }
}
