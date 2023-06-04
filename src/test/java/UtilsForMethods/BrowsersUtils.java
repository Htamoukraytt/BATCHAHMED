package UtilsForMethods;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.util.Set;

public class BrowsersUtils {



    // Select Class ==>  getting element text and trim it to avoid repeating it in the code ,
    public static String getText(WebElement element){
        return element.getText().trim();
    }


    // Select Class   Text || value || index
    public static void selectBy(WebElement location, String value ,String methodName){

        Select select= new Select(location);


        switch (methodName){

            case "text":
                select.selectByVisibleText(value); break;

            case "value":
                select.selectByValue(value); break;

            case "index":
                select.selectByIndex(Integer.parseInt(value)); break;

            default:
                System.out.println("Your Method name is not correct");
                Assert.assertTrue(false); break;


        }
    }

    /// ----------------------- JS Methods ----------

    public static String getTitleWithJS(WebDriver driver){
        JavascriptExecutor js=(JavascriptExecutor) driver;
        return js.executeScript("return document.title").toString().trim();
    }


    // JS CLICK
    public static void clickWithJS(WebDriver driver ,WebElement element){
        JavascriptExecutor js=(JavascriptExecutor) driver;
        js.executeScript("arguments[0].click()",element);
    }


    //SCROLL INTO VIEW JS
    public static void scrollWithJS(WebDriver driver, WebElement element){
        JavascriptExecutor js=(JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true)",element);
    }








    // GET WINDOW HANDEL METHOD 1 ===> FOR ONLY TOW TAPS

    public static void switchById2(WebDriver driver){

        String mainPageID=driver.getWindowHandle(); // main Page Id
        Set<String> allPagesId=driver.getWindowHandles();  // all ides
        for(String each : allPagesId){

            if(!each.equals(mainPageID)){ // avoiding main page id
                driver.switchTo().window(each);  // move to it
                break; // stop loop
            }

        }

    }





    //  GIT window method 2 ===> for all windows
    public static void switchByTitle(WebDriver driver , String title ){


        Set<String> allPagesId=driver.getWindowHandles();

        for(String eachId  : allPagesId ){

            driver.switchTo().window(eachId);
            if(driver.getTitle().equals(title)){
                break;
            }

        }

    }




}
