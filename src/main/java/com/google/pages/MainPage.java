package com.google.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.security.Key;
import java.util.List;

public class MainPage {

    public MainPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }
    @FindBy(name = "q")
        WebElement searchBox;

    @FindBy(xpath = "//a")
    List<WebElement> allTheLinks;

    public void searchBoxField(String searchWord){
        searchBox.sendKeys(searchWord,Keys.ENTER);
    }

    public int validateLinkSize(){
        return allTheLinks.size();
    }

}
