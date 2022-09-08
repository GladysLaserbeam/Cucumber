package com.weborder.pages;

import Utils.BrowserUtils;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.v85.page.Page;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class WebOrderGroupOrderPage {

    public WebOrderGroupOrderPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "ConfirmAddressID")
    WebElement deliveryOptionBox;

    @FindBy(id = "InviteNote")
    WebElement noteInvitees;

    @FindBy(id = "InviteList")
    WebElement inviteList;

    @FindBy(id = "addressPreview")
    WebElement address;

    @FindBy(id = "createGroupOrder")
    WebElement createGroupOrderButton;

    @FindBy(xpath = "//label[contains(text(),'Total Participants:')]//following-sibling ::div")
    WebElement totalParticipant;

    @FindBy(tagName = "h1")
    WebElement header;


    public void chooseTheDeliveryOption(String option, String expectedAddress) {
        BrowserUtils.selectBy(deliveryOptionBox, option, "text");
        Assert.assertTrue(BrowserUtils.getText(address).contains(expectedAddress));
    }

    public void sendingNote(String note) {
        noteInvitees.sendKeys(note);
    }

    public void sendingInviteList(String email1, String email2) {
        inviteList.sendKeys(email1 + "," + email2);
    }

    public void clickOrderButton() {
        createGroupOrderButton.click();
    }

    public boolean validateHeader(WebDriver driver, String expectedHeader) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.titleIs("View Group Order - Weborder"));
        return BrowserUtils.getText(header).equals(expectedHeader);
    }

    public int getNumberOfParticipant() {
        return Integer.parseInt(BrowserUtils.getText(totalParticipant));
    }
}