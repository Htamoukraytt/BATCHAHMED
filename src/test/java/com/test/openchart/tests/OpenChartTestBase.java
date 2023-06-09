package com.test.openchart.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public class OpenChartTestBase {


    public WebDriver driver; // making it instance (global so can be reached out )


    @BeforeMethod
    public void setup(){  // this to avoid repeating this lines all the time
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        Actions action=new Actions(driver);
        driver.navigate().to("https://demo.opencart.com/admin/index.php?route=common/login");
    }




    @AfterMethod
    public void tearDown(){
        //driver.quit();
    }






}
