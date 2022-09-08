package com.amazon.pages;

import Utils.BrowserUtils;
import io.cucumber.core.cli.Main;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class MainPage {
    public MainPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }
    @FindBy(id = "twotabsearchtextbox")
    WebElement searchField;

    @FindBy(xpath = "//span[contains(text(),'of over')]")
    WebElement results;

    @FindBy(xpath = "//h2//a")
    List<WebElement> allHeader;

    public void searchWord(String search){
        searchField.sendKeys(search, Keys.ENTER);
    }

    public int resultOfSearch(){
        String [] result=results.getText().trim().split(" ");
        int lastResult=Integer.parseInt(result[3].replace(",","")); //40000
        return lastResult;
    }

    public void validateHeaders(String word){
        for(WebElement header:allHeader) {
            if(!BrowserUtils.getText(header).contains("")){
            Assert.assertTrue(BrowserUtils.getText(header).contains(word));
        }
        }
    }

}
