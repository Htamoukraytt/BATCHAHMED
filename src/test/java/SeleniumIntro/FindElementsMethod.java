package SeleniumIntro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class FindElementsMethod {


     // Loop Concept
    //FindElements

    public static void main(String[] args) {


        WebDriverManager.chromedriver().setup(); //SetUp
        ChromeOptions options=new ChromeOptions();
        options.addArguments("--remote--allow--origins=*");
        WebDriver driver= new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); // wait 10 sec to find element make test more fixation

        driver.get("file:///Users/htamoukraytt/Desktop/Sublime/Techtorial.html");





    }
}
