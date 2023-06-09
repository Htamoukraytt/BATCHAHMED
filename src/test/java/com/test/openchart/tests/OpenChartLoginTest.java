package com.test.openchart.tests;

import com.test.openchart.pages.OpenChartLoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class OpenChartLoginTest extends OpenChartTestBase {


    @Test
    public void HappyBathLoginFunctionality() throws InterruptedException {

        OpenChartLoginPage loginPage=new OpenChartLoginPage(driver);
        loginPage.LogInFunctionality("demo","demo");
        Assert.assertEquals(driver.getTitle().trim(),"Dashboard");

    }



    @Test
    public void validateNegativeLogin() throws InterruptedException {
      OpenChartLoginPage loginPage=new OpenChartLoginPage(driver);
      loginPage.LogInFunctionality("dema","hsdj");
      Assert.assertEquals(loginPage.errorMessage(),"No match for Username and/or Password.");

    }




}
