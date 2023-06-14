package com.test.blaze.tests;

import com.test.blaze.pages.BlazeHomePage;
import com.test.blaze.pages.BlazeLaptopsPage;
import com.test.blaze.pages.MacBookProPage;
import org.testng.annotations.Test;

public class blazeMacBookProTest extends blazeTestBase{

    @Test
    public void validateMackBook() throws InterruptedException {
        BlazeHomePage homePage=new BlazeHomePage(driver);
        homePage.categoriesOptionsMethod("Laptops");
        //
        BlazeLaptopsPage laptopsPage=new BlazeLaptopsPage(driver);
        laptopsPage.laptopsBrandMethod("MacBook Pro");
        //
        MacBookProPage macBookProPage=new MacBookProPage(driver);
        macBookProPage.MackBookInformation("MacBook Pro","$1100 *includes tax","Product description\n" +
                "Apple has introduced three new versions of its MacBook Pro line, including a 13-inch and 15-inch model with the Touch Bar, a thin, multi-touch strip display that sits above the MacBook Pro's keyboard.");
        //
        macBookProPage.addToCartButtonMethod(driver,"Product added");

    }

  









}
