package com.stb.magneto.stepdefinitions;

import com.stb.pages.HomePage;
import com.stb.pages.SignupPage;
import com.stb.utils.DriverSetup;
import com.stb.pages.MyAccountPage;
import com.stb.utils.SharedTestData;
import com.stb.utils.TestDataGenerator;
import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class AccountSteps {

    WebDriver driver = DriverSetup.getDriver();
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    SignupPage signupPage = new SignupPage(driver);
    HomePage homePage = new HomePage(driver,wait);
    MyAccountPage myAccountPage = new MyAccountPage(driver, wait);

    @Given("I am on the signup page")
    public void iAmOnTheSignupPage() throws InterruptedException {
        homePage.navigateToHomePage();
        homePage.clickCreateAccount();
    }

    @When("I fill in valid account details")
    public void iFillInValidAccountDetails() {
        // Generate and store test data
        SharedTestData.firstName = TestDataGenerator.generateRandomFirstName();
        SharedTestData.lastName = TestDataGenerator.generateRandomLastName();
        SharedTestData.email = TestDataGenerator.generateRandomEmail();
        SharedTestData.password = TestDataGenerator.generateRandomPassword();

        // Use the test data for form input
        signupPage.enterFirstName(SharedTestData.firstName);
        signupPage.enterLastName(SharedTestData.lastName);
        signupPage.enterEmail(SharedTestData.email);
        signupPage.enterPassword(SharedTestData.password);
        signupPage.enterConfirmPassword(SharedTestData.password);
    }

    @When("I leave mandatory fields empty")
    public void iLeaveMandatoryFieldsEmpty() {
        // Leaving fields empty
        signupPage.enterFirstName("");
        signupPage.enterLastName("");
        signupPage.enterEmail("");
        signupPage.enterPassword("");
        signupPage.enterConfirmPassword("");
    }

    @When("I click on the submit button")
    public void iClickOnTheSubmitButton() {
        signupPage.clickCreateAccount();
    }

    @Then("my account should be created successfully")
    public void myAccountShouldBeCreatedSuccessfully() {
        // Assert success message
        String successMessage = myAccountPage.getSuccessMessage();

        // Assert user details in 'My Account' page
        Assert.assertTrue(myAccountPage.getAccountContactInformation().contains(SharedTestData.firstName));
        Assert.assertTrue(myAccountPage.getAccountContactInformation().contains(SharedTestData.lastName));
        Assert.assertTrue(myAccountPage.getAccountContactInformation().contains(SharedTestData.email));
        Assert.assertEquals(successMessage, "Thank you for registering with Main Website Store.",
                "Registration was not successful. Expected success message is missing.");

        // Assert redirection to 'My Account' page
        Assert.assertTrue(myAccountPage.isOnMyAccountPage(),
                "After successful registration, the user was not redirected to the 'My Account' page.");
    }

    @Then("I should see error messages for required fields")
    public void iShouldSeeErrorMessagesForRequiredFields() {
        boolean isErrorDisplayed = signupPage.isErrorDisplayed();
        Assert.assertTrue(isErrorDisplayed, "Error message not displayed!");
    }
}
