package SeleniumLocators;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class LocatorsIntro {


    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();

        // due the bug
        ChromeOptions options=new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");



        // Creating the DRIVER ...
        WebDriver driver=new ChromeDriver(options);

        //- going to the webSite provided
        driver.navigate().to("file:///Users/htamoukraytt/Desktop/Sublime/Techtorial.html");
        driver.manage().window().maximize(); // always good to do it to reach all elelemnts


         // ID LOCATOR !!
        //- reaching specific elements BY ID LOCATOR ... ?
        // validate the header
        WebElement header=driver.findElement(By.id("techtorial1"));
        String actualHeader=header.getText().trim(); // it gets the text from element
        String expectedHeader = "Techtorial Academy";
        System.out.println(header.getText());
        System.out.println(actualHeader.equals(expectedHeader)? "CORRECT" : "WRONG");
        System.out.println("===============================");

       // quick task --- reach out to the  paragraph Element  and print it
       WebElement Paragraph =driver.findElement(By.id("details2"));
       System.out.println(Paragraph.getText().trim());
       System.out.println("================================");





        // NAME LOCATOR --->  ( reaching the Tag Name and give value to elements ..)

         // testing sing up forms for example ...
       WebElement firstName=driver.findElement(By.name("firstName"));
       firstName.sendKeys("hicham"); //

        WebElement lastName=driver.findElement(By.name("lastName"));
        lastName.sendKeys("tamoukraytt");


        WebElement phone=driver.findElement(By.name("phone"));
        phone.sendKeys("4511250121");



        WebElement userName=driver.findElement(By.id("userName")); // it has id so better than name ..
        userName.sendKeys("hicham@gmail.com");

        WebElement address1=driver.findElement(By.name("address1"));
        address1.sendKeys("1727 forest cove Apt 201  ");


        WebElement city=driver.findElement(By.name("city"));
        city.sendKeys("chicago");


        WebElement state=driver.findElement(By.name("state"));
        state.sendKeys("IL");


         WebElement postalCode=driver.findElement(By.name("postalCode"));
         postalCode.sendKeys("60656");





         // III -   Class LOCATORS ... checking Clicked  BOXES
        WebElement allTools=driver.findElement(By.className("group_checkbox"));
        System.out.println(allTools.getText());

        System.out.println("=================================");


        // Let's check if not clicked  we will click them

            // JavaBox on techtorial Page
             WebElement javaBox=driver.findElement(By.id("cond1"));
            if(javaBox.isDisplayed() && !javaBox.isSelected()){ // box is existed and java box not selected
            javaBox.click();
            if(javaBox.isSelected()){ // condition is it true ? clicked
            System.out.println("JavaBox is Clicked!");
            }else{System.out.println("Java Box Not Selected"); }
            }else{System.out.println(" Java Box Something Went Wrong ! ");}


            // SeleniumBox ...
            WebElement SeleniumBox=driver.findElement(By.id("cond2"));
            if(SeleniumBox.isDisplayed() && !SeleniumBox.isSelected()){ // box is existed and java box not selected
            SeleniumBox.click();
            if(SeleniumBox.isSelected()){ // isSelected means clicked
            System.out.println("SeleniumBox is Selected");
            }else{System.out.println("SeleniumBox Not Selected");}
            }else{System.out.println("Something Went Wrong");}


            //TestNG
            WebElement TestNGBox=driver.findElement(By.id("cond3"));
            if(TestNGBox.isDisplayed() && !TestNGBox.isSelected()){
            TestNGBox.click();
            if(TestNGBox.isSelected()){
            System.out.println("TestNG Clicked!");
            }else {System.out.println(" Not CLICKED  ");}
            }else{System.out.println(" Something Went WRONG with TestNG TEST ");}




            //CucumberBox
            WebElement cucumberBox=driver.findElement(By.id("cond4"));
            if(!cucumberBox.isSelected() && cucumberBox.isDisplayed()){
            cucumberBox.click();
            if(cucumberBox.isSelected()){System.out.println("Cucumber is Clicked !");}
            else{System.out.println("Cucumber Not Clicked");}
            }else {System.out.println("Something Went Wrong With Cucumber");}



        System.out.println("==============================================================");


        //TAG NAME : <XXX> !! (
        WebElement header1=driver.findElement(By.tagName("h1"));
        System.out.println("<h1> is ====>"+header1.getText());


        WebElement header2=driver.findElement(By.tagName("u"));
        System.out.println("<u> has ==>  "+ header2.getText());


        Thread.sleep(2000);




        driver.quit();





























    }














}
