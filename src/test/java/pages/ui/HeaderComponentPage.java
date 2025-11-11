package pages.ui;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import io.qameta.allure.Step;
import base.utils.WaitStatementUtils;

public class HeaderComponentPage extends BasePage {

    // Locators for header components
    public By homeLink = By.linkText("Home");

    public HeaderComponentPage(WebDriver driver) {
        super(driver);
    }
}
