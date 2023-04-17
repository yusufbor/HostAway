package com.kamil_demo.pages;


import com.kamil_demo.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.time.LocalDateTime;
import java.util.List;

public class SearchResultPage extends BasePage {

    @FindBy(xpath = "//div[@class='sc-eSoXWK WzEhh']")
    public WebElement location;

    @FindBy(xpath = "//div[@class='sc-bXmHAB bMdeOs']")
    public WebElement checkIn;

    @FindBy(xpath = "//div[@class='sc-cTsKDU iKqGfS']")
    public WebElement checkOut;

    @FindBy(xpath = "//div[@class='sc-ezHeEz cIKEHp']")
    public WebElement guests;

    @FindBy(xpath = "//button[@class='sc-fWWYYk sc-gzcbmu bZTTYU fKwyEY']")
    public WebElement guestsIncr;

    @FindBy(xpath = "//button[@class='sc-fWWYYk sc-fIxmyt bZTTYU cnkbFD']")
    public WebElement guestsDecr;


    @FindBy(xpath = "//span[.='Filter']")
    public WebElement filterButton;

    @FindBy(css = ".sc-iJCRrE.iNTqRT")
    public WebElement closeFilters;

    @FindBy(xpath = "(//div[@class='sc-fHCHyC crlswz'])[2]//div[.='1']")
    public WebElement checkOutDate;

    @FindBy(xpath = "//span[.='Clear dates']")
    public WebElement clearDates;

    public void selectingToday() {

        int today = LocalDateTime.now().getDayOfMonth();
        String todaysXpath = "//div[.='" + today + "']";

        WebElement checkInDate = Driver.getDriver().findElement(By.xpath(todaysXpath));
        checkInDate.click();
    }
    public void selectCheckInOutDates() {
        selectingToday();
        checkOutDate.click();
    }

    public void selectNumberOfGuests() {
        guests.click();
        guestsIncr.click();
        guests.click();
    }

    @FindBy(xpath = "//p[.='To filter by price, please select dates']")
    public WebElement warningDateMessage;

    @FindBy(css = ".sc-gVFcvn.gnLtVL")
    public List<WebElement> numberOfAmenities;

    public void checkingClearAllFunc() {
        for (WebElement numberOfAmenity : numberOfAmenities) {
            String textOfAmenities = numberOfAmenity.getText();
            Assert.assertTrue(textOfAmenities.equalsIgnoreCase("0"));
        }
    }

    public void maxGuests() {
        int count = 0;
        while (guestsIncr.isEnabled()) {
            guestsIncr.click();
            count++;
        }
        System.out.println("Max count for guests = " + count);
    }


}
