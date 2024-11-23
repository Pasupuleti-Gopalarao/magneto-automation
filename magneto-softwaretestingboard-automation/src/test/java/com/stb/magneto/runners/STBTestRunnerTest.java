package com.stb.magneto.runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/java/com/stb/magneto/features",
        glue = {"com.stb.magneto.stepdefinitions", "com.stb.magneto.hooks"},
        plugin = {"pretty", "html:target/cucumber-report.html"}
)
public class STBTestRunnerTest extends AbstractTestNGCucumberTests {

}
