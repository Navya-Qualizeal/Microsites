package pages.ui;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.Arrays;
import java.util.List;
import base.utils.WaitStatementUtils;

public class FooterComponentPage extends BasePage {

    public FooterComponentPage(WebDriver driver) {
        super(driver);
    }

    // Locators for key footer links (from provided locators and context)
    public By aboutASTMLink = By.xpath("//a[@aria-label='About ASTM']");
    public By membershipParticipationLink = By.xpath("//a[@aria-label='Membership & Participation']");
    public By standardsSolutionsLink = By.xpath("//a[@aria-label='Standards & Solutions']");
    public By newsLink = By.xpath("//a[@aria-label='News']");
    public By helpLink = By.xpath("//a[@aria-label='Help']");
    public By policiesLink = By.xpath("//a[@aria-label='Policies']");
    public By privacyPolicyLink = By.xpath("//a[@aria-label='Privacy Policy']");
    public By logoPolicyLink = By.xpath("//a[@aria-label='Logo Policy']");
    public By ipPolicyLink = By.xpath("//a[@aria-label='IP Policy']");
    public By returnPolicyLink = By.xpath("//a[@aria-label='Return Policy']");
    public By copyrightPermissionsLink = By.xpath("//a[@aria-label='Copyright & Permissions']");
    public By emergingProfessionalsLink = By.xpath("//a[@aria-label='Emerging Professionals']");
    public By espanolLink = By.xpath("//a[@aria-label='Español']");
    public By historyLink = By.xpath("//a[@aria-label='History']");
    public By pressReleasesLink = By.xpath("//a[@aria-label='Press Releases']");
    public By corporateCitizenshipLink = By.xpath("//a[@aria-label='Corporate Citizenship']");
    public By globalCooperationLink = By.xpath("//a[@aria-label='Global Cooperation']");
    public By technicalCommitteesLink = By.xpath("//a[@aria-label='Technical Committees']");
    public By consumerParticipationLink = By.xpath("//a[@aria-label='Consumer Participation']");
    public By enterpriseSolutionsLink = By.xpath("//a[@aria-label='Enterprise Solutions']");
    public By cementConcreteReferenceLabLink = By.xpath("//a[@aria-label='Cement & Concrete Reference Lab']");
    public By membershipLink = By.xpath("//a[@aria-label='Membership']");
    public By laboratoryServicesLink = By.xpath("//a[@aria-label='Laboratory Services']");
    public By academicOutreachLink = By.xpath("//a[@aria-label='Academic Outreach']");
    public By publishWithASTMLink = By.xpath("//a[@aria-label='Publish with ASTM']");
    public By digitalLibraryLink = By.xpath("//a[@aria-label='Digital Library']");
    public By meetingsSymposiaWorkshopsLink = By.xpath("//a[@aria-label='Meetings, Symposia & Workshops']");
    public By regionalOfficesWebsitesLink = By.xpath("//a[@aria-label='Regional Offices and Websites']");
    public By cultureCareersLink = By.xpath("//a[@aria-label='Culture & Careers']");
    public By locationsLink = By.xpath("//a[@aria-label='Locations']");
    public By governanceLink = By.xpath("//a[@aria-label='Governance']");
    public By contactASTMLink = By.xpath("//a[@aria-label='Contact ASTM']");
    public By certificationLink = By.xpath("//a[@aria-label='Certification']");
    public By standardizationNewsLink = By.xpath("//a[@aria-label='Standardization News']");
    public By editorialCalendarMediaKitLink = By.xpath("//a[@aria-label='Editorial Calendar and Media Kit']");
    public By astmCompassLink = By.xpath("//a[@aria-label='ASTM Compass®']");
    public By standardsPublicationsLink = By.xpath("//a[@aria-label='Standards & Publications']");
    public By faqLink = By.xpath("//a[@aria-label='FAQ']");
    public By marketInsightsInnovationLink = By.xpath("//a[@aria-label='Market Insights & Innovation']");
    public By trainingCoursesLink = By.xpath("//a[@aria-label='Training Courses']");
    public By podcastsLink = By.xpath("//a[@aria-label='Podcasts']");
    public By diversityEquityInclusionBelongingLink = By.xpath("//a[@aria-label='Diversity, Equity, Inclusion & Belonging']");
    public By memberToolsLink = By.xpath("//a[@aria-label='Member Tools']");

    // List of all main footer links for validation
    private List<By> mainFooterLinks = Arrays.asList(
            aboutASTMLink,
            membershipParticipationLink,
            standardsSolutionsLink,
            newsLink,
            helpLink,
            policiesLink
    );

    /**
     * Validates the presence and visibility of all main footer components on the page.
     * Throws AssertionError if any are missing or not visible.
     */
    public void validateFooterComponents() {
        for (By locator : mainFooterLinks) {
            WaitStatementUtils.explicitWaitForVisibility(driver, driver.findElement(locator), 15);
            WebElement el = driver.findElement(locator);
            if (!el.isDisplayed()) {
                throw new AssertionError("Footer link not visible: " + locator.toString());
            }
        }
    }

    /**
     * Validates the presence and visibility of all secondary footer links (deep links)
     * Throws AssertionError if any are missing or not visible.
     */
    public void validateAllFooterDeepLinks() {
        List<By> allFooterLinks = Arrays.asList(
            privacyPolicyLink, logoPolicyLink, ipPolicyLink, returnPolicyLink, copyrightPermissionsLink,
            emergingProfessionalsLink, espanolLink, historyLink, pressReleasesLink, corporateCitizenshipLink,
            globalCooperationLink, technicalCommitteesLink, consumerParticipationLink, enterpriseSolutionsLink,
            cementConcreteReferenceLabLink, membershipLink, laboratoryServicesLink, academicOutreachLink,
            publishWithASTMLink, digitalLibraryLink, meetingsSymposiaWorkshopsLink, regionalOfficesWebsitesLink,
            cultureCareersLink, locationsLink, governanceLink, contactASTMLink, certificationLink,
            standardizationNewsLink, editorialCalendarMediaKitLink, astmCompassLink, standardsPublicationsLink,
            faqLink, marketInsightsInnovationLink, trainingCoursesLink, podcastsLink, diversityEquityInclusionBelongingLink,
            memberToolsLink
        );
        for (By locator : allFooterLinks) {
            try {
                WaitStatementUtils.explicitWaitForVisibility(driver, driver.findElement(locator), 10);
                WebElement el = driver.findElement(locator);
                if (!el.isDisplayed()) {
                    throw new AssertionError("Footer deep link not visible: " + locator.toString());
                }
            } catch (Exception e) {
                throw new AssertionError("Footer deep link not found or not visible: " + locator.toString(), e);
            }
        }
    }
}
