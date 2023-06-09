package FileUpload;

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

public class FileUpload {


    @Test
    public void practice1(){

        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions=new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");

        WebDriver driver=new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://the-internet.herokuapp.com/upload");
        Actions action=new Actions(driver);


        WebElement chooseFile=driver.findElement(By.cssSelector("#file-upload"));
        chooseFile.sendKeys("/Users/htamoukraytt/Desktop/usa.png"); // this how to upload a file ( pic / pdf ...)


        //uploadButton
        WebElement uploadButton=driver.findElement(By.cssSelector("#file-submit"));
        uploadButton.submit(); // works fine
       // uploadButton.click();  // works fine
        //validate File Uploaded Header and
        WebElement header=driver.findElement(By.tagName("h3"));
        String actual= BrowsersUtils.getText(header);
        String expected="File Uploaded!";
        Assert.assertEquals(actual,expected);

        // validating name of file uploaded
        WebElement fileName=driver.findElement(By.cssSelector("#uploaded-files"));
        String actualFileName=BrowsersUtils.getText(fileName);
        String expectedFileName="usa.png";
        Assert.assertEquals(actualFileName,expectedFileName);











    }



   @Test
    public void Practice2 () throws InterruptedException {

       WebDriverManager.chromedriver().setup();
       ChromeOptions chromeOptions=new ChromeOptions();
       chromeOptions.addArguments("--remote-allow-origins=*");

       WebDriver driver=new ChromeDriver(chromeOptions);
       driver.manage().window().maximize();
       driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
       driver.get("https://demo.guru99.com/test/upload/");
       Actions action=new Actions(driver);



      WebElement chooseFile=driver.findElement(By.cssSelector("#uploadfile_0"));
      chooseFile.sendKeys("/Users/htamoukraytt/Desktop/Maroc-ENG.pdf");

       WebElement accept=driver.findElement(By.cssSelector("#terms"));
       accept.click();
       Thread.sleep(1000);

       WebElement submitButton=driver.findElement(By.xpath("//div[@class='formbuttons']//button"));
       submitButton.click();
       Thread.sleep(1000); // very important i could not get text witout it

       WebElement finalMessage=driver.findElement(By.xpath("//h3//center"));
       String actualMessage=BrowsersUtils.getText(finalMessage);
       String expectMessage="has been successfully uploaded.";
       Assert.assertTrue(actualMessage.contains(expectMessage));
       System.out.println(actualMessage);


       Thread.sleep(2000);
       driver.quit();
   }













}
