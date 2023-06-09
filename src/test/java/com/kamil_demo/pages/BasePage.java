package com.kamil_demo.pages;

import com.kamil_demo.utilities.Driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public abstract class BasePage {

    protected WebDriver driver;

    BasePage() {
        this.driver = Driver.getDriver();
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//a[.='Test']")
    private WebElement testTitle;

    @FindBy(xpath = "//a[.='All listings']")
    private WebElement allListings;

    @FindBy(xpath = "//a[.='About Us']")
    private WebElement aboutUs;


    public WebElement getAllListings() {
        return allListings;
    }


}
