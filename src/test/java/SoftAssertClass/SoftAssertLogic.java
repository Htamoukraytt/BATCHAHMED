package SoftAssertClass;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class SoftAssertLogic {





    public int getSum(int n1, int n2){
        return n1+n2;

    }



    // this is hard ASSERT // if anything failed it stops at the point of throwing exception  right the way won't go for the rest
    @Test
    public void HARD_ASSERT(){
        Assert.assertEquals(getSum(1,5),6);
        System.out.println("test1");
        Assert.assertEquals(getSum(6,5),10);
        System.out.println("test2");
        Assert.assertEquals(getSum(10,10),20);
        System.out.println("test1");


    }





    // the Most important to use SoftAssert is ( softAssert.asserAll()
    @Test
    public void SOFT_ASSERT(){

        SoftAssert softAssert=new SoftAssert();  // creating new object from SoftAssert Class

        softAssert.assertEquals(getSum(3,3),6);
        System.out.println("test1 ok ");
        softAssert.assertEquals(getSum(1,1),0);
        System.out.println("test2 ok");
        softAssert.assertEquals(getSum(10,10),5);
        System.out.println("test3 ok");






    }



}
