package TestNG;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;

public class OpenChartTestNGPractice {



    @Test
    public void successfulLogIn() throws InterruptedException {
    //setup
    WebDriverManager.chromedriver().setup();
    ChromeOptions options=new ChromeOptions();
    options.addArguments("--remote--allow--origins=*");
    ChromeDriver driver=new ChromeDriver();  // the driver
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    driver.get("https://demo.opencart.com/admin/");

    WebElement userName=driver.findElement(By.xpath("//input[@id='input-username']"));
    userName.sendKeys("demo");
    WebElement passWord=driver.findElement(By.xpath("//input[@id='input-password']"));
    passWord.sendKeys("demo");
    WebElement logIn=driver.findElement(By.xpath("//button[@type='submit']"));
    logIn.click();
    Thread.sleep(2000); // to be more safe
    WebElement title=driver.findElement(By.tagName("h1"));
    Assert.assertTrue(title.getText().equals("Dashboard"));

    }





    @Test
    public void negative() throws InterruptedException {

        //setup
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote--allow--origins=*");
        ChromeDriver driver = new ChromeDriver();  // the driver
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://demo.opencart.com/admin/");
        WebElement userName = driver.findElement(By.xpath("//input[@id='input-username']"));
        userName.sendKeys("demo00");
        WebElement passWord = driver.findElement(By.xpath("//input[@id='input-password']"));
        passWord.sendKeys("Demo");
        WebElement logIn = driver.findElement(By.xpath("//button[@type='submit']"));
        logIn.click();
        Thread.sleep(2000);

         WebElement alert=driver.findElement(By.xpath("//div[@id='alert']"));
         System.out.println(alert.getText());
         Assert.assertEquals(alert.getText().trim(),"No match for Username and/or Password.");



    }




    @Test
    public void validateProductButton() throws InterruptedException {
        //setup
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote--allow--origins=*");
        ChromeDriver driver = new ChromeDriver();  // the driver
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://demo.opencart.com/admin/");
        WebElement userName = driver.findElement(By.xpath("//input[@id='input-username']"));
        userName.sendKeys("demo");
        WebElement passWord = driver.findElement(By.xpath("//input[@id='input-password']"));
        passWord.sendKeys("demo");
        WebElement logIn = driver.findElement(By.xpath("//button[@type='submit']"));
        logIn.click();
        Thread.sleep(2000);
        WebElement notifcation=driver.findElement(By.cssSelector(".btn-close"));
        Thread.sleep(2000);
        notifcation.click();
        WebElement catalog=driver.findElement(By.cssSelector("#menu-catalog"));
        Thread.sleep(2000);
        catalog.click();
        Thread.sleep(2000);
        WebElement product=driver.findElement(By.xpath("//a[.='Products']"));
        Assert.assertTrue(product.isDisplayed()); // present
        Assert.assertTrue(product.isEnabled()); // clickable


    }






   @Test
   public void boxesValidation() throws InterruptedException {
       WebDriverManager.chromedriver().setup();
       ChromeOptions options = new ChromeOptions();
       options.addArguments("--remote--allow--origins=*");
       ChromeDriver driver = new ChromeDriver();  // the driver
       driver.manage().window().maximize();
       driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
       driver.get("https://demo.opencart.com/admin/");
       WebElement userName = driver.findElement(By.xpath("//input[@id='input-username']"));
       userName.sendKeys("demo");
       WebElement passWord = driver.findElement(By.xpath("//input[@id='input-password']"));
       passWord.sendKeys("demo");
       WebElement logIn = driver.findElement(By.xpath("//button[@type='submit']"));
       logIn.click();
       Thread.sleep(2000);
       WebElement notifcation = driver.findElement(By.cssSelector(".btn-close"));
       Thread.sleep(2000);
       notifcation.click();
       WebElement catalog = driver.findElement(By.cssSelector("#menu-catalog"));
       Thread.sleep(2000);
       catalog.click();
       Thread.sleep(2000);
       WebElement product = driver.findElement(By.xpath("//a[.='Products']"));
       product.click();
       Thread.sleep(2000);

       List<WebElement> boxes = driver.findElements(By.xpath("//input[@type='checkbox']"));

          for(int i= 1 ; i<boxes.size() ; i++) {
              Thread.sleep(1000);
              Assert.assertTrue(boxes.get(i).isDisplayed());
              Assert.assertTrue(boxes.get(i).isEnabled());
              Assert.assertFalse(boxes.get(i).isSelected());
              boxes.get(i).sendKeys(Keys.ARROW_DOWN);
              boxes.get(i).click();
              Assert.assertTrue(boxes.get(i).isSelected());
              //driver.quit();}
          }
   }






       // dyali
       @Test
       public void validateProduct() throws InterruptedException {

           WebDriverManager.chromedriver().setup();
           ChromeOptions options = new ChromeOptions();
           options.addArguments("--remote--allow--origins=*");
           ChromeDriver driver = new ChromeDriver();  // the driver
           driver.manage().window().maximize();
           driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
           driver.get("https://demo.opencart.com/admin/");
           WebElement userName = driver.findElement(By.xpath("//input[@id='input-username']"));
           userName.sendKeys("demo");
           WebElement passWord = driver.findElement(By.xpath("//input[@id='input-password']"));
           passWord.sendKeys("demo");
           WebElement logIn = driver.findElement(By.xpath("//button[@type='submit']"));
           logIn.click();
           Thread.sleep(2000);
           WebElement notifcation = driver.findElement(By.cssSelector(".btn-close"));
           Thread.sleep(2000);
           notifcation.click();
           WebElement catalog = driver.findElement(By.cssSelector("#menu-catalog"));
           Thread.sleep(2000);
           catalog.click();
           Thread.sleep(2000);
           WebElement product = driver.findElement(By.xpath("//a[.='Products']"));
           product.click();
           Thread.sleep(2000);



           List<WebElement> page1_items= driver.findElements(By.cssSelector(".img-thumbnail"));
           List<String> expectedList=new ArrayList<>(); //expectedList
           // adding page 1 of items to expectedList
           for(int i=0 ; i<page1_items.size() ; i++){
           expectedList.add(page1_items.get(i).getAttribute("alt"));
           }
           Thread.sleep(2000);
           // clicking to reach page 2 of items
           WebElement page_2=driver.findElement(By.xpath("//a[.='2']"));
           page_2.click();
           Thread.sleep(2000);
           // adding page 2 of items to expectedList
           List<WebElement> page2_items= driver.findElements(By.cssSelector(".img-thumbnail"));
           for(int i = 0 ; i<page2_items.size() ; i++){
           expectedList.add(page2_items.get(i).getAttribute("alt"));}
           Collections.reverse(expectedList);
           System.out.println("=====> I- expected List :  "+expectedList);
           // clicking Product Name function To get the actual
           WebElement Product_Function=driver.findElement(By.cssSelector(".asc"));
           Product_Function.click();
           Thread.sleep(1000);
           //adding page 1 of items to actual_List
           List<WebElement> actual_page_1= driver.findElements(By.cssSelector(".img-thumbnail"));
           List<String> actual_List=new ArrayList<>(); // actual_list
           for(int i=0 ; i<actual_page_1.size() ; i++){
            actual_List.add(actual_page_1.get(i).getAttribute("alt"));
           }
           Thread.sleep(5000);
            // clicking to reach  page 2
            WebElement page2=driver.findElement(By.xpath("//a[.='>']"));
            page2.click();
            Thread.sleep(2000);
            //adding page 2 to actual_List
            List<WebElement> actl_page2_items= driver.findElements(By.cssSelector(".img-thumbnail"));
            for(int i=0 ; i<actl_page2_items.size() ; i++){
            actual_List.add(actl_page2_items.get(i).getAttribute("alt"));
            }
            System.out.println("=====> II-  actual List : "+actual_List);

          // Comparing the actual_List and expected_List
           int count=0;
           for(int i = 0 ; i<actual_List.size() ; i++){
           if(actual_List.get(i).equals(expectedList.get(i))){ // going through each item in order
            count++;
               }
           }
           // final discussion if function is working probably
           Assert.assertTrue(count == actual_List.size());


       }








     // teacher logic
       @Test
      public void ProductionNameTeacherAssending() throws InterruptedException {

           WebDriverManager.chromedriver().setup();
           ChromeOptions options = new ChromeOptions();
           options.addArguments("--remote--allow--origins=*");
           ChromeDriver driver = new ChromeDriver();  // the driver
           driver.manage().window().maximize();
           driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
           driver.get("https://demo.opencart.com/admin/");
           WebElement userName = driver.findElement(By.xpath("//input[@id='input-username']"));
           userName.sendKeys("demo");
           WebElement passWord = driver.findElement(By.xpath("//input[@id='input-password']"));
           passWord.sendKeys("demo");
           WebElement logIn = driver.findElement(By.xpath("//button[@type='submit']"));
           logIn.click();
           Thread.sleep(2000);
           WebElement notifcation = driver.findElement(By.cssSelector(".btn-close"));
           Thread.sleep(2000);
           notifcation.click();
           WebElement catalog = driver.findElement(By.cssSelector("#menu-catalog"));
           Thread.sleep(2000);
           catalog.click();
           Thread.sleep(2000);
           WebElement product = driver.findElement(By.xpath("//a[.='Products']"));
           product.click();
           Thread.sleep(2000);


            List<WebElement>  allProducts=driver.findElements(By.xpath("//td[@class='text-start']"));

           List<String> actualProductOrder=new ArrayList<>();
           List<String> expectedProductOrder=new ArrayList<>();


           for(int i = 1 ; i< allProducts.size() ; i++){
            actualProductOrder.add(allProducts.get(i).getText().toLowerCase().trim());
            expectedProductOrder.add(allProducts.get(i).getText().toLowerCase().trim());
           }

           Collections.sort(expectedProductOrder); // sorting to make sure we have asserting order
           System.out.println(actualProductOrder);
           System.out.println(expectedProductOrder);
           Assert.assertEquals(actualProductOrder,expectedProductOrder); // final result








       }
     // teacher logic
    @Test
    public void ProductionNameTeacherDissending() throws InterruptedException { // dissanding order

        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote--allow--origins=*");
        ChromeDriver driver = new ChromeDriver();  // the driver
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://demo.opencart.com/admin/");
        WebElement userName = driver.findElement(By.xpath("//input[@id='input-username']"));
        userName.sendKeys("demo");
        WebElement passWord = driver.findElement(By.xpath("//input[@id='input-password']"));
        passWord.sendKeys("demo");
        WebElement logIn = driver.findElement(By.xpath("//button[@type='submit']"));
        logIn.click();
        Thread.sleep(2000);
        WebElement notifcation = driver.findElement(By.cssSelector(".btn-close"));
        Thread.sleep(2000);
        notifcation.click();
        WebElement catalog = driver.findElement(By.cssSelector("#menu-catalog"));
        Thread.sleep(2000);
        catalog.click();
        Thread.sleep(2000);
        WebElement product = driver.findElement(By.xpath("//a[.='Products']"));
        product.click();
        Thread.sleep(2000);
        WebElement productName=driver.findElement(By.xpath("//a[.='Product Name']")); // activate function
        productName.click();
        Thread.sleep(3000);




        List<WebElement>  allProducts=driver.findElements(By.xpath("//td[@class='text-start']"));

        List<String> actualProductOrder=new ArrayList<>();
        List<String> expectedProductOrder=new ArrayList<>();

        // here started from 1 cuz the locator has at 0 non item element // 3amr lkhabyat
        for(int i = 1 ; i< allProducts.size() ; i++){
            actualProductOrder.add(allProducts.get(i).getText().toLowerCase().trim());
            expectedProductOrder.add(allProducts.get(i).getText().toLowerCase().trim());
        }

        Collections.sort(expectedProductOrder); // sorting to make sure we have asserting order
        Collections.reverse(expectedProductOrder); // reversing it
        System.out.println(actualProductOrder);
        System.out.println(expectedProductOrder);
        Assert.assertEquals(actualProductOrder,expectedProductOrder); // final result


       // Finish it later understand it better and better




    }


      // do regression test


}





































