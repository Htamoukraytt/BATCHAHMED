package JavaScriptExecutorClass;

import UtilsForMethods.BrowsersUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class JSClickScrollTitle {




  // witout JavaScript
    @Test
    public void PracticeWithOutJs(){

        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));;
        driver.get("https://demoqa.com/radio-button");
        Actions action=new Actions(driver);





        WebElement yesButton=driver.findElement(By.cssSelector("#yesRadio"));
        yesButton.click();      //  Not Working ( demo )==> ElementClickInterceptedException: element click intercepted:
        Assert.assertTrue(!yesButton.isEnabled());


        // action.click(yesButton).perform();           Working

    }





    @Test
   public void PracticeUsingJs() throws InterruptedException {

       WebDriverManager.chromedriver().setup();
       ChromeOptions chromeOptions = new ChromeOptions();
       chromeOptions.addArguments("--remote-allow-origins=*");
       WebDriver driver = new ChromeDriver(chromeOptions);
       driver.manage().window().maximize();
       driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
       driver.get("https://demoqa.com/radio-button");
       Actions action=new Actions(driver);


       WebElement yesButton=driver.findElement(By.cssSelector("#yesRadio"));
      // action.click(yesButton).perform(); // it works with action if not will go with JS (LETS SAY IT DOSNT WORK)

       JavascriptExecutor js=(JavascriptExecutor)driver;      // clicking With Java Script
       js.executeScript("arguments[0].click()",yesButton);
       Assert.assertTrue(yesButton.isEnabled()); // is clicked

       Thread.sleep(1000);
       // validating is clicked and message as well
       WebElement message=driver.findElement(By.cssSelector(".mt-3"));
       Assert.assertEquals(BrowsersUtils.getText(message),"You have selected Yes");

       WebElement noRadio=driver.findElement(By.cssSelector("#noRadio"));
       Assert.assertFalse(noRadio.isEnabled());  // expecting false not clicked



   }

   // try webElement.click
   // if not action.click(WebElement).perform();
    // if not java Script
    //  JavascriptExecutor js=(JavascriptExecutor)driver;      // clicking With Java Script
    //       js.executeScript("arguments[0].click()",yesButton);





    // SCROLL DOWN TILL U FIND COPY RIGHT AND GET TEXT VALIDATE IT
    // SCROLL  UP AND FIND  Apply now
    // validate the List



    // Only JS USED HERE FOR
   @Test
    public void practice2() throws InterruptedException {

       WebDriverManager.chromedriver().setup();
       ChromeOptions chromeoptions=new ChromeOptions();
       chromeoptions.addArguments("--remote-allow--origins=*");
       WebDriver driver=new ChromeDriver(chromeoptions);
       driver.manage().window().maximize();
       driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
       driver.get("https://www.techtorialacademy.com/");
       Actions action=new Actions(driver);


       WebElement copyRight=driver.findElement(By.xpath("//div[@id='el_1666192783854_462']"));

       JavascriptExecutor js=(JavascriptExecutor) driver;
       js.executeScript("arguments[0].scrollIntoView(true)",copyRight); // SCROLLING USING  JS


       // validate copyRight Message
       Assert.assertEquals(BrowsersUtils.getText(copyRight),"Copyright © 2023");

       Thread.sleep(1000);
       WebElement applyNow=driver.findElement(By.xpath("//span[.='Apply Now']"));
       js.executeScript("arguments[0].scrollIntoView(true)",applyNow);
       Thread.sleep(1000);
       js.executeScript("arguments[0].click()",applyNow);  // clicking with JS



       List<WebElement> listOfElements=driver.findElements(By.xpath("//h3[@ data-element-id='heading3Normal']"));

       List<String> actualMessage=new ArrayList<>();
       List<String> expectedMessage= Arrays.asList("info@techtorialacademy.com","+ 1 (224) 570 91 91","Chicago & Houston");

       for(int i=0; i<listOfElements.size() ; i++){
       actualMessage.add(BrowsersUtils.getText(listOfElements.get(i)));
       }
       System.out.println(actualMessage);
       Assert.assertEquals(actualMessage,expectedMessage);


   }




    // advanced  with Teacher
   @Test
   public void scrollIntoViewWithJSShortCut() throws InterruptedException {

       WebDriverManager.chromedriver().setup();
       ChromeOptions chromeoptions=new ChromeOptions();
       chromeoptions.addArguments("--remote-allow--origins=*");
       WebDriver driver=new ChromeDriver(chromeoptions);
       driver.manage().window().maximize();
       driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
       driver.get("https://www.techtorialacademy.com/");
       Actions action=new Actions(driver);
       Thread.sleep(1000);



       WebElement  copyRightLocation=driver.findElement(By.xpath("//div[contains(text(),'Copyright')]"));
       BrowsersUtils.scrollWithJS(driver,copyRightLocation);
       Thread.sleep(1000);
       //validating Message
       Assert.assertEquals(BrowsersUtils.getText(copyRightLocation),"Copyright © 2023");
       Thread.sleep(1000);
       WebElement applyNowLocation=driver.findElement(By.linkText("Apply Now"));
       BrowsersUtils.scrollWithJS(driver,applyNowLocation); // scroll
       Thread.sleep(1000);
       BrowsersUtils.clickWithJS(driver,applyNowLocation);  // click

       // validating the Title
       Assert.assertEquals(BrowsersUtils.getTitleWithJS(driver),"Apply Now");


       // validating school information's  as a list of webElements text Values

       List<WebElement> listOfInfo=driver.findElements(By.xpath("//h3[@ data-element-id='heading3Normal']"));
       List<String>  expectedInfo=Arrays.asList("info@techtorialacademy.com","+ 1 (224) 570 91 91","Chicago & Houston");

       for(int i=0;i< listOfInfo.size();i++){
       Assert.assertEquals(BrowsersUtils.getText(listOfInfo.get(i)),expectedInfo.get(i));
       }





   }







}
