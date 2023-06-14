package com.test.blaze.tests;

import UtilsForMethods.BrowsersUtils;
import UtilsForMethods.DriverHelper;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public class blazeTestBase {



   public  WebDriver driver;

    @BeforeMethod
    public void setup (){
//        WebDriverManager.chromedriver().setup();
//        driver=new ChromeDriver();
//        driver.manage().window().maximize();
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver= DriverHelper.getDriver();
        driver.get("https://www.demoblaze.com/#");
    }



    @AfterMethod
    public void TearDown(ITestResult iTestResult){
      if(!iTestResult.isSuccess()){
          BrowsersUtils.getScreenShot(driver,"blazePictures");
      }

      driver.quit();
    }


}
