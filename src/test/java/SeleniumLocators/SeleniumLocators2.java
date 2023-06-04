package SeleniumLocators;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class SeleniumLocators2 {

    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();

        // due the bug
        ChromeOptions options=new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        // Creating the DRIVER ... you can create it  from Web-driver or Chromedriver same ..
        ChromeDriver driver=new ChromeDriver(options);
        driver.manage().window().maximize(); // maximizing

        // get in to the WebSite
        driver.get("file:///Users/htamoukraytt/Desktop/Sublime/Techtorial.html");






    // LOCATORS II :


         // 1-  lINKTEXT LOCATOR ( ALWAYS MAKE SURE YOU HAVE -->    <a> )

        WebElement javaLink=driver.findElement(By.linkText("Java"));
        javaLink.click(); // click it and getting to it ( dkhol lih )
        WebElement javaHeader=driver.findElement(By.tagName("h1")); //validating the website we got into (java oracl)
        System.out.println("java");
        System.out.println(javaHeader.getText().trim().equals("Java")? "CORRECT" : "FALSE");

        driver.navigate().back(); // GO BACK TO THE MAIN PAGE AND BE READY FOR NEXT WEBSITE

                                  // TASK






         // 1 :
         WebElement SeleniumLink=driver.findElement(By.linkText("Selenium")); // we have <a> and text
         SeleniumLink.click(); // click and get in to the Selenium WebSite
         WebElement SeleniumHeader=driver.findElement(By.tagName("h1"));
         System.out.println("Selenium V");
         System.out.println(SeleniumHeader.getText().trim().equals("Selenium automates browsers. That's it!") ? "PASSED" : "FAILED");
         driver.navigate().back(); // GO BACK TO THE MAIN PAGE AND BE READY FOR NEXT WEBSITE

         // 2 :
         WebElement CucumberLink=driver.findElement(By.linkText("Cucumber")); //was sapace
         CucumberLink.click(); // get in to the Cucumber
         WebElement cucumberHeader=driver.findElement(By.tagName("h1"));
         System.out.println("Cucumber");
         System.out.println("cucumber ==>"+ (cucumberHeader.getText().trim().equals("Tools & techniques that elevate teams to greatness") ? "PASSED" : "FAILED"));
         driver.navigate().back(); // GO BACK TO THE MAIN PAGE AND BE READY FOR NEXT WEBSITE




          // 3 :
         WebElement TestNG=driver.findElement(By.linkText("TestNG"));
         TestNG.click(); // get it to the WebSite TestNG
         WebElement testNG=driver.findElement(By.tagName("h2"));
         System.out.println(testNG.getText().trim().equals("TestNG")? "true" : " false" );
         driver.navigate().back(); // GO BACK TO THE MAIN PAGE AND BE READY FOR NEXT WEBSITE






        //4 :

       String currentUrl =  driver.getCurrentUrl().trim();
       String expectedUrl = "file:///Users/htamoukraytt/Desktop/Sublime/Techtorial.html";
        System.out.println("current Url =>" + (currentUrl.equals(expectedUrl) ? " passed Url" : "failed Url "));









    }
}
