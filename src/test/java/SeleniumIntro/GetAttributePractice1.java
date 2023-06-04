package SeleniumIntro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;
import java.util.List;

public class GetAttributePractice1 {
    public static void main(String[] args) {


        WebDriverManager.chromedriver().setup(); //SetUp
        ChromeOptions options=new ChromeOptions();
        options.addArguments("--remote--allow--origins=*");
        WebDriver driver= new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); // wait 10 sec to find element make test more fixation (saves time)

        driver.get("https://www.w3.org/TR/2019/NOTE-wai-aria-practices-1.1-20190814/examples/checkbox/checkbox-1/checkbox-1.html");







        //button[.='▾ collapse']
        WebElement collapse=driver.findElement(By.xpath("//button[.='▾ collapse']"));
        collapse.click();

        List<WebElement> list=driver.findElements(By.xpath("//div[@role='checkbox']"));

        for(WebElement each : list){
        if(each.getAttribute("aria-checked").equals("false") ){
        each.click();
         }
        }




























    }
}
