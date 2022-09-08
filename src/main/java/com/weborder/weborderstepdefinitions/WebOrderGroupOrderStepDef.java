package com.weborder.weborderstepdefinitions;

import Utils.DriverHelper;
import com.weborder.pages.WebOrderGroupOrderPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

public class WebOrderGroupOrderStepDef {
    WebDriver driver= DriverHelper.getDriver();
    WebOrderGroupOrderPage webOrderGroupOrderPage=new WebOrderGroupOrderPage(driver);

    @When("User sends the word {string} for Note to Invitees part")
    public void user_sends_the_word_for_note_to_invitees_part(String note) {
        webOrderGroupOrderPage.sendingNote(note);
    }

    @When("User sends e-mail addresses which are {string} and {string} to Invite List")
    public void user_sends_e_mail_addresses_which_are_and_to_invite_list(String email1, String email2) {
        webOrderGroupOrderPage.sendingInviteList(email1,email2);
    }

    @When("User clicks create group order button.")
    public void user_clicks_create_group_order_button() {
        webOrderGroupOrderPage.clickOrderButton();
    }

    @Then("User validates the header of page is {string}")
    public void user_validates_the_title_of_page_is(String header) {
        Assert.assertTrue(webOrderGroupOrderPage.validateHeader(driver,header));
    }

    @Then("User validates total participant is {int}")
    public void user_validates_total_participant_is(int expectedNumber) {
        Assert.assertEquals(expectedNumber,webOrderGroupOrderPage.getNumberOfParticipant());
    }

    @When("User chooses the delivery address {string} and validates the address {string}")
    public void user_chooses_the_delivery_address_and_validates_the_address(String deliveryOption, String address) {
        webOrderGroupOrderPage.chooseTheDeliveryOption(deliveryOption,address);
    }

}
