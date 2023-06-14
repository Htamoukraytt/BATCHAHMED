package com.test.blaze.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class BlazeHomePage {

    public BlazeHomePage(WebDriver driver) {
    PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//a[@id='itemc']")
    List<WebElement> categoriesOptions;


    @FindBy(xpath = "//a[.='Cart']")
    WebElement cartButton;

    public void categoriesOptionsMethod(String item) throws InterruptedException {
        for(WebElement eachItem : categoriesOptions){
            if(eachItem.getText().equalsIgnoreCase(item)){
              eachItem.click();
              break;
            }
        }
        Thread.sleep(1000);
    }


    public void cartButtonMethod() throws InterruptedException {
    cartButton.click();
    Thread.sleep(1000);
    }




}
