package com.kamil_demo.pages;

import com.kamil_demo.utilities.Driver;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class AllListingsPage extends BasePage {

    @FindBy(xpath = "//span[@class='sc-eGJWMs lkeyLH']/span")
    private WebElement allAmount;

    public WebElement getAllAmount() {
        return allAmount;
    }

    @FindBy(xpath = "//a[@href='/terms-and-conditions']")
    private WebElement termsCondition;

    @FindBy(xpath = "//div[@class='sc-gSYDnn wmfak']")
    private List<WebElement> properties;

    @FindBy(css = ".sc-tsGVs.hebieQ")
    private WebElement loaderMask;

    WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 3);

    public void waitUntilLoaderMaskDisappear() {

        try {
            wait.until(ExpectedConditions.invisibilityOf(loaderMask));
            System.out.println("in-visibility");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public int getAllAmounts() {
        String org_number = allAmount.getText();
        String number = org_number.substring(1, org_number.length() - 1);
        int num = Integer.parseInt(number);
        return num;
    }

    public int movingLastProperties() {
        int num = getAllAmounts();
        for (int i = 0; i < (num / 15); i++) {
            ((JavascriptExecutor) Driver.getDriver()).executeScript("window.scrollBy(0,10000)");
            waitUntilLoaderMaskDisappear();
        }
        String lastElementXpath = "(//div[@class='sc-gSYDnn wmfak'])[" + num +"]";
        WebElement lastItem = Driver.getDriver().findElement(By.xpath(lastElementXpath));
        wait.until(ExpectedConditions.elementToBeClickable(lastItem));
        return properties.size();
    }


}
