package com.google.stepdefinitions;

import com.google.pages.MainPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class GoogleStepDef {
    WebDriver driver;
    @Given("User navigates to the google")
    public void user_navigates_to_the_google() {
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.google.com/");

    }
    @When("User searches for Techtorial")
    public void user_searches_for_techtorial() {
        MainPage mainPage=new MainPage(driver);
        mainPage.searchBoxField("Techtorial");

    }
    @Then("User gets more than {int} links on the google page")
    public void user_gets_more_than_links_on_the_google_page(int expectedLinkNumber) {
    MainPage mainPage=new MainPage(driver);
       // Assert.assertEquals(expectedLinkNumber,mainPage.validateLinkSize());
        Assert.assertTrue(expectedLinkNumber< mainPage.validateLinkSize());
    }

}
