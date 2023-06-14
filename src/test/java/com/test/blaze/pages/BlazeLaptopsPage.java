package com.test.blaze.pages;

import UtilsForMethods.BrowsersUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.List;

public class BlazeLaptopsPage {


    public BlazeLaptopsPage(WebDriver driver) {
        PageFactory.initElements(driver,this);
    }



    @FindBy(xpath = "//h4[@class='card-title']//a")
    List<WebElement>  laptops;





    public void laptopsBrandMethod(String itemsName ) throws InterruptedException {

        for(WebElement eachLaptop : laptops){
         if(eachLaptop.getText().equalsIgnoreCase(itemsName)){
             eachLaptop.click();
             break;
         }
        }

       Thread.sleep(1000);
    }








}
