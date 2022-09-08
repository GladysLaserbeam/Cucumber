package com.products.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductsMainPage {
    public ProductsMainPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath = "//a[.='Order']")
    WebElement orderButton;

    @FindBy(xpath = "//a[.='View all orders']")
    WebElement viewAllOrdersButton;

   public void clickOrderButton(){
       orderButton.click();
   }

   public void clickViewAllOrderButton(){
       viewAllOrdersButton.click();
   }
}
