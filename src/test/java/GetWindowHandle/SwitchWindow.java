package GetWindowHandle;

import UtilsForMethods.BrowsersUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Set;

public class SwitchWindow {




    @Test
    public void switchPractice(){

        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions=new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");

        WebDriver driver=new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://the-internet.herokuapp.com/");

       // CLICKING THE MULTIPLE
       driver.findElement(By.partialLinkText("Windows")).click();
       // CLICKING CLICK HERE
       driver.findElement(By.linkText("Click Here")).click();


       //
        System.out.println(driver.getWindowHandle()); // method returns main page id
        String mainPageId=driver.getWindowHandle();   // stored it cuz we will need it in the loop

        //
        Set<String> allPages= driver.getWindowHandles(); // returns Set of String collections all pages open including main
        // to reach second Window need this logic
        for(String id : allPages){

            if(!id.equals(mainPageId)){
                driver.switchTo().window(id);
                break;
            }

        }

        WebElement header=driver.findElement(By.tagName("h3"));
        System.out.println(BrowsersUtils.getText(header));
        // validate reaching out to second Window
        Assert.assertEquals(BrowsersUtils.getText(header),"New Window");




    }




     @Test
    public void Practice2() throws InterruptedException {

         WebDriverManager.chromedriver().setup();
         ChromeOptions chromeOptions=new ChromeOptions();
         chromeOptions.addArguments("--remote-allow-origins=*");

         WebDriver driver=new ChromeDriver(chromeOptions);
         driver.manage().window().maximize();
         driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
         Actions action=new Actions(driver);

         driver.get("https://www.hyrtutorials.com/p/window-handles-practice.html");
         action.scrollByAmount(200,200).perform();

         driver.findElement(By.xpath("//button[@id='newTabBtn']")).click();


         String mainPageID=driver.getWindowHandle(); // main Page Id
         Set<String> allPagesId=driver.getWindowHandles();  // all ides
         for(String each : allPagesId){

             if(!each.equals(mainPageID)){ // avoiding main page id
             driver.switchTo().window(each);  // move to it
             break; // stop loop
             }

         }

         // validate Title
         String actualTitle=driver.getTitle().trim();
         String expectedTitle="AlertsDemo - H Y R Tutorials";
         Assert.assertEquals(actualTitle,expectedTitle);


         WebElement header= driver.findElement(By.xpath("//div[@id='main']//h1[@itemprop='name']"));
         String actualHeader=BrowsersUtils.getText(header);
         String expectedHeader="AlertsDemo";
         System.out.println(actualHeader);
         Assert.assertEquals(actualHeader,expectedHeader);





     }












}
