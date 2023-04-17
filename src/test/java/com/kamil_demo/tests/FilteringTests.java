package com.kamil_demo.tests;

import com.kamil_demo.pages.AllListings_Page;
import com.kamil_demo.pages.Filter_Page;
import com.kamil_demo.pages.Main_Page;
import com.kamil_demo.pages.SearchResult_Page;
import com.kamil_demo.utilities.Driver;
import io.qameta.allure.Description;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import static io.qameta.allure.Allure.step;

public class FilteringTests extends Hooks {


    Main_Page main_page = new Main_Page();
    SearchResult_Page searchResult_page = new SearchResult_Page();
    Filter_Page filter_page = new Filter_Page();
    AllListings_Page all_listings_page = new AllListings_Page();
    WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);


    @Test(priority = 1)
    @Description("Testing happy path scenario for Search and Filter button")
    public void clicking_Filter_Button() {
        step("Step 1: User should be able to click 'Search Button'");
        wait.until(ExpectedConditions.visibilityOf(main_page.searchButton)).click();
        step("Step 2: User should be able to select check_in and check_out date");
        wait.until(ExpectedConditions.elementToBeClickable(searchResult_page.check_in)).click();
        searchResult_page.select_check_in_out_dates();
        wait.until(ExpectedConditions.visibilityOf(searchResult_page.guests));
        searchResult_page.select_number_of_guests();
        step("Step 3: User should be able to select click 'Filter Button'");
        wait.until(ExpectedConditions.visibilityOf(searchResult_page.filter_button)).click();
        wait.until(ExpectedConditions.visibilityOf(searchResult_page.close_filters)).click();

    }

    @Test(priority = 2)
    @Description("If user didnt select Checkin AND Checkout date: " +
            "User Should get the message under price filter")
    public void clicking_Filter_Without_Selecting_Date() {
        step("Step 4: User should be able to navigate Filter form");
        wait.until(ExpectedConditions.visibilityOf(main_page.searchButton)).click();
        wait.until(ExpectedConditions.visibilityOf(searchResult_page.check_in)).click();
        searchResult_page.clear_dates.click();
        wait.until(ExpectedConditions.visibilityOf(searchResult_page.filter_button)).click();
        step("Step 5: User should see this expected_message");
        String actual_message = searchResult_page.warning_date_message.getText();
        String expected_message = "To filter by price, please select dates";
        Assert.assertEquals(actual_message, expected_message);

    }


    @Test(priority = 3)
    @Description("Testing minimum and maximum values")
    public void min_Max_Values_Test() {
        step("Step 6: User navigating to the Filter form");
        wait.until(ExpectedConditions.visibilityOf(main_page.searchButton)).click();
        wait.until(ExpectedConditions.elementToBeClickable(searchResult_page.check_in)).click();
        searchResult_page.select_check_in_out_dates();
        wait.until(ExpectedConditions.elementToBeClickable(searchResult_page.filter_button)).click();
        filter_page.clear_All_Button.click();
        step("Step 7: Testing minimum and maximum values for beds,bedrooms and bathrooms");
        Assert.assertFalse(filter_page.min_Bed());
        Assert.assertFalse(filter_page.min_Bedroom_Test());
        Assert.assertFalse(filter_page.min_Bathroom_Test());
        int expected_max = 10;
        Assert.assertEquals(filter_page.max_Bed_Test(),expected_max);
        Assert.assertEquals(filter_page.max_Bedroom_Test(),expected_max);
        Assert.assertEquals(filter_page.max_Bathroom_Test(),expected_max);
    }

    @Test(priority = 4)
    @Description("Testing the 'Clear All' function")
    public void clear_All_Function_Test() {

        wait.until(ExpectedConditions.visibilityOf(main_page.searchButton)).click();
        step("Step 8: User should be able to select check_in and check_out date");
        wait.until(ExpectedConditions.visibilityOf(searchResult_page.check_in)).click();
        searchResult_page.select_check_in_out_dates();
        wait.until(ExpectedConditions.visibilityOf(searchResult_page.guests));
        searchResult_page.select_number_of_guests();
        searchResult_page.filter_button.click();
        wait.until(ExpectedConditions.visibilityOf(filter_page.price_From)).click();
        step("Step 9:User selecting Price range ");
        filter_page.price_From.sendKeys("50");
        filter_page.price_To.sendKeys("1000");
        step("Step 10:User selecting bed_bedroom_bathroom and all amenities ");
        filter_page.incr_Beds.click();
        filter_page.incr_Bedrooms.click();
        filter_page.incr_Bathrooms.click();
        filter_page.select_all_amenities();
        step("step 11: User clicking the 'Clear All' button ");
        filter_page.clear_All_Button.click();
        Assert.assertFalse(filter_page.am_Air_Conditioning.isSelected(), "Clear button is not working");
        Assert.assertFalse(filter_page.am_Swimming_Pool.isSelected(), "Clear button is not working");
        Assert.assertFalse(filter_page.am_Free_Wifi.isSelected(), "Clear button is not working");
        searchResult_page.checking_Clear_All_Func();

    }

    @Test(priority = 5)
    @Description("Testing the All Listings Page")
    public void all_Listing_Page_Test() {
        step("step 11: User should be able to navigate All Listings page ");
        wait.until(ExpectedConditions.visibilityOf(main_page.allListings)).click();
        wait.until(ExpectedConditions.visibilityOf(all_listings_page.all_amount));
        step("step 12: Getting the amount of number from All label ");
        int number_on_top = all_listings_page.get_all_amount();
        step("step 13: Scrolling down to the last item and getting the amount ");
        int number_of_properties = all_listings_page.moving_last_properties();
        Assert.assertEquals(number_on_top, number_of_properties);
    }
/*
    @Test
    public void guest_Number(){
        wait.until(ExpectedConditions.visibilityOf(main_page.searchButton)).click();
        step("Step 0: User should be able to select check_in and check_out date");
        wait.until(ExpectedConditions.visibilityOf(searchResult_page.check_in)).click();
        searchResult_page.select_check_in_out_dates();
        wait.until(ExpectedConditions.visibilityOf(searchResult_page.guests)).click();
        searchResult_page.max_Guests();
    }

 */

}
