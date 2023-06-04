package Iframe;

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
import java.util.List;

public class IframePractice {




    // not working for me double check later
    @Test
    public void Practice1() throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions=new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");

        WebDriver driver=new ChromeDriver(chromeOptions);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        Actions action=new Actions(driver);
        driver.get("https://the-internet.herokuapp.com/iframe");

        WebElement text=driver.findElement(By.tagName("h3"));
        System.out.println(BrowsersUtils.getText(text));
        Thread.sleep(1000);

        driver.switchTo().parentFrame();
        driver.switchTo().frame("mce_0_ifr"); //***********************
        Thread.sleep(1000);
        // inputBox.click();

       WebElement inputBox=driver.findElement(By.cssSelector(".tox-edit-area__iframe"));
       inputBox.clear();
       inputBox.sendKeys("I love selenium ");

       // driver.switchTo().parentFrame(); // get back

    }






    // Task

    @Test
    public void Task() throws InterruptedException {


        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions=new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");

        WebDriver driver=new ChromeDriver(chromeOptions);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        Actions action=new Actions(driver);

        driver.get("https://skpatro.github.io/demo/iframes/");

        WebElement pavilion = driver.findElement(By.linkText("Pavilion"));
        pavilion.click();
        Thread.sleep(2000);

        BrowsersUtils.switchByTitle(driver,"Home - qavalidation");

        WebElement selenium=driver.findElement(By.xpath("//ul[@id='primary-menu']//span[.='Selenium']"));
        action.moveToElement(selenium).perform();


        WebElement javaPhyton=driver.findElement(By.linkText("Selenium-Python"));
        action.click(javaPhyton).perform();

        WebElement header=driver.findElement(By.tagName("h1"));
        Assert.assertEquals(BrowsersUtils.getText(header),"Selenium-Python Tutorial");


        List<WebElement>  allLinks=driver.findElements(By.xpath("//p//a"));
        for(WebElement each : allLinks){
            System.out.println(BrowsersUtils.getText(each));
        }

        //----

        // switching the tab
        BrowsersUtils.switchByTitle(driver,"iframes");
        // entering the frame
        driver.switchTo().frame("Framename1");  // ***********
        WebElement category=driver.findElement(By.xpath("//a[.='Category1']"));
        action.click(category).perform();
        //leaving the frame
        driver.switchTo().parentFrame(); // leaving the frame
        Thread.sleep(2000);
        // switching the tab
        BrowsersUtils.switchByTitle(driver,"SeleniumTesting Archives - qavalidation");
        WebElement headerH1=driver.findElement(By.tagName("h1"));
        String actualH1=BrowsersUtils.getText(headerH1);
        String expectedH1="Category Archives: SeleniumTesting";
        Assert.assertEquals(actualH1,expectedH1);
      ; //

        Thread.sleep(2000);


        List<WebElement> allTitles=driver.findElements(By.xpath("//h3//a"));
        for(WebElement eachTitle : allTitles){
        System.out.println(BrowsersUtils.getText(eachTitle));
        }
        System.out.println(allTitles.size());


//--------------

        // going back to main page
        BrowsersUtils.switchByTitle(driver,"iframes");
        driver.switchTo().frame("Frame1"); //
        WebElement frameText=driver.findElement(By.cssSelector("#frametext"));
        System.out.println("text frame 1 ==>" + BrowsersUtils.getText(frameText));
        driver.switchTo().parentFrame(); // leaving the frame

        // clicking category3 inside frame
        driver.switchTo().frame("Frame2");
        WebElement category3=driver.findElement(By.xpath("//a[.='Category3']"));
        action.click(category3).perform();
        driver.switchTo().parentFrame(); // leaving it

        //SoftwareTesting Archives - qavalidation
        BrowsersUtils.switchByTitle(driver,"Archives");
        WebElement headerA=driver.findElement(By.xpath("//h1"));
        System.out.println(BrowsersUtils.getText(headerA));
        Assert.assertEquals(BrowsersUtils.getText(headerA),"Category Archives: SoftwareTesting");









    }






    // task-2














}
