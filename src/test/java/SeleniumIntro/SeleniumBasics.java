package SeleniumIntro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class SeleniumBasics {

    public static void main(String[] args) {

                    // 1 step   // Setting Up our Automation


               WebDriverManager.chromedriver().setup();             // memorize


               ChromeOptions options=new ChromeOptions();

               options.addArguments("--remote--allow--origins=*");


               // then create your driver to start automation

               WebDriver driver = new ChromeDriver(options);  // the key to the website

              driver.get("https://www.amazon.com/");  // go to the website ... ENTER TO THE WEBSITE



        // validation of the title

              System.out.println(" here is the title "+driver.getTitle()); // get me the title

              String actualTitle= driver.getTitle(); // store in it in String actual

              String expectedTitle="Amazon.com. Spend less. Smile more."; // i expect ...


            //

            if(actualTitle.equals(expectedTitle)){
            System.out.println("passed");
            }else{
            System.out.println("filled");
            }




            //


             String actualUrl= driver.getCurrentUrl();
             String expectUrl="https://www.amazon.com/";

                //
         if(actualUrl.equals(expectUrl)){

             System.out.println("Url Passed ");
         }else {
             System.out.println("Url filled ");
         }




                 driver.close();   // CLOSE THE WEB SITE





         /// =======>

















    }






}
