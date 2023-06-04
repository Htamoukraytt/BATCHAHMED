package Alert_Interface;

import UtilsForMethods.BrowsersUtils;
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

public class Alert_Practice1 {




       @Test
       public  void Practice1() throws InterruptedException {

           WebDriverManager.chromedriver().setup();
           ChromeOptions chromeOptions=new ChromeOptions();
           chromeOptions.addArguments("--remote-allow-origins=*");

           WebDriver driver=new ChromeDriver(chromeOptions);
           driver.manage().window().maximize();
           driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
           driver.get("https://www.hyrtutorials.com/p/alertsdemo.html");
           Actions action=new Actions(driver);




           driver.findElement(By.cssSelector("#alertBox")).click();
           Alert alert=driver.switchTo().alert();
           alert.accept();
           WebElement message1=driver.findElement(By.cssSelector("#output"));
           System.out.println(BrowsersUtils.getText(message1));
           Thread.sleep(3000);
           driver.findElement(By.cssSelector("#confirmBox")).click();
           alert.dismiss();
           WebElement message2=driver.findElement(By.cssSelector("#output"));
           System.out.println(BrowsersUtils.getText(message2));
           Thread.sleep(3000);
           WebElement PromptButton=driver.findElement(By.xpath("//button[@id='promptBox']"));
           action.click(PromptButton).perform();
           Thread.sleep(1000);
           alert.sendKeys("Hicham was here !");
           alert.accept();
           WebElement message3=driver.findElement(By.cssSelector("#output"));
           String actualText=BrowsersUtils.getText(message3); // propmt bug !!!!!!!!!!!!!!!!!!
           String expectedText="You entered text Hicham was here ! in prompt popup";
           Assert.assertEquals(actualText,expectedText);
           System.out.println(BrowsersUtils.getText(message3)); // You entered text Hicham was here ! in propmt popup here is a bug of misspelling
           Thread.sleep(3000);                              // pay attention to the misspelling


       }








    
}
