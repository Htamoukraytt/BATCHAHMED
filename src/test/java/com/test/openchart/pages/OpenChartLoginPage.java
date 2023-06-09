package com.test.openchart.pages;

import UtilsForMethods.BrowsersUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OpenChartLoginPage {

    public OpenChartLoginPage(WebDriver driver) {
    PageFactory.initElements(driver,this);
    }


    // elements

    @FindBy(xpath = "//img[@alt='OpenCart']")
    WebElement loginPageHeader;


    @FindBy(css = "#input-username")
    WebElement userName;

    @FindBy(css = "#input-password")
    WebElement passWord;



    @FindBy(xpath = "//button[@type='submit']")
    WebElement login;


    @FindBy(css = "#alert")
    WebElement alert;



    public void LogInFunctionality(String username1, String passWord1) throws InterruptedException {

       userName.sendKeys(username1);
       passWord.sendKeys(passWord1);
       login.submit();
       Thread.sleep(2000);
    }


    public String errorMessage(){
    return BrowsersUtils.getText(alert);
    }











}
