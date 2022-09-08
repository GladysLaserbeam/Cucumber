package com.weborder.weborderstepdefinitions;

import Utils.ConfigReader;
import Utils.DriverHelper;
import com.weborder.pages.WebOrderLoginPage;
import io.cucumber.java.en.But;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import java.sql.Driver;

public class WebOrderLoginStepDef {
    WebDriver driver = DriverHelper.getDriver();

//    @When("User provides correct {string} and {string} for WebOrder")
//    public void user_provides_correct_and_for_web_order(String userName, String password) {
//        WebOrderLoginPage loginPage=new WebOrderLoginPage(driver);
//        loginPage.webOrderLogin(userName,password);
//    }

    @Then("User validates the {string} from homepage")
    public void user_validates_the_from_homepage(String expectedTitle) {
        Assert.assertEquals(expectedTitle, driver.getTitle());
    }

    //    @When("User provides correct {string} and wrong {string} for WebOrder")
//    public void user_provides_correct_and_wrong_for_web_order(String username, String password) {
//        WebOrderLoginPage loginPage=new WebOrderLoginPage(driver);
//        loginPage.webOrderLogin(username,password);
//    }
    @Then("User validates the {string} error message.")
    public void user_validates_the_error_message(String expectedErrorMessage) {
        WebOrderLoginPage webOrderLoginPage = new WebOrderLoginPage(driver);
        Assert.assertEquals(expectedErrorMessage, webOrderLoginPage.getErrorMessage());
    }

//    @When("User provides wrong {string} and correct {string} for WebOrder")
//    public void user_provides_wrong_and_correct_for_web_order(String username, String password) {
//        WebOrderLoginPage loginPage=new WebOrderLoginPage(driver);
//        loginPage.webOrderLogin(username,password);
//    }

//    @When("User provides empty {string} and empty {string} for WebOrder")
//    public void user_provides_empty_and_empty_for_web_order(String userName, String Password) {
//        WebOrderLoginPage loginPage=new WebOrderLoginPage(driver);
//        loginPage.webOrderLogin(userName,Password);
//    }

    @When("User provides credentials {string} and {string} for WebOrder")
    public void user_provides_credentials_and_for_web_order(String userName, String password) {
        WebOrderLoginPage loginPage = new WebOrderLoginPage(driver);
        loginPage.webOrderLogin(userName, password);
    }

    @Given("User navigates to the WebOrder")
    public void user_navigates_to_the_web_order() {
        driver.get(ConfigReader.readProperty("weborderurl"));
    }
}
