package com.test.blaze.pages;

import UtilsForMethods.BrowsersUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class PlaceOrderPage {
    public PlaceOrderPage(WebDriver driver) {
        PageFactory.initElements(driver,this);
    }
    @FindBy(css = "#name" )
    WebElement name ;
    @FindBy(css = "#country")
    WebElement country;
    @FindBy(css ="#city" )
    WebElement city;
    @FindBy(css ="#card" )
    WebElement creditCard;
    @FindBy(css = "#month")
    WebElement month;
    @FindBy(css = "#year")
    WebElement year;
    @FindBy(xpath = "//button[.='Purchase']")
    WebElement purchaseButton;
    @FindBy(xpath = "//div[@data-animation='pop']//h2")
    WebElement thanksMessage;

    @FindBy(xpath = "//button[.='OK']")
    WebElement alertOk;

    // input form
    public void placeOrderFormMethod(String name1,String country1, String city1,String card1, String month1 , String year1){
       name.sendKeys(name1);
       country.sendKeys(country1);
       city.sendKeys(city1);
       creditCard.sendKeys(card1);
       month.sendKeys(month1);
       year.sendKeys(year1);
    }
    // button click
    public void purchaseButtonMethod() throws InterruptedException {
    purchaseButton.click();
    }

    //Alert message , Thanks !
  public void thanksMessageAlertMethod(WebDriver driver,String expectedMessage ) throws InterruptedException {
  Assert.assertEquals(BrowsersUtils.getText(thanksMessage),expectedMessage);
   Thread.sleep(1000);
   //BrowsersUtils.clickWithJS(driver,alertOk);
   alertOk.click();
  }

  // Url validation
  public void ValidatingUrlMethod(WebDriver driver , String expectedUrl) throws InterruptedException {
  Thread.sleep(1000);
  Assert.assertEquals(driver.getCurrentUrl().trim() ,expectedUrl);
  }






}
