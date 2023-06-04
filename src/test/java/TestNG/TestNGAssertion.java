package TestNG;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestNGAssertion {

    // forgot Validation
    // will validate  ( class Assert



    public static int Multiply(int n1 ,int n2){
        return n1*n2;
    }


    @Test
    public void validateMultiplication(){
    int act_res= Multiply(5,5);
    int excpacted=25;
        Assert.assertEquals(act_res,excpacted); // mostlu used this method and its overloaded for other types
       // Assert.assertTrue(act_res == excpacted); // it returns Boolean
    }





    @Test
    public void validateZero(){


    }

    @Test
    public void validateNigativeWithPositive(){


    }









}
