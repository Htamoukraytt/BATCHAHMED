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

public class Html_and_JSpRACTICE {

    @Test
    public  void Practice1() throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions=new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");

        WebDriver driver=new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://sweetalert.js.org/");
        Actions action=new Actions(driver);
          Thread.sleep(2000);
          WebElement previewJs1=driver.findElement(By.xpath("//button[contains(@onclick,'alert')]"));
          previewJs1.click();
          Alert alert=driver.switchTo().alert();
          System.out.println(alert.getText()); // text through alert cuz it not a belittlement
          alert.accept();

        Thread.sleep(2000);

          WebElement previewHtml2=driver.findElement(By.xpath("//button[contains(@onclick,'error')]"));
          previewHtml2.click();
        Thread.sleep(2000);
          WebElement htmlAlert=driver.findElement(By.xpath("//div[@class='swal-modal']"));
          System.out.println(BrowsersUtils.getText(htmlAlert));


          driver.findElement(By.xpath("//button[.='OK']")).click();







    }








}
