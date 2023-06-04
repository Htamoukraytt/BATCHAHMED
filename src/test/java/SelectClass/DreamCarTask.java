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
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DreamCarTask {

     /*
NOTE: Please use browser utils for the select classes if it is needed or getText.
1-Navigate to the website
2-Choose the "New" from the New/used option
3-Choose "Lexus" for Make part
4-Choose "RX-350"
5-Validate the Price is selected "No max price"-->getFirstSelectedOption
6-Choose the distance 40 mil
7-Put your Zip code-->Before that Clear it.60056 element.clear()
8-Click Search Button
9-Validate the header "New Lexus RX 350 for sale"
10-Click Sort by and choose the Lowest Price
11-Validate the all titles has Lexus RX 350
     */





    @Test
    public void HeaderOfCar() throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote--allow--origins=*");
        ChromeDriver driver = new ChromeDriver();  // the driver
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.cars.com/");

        // new Option
        WebElement newButton = driver.findElement(By.xpath("//select[@id='make-model-search-stocktype']"));
        BrowsersUtils.selectBy(newButton, "New", "text");

        // make
        WebElement make = driver.findElement(By.xpath("//select[@id='makes']"));
        BrowsersUtils.selectBy(make, "lexus", "value");


        // model
        WebElement model = driver.findElement(By.xpath("//select[@id='models']"));
        BrowsersUtils.selectBy(model, "lexus-rx_350", "value");


        //validate selected Price
        WebElement price = driver.findElement(By.xpath("//select[@id='make-model-max-price']"));
        Select priceSelector = new Select(price);
        String actual_Price = priceSelector.getFirstSelectedOption().getText().trim();
        String expected_Price = "No max price";
        Assert.assertEquals(actual_Price, expected_Price);


        // DISTANCE BOX
        WebElement distance = driver.findElement(By.xpath("//select[@id='make-model-maximum-distance']"));
        BrowsersUtils.selectBy(distance, "40", "value");


        //Zip Code Box
        WebElement zipCode = driver.findElement(By.xpath("//input[@id='make-model-zip']"));
        zipCode.clear();
        zipCode.sendKeys("60056");


        //search Button
        WebElement searchButton = driver.findElement(By.xpath("//button[@data-searchtype='make']"));
        searchButton.click();


        // validating header
        WebElement header = driver.findElement(By.xpath("//h1[@data-qa='page_h1']"));
        String actualHeader = header.getText().trim();
        String expectedHeader = "New Lexus RX 350 for sale";
        Assert.assertEquals(actualHeader, expectedHeader);

        Thread.sleep(2000);

        //
        WebElement sortBy = driver.findElement(By.xpath("//select[@name='sort']"));
        BrowsersUtils.selectBy(sortBy, "list_price", "value");
        Thread.sleep(2000);


        //11-Validate the all titles has Lexus RX 350
        List<WebElement> headersList = driver.findElements(By.xpath("//a[@data-linkname='vehicle-listing']"));
        for (int i = 0; i < headersList.size(); i++) {
         System.out.println(BrowsersUtils.getText(headersList.get(i)));
         Assert.assertTrue(BrowsersUtils.getText(headersList.get(i)).contains("Lexus RX 350"));
        }

        System.out.println("<=======LowestPrice========>");

        // make sure prices are going  up
        List<WebElement> Prices = driver.findElements(By.xpath("//span[@class='primary-price']"));
        List<Integer> actualPrices=new ArrayList<>();
        List<Integer> expectedPrices=new ArrayList<>();
        for (int i = 0; i < Prices.size() ; i++) {
         actualPrices.add(Integer.parseInt(BrowsersUtils.getText(Prices.get(i)).replace("$", "").replace(",", "")));
         expectedPrices.add(Integer.parseInt(BrowsersUtils.getText(Prices.get(i)).replace("$", "").replace(",", "")));
        }
        Collections.sort(expectedPrices);
        System.out.println(expectedPrices);
        Assert.assertEquals(actualPrices,expectedPrices);






        // select Higher Price
        WebElement higherPriceButton = driver.findElement(By.xpath("//select[@name='sort']"));
        BrowsersUtils.selectBy(higherPriceButton, "Highest price", "text");

        List<WebElement> pricesHigher = driver.findElements(By.cssSelector(".primary-price"));

        List<Integer> actual_prices = new ArrayList<>();
        List<Integer> expected_prices = new ArrayList<>();


        for (int i = 0; i < pricesHigher.size(); i++) {
         actual_prices.add(Integer.parseInt(BrowsersUtils.getText(pricesHigher.get(i)).replace("$", "").replace(",", "")));
         expected_prices.add(Integer.parseInt(BrowsersUtils.getText(pricesHigher.get(i)).replace("$", "").replace(",", "")));
        }

        Collections.sort(expected_prices);
        Collections.reverse(expected_prices);
        Assert.assertEquals(actual_prices,expected_prices);



    }


    }
