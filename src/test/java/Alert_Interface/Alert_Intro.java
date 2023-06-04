package Alert_Interface;

import UtilsForMethods.BrowsersUtils;
import com.beust.ah.A;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class Alert_Intro {







    @Test
    public void AlertAcceptAndGetText(){

        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions=new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");

        WebDriver driver=new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        Actions action=new Actions(driver);

        driver.get("https://the-internet.herokuapp.com/javascript_alerts");


        //locationOf JS  //button[contains(@onclick,'jsAlert')] // new way
        WebElement jsAlert=driver.findElement(By.xpath("//button[contains(@onclick,'jsAlert')]"));
        jsAlert.click();


        Alert alert=driver.switchTo().alert();         // not a class so cant create object
        String actual= alert.getText().trim();        // will return text of the alert that we coudlnt ispect
        String expected="I am a JS Alert";
        Assert.assertEquals(actual,expected);  // passed

         alert.accept(); // click ok ( clicking ok the
         WebElement messageAfterAccept=driver.findElement(By.cssSelector("#result"));
         String actualMessageAfter= BrowsersUtils.getText(messageAfterAccept);
         String expectedMessageAfter="You successfully clicked an alert";
         Assert.assertEquals(actual,expected);











    }




    @Test
    public void AlertDismissAndGetText() {

        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        Actions action = new Actions(driver);
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");


        //locationOf JS  //button[contains(@onclick,'jsAlert')] // new way
        WebElement jsAlert = driver.findElement(By.xpath("//button[contains(@onclick,'jsConfirm')]"));
        jsAlert.click();

        Alert alert = driver.switchTo().alert();         // not a class so cant create object
        alert.dismiss(); // dismissing the alert ( cancel )

        WebElement messageAfterAccept = driver.findElement(By.cssSelector("#result"));
        String actualMessageAfter = BrowsersUtils.getText(messageAfterAccept);
        String expectedMessageAfter = "You clicked: Cancel";
        Assert.assertEquals(actualMessageAfter, expectedMessageAfter);

    }


   // some alerts request sendKys some time ( action.sendKys or WebElemnt Will Not WORK )
    @Test
    public void AlertSendKeys() throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        Actions action = new Actions(driver);
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");


        WebElement jsPrompt=driver.findElement(By.xpath("//button[.='Click for JS Prompt']"));
        jsPrompt.click();
        Thread.sleep(1000);
        Thread.sleep(2000);
        Alert alert=driver.switchTo().alert();
        alert.sendKeys("home work is important");
        alert.accept();

        Thread.sleep(2000);

        WebElement message=driver.findElement(By.cssSelector("#result"));
        String act_message=BrowsersUtils.getText(message);
        String expected_message="You entered: home work is important";
        Assert.assertEquals(act_message,expected_message);


    }








}
