package com.stb.magneto.stepdefinitions;

import com.stb.pages.HomePage;
import com.stb.pages.LoginPage;
import com.stb.utils.DriverSetup;
import com.stb.utils.SharedTestData;
import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class LoginSteps {

    LoginPage loginPage = new LoginPage(DriverSetup.getDriver());
    WebDriver driver = DriverSetup.getDriver();
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    HomePage homePage = new HomePage(driver,wait);


    @Given("I am on the login page")
    public void iAmOnTheLoginPage() {
        homePage.navigateToHomePage();
        homePage.clickSignIn();
    }

    @When("I enter valid credentials")
    public void iEnterValidCredentials() {
        // Use shared test data for login
        loginPage.enterEmail(SharedTestData.email);
        loginPage.enterPassword(SharedTestData.password);
    }

    @And("I click on the login button")
    public void iClickOnTheLoginButton() {
        // Click the login button
        loginPage.clickLoginButton();
    }

    @Then("I should be redirected to the homepage")
    public void iShouldBeRedirectedToTheHomepage() throws InterruptedException {
        // Verify the successful redirection after login
        String currentUrl = DriverSetup.getDriver().getCurrentUrl();
        String expectedUrl = "https://magento.softwaretestingboard.com/";
        Assert.assertEquals(currentUrl, expectedUrl, "Login was not successful or user was not redirected correctly.");
    }

    @When("I enter invalid credentials")
    public void iEnterInvalidCredentials() {
        // Hardcoded invalid credentials for testing error scenario
        loginPage.enterEmail("invaliduser@example.com");
        loginPage.enterPassword("wrongpassword");
    }

    @Then("I should see an error message")
    public void iShouldSeeAnErrorMessage() {
        // Verify error message is displayed
        String error = loginPage.getErrorMessage();
        Assert.assertTrue(error.contains("Invalid login or password."),
                "Expected error message not displayed for invalid credentials.");
    }


    @Then("I should see an error message indicating invalid login")
    public void iShouldSeeAnErrorMessageIndicatingInvalidLogin() {
    }
}
