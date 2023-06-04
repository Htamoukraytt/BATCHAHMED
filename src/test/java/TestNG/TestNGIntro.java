package TestNG;

import org.testng.annotations.Test;

public class TestNGIntro {

    @Test(priority = 3)   // @Test // this keyword will let u create as much as u want just like main method to run
    public static void test(){ // main method 1 // case 1
      System.out.println(" test 1");
    }



    @Test(priority = 1) // by using priority keyword  we gave [first class] to this case so this one will run first in case we run  all of them
    public static void test2(){ // case 2
    System.out.println(" test 2");
    }


    @Test(priority = 2 , invocationCount = 5) // priority i put in order 2 // (invocationCount = 5 )means will run 5 times( looping in other hand ;)
    public static void test3(){ // case3
    System.out.println(" test 3 ");
    }
















}
