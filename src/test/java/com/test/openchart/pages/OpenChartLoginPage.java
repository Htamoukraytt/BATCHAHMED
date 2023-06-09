package com.test.openchart.pages;

import UtilsForMethods.BrowsersUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class LoginPage {

    public LoginPage(WebDriver driver) {
    PageFactory.initElements(driver,this);
    }


    // elements

    @FindBy(xpath = "//img[@alt='OpenCart']")
    WebElement loginPageHeader;


    @FindBy(xpath = "#input-username")
    WebElement userName;

    @FindBy(xpath = "input-password")
    WebElement passWord;



    @FindBy(xpath = "//button[@type='submit']")
    WebElement login;





    public void logInFunctionality(WebDriver driver ,String expectedTitle){

       userName.sendKeys("demo");
       passWord.sendKeys("demo");
       login.submit();
       Assert.assertEquals(driver.getTitle(),expectedTitle);  // Dashboard




    }












}
