package SeleniumIntro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;
import java.util.List;

public class YoutoubeRealInterviewquition {

    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup(); //SetUp
        ChromeOptions options=new ChromeOptions(); // due bug
        options.addArguments("--remote--allow--origins=*"); // due bug
        WebDriver driver= new ChromeDriver(options); // driver
        driver.manage().window().maximize(); // maximizing
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); // wait 10 sec to find element make test more fixation
        driver.get("https://www.youtube.com/"); // get in to the target WebSite

        
        //searchBox
        //input[@id='search']
        WebElement searchBox=driver.findElement(By.xpath("//input[@id='search']"));
        searchBox.sendKeys("Dizzy Dross");
        searchBox.sendKeys(Keys.ENTER);
        //Search
        //button[@id='search-icon-legacy']
        // WebElement search=driver.findElement(By.xpath("//button[@id='search-icon-legacy']"));
       //  search.click();


        Thread.sleep(2000);
        List<WebElement>   songs=driver.findElements(By.xpath("//a[@id='video-title']"));
        for(WebElement song : songs){
        song.sendKeys(Keys.ARROW_DOWN);
        if(song.getAttribute("title").equals("MOMO MORNING SHOW - DIZZY DROS | 27.09.19")){
        song.click();
        break; // i foound song stop looping
        }
        }















    }



}
