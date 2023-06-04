package SeleniumLocators;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class XPATHLocator_Practice4 {

    public static void main(String[] args) throws InterruptedException {


        WebDriverManager.chromedriver().setup();


        ChromeOptions options=new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");


        WebDriver driver=new ChromeDriver(options);
        driver.manage().window().maximize();

        driver.get("http://tutorialsninja.com/demo/index.php?route=account/register");



        //firstname
        WebElement f_Name=driver.findElement(By.xpath("//input[@id='input-firstname']"));
        f_Name.click();
        f_Name.sendKeys("hicham");

         Thread.sleep(2000);

        //input[@id='input-lastname']
        //lastName
        WebElement lastName=driver.findElement(By.xpath("//input[@id='input-lastname']"));
        lastName.click();
        lastName.sendKeys("tamk");

        Thread.sleep(2000);

        ////input[@id='input-email']
        // email
        WebElement email=driver.findElement(By.xpath("//input[@id='input-email']"));
        email.click();
        email.sendKeys("sma3in154455@gmail.com");

        Thread.sleep(2000);

        //input[@id='input-telephone']
        //phone
        WebElement phone=driver.findElement(By.xpath("//input[@id='input-telephone']"));
        phone.click();
        phone.sendKeys("773524541");

        Thread.sleep(2000);

        //input[@id='input-password']
        //PassWord
        WebElement pass1=driver.findElement(By.xpath("//input[@id='input-password']"));
        pass1.click();
        pass1.sendKeys("hicham123");

        Thread.sleep(2000);

        //input[@id='input-confirm']
        //ConfirmPassWord
        WebElement pass2=driver.findElement(By.xpath("//input[@id='input-confirm']"));
        pass2.click();
        pass2.sendKeys("hicham123");




        Thread.sleep(2000);

        //Subscribe
        ////input[@name='newsletter']
        WebElement Sub=driver.findElement(By.xpath("//input[@name='newsletter']"));
        Sub.click();



        Thread.sleep(2000);


        //input[@name='agree']
        // agreePrivacy
        WebElement agreePrivacy=driver.findElement(By.xpath("//input[@name='agree']"));
        agreePrivacy.click();



        Thread.sleep(2000);


        //input[@value='Continue']
        //Continue
        WebElement continue1=driver.findElement(By.xpath("//input[@value='Continue']"));
        continue1.click();





        // validate the WebSite
        System.out.println(  driver.getCurrentUrl().equals("https://tutorialsninja.com/demo/index.php?route=account/success") ? "Url Passed " : " failed");


        // validate the head
        WebElement header= driver.findElement(By.xpath("//h1[.='Your Account Has Been Created!']"));
        String act_Header=header.getText();
        String exp_Header="Your Account Has Been Created!";
        System.out.println("===>"+ (act_Header.equals(exp_Header)? " header passed " : "header failed"));




        //ContinueToWebSiteinside
        //a[.='Continue']
        WebElement continue2=driver.findElement(By.xpath(" //a[.='Continue']"));
        continue2.click();









        driver.quit();

    }
}
