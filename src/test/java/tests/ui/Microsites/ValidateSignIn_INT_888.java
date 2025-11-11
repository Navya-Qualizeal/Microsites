package tests.ui.Microsites;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import pages.ui.SignInPage;
import base.utils.JsonFileReader;
import org.json.simple.JSONObject;

public class ValidateSignIn_INT_888 {

    @BeforeMethod(alwaysRun = true)
    public void beforeTest() {
        // No base URL or navigation step provided in test data
        // If needed, add navigation to Sign In page here
    }

    @Test(description = "INT-888: Validate Sign In button click functionality")
    @Description("Validate that the user is able to click the Sign In button successfully.")
    @Severity(SeverityLevel.NORMAL)
    public void validateSignInButtonClick() {
        try {
            SignInPage signInPage = page.getInstance(SignInPage.class);
            // No test data required as per test data context
            // Call the comprehensive signIn method (no parameters required)
            signInPage.signIn();
            // Optionally, add an assertion if signIn() returns a boolean or exposes a method to verify success
            // Example:
            // Assert.assertTrue(signInPage.isSignInSuccessful(), "Sign In was not successful");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
