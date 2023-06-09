package com.test.openchart.pages;

import UtilsForMethods.BrowsersUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.List;

public class OpenChartCustomerPage {

    public OpenChartCustomerPage(WebDriver driver) {  // constructor
        PageFactory.initElements(driver, this);
    }


    // public  WebDriver driver;
    //Elements


    @FindBy(css = "#menu-customer")
    WebElement customersButton;

    @FindBy(xpath = "//ul//a[.='Customers']")
    WebElement internalCustomersButton;
    @FindBy(xpath = "//a[@aria-label='Add New']")
    WebElement addSing;

    @FindBy(css = "#input-firstname")
    WebElement firstName;

    @FindBy(css = "#input-lastname")
    WebElement lastName;


    @FindBy(css = "#input-email")
    WebElement email;

    @FindBy(css = "#input-telephone")
    WebElement telephone;

    @FindBy(css = "#input-password")
    WebElement password;

    @FindBy(css = "#input-confirm")
    WebElement confirmPassword;

    @FindBy(css = "#input-newsletter")
    WebElement newsLetterBox;

    @FindBy(xpath = "//input[@type='checkbox']")
    List<WebElement> checkBoxes;

   @FindBy(xpath = "//button[@form='form-customer']")
   WebElement save;

   @FindBy(xpath = "//div[@id='alert']")
   WebElement alertMessage;

    public void customersFunctionMethod() throws InterruptedException {
        customersButton.click();
        internalCustomersButton.click();
        Thread.sleep(500);
    }


    public void addCustomerFunctionMethod(WebDriver driver, String fName, String lName, String email1, String phoneNumber, String password1, String confirmPass) throws InterruptedException {
        addSing.click();
        firstName.sendKeys(fName);
        lastName.sendKeys(lName);
        email.sendKeys(email1);
        telephone.sendKeys(phoneNumber);
        password.sendKeys(password1);
        confirmPassword.sendKeys(confirmPass);
      //  BrowsersUtils.scrollWithJS(driver,checkBoxes.get(3));
        //
        Actions action=new Actions(driver);
        action.scrollByAmount(0,500).perform();
        for (WebElement each : checkBoxes) {
            if (each.isEnabled() && !each.isSelected()) {
                  each.click();
                // action.click(each).perform();
            }
        }
        Thread.sleep(1000);
        //  save.sendKeys(Keys.PAGE_UP);  it works too
        BrowsersUtils.scrollWithJS(driver,save);
        BrowsersUtils.clickWithJS(driver,save); // clicked with js cuz regular not working

        //
        Thread.sleep(500);
        BrowsersUtils.getText(alertMessage);
        Assert.assertEquals(BrowsersUtils.getText(alertMessage),"Warning: You do not have permission to modify customers!");

    }


}




