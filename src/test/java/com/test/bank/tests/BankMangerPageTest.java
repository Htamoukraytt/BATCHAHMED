package com.test.bank.tests;

import com.test.bank.pages.BankLoginPage;
import com.test.bank.pages.BankMangerPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class BankMangerPageTest extends  BankTestBase {  // extending from the Base


    @Test
    public void validateAddCustomerFunctionality(){
//        WebDriverManager.chromedriver().setup();
//        WebDriver driver=new ChromeDriver();
//        driver.manage().window().maximize();
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//        driver.navigate().to("https://www.globalsqa.com/angularJs-protractor/BankingProject/#/login");
        BankLoginPage loginPage=new BankLoginPage(driver); // object to call method
        loginPage.clickBankMangerLogIn(); // it's a method that clicks bankMangerLogIn

        BankMangerPage bankManger=new BankMangerPage(driver);
        bankManger.addCustomerButtonFunctionality(driver,"hicham","tam","60056","Customer added successfully with customer id");

    }




    @Test
    public void validatingOpenAccountFunction() throws InterruptedException {
//        WebDriverManager.chromedriver().setup();
//        WebDriver driver=new ChromeDriver();
//        driver.manage().window().maximize();
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//        driver.navigate().to("https://www.globalsqa.com/angularJs-protractor/BankingProject/#/login");

        BankLoginPage loginPage=new BankLoginPage(driver);
        loginPage.clickBankMangerLogIn();
        BankMangerPage mangerPage=new BankMangerPage(driver);
        mangerPage.addCustomerButtonFunctionality(driver,"hicham","tam","60056","Customer added successfully with customer id");
        mangerPage.openAccountFunctionality(driver,"hicham tam","Dollar","Account created successfully with account Number");

    }


    @Test
    public void validatingCustomersFunctionality() throws InterruptedException {
        //        WebDriverManager.chromedriver().setup();
//        WebDriver driver=new ChromeDriver();
//        driver.manage().window().maximize();
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//        driver.navigate().to("https://www.globalsqa.com/angularJs-protractor/BankingProject/#/login");

        BankLoginPage loginPage=new BankLoginPage(driver);
        loginPage.clickBankMangerLogIn();
        BankMangerPage mangerPage=new BankMangerPage(driver);
        // addCustomerFunction
        mangerPage.addCustomerButtonFunctionality(driver,"hicham","tam","60056","Customer added successfully with customer id");
        //openAccountFunction
        mangerPage.openAccountFunctionality(driver,"hicham tam","Dollar","Account created successfully with account Number");
        // customer Function
        mangerPage.customersFunctionality("hicham","tam","60056");


    }





}
