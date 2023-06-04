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

import java.time.Duration;

public class JavaScriptMethods {


   //   ||||| in case selenium not working we use javaScriptMethod   |||














    // click by JavaScript Methods .
    @Test
    public void clickJs() throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://codefish.io/");
        Actions action=new Actions(driver);


        // click By selenium
        WebElement AbutUsButton=driver.findElement(By.xpath("//button[.='About us']"));
        action.click(AbutUsButton).perform();
        Thread.sleep(1000);
        driver.navigate().back();
        Thread.sleep(1000);
        AbutUsButton.click();
        Thread.sleep(1000);
        driver.navigate().back();
        Thread.sleep(1000);




         // this is how you click in Java
        // click by JavaScript Methods
        JavascriptExecutor js=(JavascriptExecutor)driver;
        js.executeScript("arguments[0].click()",AbutUsButton);










    }











}
