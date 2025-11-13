package tests.ui.Microsites;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Step;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.ui.HomePage_WCMS;
import pages.ui.SearchPage;
import pages.ui.ProductDetailPage;
import pages.ui.CartPage;
import base.utils.PublicCommon;
import tests.ui.base.BaseTest;

public class ValidateAddProductToCart_INT_8633 extends BaseTest {
    private HomePage_WCMS homePage;
    private SearchPage searchPage;
    private ProductDetailPage productDetailPage;
    private CartPage cartPage;

    @BeforeMethod
    public void setUpPages() {
        homePage = page.getInstance(HomePage_WCMS.class);
        searchPage = page.getInstance(SearchPage.class);
        productDetailPage = page.getInstance(ProductDetailPage.class);
        cartPage = page.getInstance(CartPage.class);
    }

    @Test(description = "INT-8633: Validate User able to add products to cart")
    @Description("INT-8633: User should be able to add a research report to the cart and see product name, quantity, and price.")
    @Severity(SeverityLevel.NORMAL)
    public void testValidateUserAbleToAddProductToCart_INT_8633() {
        String productName = "Sample Research Report"; // Update as per actual product if needed
        stepNavigateToHomePage();
        stepSearchForProduct(productName);
        stepSelectProductFromResults(productName);
        stepAddProductToCart();
        stepNavigateToCart();
        stepVerifyProductInCart(productName);
    }

    @Step("Navigate to Home Page")
    public void stepNavigateToHomePage() {
        try {
            homePage.navigateToHomePage();
            PublicCommon.reportPass("Navigated to Home Page successfully");
        } catch (Exception e) {
            PublicCommon.reportFailAssert("Failed to navigate to Home Page: " + e.getMessage());
        }
    }

    @Step("Search for product: {productName}")
    public void stepSearchForProduct(String productName) {
        try {
            homePage.enterSearchText(productName);
            homePage.clickSearchButton();
            Assert.assertTrue(searchPage.isSearchResultsDisplayed(), "Search results should be displayed");
            PublicCommon.reportPass("Searched for product: " + productName);
        } catch (Exception e) {
            PublicCommon.reportFailAssert("Failed to search for product: " + e.getMessage());
        }
    }

    @Step("Select product '{productName}' from search results")
    public void stepSelectProductFromResults(String productName) {
        try {
            searchPage.selectProductByName(productName);
            Assert.assertTrue(productDetailPage.isProductDetailDisplayed(productName), "Product detail page should be displayed");
            PublicCommon.reportPass("Selected product from search results: " + productName);
        } catch (Exception e) {
            PublicCommon.reportFailAssert("Failed to select product from results: " + e.getMessage());
        }
    }

    @Step("Add product to cart")
    public void stepAddProductToCart() {
        try {
            productDetailPage.clickAddToCartButton();
            Assert.assertTrue(productDetailPage.isAddToCartSuccessMessageDisplayed(), "Add to cart success message should be displayed");
            PublicCommon.reportPass("Product added to cart successfully");
        } catch (Exception e) {
            PublicCommon.reportFailAssert("Failed to add product to cart: " + e.getMessage());
        }
    }

    @Step("Navigate to Cart")
    public void stepNavigateToCart() {
        try {
            productDetailPage.clickCartIcon();
            Assert.assertTrue(cartPage.isCartPageDisplayed(), "Cart page should be displayed");
            PublicCommon.reportPass("Navigated to Cart page successfully");
        } catch (Exception e) {
            PublicCommon.reportFailAssert("Failed to navigate to Cart: " + e.getMessage());
        }
    }

    @Step("Verify product '{productName}' is present in cart with correct quantity and price")
    public void stepVerifyProductInCart(String productName) {
        try {
            Assert.assertTrue(cartPage.isProductPresentInCart(productName), "Product should be present in cart");
            int quantity = cartPage.getProductQuantity(productName);
            Assert.assertTrue(quantity > 0, "Product quantity should be greater than 0");
            double price = cartPage.getProductPrice(productName);
            Assert.assertTrue(price > 0, "Product price should be greater than 0");
            PublicCommon.reportPass("Verified product in cart: " + productName + ", Quantity: " + quantity + ", Price: " + price);
        } catch (AssertionError | Exception e) {
            PublicCommon.reportFailAssert("Product verification in cart failed: " + e.getMessage());
        }
    }
}
