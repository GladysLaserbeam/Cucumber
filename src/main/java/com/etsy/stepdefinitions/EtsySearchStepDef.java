package com.etsy.stepdefinitions;

import Utils.DriverHelper;
import com.etsy.pages.EtsyMainPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

public class EtsySearchStepDef {
    WebDriver driver= DriverHelper.getDriver();
    EtsyMainPage etsyMainPage=new EtsyMainPage(driver);
    @Given("User naviagates to {string}")
    public void user_naviagates_to(String url) {
    driver.get(url);
    }
    @When("user searches for {string}")
    public void user_searches_for(String word) {
    etsyMainPage.searchItem(word);


    }
    @Then("user sees and validates the title is {string}")
    public void user_sees_and_validates_the_title_is(String expectedTitle) {
        Assert.assertEquals(expectedTitle,driver.getTitle());

    }

}
