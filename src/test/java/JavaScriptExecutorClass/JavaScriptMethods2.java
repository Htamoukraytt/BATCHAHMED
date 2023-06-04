package JavaScriptExecutorClass;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import javax.swing.*;
import java.time.Duration;

public class JavaScriptMethods2 {

    //




    @Test
    public void ScrollIntoView() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeoptions=new ChromeOptions();
        chromeoptions.addArguments("--remote-allow--origins=*");
        WebDriver driver=new ChromeDriver(chromeoptions);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.techtorialacademy.com/");
        Actions action=new Actions(driver);


                                                                           // child to parent
        WebElement findOutCourse=driver.findElement(By.xpath("//span[contains(text(),'Find out which ')]//.."));

        JavascriptExecutor js=(JavascriptExecutor)driver; // creating an object fROM js executor and casting it
        js.executeScript("arguments[0].scrollIntoView(true)",findOutCourse); // using object methods executeScript
        Thread.sleep(2000);


        action.click(findOutCourse).perform();










    }












}
