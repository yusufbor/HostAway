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
        wait.until(ExpectedConditions.elementToBeClickable(searchResultPage.getCheckIn())).click();
        searchResultPage.selectCheckInOutDates();
        wait.until(ExpectedConditions.visibilityOf(searchResultPage.getGuests()));
        searchResultPage.selectNumberOfGuests();
        step("Step 3: User should be able to select click 'Filter Button'");
        wait.until(ExpectedConditions.visibilityOf(searchResultPage.getFilterButton())).click();
        wait.until(ExpectedConditions.visibilityOf(searchResultPage.getCloseFilters())).click();

    }

    @Test(priority = 2)
    @Description("If user didnt select Checkin AND Checkout date: " +
            "User Should get the message under price filter")
    public void clickingFilterWithoutSelectingDate() {
        wait.until(ExpectedConditions.visibilityOf(searchResultPage.getCheckIn())).click();
        searchResultPage.getClearDates().click();
        wait.until(ExpectedConditions.visibilityOf(searchResultPage.getFilterButton())).click();
        step("Step 5: User should see this expected_message");
        String actual_message = searchResultPage.getWarningDateMessage().getText();
        String expected_message = "To filter by price, please select dates";
        Assert.assertEquals(actual_message, expected_message);

    }


    @Test(priority = 3)
    @Description("Testing minimum and maximum values")
    public void minMaxValuesTest() {
        step("Step 6: User navigating to the Filter form");
        wait.until(ExpectedConditions.elementToBeClickable(searchResultPage.getCheckIn())).click();
        searchResultPage.selectCheckInOutDates();
        wait.until(ExpectedConditions.elementToBeClickable(searchResultPage.getFilterButton())).click();
        filterPage.getClearAllButton().click();
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

        wait.until(ExpectedConditions.visibilityOf(searchResultPage.getCheckIn())).click();
        searchResultPage.selectCheckInOutDates();
        wait.until(ExpectedConditions.visibilityOf(searchResultPage.getGuests()));
        searchResultPage.selectNumberOfGuests();
        searchResultPage.getFilterButton().click();
        wait.until(ExpectedConditions.visibilityOf(filterPage.getPriceFrom())).click();
        step("Step 9:User selecting Price range ");
        filterPage.getPriceFrom().sendKeys("50");
        filterPage.getPriceTo().sendKeys("1000");
        step("Step 10:User selecting bed_bedroom_bathroom and all amenities ");
        filterPage.getIncrBeds().click();
        filterPage.getIncrBedrooms().click();
        filterPage.getIncrBathrooms().click();
        filterPage.select_all_amenities();
        step("step 11: User clicking the 'Clear All' button ");
        filterPage.getClearAllButton().click();

        filterPage.getAmWashingMachine().click();
        System.out.println("filterPage.getAmSuitableForChildren().isSelected() = " + filterPage.getAmSuitableForChildren().isSelected());
        System.out.println("filterPage.getAmWashingMachine().isSelected() = " + filterPage.getAmWashingMachine().isSelected());
        System.out.println("filterPage.getAmKitchen().isSelected() = " + filterPage.getAmKitchen().isSelected());
        boolean amenitiesSelected = searchResultPage.checkingClearAllFunc();
        System.out.println("amenitiesSelected = " + amenitiesSelected);

        Assert.assertTrue(amenitiesSelected);

    }

    @Test(priority = 5)
    @Description("Testing the All Listings Page")
    public void allListingPageTest() {
        step("step 11: User should be able to navigate All Listings page ");
        wait.until(ExpectedConditions.visibilityOf(mainPage.getAllListings())).click();
        wait.until(ExpectedConditions.visibilityOf(allListingsPage.getAllAmount()));
        step("step 12: Getting the amount of number from All label ");
        int number_on_top = allListingsPage.getAllAmounts();
        step("step 13: Scrolling down to the last item and getting the amount ");
        int number_of_properties = allListingsPage.movingLastProperties();
        Assert.assertEquals(number_on_top, number_of_properties);
    }
/*
    @Test
    @Description("Testing the maximum value for guests")
    public void guestNumber() {
        step("Step 0: User should be able to select check_in and check_out date");
        wait.until(ExpectedConditions.visibilityOf(searchResultPage.getCheckIn())).click();
        searchResultPage.selectCheckInOutDates();
        wait.until(ExpectedConditions.visibilityOf(searchResultPage.getGuests())).click();
        searchResultPage.maxGuests();
    }

 */


}
