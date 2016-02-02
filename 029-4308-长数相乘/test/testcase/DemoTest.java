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
        System.out.println(result + " = null");
        Assert.assertEquals(result, null);

    }

    @Test
    public void testcase02() {
        String result = Demo.multiply("23", "12");
        System.out.println(result + " = 276");
        Assert.assertEquals(result, "276");
    }


    @Test
    public void testcase03() {
        String result = Demo.multiply("23.00", "12.00");
        System.out.println(result + " = 276");
        Assert.assertEquals(result, "276");
    }

    @Test
    public void testcase04() {
        String result = Demo.multiply("-23.00", "-12.00");
        System.out.println(result + " = 276");
        Assert.assertEquals(result, "276");
    }

    @Test
    public void testcase05() {
        String result = Demo.multiply("-23.00", "12.00");
        System.out.println(result + " = -276");
        Assert.assertEquals(result, "-276");
    }

    @Test
    public void testcase06() {
        String result = Demo.multiply("-23.00", "+12.00");
        System.out.println(result + " = -276");
        Assert.assertEquals(result, "-276");
    }

    @Test
    public void testcase08() {
        String result = Demo.multiply("-023.00", "+012.00");
        System.out.println(result + " = -276");
        Assert.assertEquals(result, "-276");
    }

    @Test
    public void testcase09() {
        String result = Demo.multiply("-1000.000001000", "1000.000001000");
        System.out.println(result + " = -1000000.002000000001");
        Assert.assertEquals(result, "-1000000.002000000001");
    }

    @Test
    public void testcase10() {
        String result = Demo.multiply("-001000.000001000", "001000.000001000");
        System.out.println(result + " = -1000000.002000000001");
        Assert.assertEquals(result, "-1000000.002000000001");
    }

    @Test
    public void testcase11() {
        String result = Demo.multiply("-000.000", "000.000");
        System.out.println(result + " = 0");
        Assert.assertEquals(result, "0");
    }

    @Test
    public void testcase12() {
        String result = Demo.multiply("-001.000", "000.000");
        System.out.println(result + " = 0");
        Assert.assertEquals(result, "0");
    }
}
