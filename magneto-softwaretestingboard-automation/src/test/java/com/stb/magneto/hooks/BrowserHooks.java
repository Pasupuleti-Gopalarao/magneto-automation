package com.stb.magneto.hooks;

import com.stb.utils.DriverSetup;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class BrowserHooks {

    @Before
    public void startBrowser(Scenario scenario) {
        System.out.println("Starting browser for scenario: " + scenario.getName());
        DriverSetup.getDriver();
    }

    @After
    public void closeBrowser(Scenario scenario) throws InterruptedException {
        System.out.println("Closing browser for scenario: " + scenario.getName());
        DriverSetup.quitDriver();
        Thread.sleep(4000);

    }
}
