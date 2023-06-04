package SelectClass;

import UtilsForMethods.BrowsersUtils;
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

public class SelectMidLevelPractice {



    /*

    1-Navigate to the website
2-Select one way trip button
3-Choose 4 passangers(1 wife-1 husband-2 kids)
4-Validate the depart from is default "Acapulco"
5-Choose the depart from is Paris
6-Choose the date August 15th
7-Choose the arrive in is San Francisco
8-Choose the date December 15th
10-Click first class option.
11-Validate All the options from Airline
12-Choose the Unified option from airline list
13-Click Continue
14-Validate the message at the top.There is a bug here/
 "After flight finder - No Seats Avaialble"

      //  After flight finder - No Seats Avaialble
 NOTE:Your test should fail and say available is not matching with Available.
 NOTE2:You can use any select method value,visibleText
     */

    @Test
    public void validateOrderMessage(){

        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote--allow--origins=*");
        ChromeDriver driver = new ChromeDriver();  // the driver
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://demo.guru99.com/test/newtours/reservation.php");

       // clicking one way
        WebElement oneWay=driver.findElement(By.xpath("//input[@value='oneway']"));
        oneWay.click();




        // selecting 4 passengers
        WebElement Passengers=driver.findElement(By.xpath("//select[@name='passCount']"));
        Select passengerCount=new Select(Passengers);
        passengerCount.selectByValue("4");



        // validating departure location
        WebElement departureLocation=driver.findElement(By.xpath("//select[@name='fromPort']"));
        Select  departureSelector=new Select(departureLocation);
        String actualDepartureLocation=departureSelector.getFirstSelectedOption().getText();
        String expectedDepartureLocation="Acapulco";
        Assert.assertEquals(actualDepartureLocation.toLowerCase().trim() , expectedDepartureLocation.toLowerCase().trim());

        // depart from paris
        departureSelector.selectByVisibleText("Paris");


        //6-Choose the date August 15th
        //month
        WebElement monthDate=driver.findElement(By.xpath("//select[@name='fromMonth']"));
        Select monthDateSelector=new Select(monthDate);
        monthDateSelector.selectByValue("8");
        //day
        WebElement dayDate=driver.findElement(By.xpath("//select[@name='fromDay']"));
        Select dayDateSelector=new Select(dayDate);
        dayDateSelector.selectByValue("15");




       // 7-Choose the arrive in is San Francisco
       WebElement arrivalLocation=driver.findElement(By.xpath("//select[@name='toPort']"));
       Select arrivalSelector=new Select(arrivalLocation);
       arrivalSelector.selectByIndex(6);

       // 8-Choose return date December 15th
        //month
        WebElement monthDateReturn=driver.findElement(By.xpath("//select[@name='toMonth']"));
        Select monthDateReturnSelector=new Select(monthDateReturn);
        monthDateReturnSelector.selectByValue("12");
        //day
        WebElement dayDateReturn=driver.findElement(By.xpath("//select[@name='toDay']"));
        Select dayDateReturnSelector=new Select(dayDateReturn);
        dayDateReturnSelector.selectByVisibleText("15");




        //10-Click first class option.
        WebElement firstClass=driver.findElement(By.xpath("//input[@value='First']"));
        firstClass.click();

        // 11-Validate All the options from Airline
        WebElement airlineLocation=driver.findElement(By.xpath("//select[@name='airline']"));
        Select airlineSelector=new Select(airlineLocation);
        List<WebElement> actual_Options=airlineSelector.getOptions();
        List<String> expected_Options= Arrays.asList("No Preference","Blue Skies Airlines","Unified Airlines","Pangea Airlines");
        for(int i = 0 ; i<actual_Options.size() ; i++){
          // System.out.println(actual_Options.get(i).getText());
         //  System.out.println(expected_Options.get(i));
        Assert.assertEquals(actual_Options.get(i).getText().toLowerCase().trim(),expected_Options.get(i).toLowerCase().trim());
        }
        // 12-Choose the Unified option from airline list
         airlineSelector.selectByIndex(2);

        // click continue to find flight
        WebElement continueButton=driver.findElement(By.xpath("//input[@name='findFlights']"));
        continueButton.click();

        //validating the message
        WebElement messageValidationLocation=driver.findElement(By.xpath("//font[@size='4']"));
       String actualMessage= messageValidationLocation.getText().trim();
       String expectedMessage="After flight finder - No Seats available"; //available - correct spelling
       Assert.assertEquals(actualMessage,expectedMessage);               //Avaialble

        // this test Must Fail becouse it has a bug of //Avaialble
    }








    // using Util  Methods
    @Test
    public void validateMessageShortCut(){

        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote--allow--origins=*");
        ChromeDriver driver = new ChromeDriver();  // the driver
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://demo.guru99.com/test/newtours/reservation.php");

        // clicking one way
        WebElement oneWay=driver.findElement(By.xpath("//input[@value='oneway']"));
        oneWay.click();




        // selecting 4 passengers
        WebElement Passengers=driver.findElement(By.xpath("//select[@name='passCount']"));
       // Select passengerCount=new Select(Passengers);
       // passengerCount.selectByValue("4");
        BrowsersUtils.selectBy(Passengers,"4","value");



        // validating departure location
        WebElement departureLocation=driver.findElement(By.xpath("//select[@name='fromPort']"));
         Select  departureSelector=new Select(departureLocation);
         String actualDepartureLocation=departureSelector.getFirstSelectedOption().getText();
        String expectedDepartureLocation="Acapulco";
        Assert.assertEquals(actualDepartureLocation.trim(), expectedDepartureLocation.trim());

        // depart from paris
       // departureSelector.selectByVisibleText("Paris");
        BrowsersUtils.selectBy(departureLocation,"Paris","text");

        //6-Choose the date August 15th
        //month
        WebElement monthDate=driver.findElement(By.xpath("//select[@name='fromMonth']"));
       // Select monthDateSelector=new Select(monthDate);
        //monthDateSelector.selectByValue("8");
        BrowsersUtils.selectBy(monthDate,"8","value");

        //day
        WebElement dayDate=driver.findElement(By.xpath("//select[@name='fromDay']"));
        // Select dayDateSelector=new Select(dayDate);
        //dayDateSelector.selectByValue("15");
        BrowsersUtils.selectBy(dayDate,"15","value");




        // 7-Choose the arrive in is San Francisco
        WebElement arrivalLocation=driver.findElement(By.xpath("//select[@name='toPort']"));
        // Select arrivalSelector=new Select(arrivalLocation);
        //arrivalSelector.selectByIndex(6);
        BrowsersUtils.selectBy(arrivalLocation,"6","index");

        // 8-Choose return date December 15th
        //month
        WebElement monthDateReturn=driver.findElement(By.xpath("//select[@name='toMonth']"));
        //Select monthDateReturnSelector=new Select(monthDateReturn);
        //monthDateReturnSelector.selectByValue("12");
        BrowsersUtils.selectBy(monthDateReturn,"12","value");

        //day
        WebElement dayDateReturn=driver.findElement(By.xpath("//select[@name='toDay']"));
       // Select dayDateReturnSelector=new Select(dayDateReturn);
       // dayDateReturnSelector.selectByVisibleText("15");
        BrowsersUtils.selectBy(dayDateReturn,"15","text");



        //10-Click first class option.
        WebElement firstClass=driver.findElement(By.xpath("//input[@value='First']"));
        firstClass.click();

        // 11-Validate All the options from Airline
        WebElement airlineLocation=driver.findElement(By.xpath("//select[@name='airline']"));
        Select airlineSelector=new Select(airlineLocation);
        List<WebElement> actual_Options=airlineSelector.getOptions();
        List<String> expected_Options= Arrays.asList("No Preference","Blue Skies Airlines","Unified Airlines","Pangea Airlines");
        for(int i = 0 ; i<actual_Options.size() ; i++){
            // System.out.println(actual_Options.get(i).getText());
            //  System.out.println(expected_Options.get(i));
            Assert.assertEquals(actual_Options.get(i).getText().toLowerCase().trim(),expected_Options.get(i).toLowerCase().trim());
        }
        // 12-Choose the Unified option from airline list
        airlineSelector.selectByIndex(2);

        // click continue to find flight
        WebElement continueButton=driver.findElement(By.xpath("//input[@name='findFlights']"));
        continueButton.click();

        //validating the message
        WebElement messageValidationLocation=driver.findElement(By.xpath("//font[@size='4']"));
       // String actualMessage= messageValidationLocation.getText().trim();
        String expectedMessage="After flight finder - No Seats available"; //available - correct spelling
        Assert.assertEquals(BrowsersUtils.getText(messageValidationLocation),expectedMessage.trim());               //Avaialble














    }














}
