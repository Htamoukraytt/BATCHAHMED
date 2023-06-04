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
import java.util.Arrays;
import java.util.List;

public class SelectClass {



    @Test
    public void selectClass() throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote--allow--origins=*");
        ChromeDriver driver = new ChromeDriver();  // the driver
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://the-internet.herokuapp.com/");
        WebElement drpBox=driver.findElement(By.xpath("//a[.='Dropdown']"));
        drpBox.click();
        WebElement optionBox=driver.findElement(By.xpath("//select[@id='dropdown']"));

        // need an object from Select Class so i can use it's methods
        Select myChoice=new Select(optionBox);

        // validating selected option by default (must be first thing to do or refresh page because no option should be selected by us
        String actualDefaultOption=myChoice.getFirstSelectedOption().getText();
        String expectedDefaultOption="Please select an option";
        Assert.assertEquals(actualDefaultOption,expectedDefaultOption);

        // chosing a choice by me (sending Keys)
        myChoice.selectByVisibleText("Option 2"); // must usage it takes text .. i chose by text
        Thread.sleep(2000);
        myChoice.selectByValue("1"); // chose by value 1
        Thread.sleep(2000);
        myChoice.selectByIndex(2);  // chose by index
        Thread.sleep(2000);

        // validation of Option of that  the drop_Down has (getOptions Method )
        List<WebElement> actualOptions=myChoice.getOptions(); //3 stored here but we need the text
        List<String>   expectedOptions= Arrays.asList("Please select an option","Option 1","Option 2"); // we gave it as String in loop only get(i)
        for(int i = 0 ; i<actualOptions.size() ; i++){
        Assert.assertEquals(actualOptions.get(i).getText().toLowerCase().trim(),expectedOptions.get(i).toLowerCase().trim());
        }

















    }
}
