package SeleniumLocators;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.bouncycastle.jcajce.provider.drbg.DRBG;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class XphatRealHEALTHProject {

    public static void main(String[] args) throws InterruptedException {

     /*

     //THESE PARTS SHOULD BE DONE BY XPATH:
1-Navigate to the https://katalon-demo-cura.herokuapp.com/ -->DONE
2-Click Make an Appointment
3-Login the username and password provided and Login successfully
4-Choose the facility either HongKong or Seoul -->send keys
5-Click apply for hospital admission box if it is displayed and validate it is selected
6-Healthcare program 'Medicaid'
7-Visit date should be provided -->send keys
8-Put your comment for this box -->send keys
9-Book your appointment
THESE PARTS SHOULD BE DONE BY CONTAINS or . XPATH METHOD
10-Validate the header is "Appointment confirmation" (if statement)
11-Print out the headers and values(only values) on your console.
12)Click go to homepage and print out url
13)Driver.quit or close.
      */


        WebDriverManager.chromedriver().setup();


        ChromeOptions options=new ChromeOptions();
        options.addArguments("--remote--allow--origins=*");


        WebDriver driver=new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get("https://katalon-demo-cura.herokuapp.com/");




        //Make an Appointment
        //a[@id='btn-make-appointment'] ==>  xpath();
       // WebElement  appointment=driver.findElement(By.xpath("//a[@id='btn-make-appointment']"));
        //appointment.click();
        //////////////////////

        //Css  with Id Locator
        WebElement  appointment=driver.findElement(By.cssSelector("#btn-book-appointment"));
        appointment.click();

        Thread.sleep(2000);

        //input[@ id='txt-username']
        //UserName
        WebElement  userName=driver.findElement(By.xpath("//input[@ id='txt-username']"));
        userName.sendKeys("John Doe");

                   Thread.sleep(2000);

        //input[@ id='txt-password']
        //PassWord
        WebElement  passWord=driver.findElement(By.xpath("//input[@ id='txt-password']"));
        passWord.sendKeys("ThisIsNotAPassword");

                      Thread.sleep(2000);

        //button[@ id='btn-login']
        //logIn button
        WebElement  button=driver.findElement(By.xpath("//button[@ id='btn-login']"));
        button.click();

        //select[@ id='combo_facility']
        //Facility
        WebElement  facility=driver.findElement(By.xpath("//select[@ id='combo_facility']"));
        facility.sendKeys("Tokyo CURA Healthcare Center");

                       Thread.sleep(2000);


        //input[@ id='chk_hospotal_readmission']
        //apply
        WebElement  apply=driver.findElement(By.xpath("//input[@ id='chk_hospotal_readmission']"));
        if(apply.isDisplayed() && !apply.isSelected()){                               //==!!!! better use name tobe safe they made a little mistake here
            apply.click();
        }


                         Thread.sleep(2000);

        //input[@ id='radio_program_medicaid']
        //medicaid
        WebElement  medicaidButton=driver.findElement(By.xpath("//input[@ id='radio_program_medicaid']"));
        medicaidButton.click();

                          Thread.sleep(2000);

        //input[@ name='visit_date']
        //date
        WebElement date=driver.findElement(By.xpath("//input[@ name='visit_date']"));
        date.sendKeys("17/05/2023");

                              Thread.sleep(2000);

        //textarea[@id='txt_comment']
        //comment
        WebElement comment=driver.findElement(By.xpath("//textarea[@id='txt_comment']"));
        comment.sendKeys("Emergency");

                               Thread.sleep(2000);
        //button[@id='btn-book-appointment']
        //booking
         WebElement book=driver.findElement(By.xpath("//button[@id='btn-book-appointment']"));
         book.click();

                                    Thread.sleep(2000);


       // validation
       //h2[.='Appointment Confirmation']
       WebElement header=driver.findElement(By.xpath("//h2[.='Appointment Confirmation']"));
       if(header.getText().equals("Appointment Confirmation")){
       System.out.println("===> h2"+ header.getText()); } else{
       System.out.println("something Wrong");
       }

                                 //  Thread.sleep(2000);
       //printValues
        
       //p[.='Tokyo CURA Healthcare Center']
       WebElement v1=driver.findElement(By.xpath("//p[.='Tokyo CURA Healthcare Center']"));
       System.out.println(v1.getText());


                                 //    Thread.sleep(2000);
        //p[.='Yes']
        WebElement v2=driver.findElement(By.xpath("//p[.='Yes']"));
        System.out.println(v2.getText());
                                           Thread.sleep(2000);
       //p[.='01/05/2023']
       WebElement v3=driver.findElement(By.xpath("//p[.='17/05/2023']"));
       System.out.println(v3.getText());

                                         //     Thread.sleep(2000);

       //p[.='Emergency']
       WebElement v4=driver.findElement(By.xpath("//p[.='Emergency']"));
       System.out.println(v4.getText());
                                                      Thread.sleep(2000);
       //a[.='Go to Homepage']                        Thread.sleep(2000);
       WebElement buttonGoHome=driver.findElement(By.xpath("//a[.='Go to Homepage']"));
       buttonGoHome.click();

                                                  Thread.sleep(2000);

       //url
       System.out.println(driver.getCurrentUrl());
      // driver.quit();

       





       















        








































    }
}
