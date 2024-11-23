package com.stb.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignupPage {
    WebDriver driver;

    @FindBy(id = "firstname") private WebElement firstNameField;
    @FindBy(id = "lastname") private WebElement lastNameField;
    @FindBy(id = "email_address") private WebElement emailField;
    @FindBy(id = "password") private WebElement passwordField;
    @FindBy(id = "password-confirmation") private WebElement confirmPasswordField;
    @FindBy(xpath = "//button[@title='Create an Account']") private WebElement createAccountButton;
    @FindBy(xpath = "//div[@class='mage-error']") private WebElement errorMessage;

    public SignupPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void enterFirstName(String firstName) {
        firstNameField.sendKeys(firstName);
    }

    public void enterLastName(String lastName) {
        lastNameField.sendKeys(lastName);
    }

    public void enterEmail(String email) {
        emailField.sendKeys(email);
    }

    public void enterPassword(String password) {
        passwordField.sendKeys(password);
    }

    public void enterConfirmPassword(String password) {
        confirmPasswordField.sendKeys(password);
    }

    public void clickCreateAccount() {
        // Scroll to the createAccountButton
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", createAccountButton);
        // Click the button
        createAccountButton.click();    }

    public boolean isErrorDisplayed() {
        try {
            return errorMessage.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
}
