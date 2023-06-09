package com.test.bank.tests;

import com.test.bank.pages.BankLoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.time.Duration;

public class BankLoginTest {




  @Test
  public void ValidateLoginPageComponents(){
      WebDriverManager.chromedriver().setup();
      WebDriver driver=new ChromeDriver();
      driver.manage().window().maximize();
      driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
      driver.navigate().to("https://www.globalsqa.com/angularJs-protractor/BankingProject/#/login");

      BankLoginPage bankLoginPage=new BankLoginPage(driver); // calling the method from bankLoginPage
      bankLoginPage.LoginPageComponentsValidation("XYZ Bank");

  }









}
