package pages.ui;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.List;

public class LeftSideMenuPage extends BasePage {

    // Constructor
    public LeftSideMenuPage(WebDriver driver) {
        super(driver);
    }

    // Locators for left side menu links (placeholders, update with actual locators)
    private By agendasMenuLink = By.id("PLACEHOLDER_agendas_menu_link"); // TODO: Replace with actual locator
    private By meetingsMenuLink = By.id("PLACEHOLDER_meetings_menu_link"); // TODO: Replace with actual locator
    private By documentsMenuLink = By.id("PLACEHOLDER_documents_menu_link"); // TODO: Replace with actual locator
    private By attendeesMenuLink = By.id("PLACEHOLDER_attendees_menu_link"); // TODO: Replace with actual locator
    private By tasksMenuLink = By.id("PLACEHOLDER_tasks_menu_link"); // TODO: Replace with actual locator

    // Example: Click on Agendas link in left menu
    public void clickOnAgendasMenu() {
        clickOnMethod(agendasMenuLink);
    }

    // Example: Click on Meetings link in left menu
    public void clickOnMeetingsMenu() {
        clickOnMethod(meetingsMenuLink);
    }

    // Example: Click on Documents link in left menu
    public void clickOnDocumentsMenu() {
        clickOnMethod(documentsMenuLink);
    }

    // Example: Click on Attendees link in left menu
    public void clickOnAttendeesMenu() {
        clickOnMethod(attendeesMenuLink);
    }

    // Example: Click on Tasks link in left menu
    public void clickOnTasksMenu() {
        clickOnMethod(tasksMenuLink);
    }

    // Example: Validate navigation to Agendas list page
    public boolean isAgendasListPageDisplayed() {
        // Placeholder for validation logic, update with actual locator/condition
        By agendasListHeader = By.id("PLACEHOLDER_agendas_list_header"); // TODO: Replace with actual locator
        try {
            waitForElementPresent(agendasListHeader);
            WebElement header = getElement(agendasListHeader);
            return header != null && header.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    // Example: Get all left menu items (for iterating through all listing pages)
    public List<WebElement> getAllLeftMenuItems() {
        By leftMenuItems = By.cssSelector("PLACEHOLDER_left_menu_items"); // TODO: Replace with actual locator
        return getElements(leftMenuItems);
    }

    // Example: Click menu item by visible text
    public void clickMenuItemByText(String menuText) {
        By menuItem = By.xpath("//nav[contains(@class,'left-menu')]//a[normalize-space(text())='" + menuText + "']"); // TODO: Adjust nav selector as needed
        clickOnMethod(menuItem);
    }
}
