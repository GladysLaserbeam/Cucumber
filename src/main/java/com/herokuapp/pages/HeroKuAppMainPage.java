package com.herokuapp.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class HeroKuAppMainPage {
    public HeroKuAppMainPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }
    @FindBy(tagName = "li")
    List<WebElement> allLinks;

    public void clickonLink(String linkName){
        for (int i=0;i<allLinks.size(); i++){
            allLinks.get(i).click();
        }
    }

}
