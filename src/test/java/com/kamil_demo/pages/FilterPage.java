package com.kamil_demo.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class FilterPage extends BasePage {

    @FindBy(xpath = "//input[@placeholder='From']")
    public WebElement priceFrom;

    @FindBy(xpath = "//input[@placeholder='To']")
    public WebElement priceTo;

    @FindBy(xpath = "(//div[.='Beds']/following-sibling::div/div/button)[1]")
    public WebElement decrBeds;

    @FindBy(xpath = "(//div[.='Beds']/following-sibling::div/div/button)[2]")
    public WebElement incrBeds;

    @FindBy(xpath = "(//div[.='Bedrooms']/following-sibling::div/div/button)[1]")
    public WebElement decrBedrooms;

    @FindBy(xpath = "(//div[.='Bedrooms']/following-sibling::div/div/button)[2]")
    public WebElement incrBedrooms;

    @FindBy(xpath = "(//div[.='Bathrooms']/following-sibling::div/div/button)[1]")
    public WebElement decrBathrooms;

    @FindBy(xpath = "(//div[.='Bathrooms']/following-sibling::div/div/button)[2]")
    public WebElement incrBathrooms;

    @FindBy(xpath = "//label[@class='sc-dTSzeu krkYvd']/span[.='Beach front']")
    public WebElement amBeachFront;

    @FindBy(xpath = "//label[@class='sc-dTSzeu krkYvd']/span[.='Swimming pool']")
    public WebElement amSwimmingPool;

    @FindBy(xpath = "//label[@class='sc-dTSzeu krkYvd']/span[.='Free WiFi']")
    public WebElement amFreeWifi;

    @FindBy(xpath = "//label[@class='sc-dTSzeu krkYvd']/span[.='Kitchen']")
    public WebElement amKitchen;

    @FindBy(xpath = "//label[@class='sc-dTSzeu krkYvd']/span[.='Air conditioning']")
    public WebElement amAirConditioning;

    @FindBy(xpath = "//label[@class='sc-dTSzeu krkYvd']/span[.='Washing Machine']")
    public WebElement amWashingMachine;

    @FindBy(xpath = "//label[@class='sc-dTSzeu krkYvd']/span[.='Pets allowed']")
    public WebElement amPetsAllowed;

    @FindBy(xpath = "//label[@class='sc-dTSzeu krkYvd']/span[.='Hot tub']")
    public WebElement amHotTub;

    @FindBy(xpath = "//label[@class='sc-dTSzeu krkYvd']/span[.='Street parking']")
    public WebElement amStreetParking;

    @FindBy(xpath = "//label[@class='sc-dTSzeu krkYvd']/span[.='Suitable for children']")
    public WebElement amSuitableForChildren;

    @FindBy(xpath = "//b[.='Clear all']")
    public WebElement clearAllButton;

    @FindBy(xpath = "//span[.='Apply']")
    public WebElement applyButton;

    public void select_all_amenities() {
        amBeachFront.click();
        amSwimmingPool.click();
        amFreeWifi.click();
        amKitchen.click();
        amAirConditioning.click();
        amWashingMachine.click();
        amPetsAllowed.click();
        amHotTub.click();
        amStreetParking.click();
        amSuitableForChildren.click();
    }

    public boolean minBed() {
        boolean minBedIsZero = decrBeds.isEnabled();
        return minBedIsZero;
    }

    public boolean minBedroomTest() {
        boolean minBedroomIsZero = decrBedrooms.isEnabled();
        return minBedroomIsZero;
    }

    public boolean minBathroomTest() {
        boolean minBathroomIsZero = decrBathrooms.isEnabled();
        return minBathroomIsZero;
    }

    public int maxBedTest() {
        int maxBed = 0;
        int expected_max = 10;
        while (incrBeds.isEnabled()) {
            incrBeds.click();
            maxBed++;
        }
        return maxBed;
    }

    public int maxBedroomTest() {
        int maxBedroom = 0;
        while (incrBedrooms.isEnabled()) {
            incrBedrooms.click();
            maxBedroom++;
        }
        return maxBedroom;
    }

    public int maxBathroomTest() {
        int maxBathroom = 0;
        while (incrBathrooms.isEnabled()) {
            incrBathrooms.click();
            maxBathroom++;
        }
        return maxBathroom;
    }

}



