package SeleniumLocators;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class LocatorPractice {
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();

        ChromeOptions options=new ChromeOptions();
        options.addArguments("--remote--allow--origins=*");



        WebDriver driver= new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get("https://www.techlistic.com/p/selenium-practice-form.html");
       // driver.manage().window().maximize();

        //first name
        WebElement firstName = driver.findElement(By.name("firstname"));
        firstName.click();
        firstName.sendKeys("hicham");

        Thread.sleep(2000);

        //lastName
        WebElement lastname = driver.findElement(By.name("lastname"));
        lastname.click();
        lastname.sendKeys("tamoukraytt");

        Thread.sleep(2000);

        //Gender
        WebElement Gender=driver.findElement(By.id("sex-0"));
        Gender.click();


        Thread.sleep(2000);

        //experience
        WebElement exp=driver.findElement(By.id("exp-0"));
        exp.click();


        Thread.sleep(2000);

        //date
        WebElement date=driver.findElement(By.id("datepicker"));
        date.sendKeys("16/05/2023");

        Thread.sleep(2000);


        //Automation
        WebElement prof=driver.findElement(By.id("profession-1"));
        prof.click();


        Thread.sleep(2000);

        //tool
        WebElement tool=driver.findElement(By.id("tool-2"));
        tool.click();

        Thread.sleep(2000);


        // continents
        WebElement africa= driver.findElement(By.id("continents"));
        africa.sendKeys("Africa");

        Thread.sleep(2000);

        //Botton
        WebElement button=driver.findElement(By.id("submit"));
        button.click();

























    }
}
