package com.test.bank.pages;

import UtilsForMethods.BrowsersUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class BankLoginPage {

    public BankLoginPage(WebDriver driver) {   // constructor
    PageFactory.initElements(driver,this);  // it dose same logic of driver.findElement();
    }



    @FindBy(css = ".mainHeading")           // WebElement
    WebElement header;

    @FindBy(xpath = "//button[.='Customer Login']")
    WebElement  customerLogin;


    @FindBy(xpath =  "//button[.='Bank Manager Login']")
    WebElement bankMangerLogin;

   // back to page
    @FindBy(xpath = "//button[.='Home']")
    WebElement homePage;


    // Method for validating component of the LoginPage
    public void LoginPageComponentsValidation(String expectedHeader){

    Assert.assertEquals(BrowsersUtils.getText(header),expectedHeader);
    Assert.assertTrue(customerLogin.isDisplayed() && customerLogin.isEnabled());
    Assert.assertTrue(bankMangerLogin.isDisplayed() && bankMangerLogin.isEnabled());
    }


   //Method :  bankMangerLogin Button --> click
    public void clickBankMangerLogIn(){
        bankMangerLogin.click();
    }



    //Method Customer Login Button
    public  void customerLogin(){
     customerLogin.click();
    }

   // Method for Home button
    public void clickHomeButton(WebDriver driver){
        Actions action=new Actions(driver);
        action.click(homePage).perform();
    }

}
