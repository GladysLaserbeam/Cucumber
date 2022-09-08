package com.amazon.stepdefinitions;

import com.amazon.pages.MainPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AmazonStepDef {
    WebDriver driver;
    MainPage mainPage;
    @Given("User navigates to Amazon")
    public void user_navigates_to_amazon() {
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.amazon.com/");

    }
    @When("User searches for iphone 13 case")
    public void user_searches_for_iphone_case() {
        mainPage=new MainPage(driver);
        mainPage.searchWord("iPhone 13 case");
    }
    @Then("User validates the number is {int} results on top that shown")
    public void user_validates_the_number_is_results_on_top_that_shown(int expectedResult) {
        mainPage=new MainPage(driver);
        Assert.assertTrue(mainPage.resultOfSearch()==expectedResult);
    }

    @Then("User validates all headers contains iPhone")
    public void user_validates_all_headers_contains_i_phone() {
        mainPage=new MainPage(driver);
        mainPage.validateHeaders("iPhone");
    }


}
