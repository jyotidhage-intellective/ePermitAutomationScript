package com.intellective.testRunner;

import com.intellective.factory.BaseAction;
import com.intellective.factory.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

    @Test
    @CucumberOptions(
            plugin = {"pretty",
                    "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
                    "timeline:test-output-thread/"
            },
            monochrome = true,
            glue = {"com/intellective/Stepdefinations", "com/intellective/appHooks"},
            features = {"resources\\com\\features\\sample.feature"},
            dryRun =false
    )

    public class testNGReport extends AbstractTestNGCucumberTests {
        private WebDriver driver;

        @Override
        @DataProvider(parallel = false)
        public Object[][] scenarios() {
            return super.scenarios();
        }

    }

