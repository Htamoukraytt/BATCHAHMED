package Iframe;

import UtilsForMethods.BrowsersUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import java.time.Duration;

public class Nested_Iframe {


     @Test
     public void Tc_NestedFrame(){


         WebDriverManager.chromedriver().setup();
         ChromeOptions chromeOptions=new ChromeOptions();
         chromeOptions.addArguments("--remote-allow-origins=*");

         WebDriver driver=new ChromeDriver(chromeOptions);
         driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
         driver.manage().window().maximize();
         Actions action=new Actions(driver);

         driver.get("https://the-internet.herokuapp.com/nested_frames");



         // iframeSet (lbab dyal bara )
         driver.switchTo().frame("frame-top");
         WebElement iframeLeft=driver.findElement(By.xpath("//frame[@name='frame-left']"));
         //opening the room left room door with webElement
         driver.switchTo().frame(iframeLeft);
         WebElement leftText=driver.findElement(By.xpath("//body[contains(text(),'LEFT')]"));
         System.out.println(BrowsersUtils.getText(leftText));
         //closing the left Room door and back to top frame (inside the house )
         driver.switchTo().parentFrame();


         //opening middle room
         driver.switchTo().frame("frame-middle");
         WebElement middle=driver.findElement(By.cssSelector("#content"));
         System.out.println(BrowsersUtils.getText(middle));
         driver.switchTo().parentFrame(); // closing room

          //opening right room
          driver.switchTo().frame("frame-right");
          WebElement right=driver.findElement(By.xpath("//body[contains(text(),'RIGHT')]"));
          System.out.println(BrowsersUtils.getText(right));

           //driver.switchTo().parentFrame();
           //driver.switchTo().parentFrame(); // getting out of appartment
           driver.switchTo().defaultContent(); //*******  it goes back to the main html it dosent matter where you at
          // very good method interview question

          // im going the different apartment same building
          driver.switchTo().frame(1);// not recommended (indexing logic )
          WebElement bottom=driver.findElement(By.xpath("//body"));
          System.out.println(BrowsersUtils.getText(bottom));










     }














}
