package com.test.blaze.pages;

import UtilsForMethods.BrowsersUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class MacBookProPage {


    public MacBookProPage(WebDriver driver) {
        PageFactory.initElements(driver,this);
    }


    @FindBy(tagName = "h2")
    WebElement header;

    @FindBy(xpath = "//h3[@class='price-container']")
    WebElement price;

    @FindBy(xpath = "//div[@id='more-information']")
    WebElement descriptions;

    @FindBy(xpath = "//a[.='Add to cart']")
    WebElement addToCartButton;



    public  void MackBookInformation(String expectedHeader, String expectedPrice , String expectedDesc){
        Assert.assertEquals(BrowsersUtils.getText(header),expectedHeader);
        // System.out.println(BrowsersUtils.getText(header));
        Assert.assertEquals(BrowsersUtils.getText(price),expectedPrice);
        // System.out.println(BrowsersUtils.getText(price));
        Assert.assertEquals(BrowsersUtils.getText(descriptions),expectedDesc);
        // System.out.println(BrowsersUtils.getText(descriptions));
    }

    public void addToCartButtonMethod(WebDriver driver, String alertExpected) throws InterruptedException {
        Thread.sleep(1000);
        addToCartButton.click();
        Thread.sleep(1500);
        Alert alert= driver.switchTo().alert();
        Assert.assertEquals(alert.getText(),alertExpected);
        alert.accept();
    }



}
