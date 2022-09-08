package com.products.pages;

import Utils.BrowserUtils;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class ProductOrderPage {

    public ProductOrderPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "ctl00_MainContent_fmwOrder_ddlProduct")
    WebElement product;

    @FindBy(id = "ctl00_MainContent_fmwOrder_txtQuantity")
    WebElement quantity;

    @FindBy(id = "ctl00_MainContent_fmwOrder_TextBox2")
    WebElement street;

    @FindBy(id = "ctl00_MainContent_fmwOrder_txtName")
    WebElement customerName;

    @FindBy(id = "ctl00_MainContent_fmwOrder_TextBox4")
    WebElement state;

    @FindBy(id = "ctl00_MainContent_fmwOrder_TextBox3")
    WebElement city;

    @FindBy(id = "ctl00_MainContent_fmwOrder_TextBox5")
    WebElement zip;

    @FindBy(id = "ctl00_MainContent_fmwOrder_cardList_0")
    WebElement visacard;

    @FindBy(id = "ctl00_MainContent_fmwOrder_cardList_1")
    WebElement mastercard;

    @FindBy(id = "ctl00_MainContent_fmwOrder_cardList_2")
    WebElement americanExpress;

    @FindBy(id = "ctl00_MainContent_fmwOrder_TextBox6")
    WebElement cardNumber;

    @FindBy(id = "ctl00_MainContent_fmwOrder_TextBox1")
    WebElement expireDate;

    @FindBy(id = "ctl00_MainContent_fmwOrder_InsertButton")
    WebElement processButton;

    @FindBy(xpath = "//strong")
    WebElement message;

    @FindBy(xpath = "//li[.='View all orders']")
    WebElement viewAllOrdersButton;

    @FindBy(xpath = "//tbody/tr[2]/td")
    List<WebElement> rowList;

    public void sendProductInformation(String productName, String quantityNumber) {
        BrowserUtils.selectBy(product, productName, "text");
        quantity.clear();
        quantity.sendKeys(quantityNumber);
    }

    public void sendAddressInformation(String name, String street, String city, String state, String zip) {
        customerName.sendKeys(name);
        this.street.sendKeys(street);
        this.city.sendKeys(city);
        this.state.sendKeys(state);
        this.zip.sendKeys(zip);
    }

    public void sendPaymentInformation(String cardNumber, String expireDate, String cardType) {
        this.cardNumber.sendKeys(cardNumber);
        this.expireDate.sendKeys(expireDate);
        selectCard(cardType);
        processButton.click();
    }

    public void selectCard(String cardType) {
        cardType = cardType.toUpperCase();

        switch (cardType) {
            case "VISA":
                visacard.click();
                break;
            case "MASTERCARD":
                mastercard.click();
                break;
            case "AMERICAN EXPRESS":
                americanExpress.click();
                break;
            default:
                System.out.println("Card name is not correct. Please provide a valid card type");
                break;
        }
    }

    public String getMessage() {
        return BrowserUtils.getText(message);
    }

    public void validateList(String CustomerName, String product, String quantity, String street, String city, String state, String zipCode,
                                String cardType, String cardNumber, String expiredDate) {
        viewAllOrdersButton.click();
        List<String> orderInfo=new ArrayList<>();
        for (int i=1;i<rowList.size()-1;i++){
            rowList.get(i).getText().trim();
            orderInfo.add(rowList.get(i).getText().trim());
        }
        Assert.assertEquals(orderInfo.get(0),CustomerName);
        Assert.assertEquals(orderInfo.get(1),product);
        Assert.assertEquals(orderInfo.get(2),quantity);
        Assert.assertEquals(orderInfo.get(4),street);
        Assert.assertEquals(orderInfo.get(5),city);
        Assert.assertEquals(orderInfo.get(6),state);
        Assert.assertEquals(orderInfo.get(7),zipCode);
        Assert.assertEquals(orderInfo.get(8),cardType);
        Assert.assertEquals(orderInfo.get(9),cardNumber);
        Assert.assertEquals(orderInfo.get(10),expiredDate);

    }
}




