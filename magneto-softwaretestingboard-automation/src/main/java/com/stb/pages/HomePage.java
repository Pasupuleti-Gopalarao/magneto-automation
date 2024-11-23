package com.stb.pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {

    private final WebDriver driver;
    private final WebDriverWait wait;

    private final By createAccountLink = By.xpath("(//*[contains(text(), 'Create an Account')])[1]");
    private final By signInLink = By.xpath("//div[@class='panel header']//a[contains(text(),'Sign In')]");


    public HomePage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }


    public void navigateToHomePage() {
        driver.navigate().to("https://magento.softwaretestingboard.com/");
    }


    public void clickCreateAccount() {
        wait.until(ExpectedConditions.elementToBeClickable(createAccountLink)).click();
    }

    public void clickSignIn() {
        wait.until(ExpectedConditions.elementToBeClickable(signInLink)).click();
    }


}
