package com.stb.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    WebDriver driver;

    // Locators for login page elements
    @FindBy(id = "email") private WebElement emailField;
    @FindBy(id = "pass") private WebElement passwordField;
    @FindBy(id = "send2") private WebElement loginButton;
    @FindBy(xpath = "//div[@class='message-error']") private WebElement errorMessage;

    // Constructor to initialize elements
    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // Actions for interacting with login page elements
    public void enterEmail(String email) {
        emailField.sendKeys(email);
    }

    public void enterPassword(String password) {
        passwordField.sendKeys(password);
    }

    public void clickLoginButton() {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",loginButton);
        loginButton.click();
    }

    public String getErrorMessage() {
        return errorMessage.getText();
    }

}
