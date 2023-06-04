package SeleniumIntro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class GetAttributeMethod {

    public static void main(String[] args) {

        // we were using gettext for text
        // Now we will be using  getAttribute





        WebDriverManager.chromedriver().setup();
        ChromeOptions options=new ChromeOptions();
        options.addArguments("--remote--allow--origins=*");
        WebDriver driver= new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); // wait 10 sec to find element make test more fixation


        driver.get("https://katalon-demo-cura.herokuapp.com/");




        //#btn-make-appointment
        WebElement make_app=driver.findElement(By.cssSelector("#btn-make-appointment"));
        make_app.click();


        // How to get ATTRIBUTES VALUE
        WebElement getAttribute=driver.findElement(By.xpath("//input[@value='John Doe']"));
        System.out.println(getAttribute.getAttribute("value")); //
        System.out.println(getAttribute.getAttribute("type"));









    }
}
