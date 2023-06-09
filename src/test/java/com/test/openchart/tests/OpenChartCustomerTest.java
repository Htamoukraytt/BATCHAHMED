package com.test.openchart.tests;

import com.test.openchart.pages.OpenChartCustomerPage;
import com.test.openchart.pages.OpenChartHomePage;
import org.testng.annotations.Test;

public class OpenChartCustomerTest extends OpenChartTestBase {






    @Test
    public void Tc_CustomerFunction() throws InterruptedException {
        OpenChartHomePage homePage=new OpenChartHomePage(driver);
        homePage.homePageFunction(driver);
        //
        OpenChartCustomerPage customerPage=new OpenChartCustomerPage(driver);
        //
        customerPage.customersFunctionMethod();
        //
        customerPage.addCustomerFunctionMethod(driver ,"hicham","tamoukraytt","h@gmail.ocm","7737326307","h1234","h1234");
    }


















}
