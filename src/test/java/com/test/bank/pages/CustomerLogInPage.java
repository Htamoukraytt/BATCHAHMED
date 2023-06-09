package com.test.bank.pages;

import UtilsForMethods.BrowsersUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CustomerPage {


    public void CustomerPage(WebDriver driver){
    PageFactory.initElements(driver,this);
    }


    //Elements

    @FindBy(css = "#userSelect")
    WebElement selectUserName;

    @FindBy(xpath = "//button[.='Login']")
    WebElement logIn;

    @FindBy(xpath = "//div//strong//span")
    WebElement  welcomeUser;



    @FindBy(xpath = "//button[@ng-class='btnClass1']")
    WebElement transactionOption;

    @FindBy(xpath = "//button[@ng-class='btnClass2']")
    WebElement depositOption;


    @FindBy(xpath = "//button[@ng-class='btnClass3']") // bug here miss spelling withdrawal (withdrawl)
    WebElement withdrawalOption;


    @FindBy(xpath = "//input[@placeholder='amount']")
    WebElement amount;


    @FindBy(xpath = "//button[@type='submit']")
    WebElement submit;


    @FindBy(xpath = "//span[@ng-show='message']")
    WebElement message;

    @FindBy(xpath = "//td[2]")
    List<WebElement>  transactionsAmount;

    @FindBy(xpath = "//button[.='Back']")
    WebElement backButton;

    @FindBy(xpath = "//strong[@class='ng-binding']")
    List<WebElement>  balanceIndex1;



    // customer function
    public void customerLoginFunctionality(WebDriver driver,String userName ,String expected) throws InterruptedException {
    BankLoginPage logInPage=new BankLoginPage(driver) ;
    logInPage.customerLogin(); // login to customerPage
    Thread.sleep(3000);
    selectUserName.sendKeys("hicham tam");
    //BrowsersUtils.selectBy(this.selectUserName,userName,"text");
    logIn.click();
    Assert.assertTrue(BrowsersUtils.getText(welcomeUser).contains(expected));
    }


  public void depositFunctionality(String amountIn ,String expectedMessageIn){
      depositOption.click();
      amount.sendKeys(amountIn); //500
      submit.submit();//deposit
      Assert.assertEquals(BrowsersUtils.getText(message),expectedMessageIn); // message deposit successfully
  }


  public void withdrawalFunctionality(String amountOut ,String expectedMessageOut){
      withdrawalOption.click();
      amount.sendKeys(amountOut); //200
      submit.submit(); // withdrawal
      Assert.assertEquals(BrowsersUtils.getText(message),expectedMessageOut); // message after withdrawal
  }

  public  void transactionsFunctionality(String expectedBalance ,int amountIn , int amountOut){

      transactionOption.click(); // clicking transaction Option
      // this logic to validate transaction we made from transactions option
      List<Integer>  expectedTransactionsAmount= Arrays.asList(amountIn,amountOut);
      for (int i = 1; i <transactionsAmount.size() ; i++) {
          int transaction=Integer.parseInt(BrowsersUtils.getText(transactionsAmount.get(i)));
          Assert.assertEquals(transaction,expectedTransactionsAmount.get(i));
      }
      backButton.click(); // back to all options
      // this logic to validate balance after
      for(int i = 0 ; i<balanceIndex1.size();i++){   // balance at index 1
          if(i==1){
              int balance=Integer.parseInt(BrowsersUtils.getText(balanceIndex1.get(i)));
              Assert.assertEquals(balance,expectedBalance);
          }
      }
  }



















}
