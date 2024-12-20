package com.stb.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MyAccountPage {

    private final WebDriver driver;
    private final WebDriverWait wait;

    private final By successMessage = By.xpath("//*[contains(text(), 'Thank you for registering with Main Website Store.')]");
    private final By accountContactInformation = By.xpath("//*[@class='box box-information']//*[@class='box-content']");

    private static final String EXPECTED_URL = "https://magento.softwaretestingboard.com/customer/account/";
    private static final String HOME_PAGE_URL = "https://magento.softwaretestingboard.com/";

    public MyAccountPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public String getSuccessMessage() {
        WebElement confirmationMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(successMessage));
        return confirmationMessage.getText();
    }

    public boolean isOnMyAccountPage() {
        String actualUrl = driver.getCurrentUrl();
        return actualUrl.equals(EXPECTED_URL);
    }

    public String getAccountContactInformation() {
        WebElement accContactInfo = wait.until(ExpectedConditions.visibilityOfElementLocated(accountContactInformation));
        return accContactInfo.getText();
    }
}