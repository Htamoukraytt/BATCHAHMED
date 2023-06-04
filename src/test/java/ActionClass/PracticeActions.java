package ActionClass;

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

public class PracticeActions {

     // dragAndDropMethod

    @Test
    public void DragAndDrop(){

        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://demoqa.com/droppable");
        Actions action=new Actions(driver); // action Object ready with its methods



        // validating the drag
        WebElement dropLocation=driver.findElement(By.xpath("//div[@id='droppableExample-tabpane-simple']//div[@id='droppable']"));
        String actualMessageDrop= BrowsersUtils.getText(dropLocation);
        String expectedMessageDrop="Drop here";
        Assert.assertEquals(actualMessageDrop,expectedMessageDrop);



        // Drag and drop  location and the operation
       WebElement dragLocation=driver.findElement(By.cssSelector("#draggable"));
       dropLocation=driver.findElement(By.xpath("//div[@id='droppableExample-tabpane-simple']//div[@id='droppable']"));
       action.dragAndDrop(dragLocation,dropLocation).perform();


        // validate the Color and Message
        dropLocation=driver.findElement(By.xpath("//div[@id='droppableExample-tabpane-simple']//div[@id='droppable']"));
        String actual_MessageDrop=BrowsersUtils.getText(dropLocation);
        String expected_MessageDrop="Dropped!";
        Assert.assertEquals(actual_MessageDrop,expected_MessageDrop);


        //validating BackgroundColor
        dropLocation=driver.findElement(By.xpath("//div[@id='droppableExample-tabpane-simple']//div[@id='droppable']"));
        String actual_dropColor=dropLocation.getCssValue("background-color");
        String expected_DropColor="rgba(70, 130, 180, 1)";
        Assert.assertEquals(actual_dropColor,expected_DropColor);













    }




    @Test
    public  void PracticeClickAndHold() throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://demoqa.com/droppable");
        Actions action=new Actions(driver); // action Object ready with its methods


        Thread.sleep(2000);
        //clicking Accept button
         driver.findElement(By.xpath("//a[.='Accept']")).click();

        Thread.sleep(2000);
         //drag Location and validation
         WebElement dragLocation=driver.findElement(By.cssSelector("#notAcceptable"));
         Assert.assertEquals(BrowsersUtils.getText(dragLocation),"Not Acceptable");

        Thread.sleep(2000);
       //drop location and validation
        WebElement dropLocation=driver.findElement(By.xpath("//div[@class='accept-drop-container']//p[.='Drop here']"));
        Assert.assertEquals(BrowsersUtils.getText(dropLocation),"Drop here");

        Thread.sleep(2000);
        // drag and hold realese
        dragLocation=driver.findElement(By.cssSelector("#notAcceptable"));
        dropLocation=driver.findElement(By.xpath("//div[@class='accept-drop-container']//p[.='Drop here']"));
        action.clickAndHold(dragLocation).moveToElement(dropLocation).perform();

        Thread.sleep(2000);
        // validate message after  :
        dropLocation=driver.findElement(By.xpath("//div[@class='accept-drop-container']//p[.='Drop here']"));
        Assert.assertEquals(BrowsersUtils.getText(dropLocation),"Drop here");





    }



































}
