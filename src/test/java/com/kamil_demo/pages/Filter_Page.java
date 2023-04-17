package com.kamil_demo.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class Filter_Page extends Base_Page {

    @FindBy(xpath = "//input[@placeholder='From']")
    public WebElement price_From;

    @FindBy(xpath = "//input[@placeholder='To']")
    public WebElement price_To;

    @FindBy(xpath = "(//div[.='Beds']/following-sibling::div/div/button)[1]")
    public WebElement decr_Beds;

    @FindBy(xpath = "(//div[.='Beds']/following-sibling::div/div/button)[2]")
    public WebElement incr_Beds;

    @FindBy(xpath = "(//div[.='Bedrooms']/following-sibling::div/div/button)[1]")
    public WebElement decr_Bedrooms;

    @FindBy(xpath = "(//div[.='Bedrooms']/following-sibling::div/div/button)[2]")
    public WebElement incr_Bedrooms;

    @FindBy(xpath = "(//div[.='Bathrooms']/following-sibling::div/div/button)[1]")
    public WebElement decr_Bathrooms;

    @FindBy(xpath = "(//div[.='Bathrooms']/following-sibling::div/div/button)[2]")
    public WebElement incr_Bathrooms;

    @FindBy(xpath = "//label[@class='sc-dTSzeu krkYvd']/span[.='Beach front']")
    public WebElement am_Beach_Front;

    @FindBy(xpath = "//label[@class='sc-dTSzeu krkYvd']/span[.='Swimming pool']")
    public WebElement am_Swimming_Pool;

    @FindBy(xpath = "//label[@class='sc-dTSzeu krkYvd']/span[.='Free WiFi']")
    public WebElement am_Free_Wifi;

    @FindBy(xpath = "//label[@class='sc-dTSzeu krkYvd']/span[.='Kitchen']")
    public WebElement am_Kitchen;

    @FindBy(xpath = "//label[@class='sc-dTSzeu krkYvd']/span[.='Air conditioning']")
    public WebElement am_Air_Conditioning;

    @FindBy(xpath = "//label[@class='sc-dTSzeu krkYvd']/span[.='Washing Machine']")
    public WebElement am_Washing_Machine;

    @FindBy(xpath = "//label[@class='sc-dTSzeu krkYvd']/span[.='Pets allowed']")
    public WebElement am_Pets_Allowed;

    @FindBy(xpath = "//label[@class='sc-dTSzeu krkYvd']/span[.='Hot tub']")
    public WebElement am_Hot_Tub;

    @FindBy(xpath = "//label[@class='sc-dTSzeu krkYvd']/span[.='Street parking']")
    public WebElement am_Street_Parking;

    @FindBy(xpath = "//label[@class='sc-dTSzeu krkYvd']/span[.='Suitable for children']")
    public WebElement am_Suitable_For_Children;

    @FindBy(xpath = "//b[.='Clear all']")
    public WebElement clear_All_Button;

    @FindBy(xpath = "//span[.='Apply']")
    public WebElement apply_Button;

    public void select_all_amenities() {
        am_Beach_Front.click();
        am_Swimming_Pool.click();
        am_Free_Wifi.click();
        am_Kitchen.click();
        am_Air_Conditioning.click();
        am_Washing_Machine.click();
        am_Pets_Allowed.click();
        am_Hot_Tub.click();
        am_Street_Parking.click();
        am_Suitable_For_Children.click();
    }

    public boolean min_Bed() {
        boolean min_bed_is_zero = decr_Beds.isEnabled();
        return min_bed_is_zero;
    }

    public boolean min_Bedroom_Test() {
        boolean min_bedroom_is_zero = decr_Bedrooms.isEnabled();
        return min_bedroom_is_zero;
    }

    public boolean min_Bathroom_Test() {
        boolean min_bathroom_is_zero = decr_Bathrooms.isEnabled();
        return min_bathroom_is_zero;
    }

    public int max_Bed_Test() {
        int max_Bed = 0;
        int expected_max = 10;
        while (incr_Beds.isEnabled()) {
            incr_Beds.click();
            max_Bed++;
        }
        return max_Bed;
    }

    public int max_Bedroom_Test() {
        int max_Bedroom = 0;
        while (incr_Bedrooms.isEnabled()) {
            incr_Bedrooms.click();
            max_Bedroom++;
        }
        return max_Bedroom;
    }

    public int max_Bathroom_Test() {
        int max_Bathroom = 0;
        while (incr_Bathrooms.isEnabled()) {
            incr_Bathrooms.click();
            max_Bathroom++;
        }
        return max_Bathroom;
    }

}



