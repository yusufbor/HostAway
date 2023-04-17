package com.kamil_demo.pages;

import com.kamil_demo.utilities.Driver;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class AllListings_Page extends Base_Page {

    @FindBy(xpath = "//span[@class='sc-eGJWMs lkeyLH']/span")
    public WebElement all_amount;

    @FindBy(xpath = "//a[@href='/terms-and-conditions']")
    public WebElement terms_condition;

    @FindBy(xpath = "//div[@class='sc-gSYDnn wmfak']")
    public List<WebElement> properties;

    @FindBy(css = ".sc-tsGVs.hebieQ")
    public WebElement loader_mask;

    WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 3);

    public void waitUntilLoaderMaskDisappear() {

        try {
            wait.until(ExpectedConditions.invisibilityOf(loader_mask));
            System.out.println("in-visibility");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public int get_all_amount() {
        String org_number = all_amount.getText();
        String number = org_number.substring(1, org_number.length() - 1);
        int num = Integer.parseInt(number);
        return num;
    }

    public int moving_last_properties() {
        int num = get_all_amount();
        for (int i = 0; i < (num / 15); i++) {
            ((JavascriptExecutor) Driver.getDriver()).executeScript("window.scrollBy(0,10000)");
            waitUntilLoaderMaskDisappear();
        }
        String last_element_xpath = "(//div[@class='sc-gSYDnn wmfak'])[" + num +"]";
        WebElement last_item = Driver.getDriver().findElement(By.xpath(last_element_xpath));
        wait.until(ExpectedConditions.elementToBeClickable(last_item));
        return properties.size();

    }


}
