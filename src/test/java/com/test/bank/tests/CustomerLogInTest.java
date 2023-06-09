package com.test.bank.tests;

import com.test.bank.pages.BankLoginPage;
import com.test.bank.pages.BankMangerPage;
import com.test.bank.pages.CustomerPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.time.Duration;

public class CustomerTest {





    @Test
    public void validatingCustomerFunction() throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://www.globalsqa.com/angularJs-protractor/BankingProject/#/login");

        BankLoginPage loginPage=new BankLoginPage(driver);
        loginPage.clickBankMangerLogIn();
        BankMangerPage mangerPage=new BankMangerPage(driver);
        // addCustomerFunction
        mangerPage.addCustomerButtonFunctionality(driver,"hicham","tam","60056","Customer added successfully with customer id");
        //openAccountFunction
        mangerPage.openAccountFunctionality(driver,"hicham tam","Dollar","Account created successfully with account Number");
        // customer Function
        mangerPage.customersFunctionality("hicham","tam","60056");

        //---->
        BankLoginPage logInpage=new BankLoginPage(driver);
        logInpage.clickHomePage(driver);
        CustomerPage customer=new CustomerPage();
        customer.customerLoginFunctionality(driver,"hicham tam","hicham tam");



    }













}
