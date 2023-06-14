package com.test.blaze.tests;

import com.test.blaze.pages.*;
import org.testng.annotations.Test;

public class blazePlaceOrderTest extends blazeTestBase {







  @Test
  public void validatingOrdersFunctionality() throws InterruptedException {
      BlazeHomePage homePage=new BlazeHomePage(driver);
      homePage.categoriesOptionsMethod("Laptops");
      //
      BlazeLaptopsPage laptopsPage=new BlazeLaptopsPage(driver);
      laptopsPage.laptopsBrandMethod("MacBook Pro");
      //
      MacBookProPage macBookProPage=new MacBookProPage(driver);
       macBookProPage.addToCartButtonMethod(driver,"Product added"); //added
      //
      homePage.cartButtonMethod();
      CartPage cartPage=new CartPage(driver);
      //cartPage.getInfoFromCart("MacBook Pro","1100"); ** what has been validated no need to duplicate it !!
      cartPage.PlaceOrderButtonMethod();
      //
      PlaceOrderPage placeOrderPage=new PlaceOrderPage(driver);
      placeOrderPage.placeOrderFormMethod("hicham","usa","chicago","153673","12","2023");
      placeOrderPage.purchaseButtonMethod();
      placeOrderPage.thanksMessageAlertMethod(driver,"Thank you for your purchase!");
      placeOrderPage.ValidatingUrlMethod(driver,"https://www.demoblaze.com/index.html");

  }










}
