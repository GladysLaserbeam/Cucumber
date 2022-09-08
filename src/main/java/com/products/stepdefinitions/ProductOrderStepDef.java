package com.products.stepdefinitions;

import Utils.ConfigReader;
import Utils.DriverHelper;
import com.products.pages.ProductLoginPage;
import com.products.pages.ProductOrderPage;
import com.products.pages.ProductsMainPage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductOrderStepDef {
    WebDriver driver= DriverHelper.getDriver();
    ProductLoginPage loginPage=new ProductLoginPage(driver);
    ProductsMainPage mainPage=new ProductsMainPage(driver);
    ProductOrderPage orderPage=new ProductOrderPage(driver);

    @Given("User navigates to product homepage and clicks Order Button")
    public void user_navigates_to_product_homepage_and_clicks_order_button() {
        driver.get(ConfigReader.readProperty("producturl"));
        loginPage.login(ConfigReader.readProperty("productusername"),ConfigReader.readProperty("productpassword"));
        mainPage.clickOrderButton();

    }
    @When("User enters the product information {string} and {string}")
    public void user_enters_the_product_information_and(String product, String quantity) {
        orderPage.sendProductInformation(product,quantity);
    }
    @When("User enters the address information {string},{string},{string},{string},{string}")
    public void user_enters_the_address_information(String name, String street, String city, String state, String zip) {
        orderPage.sendAddressInformation(name, street, city, state, zip);

    }
    @When("User enters the payment information {string},{string},{string} and process the order")
    public void user_enters_the_payment_information_and_process_the_order(String cardNumber, String expireDate, String cardType) {
        orderPage.sendPaymentInformation(cardNumber, expireDate, cardType);

    }
    @Then("User validates the message {string}")
    public void user_validates_the_message(String expectedMessage) {
       Assert.assertEquals(expectedMessage,orderPage.getMessage());

    }
    @Then("User clicks View All Orders and validates {string},{string},{string},{string},{string},{string},{string},{string},{string},{string}")
    public void user_clicks_view_all_orders_and_validates(String CustomerName, String product, String quantity, String street, String city, String state, String zipCode, String cardType, String cardNumber, String expiredDate) {
        orderPage.validateList(CustomerName, product, quantity, street, city, state, zipCode, cardType, cardNumber, expiredDate);
    }

    @Given("User navigates to product homepage and clicks Order Button with DataTable")
    public void user_navigates_to_product_homepage_and_clicks_order_button_with_data_table(DataTable dataTable) {
        driver.get(ConfigReader.readProperty("producturl"));
        Map<String,String> loginCredentials=dataTable.asMap(); //username and password
        loginPage.login(loginCredentials.get("username"),loginCredentials.get("password"));
        mainPage.clickOrderButton();
    }
    @When("User enters the product information")
    public void user_enters_the_product_information(DataTable dataTable) {
        Map<String,String> productInformation=dataTable.asMap();
        orderPage.sendProductInformation(productInformation.get("product"),productInformation.get("quantity"));

    }
    @When("User enters the address information")
    public void user_enters_the_address_information(DataTable dataTable) {
        Map<String,String> addressInfo=dataTable.asMap();
        orderPage.sendAddressInformation(addressInfo.get("name"),addressInfo.get("street"),addressInfo.get("city"),addressInfo.get("state"),addressInfo.get("zipCode"));


    }
    @When("User enters the payment information and process the order")
    public void user_enters_the_payment_information_and_process_the_order(DataTable dataTable) {
        Map<String,String> paymentInfo=dataTable.asMap();
        orderPage.sendPaymentInformation(paymentInfo.get("cardNumber"),paymentInfo.get("expireDate"),paymentInfo.get("cardType"));

    }
    @Then("User validates the message")
    public void user_validates_the_message(DataTable dataTable) {
        List<String> message=dataTable.asList(); //you can use list in the other steps above instead of map it is up tp you
        Assert.assertEquals(message.get(0),orderPage.getMessage());

    }
    @Then("User clicks View All Orders and validates")
    public void user_clicks_view_all_orders_and_validates(DataTable dataTable) {
        Map<String,String> viewsAllOrders=dataTable.asMap();
        orderPage.validateList(viewsAllOrders.get("CustomerName"),viewsAllOrders.get("product"),viewsAllOrders.get("quantity"),
                viewsAllOrders.get("street"),viewsAllOrders.get("city"),viewsAllOrders.get("state"),viewsAllOrders.get("zipCode"),
                viewsAllOrders.get("cardType"),viewsAllOrders.get("cardNumber"),viewsAllOrders.get("expiredDate"));



    }



}
