package com.kamil_demo.tests;

import com.kamil_demo.pages.AllListingsPage;
import com.kamil_demo.pages.FilterPage;
import com.kamil_demo.pages.MainPage;
import com.kamil_demo.pages.SearchResultPage;
import com.kamil_demo.utilities.Driver;
import io.qameta.allure.Description;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import static io.qameta.allure.Allure.step;

public class FilteringTests extends Hooks {


    MainPage mainPage = new MainPage();
    SearchResultPage searchResultPage = new SearchResultPage();
    FilterPage filterPage = new FilterPage();
    AllListingsPage allListingsPage = new AllListingsPage();
    WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);


    @Test(priority = 1)
    @Description("Testing happy path scenario for Search and Filter button")
    public void clickingFilterButton() {
        step("Step 1: User should be able to click 'Search Button'");
        wait.until(ExpectedConditions.visibilityOf(mainPage.searchButton)).click();
        step("Step 2: User should be able to select check_in and check_out date");
        wait.until(ExpectedConditions.elementToBeClickable(searchResultPage.checkIn)).click();
        searchResultPage.selectCheckInOutDates();
        wait.until(ExpectedConditions.visibilityOf(searchResultPage.guests));
        searchResultPage.selectNumberOfGuests();
        step("Step 3: User should be able to select click 'Filter Button'");
        wait.until(ExpectedConditions.visibilityOf(searchResultPage.filterButton)).click();
        wait.until(ExpectedConditions.visibilityOf(searchResultPage.closeFilters)).click();

    }

    @Test(priority = 2)
    @Description("If user didnt select Checkin AND Checkout date: " +
            "User Should get the message under price filter")
    public void clickingFilterWithoutSelectingDate() {
        step("Step 4: User should be able to navigate Filter form");
        wait.until(ExpectedConditions.visibilityOf(mainPage.searchButton)).click();
        wait.until(ExpectedConditions.visibilityOf(searchResultPage.checkIn)).click();
        searchResultPage.clearDates.click();
        wait.until(ExpectedConditions.visibilityOf(searchResultPage.filterButton)).click();
        step("Step 5: User should see this expected_message");
        String actual_message = searchResultPage.warningDateMessage.getText();
        String expected_message = "To filter by price, please select dates";
        Assert.assertEquals(actual_message, expected_message);

    }


    @Test(priority = 3)
    @Description("Testing minimum and maximum values")
    public void minMaxValuesTest() {
        step("Step 6: User navigating to the Filter form");
        wait.until(ExpectedConditions.visibilityOf(mainPage.searchButton)).click();
        wait.until(ExpectedConditions.elementToBeClickable(searchResultPage.checkIn)).click();
        searchResultPage.selectCheckInOutDates();
        wait.until(ExpectedConditions.elementToBeClickable(searchResultPage.filterButton)).click();
        filterPage.clearAllButton.click();
        step("Step 7: Testing minimum and maximum values for beds,bedrooms and bathrooms");
        Assert.assertFalse(filterPage.minBed());
        Assert.assertFalse(filterPage.minBedroomTest());
        Assert.assertFalse(filterPage.minBathroomTest());
        int expected_max = 10;
        Assert.assertEquals(filterPage.maxBedTest(), expected_max);
        Assert.assertEquals(filterPage.maxBedroomTest(), expected_max);
        Assert.assertEquals(filterPage.maxBathroomTest(), expected_max);
    }

    @Test(priority = 4)
    @Description("Testing the 'Clear All' function")
    public void clearAllFunctionTest() {

        wait.until(ExpectedConditions.visibilityOf(mainPage.searchButton)).click();
        step("Step 8: User should be able to select check_in and check_out date");
        wait.until(ExpectedConditions.visibilityOf(searchResultPage.checkIn)).click();
        searchResultPage.selectCheckInOutDates();
        wait.until(ExpectedConditions.visibilityOf(searchResultPage.guests));
        searchResultPage.selectNumberOfGuests();
        searchResultPage.filterButton.click();
        wait.until(ExpectedConditions.visibilityOf(filterPage.priceFrom)).click();
        step("Step 9:User selecting Price range ");
        filterPage.priceFrom.sendKeys("50");
        filterPage.priceTo.sendKeys("1000");
        step("Step 10:User selecting bed_bedroom_bathroom and all amenities ");
        filterPage.incrBeds.click();
        filterPage.incrBedrooms.click();
        filterPage.incrBathrooms.click();
        filterPage.select_all_amenities();
        step("step 11: User clicking the 'Clear All' button ");
        filterPage.clearAllButton.click();
        Assert.assertFalse(filterPage.amAirConditioning.isSelected(), "Clear button is not working");
        Assert.assertFalse(filterPage.amSwimmingPool.isSelected(), "Clear button is not working");
        Assert.assertFalse(filterPage.amFreeWifi.isSelected(), "Clear button is not working");
        searchResultPage.checkingClearAllFunc();

    }

    @Test(priority = 5)
    @Description("Testing the All Listings Page")
    public void allListingPageTest() {
        step("step 11: User should be able to navigate All Listings page ");
        wait.until(ExpectedConditions.visibilityOf(mainPage.allListings)).click();
        wait.until(ExpectedConditions.visibilityOf(allListingsPage.allAmount));
        step("step 12: Getting the amount of number from All label ");
        int number_on_top = allListingsPage.getAllAmount();
        step("step 13: Scrolling down to the last item and getting the amount ");
        int number_of_properties = allListingsPage.movingLastProperties();
        Assert.assertEquals(number_on_top, number_of_properties);
    }
/*
    @Test
    @Description("Testing the maximum value for guests")
    public void guestNumber() {
        wait.until(ExpectedConditions.visibilityOf(mainPage.searchButton)).click();
        step("Step 0: User should be able to select check_in and check_out date");
        wait.until(ExpectedConditions.visibilityOf(searchResultPage.checkIn)).click();
        searchResultPage.selectCheckInOutDates();
        wait.until(ExpectedConditions.visibilityOf(searchResultPage.guests)).click();
        searchResultPage.maxGuests();
    }

 */


}
