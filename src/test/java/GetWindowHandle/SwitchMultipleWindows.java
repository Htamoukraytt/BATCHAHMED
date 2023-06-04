package GetWindowHandle;

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
import java.util.Set;

public class SwitchMultipleWindows {


    @Test
    public void Practice2() throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");

        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        Actions action = new Actions(driver);
       // driver.get("https://www.hyrtutorials.com/p/window-handles-practice.html");

        JavascriptExecutor js=(JavascriptExecutor) driver;

        // it opens more than 2 tabs // windows
        js.executeScript("window.open('http://www.techtorialacademy.com/')"); // main
        js.executeScript("window.open('https://www.techtorialacademy.com/contact-us-techtorial')"); // contact ustab
        js.executeScript("window.open('https://www.techtorialacademy.com/courses')"); // courses



        // GET CONTACT  US TAP TITLE

        String   mainPageId=driver.getWindowHandle();
        Set<String> setOfIdes=driver.getWindowHandles();

//        for(String eachId : setOfIdes){
//
//           if(!eachId.equals(mainPageId)) {
//               driver.switchTo().window(eachId);
//               break;
//           }
//
//        }

        // behind the since there was a logic of checking windows by titles
        BrowsersUtils.switchByTitle(driver,"Courses");
        System.out.println(driver.getTitle());


        BrowsersUtils.switchByTitle(driver,"Kickstart");
        System.out.println(driver.getTitle());




    }



    @Test
    public  void RealTest() throws InterruptedException {


        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");

        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        Actions action = new Actions(driver);
        driver.get("https://www.hyrtutorials.com/p/window-handles-practice.html");



      WebElement  button4=driver.findElement(By.cssSelector("#newTabsBtn"));
      BrowsersUtils.scrollWithJS(driver,button4);
      action.click(button4).perform();


      BrowsersUtils.switchByTitle(driver,"Basic Controls H Y R Tutorialss");
      System.out.println(driver.getTitle());

        //
        Thread.sleep(1000);
        action.scrollByAmount(200,200).perform();
        driver.findElement(By.cssSelector("#firstName")).sendKeys("hicham");
        driver.findElement(By.cssSelector("#lastName")).sendKeys("tamk");
        action.scrollByAmount(100,100).perform();
        driver.findElement(By.cssSelector("#malerb")).click();
        driver.findElement(By.cssSelector("#englishchbx")).click();
        action.scrollByAmount(100,100).perform();
        driver.findElement(By.cssSelector("#email")).sendKeys("HICHAM@gmail.com");
        driver.findElement(By.cssSelector("#password")).sendKeys("12361273");
        WebElement registerButton = driver.findElement(By.xpath("//button[.='Register']"));
        registerButton.click();
       // BrowsersUtils.scrollWithJS(driver,registerButton);
       Thread.sleep(1000);

       WebElement msg=driver.findElement(By.cssSelector("#msg"));
       Assert.assertEquals(BrowsersUtils.getText(msg),"Registration is Successful");

       // Moving to the alertDemo window
        BrowsersUtils.switchByTitle(driver,"AlertsDemo - H Y R Tutorials");
        System.out.println(driver.getTitle());
        // validating that we are at the right window or tab !!
        WebElement alertDemo=driver.findElement(By.xpath("//h1[@itemprop='name']"));
        String actualText=BrowsersUtils.getText(alertDemo);
        String expectedText="AlertsDemo";
        Assert.assertEquals(actualText,expectedText);
        // clicking prompt Box
        WebElement clickPromptBox=driver.findElement(By.cssSelector("#promptBox"));
        BrowsersUtils.clickWithJS(driver,clickPromptBox);

        Thread.sleep(1000);
        // moving to Window Handles Practice - H Y R Tutorials
        BrowsersUtils.switchByTitle(driver,"Window Handles Practice - H Y R Tutorials");
        System.out.println(driver.getTitle());
        Thread.sleep(1000);

        //validating a text
        WebElement WindowHandlesText=driver.findElement(By.xpath("//h1[contains(text(),'Window Handles')]"));
        BrowsersUtils.scrollWithJS(driver,WindowHandlesText);
        String actualWindowHandleText=BrowsersUtils.getText(WindowHandlesText);
        String expectedWindowHandleText="Window Handles Practice";
        Assert.assertEquals(actualText,expectedWindowHandleText);


    }
}
