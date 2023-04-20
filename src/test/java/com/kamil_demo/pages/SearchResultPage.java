package com.kamil_demo.pages;


import com.kamil_demo.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.time.LocalDateTime;
import java.util.List;

public class SearchResultPage extends BasePage {

    FilterPage filterPage = new FilterPage();

    @FindBy(xpath = "//div[@class='sc-eSoXWK WzEhh']")
    private WebElement location;

    @FindBy(xpath = "//div[@class='sc-bXmHAB bMdeOs']")
    private WebElement checkIn;

    @FindBy(xpath = "//div[@class='sc-cTsKDU iKqGfS']")
    private WebElement checkOut;

    @FindBy(xpath = "//div[@class='sc-ezHeEz cIKEHp']")
    private WebElement guests;

    @FindBy(xpath = "//button[@class='sc-fWWYYk sc-gzcbmu bZTTYU fKwyEY']")
    private WebElement guestsIncr;

    @FindBy(xpath = "//button[@class='sc-fWWYYk sc-fIxmyt bZTTYU cnkbFD']")
    private WebElement guestsDecr;


    @FindBy(xpath = "//span[.='Filter']")
    private WebElement filterButton;

    @FindBy(css = ".sc-iJCRrE.iNTqRT")
    private WebElement closeFilters;

    @FindBy(xpath = "(//div[@class='sc-fHCHyC crlswz'])[2]//div[.='1']")
    private WebElement checkOutDate;

    @FindBy(xpath = "//span[.='Clear dates']")
    private WebElement clearDates;

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
    private WebElement warningDateMessage;

    @FindBy(css = ".sc-gVFcvn.gnLtVL")
    private List<WebElement> numberOfAmenities;

    public boolean checkingClearAllFunc() {
        for (WebElement numberOfAmenity : numberOfAmenities) {
            String textOfAmenities = numberOfAmenity.getText();
            Assert.assertTrue(textOfAmenities.equalsIgnoreCase("0"));
        }
        boolean amenitiesSelected = false;
        if (filterPage.getAmAirConditioning().isSelected() || filterPage.getAmSwimmingPool().isSelected() ||
                filterPage.getAmFreeWifi().isSelected() || filterPage.getAmBeachFront().isSelected() ||
                filterPage.getAmKitchen().isSelected() || filterPage.getAmHotTub().isSelected() ||
                filterPage.getAmPetsAllowed().isSelected() || filterPage.getAmStreetParking().isSelected() ||
                filterPage.getAmSuitableForChildren().isSelected() || filterPage.getAmWashingMachine().isSelected()){
            amenitiesSelected = true;
        }else {
            amenitiesSelected = false;
        }
        return amenitiesSelected;
    }

    public void maxGuests() {
        int count = 0;
        while (guestsIncr.isEnabled()) {
            guestsIncr.click();
            count++;
        }
        System.out.println("Max count for guests = " + count);
    }

    public FilterPage getFilterPage() {
        return filterPage;
    }

    public WebElement getLocation() {
        return location;
    }

    public WebElement getCheckIn() {
        return checkIn;
    }

    public WebElement getCheckOut() {
        return checkOut;
    }

    public WebElement getGuests() {
        return guests;
    }

    public WebElement getGuestsIncr() {
        return guestsIncr;
    }

    public WebElement getGuestsDecr() {
        return guestsDecr;
    }

    public WebElement getFilterButton() {
        return filterButton;
    }

    public WebElement getCloseFilters() {
        return closeFilters;
    }

    public WebElement getCheckOutDate() {
        return checkOutDate;
    }

    public WebElement getClearDates() {
        return clearDates;
    }

    public WebElement getWarningDateMessage() {
        return warningDateMessage;
    }

    public List<WebElement> getNumberOfAmenities() {
        return numberOfAmenities;
    }
}
