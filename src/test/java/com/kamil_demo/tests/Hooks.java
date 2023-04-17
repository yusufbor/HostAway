package com.kamil_demo.tests;


import com.kamil_demo.utilities.ConfigurationReader;
import com.kamil_demo.utilities.Driver;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.NoSuchSessionException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class Hooks {

    public static WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = Driver.getDriver();
        driver.get(ConfigurationReader.getProperty("base_url"));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    }


    @AfterMethod
    public void afterMethod(ITestResult result) {
        if (result.getStatus() == ITestResult.FAILURE) {
            try {
                captureScreenshot(result.getName());
            } catch (NoSuchSessionException e) {
                System.out.println("WebDriver session expired:" + e.getMessage());
            }
        }
    }

    private void captureScreenshot(String screenshotName) {
        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

        String destination = "path/to/screenshots/" + screenshotName + ".png";
        File destinationFile = new File(destination);

        try {
            FileUtils.copyFile(screenshot, destinationFile);
            System.out.println("Screenshot captured!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @AfterTest
    public void tearDown() {
        Driver.closeDriver();
    }


}
