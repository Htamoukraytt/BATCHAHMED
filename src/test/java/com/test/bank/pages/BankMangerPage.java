package com.test.bank.pages;

import UtilsForMethods.BrowsersUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BankMangerPage {


    public BankMangerPage(WebDriver driver ){    // constructor
        PageFactory.initElements(driver,this);
    }

    // addCustomerButton - location
    @FindBy(xpath = "//button[contains(text(),'Add Customer')]")
    WebElement addCustomerButton;

    // firstName Box location
    @FindBy(xpath = "//input[@placeholder='First Name']")
    WebElement firstName;

    @FindBy(xpath = "//input[@placeholder='Last Name']")
    WebElement lastName;

    @FindBy(xpath = "//input[@placeholder='Post Code']")
    WebElement postCode;


    @FindBy(xpath = "//button[.='Add Customer']")
    WebElement submitAddCustomer;



    // location of Open Account function and form ( c and c )
    @FindBy(xpath = "//button[contains(text(),'Open Account')]")
    WebElement openAccountButton;


    @FindBy(css = "#userSelect")
    WebElement customerName;

    @FindBy(css = "#currency")
    WebElement currency;


    @FindBy(xpath = "//button[.='Process']")
    WebElement processButton;


    // customers function location
    @FindBy(xpath = "//button[contains(text(),'Customers')]")
    WebElement customersButton;

    @FindBy(xpath = "//input[@ng-model='searchCustomer']")
    WebElement searchBox;

    @FindBy(xpath = "//td[@class='ng-binding']")
    List<WebElement>  CustomerInfo;









    // Method :  clicking add ..button and filling form --> method is dynamic
    public void addCustomerButtonFunctionality(WebDriver driver,String firstName,String lastName ,String postCode, String expectedMessage){
    addCustomerButton.click(); // clicking
    this.firstName.sendKeys(firstName);
    this.lastName.sendKeys(lastName);
    this.postCode.sendKeys(postCode);
    submitAddCustomer.submit(); // clicking
    Alert alert=driver.switchTo().alert();  // alert active
    Assert.assertTrue(alert.getText().contains(expectedMessage));   // validating alert message
    alert.accept(); // ok
    }



   //Method openAccount Method  (
    public void openAccountFunctionality(WebDriver driver,String name ,String currencyType, String expectedMessage) throws InterruptedException {
    openAccountButton.click(); // click openButton
    Thread.sleep(1000);
    BrowsersUtils.selectBy(customerName,name,"text");   // using method from selectBy from Browser util and providing info
    Thread.sleep(1000);
    BrowsersUtils.selectBy(currency,currencyType,"value");
    Thread.sleep(1000);
    processButton.click();
    Alert alert=driver.switchTo().alert();
    Thread.sleep(1000);
    Assert.assertTrue(alert.getText().trim().contains(expectedMessage));
    alert.accept();
    }




    //Method  customers function
    public void customersFunctionality( String customerName ,String lastName ,String postCode) {
        customersButton.click();
        searchBox.sendKeys(customerName);

        // List<String> actualInfo=new ArrayList<>();
        List<String> expectedInfo = Arrays.asList(customerName, lastName, postCode);
        for (int i = 0; i < CustomerInfo.size(); i++) {
            Assert.assertEquals(BrowsersUtils.getText(CustomerInfo.get(i)), expectedInfo.get(i));
            // System.out.println(BrowsersUtils.getText(CustomerInfo.get(i)));}
        }

    }


    // HomePage button function









}
