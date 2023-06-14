package com.test.blaze.tests;

import com.test.blaze.pages.BlazeHomePage;
import com.test.blaze.pages.BlazeLaptopsPage;
import com.test.blaze.pages.CartPage;
import com.test.blaze.pages.MacBookProPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class blazeCartTest extends  blazeTestBase{






   @Test
   public void validateCartItems() throws InterruptedException {

       BlazeHomePage homePage=new BlazeHomePage(driver);
       homePage.categoriesOptionsMethod("Laptops");
       //
       BlazeLaptopsPage laptopsPage=new BlazeLaptopsPage(driver);
       laptopsPage.laptopsBrandMethod("MacBook Pro");
       //
       MacBookProPage macBookProPage=new MacBookProPage(driver);
       macBookProPage.addToCartButtonMethod(driver,"Product added");
       //
       homePage.cartButtonMethod();
       CartPage cartPage=new CartPage(driver);
       cartPage.getInfoFromCart("MacBook Pro","1100");
       cartPage.PlaceOrderButtonMethod();


   }



}
