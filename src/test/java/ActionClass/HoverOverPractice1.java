package ActionClass;

import UtilsForMethods.BrowsersUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.*;

public class HoverOverPractice1 {






    @Test
    public void HoverOverPractice () throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://demos.telerik.com/kendo-ui/fx/expand");
        Actions action=new Actions(driver);

        // Sources
        List<WebElement>  Images=driver.findElements(By.xpath("//div[@class='product k-listview-item']//img")); //for hoverOver
        List<WebElement>  productName=driver.findElements(By.xpath("//div[@class='product-description']//h3"));   // for names
        List<WebElement>  productPrices=driver.findElements(By.xpath("//div[@class='product-description']//p"));   // for prices


        action.scrollByAmount(400,400).perform();
        TreeMap<String,String>  MapOfNamesAndPrices=new TreeMap<>();
        for(int i=0;i<Images.size();i++){
        Thread.sleep(1000);
        action.moveToElement(Images.get(i)).perform(); // khtaf elihm kamlin doz elihm da9 3lih
        MapOfNamesAndPrices.put(BrowsersUtils.getText(productName.get(i)),BrowsersUtils.getText(productPrices.get(i)));
        }
        // System.out.println(MapOfNamesAndPrices); extra from me to make it look nice and organized
        for(Map.Entry<String,String> pair : MapOfNamesAndPrices.entrySet()){
        System.out.println(pair.getKey()+"-"+ pair.getValue());
        }


    }





}
