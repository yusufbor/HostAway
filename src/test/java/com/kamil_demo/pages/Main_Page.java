package com.kamil_demo.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Main_Page extends Base_Page {

    @FindBy(xpath = "//button[@type='button']")
    public WebElement searchButton;

}
