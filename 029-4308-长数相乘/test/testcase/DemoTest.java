package testcase;

import huawei.Demo;

import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;


public class DemoTest {


    @Test
    public void testFormat() {
        System.out.println("00.00->" + Demo.format("00.00"));
        System.out.println("00.010->" + Demo.format("0.01"));
        System.out.println("010.00->" + Demo.format("10"));
    }

    @Test
    public void testcase01() {


        String result = Demo.multiply("", "999999999");
        Assert.assertEquals(result, null);

        result = Demo.multiply("23", "12");
        Assert.assertEquals(result, "276");

    }


}
