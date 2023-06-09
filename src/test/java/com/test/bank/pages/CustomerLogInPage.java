package com.test.bank.pages;

import UtilsForMethods.BrowsersUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.Arrays;
import java.util.List;

public class CustomerLogInPage {


    public CustomerLogInPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    //Elements
    @FindBy(css = "#userSelect")
    WebElement selectUserName;

    @FindBy(xpath = "//button[.='Login']")
    WebElement logIn;

    @FindBy(xpath = "//strong[contains(text(),'Welcome')]")
    WebElement header;


    @FindBy(xpath = "//button[contains(text(),'Transactions')]")
    WebElement transactionsButton;

    @FindBy(xpath = "//button[contains(text(),'Deposit')]")
    WebElement depositButton;


    @FindBy(xpath = "//button[contains(text(),'Withdrawl')]") // bug here miss spelling withdrawal (withdrawl)
    WebElement withdrawalButton;


    @FindBy(xpath = "//input[@placeholder='amount']")
    WebElement amountBox;


    @FindBy(xpath = "//button[@type='submit']")
    WebElement submitButton;


    @FindBy(xpath = "//span[@ng-show='message']")
    WebElement message;

    @FindBy(xpath = "//tr[@id='anchor0']//td[2]")
    WebElement transactionCredit;

    @FindBy(xpath = "/tr[@id='anchor1']//td[2]")
    WebElement transactionDebt;


    @FindBy(xpath = "//button[.='Back']")
    WebElement backButton;


    @FindBy(xpath = "//strong[@class='ng-binding']")
    List<WebElement> balanceIndex1;


    // customer functions


    //login
    public void LoginFunctionality(WebDriver driver, String userName, String expected) throws InterruptedException {
        BankLoginPage logInPage = new BankLoginPage(driver);
        logInPage.customerLogin(); // login to customerPage
        Thread.sleep(2000);
        BrowsersUtils.selectBy(this.selectUserName, userName, "text");
        logIn.click();
        Assert.assertTrue(BrowsersUtils.getText(header).contains(expected));
    }

    // deposit
    public void depositFunctionality(String amountIn, String expectedMessageIn) throws InterruptedException {
        depositButton.click();
        Thread.sleep(500);
        amountBox.sendKeys(amountIn); //500
        submitButton.submit();//deposit
        Assert.assertEquals(BrowsersUtils.getText(message), expectedMessageIn); // message deposit successfully
        Thread.sleep(1000);
    }


    public void withdrawalFunctionality(String amountOut, String expectedMessageOut) throws InterruptedException {
        withdrawalButton.click();
        Thread.sleep(500);
        amountBox.sendKeys(amountOut); //200
        submitButton.submit(); // withdrawal
        Assert.assertEquals(BrowsersUtils.getText(message), expectedMessageOut); // message after withdrawal
        Thread.sleep(1000);
    }

    public void transactionsFunctionality(int deposit) {
        transactionsButton.click(); // clicking transaction Option
        int balance = deposit;
        backButton.click(); // back to all options
        int expectedBalance = Integer.parseInt(BrowsersUtils.getText(balanceIndex1.get(1)));
        System.out.println(expectedBalance +"----"+ balance);
        Assert.assertEquals(balance, expectedBalance);
    }

}


















