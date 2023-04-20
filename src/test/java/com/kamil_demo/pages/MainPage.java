package com.kamil_demo.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainPage extends BasePage {

    @FindBy(xpath = "//button[@type='button']")
    private WebElement searchButton;

    public WebElement getSearchButton() {
        return searchButton;
    }
}
