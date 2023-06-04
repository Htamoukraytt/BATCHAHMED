package SeleniumIntro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class RealLifeExamplePractice {

    public static void main(String[] args) {

        //  Test Case - Open Godaddy.com and validate it's Page title and the url.
//    Steps to Automate:
//            1. Launch browser of your choice say., Firefox, chrome etc.
//            2. Open this URL - https://www.godaddy.com/
//            3. Maximize or set size of browser window.
//4. Get Title of page and validate it.(if conditions) expected title from website
//4. Get URL of current page and validate it.          expected url from website
//            5. Close browser.(driver.close)

          WebDriverManager.chromedriver().setup();             // memorize THE SETUP
          ChromeOptions options=new ChromeOptions();
          options.addArguments("--remote--allow--origins=*");


        // then create your driver to start automation
        WebDriver driver = new ChromeDriver(options);  // the key to the website
        driver.get("https://www.godaddy.com/"); // reaching the WebSite


        String actualTitle= driver.getTitle(); // STORE THE TITLE
        String expectedTitle="Domain Names, Websites, Hosting & Online Marketing Tools - GoDaddy";


        if(actualTitle.equals(expectedTitle)){  // COMPARING TITLES
            System.out.println("passed");
        }else{
            System.out.println("FAILED");
        } // Side Note you can do this in ternary Show OFF


        String actualUrl=driver.getCurrentUrl();
        String expectedUrl="https://www.godaddy.com/";


        if(actualUrl.equals(expectedUrl)){ // COMPARING URLS
            System.out.println("passed");
        }else{
            System.out.println("FAILED");
        }

        driver.close();



















    }
}
