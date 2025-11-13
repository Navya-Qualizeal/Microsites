package pages.ui;

import base.utils.ReusableMethods;
import base.utils.ScreenshotUtil;
import base.utils.WaitStatementUtils;
import com.astm.commonFunctions.WCMSICommon;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class CartPage extends BasePage {

    public CartPage(WebDriver driver) {
        super(driver);
    }

    // TODO: Replace with actual locator for the research report product tile
    private By researchReportProductTile = By.id("PLACEHOLDER_research_report_product_tile"); // The product to add
    // TODO: Replace with actual locator for the 'Add to Cart' button
    private By addToCartButton = By.id("PLACEHOLDER_add_to_cart_button");
    // TODO: Replace with actual locator for the cart icon/button
    private By cartIcon = By.id("PLACEHOLDER_cart_icon");
    // TODO: Replace with actual locator for product name in cart
    private By cartProductName = By.id("PLACEHOLDER_cart_product_name");
    // TODO: Replace with actual locator for product quantity in cart
    private By cartProductQuantity = By.id("PLACEHOLDER_cart_product_quantity");
    // TODO: Replace with actual locator for product price in cart
    private By cartProductPrice = By.id("PLACEHOLDER_cart_product_price");

    public void selectResearchReportProduct() {
        // Wait for the research report product tile to be visible and click it
        WaitStatementUtils.explicitWaitForVisibility(driver, driver.findElement(researchReportProductTile), 20);
        driver.findElement(researchReportProductTile).click();
    }

    public void clickAddToCart() {
        // Wait for the Add to Cart button to be clickable and click it
        WaitStatementUtils.explicitWaitForVisibility(driver, driver.findElement(addToCartButton), 20);
        driver.findElement(addToCartButton).click();
    }

    public void openCart() {
        // Wait for the cart icon/button to be clickable and click it
        WaitStatementUtils.explicitWaitForVisibility(driver, driver.findElement(cartIcon), 20);
        driver.findElement(cartIcon).click();
    }

    public String getCartProductName() {
        WaitStatementUtils.explicitWaitForVisibility(driver, driver.findElement(cartProductName), 20);
        return driver.findElement(cartProductName).getText();
    }

    public String getCartProductQuantity() {
        WaitStatementUtils.explicitWaitForVisibility(driver, driver.findElement(cartProductQuantity), 20);
        return driver.findElement(cartProductQuantity).getText();
    }

    public String getCartProductPrice() {
        WaitStatementUtils.explicitWaitForVisibility(driver, driver.findElement(cartProductPrice), 20);
        return driver.findElement(cartProductPrice).getText();
    }

    public void validateProductInCart(String expectedName, String expectedQuantity, String expectedPrice) {
        Assert.assertEquals(getCartProductName(), expectedName, "Product name in cart does not match");
        Assert.assertEquals(getCartProductQuantity(), expectedQuantity, "Product quantity in cart does not match");
        Assert.assertEquals(getCartProductPrice(), expectedPrice, "Product price in cart does not match");
    }
}
