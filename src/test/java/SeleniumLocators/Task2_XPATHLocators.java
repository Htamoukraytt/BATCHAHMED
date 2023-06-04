package SeleniumLocators;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Task2_XPATHLocators {

    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();


        ChromeOptions options=new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");


        WebDriver driver=new ChromeDriver(options);
        driver.manage().window().maximize();

          driver.get("https://the-internet.herokuapp.com/abtest");

        //Relative Xpath
        WebElement abTesting=driver.findElement(By.xpath("//a[contains(text(),'A/B  Testing')]"));
        abTesting.click();


        //Absolute XPAATH
       // WebElement Header=driver.findElement(By.xpath());


        // find paragraph with Absolute Path









        driver.get("https://the-internet.herokuapp.com/");












    }
}
