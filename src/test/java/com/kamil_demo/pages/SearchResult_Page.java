package com.kamil_demo.pages;


import com.kamil_demo.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.time.LocalDateTime;
import java.util.List;

public class SearchResult_Page extends Base_Page {

    @FindBy(xpath = "//div[@class='sc-eSoXWK WzEhh']")
    public WebElement location;

    @FindBy(xpath = "//div[@class='sc-bXmHAB bMdeOs']")
    public WebElement check_in;

    @FindBy(xpath = "//div[@class='sc-cTsKDU iKqGfS']")
    public WebElement check_out;

    @FindBy(xpath = "//div[@class='sc-ezHeEz cIKEHp']")
    public WebElement guests;

    @FindBy(xpath = "//button[@class='sc-fWWYYk sc-gzcbmu bZTTYU fKwyEY']")
    public WebElement guests_incr;

    @FindBy(xpath = "//button[@class='sc-fWWYYk sc-fIxmyt bZTTYU cnkbFD']")
    public WebElement guests_decr;


    @FindBy(xpath = "//span[.='Filter']")
    public WebElement filter_button;

    @FindBy(css = ".sc-iJCRrE.iNTqRT")
    public WebElement close_filters;

    @FindBy(xpath = "(//div[@class='sc-fHCHyC crlswz'])[2]//div[.='1']")
    public WebElement check_out_date;

    @FindBy(xpath = "//span[.='Clear dates']")
    public WebElement clear_dates;

    public void selecting_today() {

        int today = LocalDateTime.now().getDayOfMonth();
        String todays_xpath = "//div[.='" + today + "']";

        WebElement check_in_date = Driver.getDriver().findElement(By.xpath(todays_xpath));
        check_in_date.click();
    }
    public void select_check_in_out_dates() {
        selecting_today();
        check_out_date.click();
    }

    public void select_number_of_guests() {
        guests.click();
        guests_incr.click();
        guests.click();
    }

    @FindBy(xpath = "//p[.='To filter by price, please select dates']")
    public WebElement warning_date_message;

    @FindBy(css = ".sc-gVFcvn.gnLtVL")
    public List<WebElement> number_of_Amenities;

    public void checking_Clear_All_Func() {
        for (WebElement number_of_amenity : number_of_Amenities) {
            String text_of_Amenities = number_of_amenity.getText();
            //   System.out.println(text_of_Amenities);
            Assert.assertTrue(text_of_Amenities.equalsIgnoreCase("0"));
        }
    }


    public void waitForMe() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void max_Guests() {
        int count = 0;
        while (guests_incr.isEnabled()) {
            guests_incr.click();
            count++;
        }
        System.out.println("Max count for guests = " + count);
    }


}
