package ActionClass;

import UtilsForMethods.BrowsersUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class HoverOver {

    // khtaf bzarba DAWZ 3LIH BACH IBAN LIA


    @Test
    public void HoverOver () throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://the-internet.herokuapp.com/hovers");
        Actions action=new Actions(driver);

    // Sources
    List<WebElement> userImage=driver.findElements(By.xpath("//img[@alt='User Avatar']")); //for hoverOver
    List<WebElement> UsersMessage=driver.findElements(By.tagName("h5"));   // for names
    // lists To compare
    List<String>  actual_names=new ArrayList<>();
    List<String>  expected_names= Arrays.asList("name: user1","name: user2","name: user3");

    for(int i=0;i<userImage.size();i++){
     Thread.sleep(2000);
     action.moveToElement(userImage.get(i)).perform(); // khtaf elihm kamlin doz elihm da9 3lih
     actual_names.add(BrowsersUtils.getText(UsersMessage.get(i)));

    }

        Assert.assertEquals(actual_names,expected_names);
        System.out.println(actual_names);
        System.out.println(expected_names);

    }














}
