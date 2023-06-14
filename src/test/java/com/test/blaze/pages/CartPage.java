package com.test.blaze.pages;

import UtilsForMethods.BrowsersUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.Arrays;
import java.util.List;

public class CartPage {
    public CartPage(WebDriver driver) {
    PageFactory.initElements(driver,this);
    }



    @FindBy(xpath = "//td")
   List<WebElement>  itemsInfo;

//    @FindBy(xpath = "//td[3]")
//    WebElement  itemPrice;


    @FindBy(xpath = "//button[.='Place Order']")
    WebElement placeOrderButton;


    public void getInfoFromCart(String expectedItemName , String expectedPrice){
        List<String> expectedInfo= Arrays.asList("",expectedItemName,expectedPrice,"");
        for(int i=1 ; i<itemsInfo.size()-1 ; i++){
        Assert.assertEquals(BrowsersUtils.getText(itemsInfo.get(i)), expectedInfo.get(i));
        }

    }


    public void PlaceOrderButtonMethod(){
    placeOrderButton.click();
    }




}
