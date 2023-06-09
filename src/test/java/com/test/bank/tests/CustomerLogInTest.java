package com.test.bank.tests;

import com.test.bank.pages.BankLoginPage;
import com.test.bank.pages.BankMangerPage;
import com.test.bank.pages.CustomerLogInPage;
import org.testng.annotations.Test;

public class CustomerLogInTest extends BankTestBase{



    @Test
    public void validatingCustomerLogInFunction() throws InterruptedException {
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

        //----> Task start here
        loginPage.clickHomeButton(driver);
        CustomerLogInPage customerLogInPage=new CustomerLogInPage(driver);
        customerLogInPage.LoginFunctionality(driver,"hicham tam","Welcome hicham tam !!");
        //
        customerLogInPage.depositFunctionality("500","Deposit Successful");
        //
         customerLogInPage.withdrawalFunctionality("200","Transaction successful");
         //
        // customerLogInPage.transactionsFunctionality();
    }













}
