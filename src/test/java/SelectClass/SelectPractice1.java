package SelectClass;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class SelectPractice1 {




    @Test
    public void Practice() throws InterruptedException {


     WebDriverManager.chromedriver().setup();
     ChromeOptions options = new ChromeOptions();
     options.addArguments("--remote--allow--origins=*");
     ChromeDriver driver = new ChromeDriver();  // the driver
     driver.manage().window().maximize();
     driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
     driver.get("file:///Users/htamoukraytt/Desktop/Sublime/Techtorial.html");



      //validate that united states selected by default
       WebElement countriesBox=driver.findElement(By.xpath("//select[@name='country']")); // location

       Select myChoice=new Select(countriesBox); // select object so we can use it's methods

       String actual= myChoice.getFirstSelectedOption().getText(); // actual by using select method " getFirstSeelcted()" .getText
       String expected="UNITED STATES ";
       System.out.println(actual);
       Assert.assertEquals(actual.trim(),expected.trim());


       // print all countries and count them and print result

        List<WebElement> allCountries=myChoice.getOptions(); // we are working in the same box soo we can use the same object
                                                             // using method will bring all of them
        int count=0;
        for(int i = 0 ; i<allCountries.size() ; i++){
            System.out.println(myChoice.getOptions().get(i).getText().trim());
            count++;
        }
        System.out.println("we have "+count+ " countries");




        // choose your country ( by visibleText)
        // and choose favorite country( by value)
        //  and you wanna visit (by index )

        //my country by text
        myChoice.selectByVisibleText("MOROCCO ");
        Thread.sleep(2000);
        //favorite by value
        myChoice.selectByValue("196");
        Thread.sleep(2000);
        //my next country by
        myChoice.selectByIndex(113);

    }





}
