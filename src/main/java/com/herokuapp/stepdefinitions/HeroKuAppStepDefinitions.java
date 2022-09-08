package com.herokuapp.stepdefinitions;

import Utils.DriverHelper;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

public class HeroKuAppStepDefinitions {
    WebDriver driver= DriverHelper.getDriver();

    @Given("User navigates to {string}")
    public void user_navigates_to(String url) {
        driver.get(url);

    }
    @When("User clicks on the {string} on the mainpage")
    public void user_clicks_on_the_on_the_mainpage(String link) {

    }
    @When("Validates the {string} of the new page")
    public void validates_the_of_the_new_page(String expectedUrl) {

    }
}
