package com.kamil_demo.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class FilterPage extends BasePage {

    @FindBy(xpath = "//input[@placeholder='From']")
    private WebElement priceFrom;

    @FindBy(xpath = "//input[@placeholder='To']")
    private WebElement priceTo;

    @FindBy(xpath = "(//div[.='Beds']/following-sibling::div/div/button)[1]")
    private WebElement decrBeds;

    @FindBy(xpath = "(//div[.='Beds']/following-sibling::div/div/button)[2]")
    private WebElement incrBeds;

    @FindBy(xpath = "(//div[.='Bedrooms']/following-sibling::div/div/button)[1]")
    private WebElement decrBedrooms;

    @FindBy(xpath = "(//div[.='Bedrooms']/following-sibling::div/div/button)[2]")
    private WebElement incrBedrooms;

    @FindBy(xpath = "(//div[.='Bathrooms']/following-sibling::div/div/button)[1]")
    private WebElement decrBathrooms;

    @FindBy(xpath = "(//div[.='Bathrooms']/following-sibling::div/div/button)[2]")
    private WebElement incrBathrooms;

    @FindBy(xpath = "//label[@class='sc-dTSzeu krkYvd']/span[.='Beach front']")
    private WebElement amBeachFront;

    @FindBy(xpath = "//label[@class='sc-dTSzeu krkYvd']/span[.='Swimming pool']")
    private WebElement amSwimmingPool;

    @FindBy(xpath = "//label[@class='sc-dTSzeu krkYvd']/span[.='Free WiFi']")
    private WebElement amFreeWifi;

    @FindBy(xpath = "//label[@class='sc-dTSzeu krkYvd']/span[.='Kitchen']")
    private WebElement amKitchen;

    @FindBy(xpath = "//label[@class='sc-dTSzeu krkYvd']/span[.='Air conditioning']")
    private WebElement amAirConditioning;

    @FindBy(xpath = "//label[@class='sc-dTSzeu krkYvd']/span[.='Washing Machine']")
    private WebElement amWashingMachine;

    @FindBy(xpath = "//label[@class='sc-dTSzeu krkYvd']/span[.='Pets allowed']")
    private WebElement amPetsAllowed;

    @FindBy(xpath = "//label[@class='sc-dTSzeu krkYvd']/span[.='Hot tub']")
    private WebElement amHotTub;

    @FindBy(xpath = "//label[@class='sc-dTSzeu krkYvd']/span[.='Street parking']")
    private WebElement amStreetParking;

    @FindBy(xpath = "//label[@class='sc-dTSzeu krkYvd']/span[.='Suitable for children']")
    private WebElement amSuitableForChildren;

    @FindBy(xpath = "//b[.='Clear all']")
    private WebElement clearAllButton;

    @FindBy(xpath = "//span[.='Apply']")
    private WebElement applyButton;

    public WebElement getPriceFrom() {
        return priceFrom;
    }

    public WebElement getPriceTo() {
        return priceTo;
    }

    public WebElement getDecrBeds() {
        return decrBeds;
    }

    public WebElement getIncrBeds() {
        return incrBeds;
    }

    public WebElement getDecrBedrooms() {
        return decrBedrooms;
    }

    public WebElement getIncrBedrooms() {
        return incrBedrooms;
    }

    public WebElement getDecrBathrooms() {
        return decrBathrooms;
    }

    public WebElement getIncrBathrooms() {
        return incrBathrooms;
    }

    public WebElement getClearAllButton() {
        return clearAllButton;
    }

    public WebElement getApplyButton() {
        return applyButton;
    }

    public WebElement getAmSwimmingPool() {
        return amSwimmingPool;
    }

    public WebElement getAmFreeWifi() {
        return amFreeWifi;
    }

    public WebElement getAmAirConditioning() {
        return amAirConditioning;
    }

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



