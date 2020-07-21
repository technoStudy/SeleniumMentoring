package Halit._09_TestNG_xml;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class _02_Test1 {

    @Test(groups = "Mentoring")
    @Parameters("str1")
    public void test1(String str1){

        Assert.assertEquals(str1, "New York");

    }

    @Test(groups = "Mentoring")
    @Parameters("str2")
    public void test2(String str2){


        Assert.assertEquals(str2, "New Jersey");

    }

    @Test(groups = "Class")
    public void test3(){

        String str3 = "Ohio";

        Assert.assertEquals(str3, "Ohio");

    }

}
