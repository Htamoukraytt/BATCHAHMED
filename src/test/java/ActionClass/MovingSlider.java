package ActionClass;

import UtilsForMethods.BrowsersUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import java.time.Duration;

public class MovingSlider {

      // slider jar mn hna lhna Voulme for example

    @Test
    public void HoverOver () throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://the-internet.herokuapp.com/horizontal_slider");


        WebElement slider=driver.findElement(By.tagName("input")); // slider that moves
        WebElement range=driver.findElement(By.xpath("//span[@id='range']")); // range/max
                                                                     // final point
        String expectedRange="4.5";  // im expecting to slid till 4.5 follow the code

        while (!BrowsersUtils.getText(range).equals(expectedRange)){
          Thread.sleep(1000);
          slider.sendKeys(Keys.ARROW_RIGHT); // that's how you slide
        }



    }



}
