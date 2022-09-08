package com.weborder.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WebOrderPage {
    public WebOrderPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//label[@for='GroupOrder']")
    WebElement groupOrderbox;

    @FindBy(id = "getAddressNextButton")
    WebElement nextButton;

    public void clickTheButtons(){
        groupOrderbox.click();
        nextButton.click();
    }

}
