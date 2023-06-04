package SeleniumIntro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class SeleniumDriverMethods {

    /*
         driver.get()
         driver.mange.windows.maximize()
         driver.getTitle()
         driver.getCurrentTitle()
         driver.navigate.to()
         driver.navigate.forward()
         driver.navigate.back()
         driver.getPageSource()
         driver.close() ----> close the current page
         driver.quite() ---> quite all pages




     */


    public static void main(String[] args) throws InterruptedException {

        // 1 -
        WebDriverManager.chromedriver().setup();

        // due the bug
        ChromeOptions options=new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");



        // Creating the DRIVER ...
        WebDriver driver=new ChromeDriver(options);


        // MANIPULATIONS ...
            // Validate by the Title
        driver.manage().window().maximize(); // IT MAXIMIZE THE SCREEN ( KAAABR SCREEN )
        driver.get("https:www.google.com/");  // enter to
        System.out.println(driver.getTitle()); // get title (Google)

        Thread.sleep(3000); // it goes very fast let's make it slower to catch everything

      // Let's try navigate().to(); navigate().back ; navigate().forward();   ===>
      driver.navigate().to("https://www.youtube.com/");
      System.out.println(driver.getTitle()); //YouTube
      driver.navigate().back(); // it will go back to "google "again
      System.out.println(driver.getTitle());

        Thread.sleep(3000); // it goes very fast let's make it slower to catch everything

      driver.navigate().forward();  // will go foeward  to YouTube
      driver.navigate().refresh(); // refresh the website
      driver.navigate().refresh(); // refresh the website
      driver.navigate().refresh(); // refresh the website
      System.out.println(driver.getTitle());

        Thread.sleep(3000); // it goes very fast let's make it slower to catch everything


      // get.PageSource(); ==> will bring Html for the webPage
      System.out.println( driver.getPageSource());


      Thread.sleep(3000); // it goes very fast let's make it slower to catch everything


      // driver.quite
      driver.quit();


//
//
//
//             System.out.println(driver.getTitle());
//
//             Thread.sleep(3000);
//
//             driver.navigate().refresh(); // it refreshes the page
//
//             Thread.sleep(3000);
//
//             System.out.println( driver.getPageSource()); // it gets html structures
//
//
//              driver.close();  // closes the current page (only one page )
//
//
//               driver.quit();   // closes the opened pages during automation
























    }
















}
