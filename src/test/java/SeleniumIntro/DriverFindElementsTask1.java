package SeleniumIntro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;
import java.util.List;

public class DriverFindElementsTask1 {


    public static void main(String[] args) {

             //print all of the names on the list and count them (list from WebPage Provided )





        WebDriverManager.chromedriver().setup(); //SetUp
        ChromeOptions options=new ChromeOptions(); // due bug
        options.addArguments("--remote--allow--origins=*"); // due bug
        WebDriver driver= new ChromeDriver(options); // driver
        driver.manage().window().maximize(); // maximizing
       // driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); // wait 10 sec to find element make test more fixation
        driver.get("https://the-internet.herokuapp.com/"); // get in to the target WebSite






        System.out.println("===========================");

        List<WebElement> listOfLinks=driver.findElements(By.tagName("li"));
        //By.xpath("//li")
        int count=0;
        for(int i = 0 ; i<listOfLinks.size() ; i++){
        System.out.println(listOfLinks.get(i).getText());
        count++;
        }
        System.out.println(count);


        System.out.println("===========================");
        //print only those equal or and more than 12 and count them
        int count1= 0;
        for(WebElement each : listOfLinks){

        if(each.getText().length() >= 12 ){
        System.out.println(each.getText());
        count1++;}
        }
        System.out.println(count1); // 31


        System.out.println("===========================");
        // find any text has ("h") and count it
         int  countH=0;
        for(WebElement each : listOfLinks){

            if(each.getText().contains("h") ){
                System.out.println(each.getText());
                countH++;
            }
        }
        System.out.println(countH);






    }
}
