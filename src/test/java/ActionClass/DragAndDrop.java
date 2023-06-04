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

public class DragAndDrop {

    // Haz abd Hat
    @Test
    public void DragAndDrop(){


        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions=new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
        WebDriver driver=new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://demos.telerik.com/kendo-ui/dragdrop/area");

        // validating message so making sure working                      // parent -- child way
        WebElement  OrangeBox=driver.findElement(By.xpath("//div[@id='droptarget']//div[@class='test2']"));
        String actual_message= BrowsersUtils.getText(OrangeBox);
        String expected_message="... Or here.";
        Assert.assertEquals(actual_message,expected_message);

        // validating the Color of OrangeBox          // it returns the color
       String  actual_BackgroundColor=OrangeBox.getCssValue("background-color");
       String  expected_backgroundColor="rgba(238, 111, 11, 1)";
       Assert.assertEquals(actual_BackgroundColor,expected_backgroundColor);


       // find the draggable we gonna drop( we are dropping in orange box
        WebElement draggable=driver.findElement(By.xpath("//div[@id='draggable']"));
        Actions action=new Actions(driver);
        action.dragAndDrop(draggable,OrangeBox).perform();  /// never forget perform
        action.scrollByAmount(300,300).perform();


         //validating message { if you noticed we reassigned here the Orange box to avoid the satel expectation
        OrangeBox=driver.findElement(By.xpath("//div[@id='droptarget']//div[@class='test2']"));
        String actual_after_drop=BrowsersUtils.getText(OrangeBox);
        String expected_after_drop="You did great!";
        Assert.assertEquals(actual_after_drop,expected_after_drop);


    }









    @Test
    public void DragAndDroppPractice1() throws InterruptedException {


        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://demos.telerik.com/kendo-ui/dragdrop/area");

        // validating message so making sure working                      // parent -- child way
        WebElement OrangeBox = driver.findElement(By.xpath("//div[@id='droptarget']//div[@class='test2']"));
        String actual_message = BrowsersUtils.getText(OrangeBox);
        String expected_message = "... Or here.";
        Assert.assertEquals(actual_message, expected_message);

        // validating the Color of OrangeBox          // it returns the color
        String  actual_BackgroundColor=OrangeBox.getCssValue("background-color");
        String  expected_backgroundColor="rgba(238, 111, 11, 1)";
        Assert.assertEquals(actual_BackgroundColor,expected_backgroundColor);


        // find the draggable we gonna drop( we are dropping in orange box
        WebElement draggable=driver.findElement(By.xpath("//div[@id='draggable']"));
        Actions action=new Actions(driver);
        action.dragAndDrop(draggable,OrangeBox).perform();  /// never forget perform
        action.scrollByAmount(300,300).perform();


        //validating message { if you noticed we reassigned here the Orange box to avoid the satel expectation
        OrangeBox=driver.findElement(By.xpath("//div[@id='droptarget']//div[@class='test2']"));
        String actual_after_drop=BrowsersUtils.getText(OrangeBox);
        String expected_after_drop="You did great!";

        Thread.sleep(2000);


        //Validiting other side
        WebElement BlueBoxLocation=driver.findElement(By.xpath("//div[@id='droptarget']//div[@class='test1']"));
        String actualBlueBoxMessage=BrowsersUtils.getText(BlueBoxLocation);
        String expectedBlueBoxMessage="(Drop here)";
        Assert.assertEquals(actualBlueBoxMessage,expectedBlueBoxMessage);

        // validating blue Box color
        WebElement blueBoxColorLocation=driver.findElement(By.xpath("//div[.='(Drop here)']"));
        String actual_BlueBoxColor=blueBoxColorLocation.getCssValue("background-color");
        String expected_BlueBoxColor="rgba(63, 81, 181, 1)";
        Assert.assertEquals(actual_BlueBoxColor,expected_BlueBoxColor);

        // draggable reassign it  since we have already
        draggable=driver.findElement(By.xpath("//div[@id='draggable']"));
        action.clickAndHold(draggable).moveToElement(blueBoxColorLocation).release().perform();
        // click hold element move to x and release it/dropping it ===> perform is a must

        Thread.sleep(2000);

        // you can validate the text just for prove but it is working great!
        blueBoxColorLocation=driver.findElement(By.xpath("//div[.='You did great!']")); // reassinging to avoid stell exception
        String actualMessageBlueBox=BrowsersUtils.getText(blueBoxColorLocation);
        String expectedMessageBlueBox="You did great!";
        Assert.assertEquals(actualMessageBlueBox,expectedMessageBlueBox);

    }






}
