package ActionClass;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import java.time.Duration;

public class ActionsMethods {




    // right-Click on the Mouse
    @Test
    public void contextClick(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions=new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");

        WebDriver driver=new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://the-internet.herokuapp.com/context_menu");

         // finding the element
           WebElement  rightClickLocation=driver.findElement(By.xpath("//div[@class='example']//div[@id='hot-spot']"));
          Actions action=new Actions(driver);
          action.contextClick(rightClickLocation).perform(); //right click
                                                 // never forget Perform




    }




    @Test
    public void rightClick(){

        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions=new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");

        WebDriver driver=new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://demo.guru99.com/test/simple_context_menu.html");

        WebElement target=driver.findElement(By.xpath("//span[.='right click me']"));

        Actions  action=new Actions(driver); // created Object and provided the driver to it // you can ise same object all the time not  like select
        action.contextClick(target).perform(); // right click


    }



    // double click
    @Test
    public void DoubleClick(){

        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions=new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");

        WebDriver driver=new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://demo.guru99.com/test/simple_context_menu.html");

        WebElement target=driver.findElement(By.tagName("button"));

        Actions  action=new Actions(driver); // created Object and provided the driver to it
        action.doubleClick(target).perform(); // double click


    }


















}
