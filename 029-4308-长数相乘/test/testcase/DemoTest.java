package testcase;

import huawei.Demo;

import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;


public class DemoTest {

    @Test
    public void testNumber() {

        System.out.println("123 is number: " + Demo.isNumber("123"));
        System.out.println("000 is number: " + Demo.isNumber("000"));
        System.out.println("00.00 is number: " + Demo.isNumber("00.00"));
        System.out.println(".00 is number: " + Demo.isNumber(".00"));
        System.out.println("00. is number: " + Demo.isNumber("00."));
        System.out.println("+.00 is number: " + Demo.isNumber("+.00"));
        System.out.println("-.00 is number: " + Demo.isNumber("-.00"));
        System.out.println("+123.45 is number: " + Demo.isNumber("+123.45"));


        System.out.println("+123.45 is number: " + Demo.isNumber(" +123.45"));
        System.out.println("+123.45 is number: " + Demo.isNumber(" +123.45 "));
        System.out.println("+123.45 is number: " + Demo.isNumber("+123.45 "));

        System.out.println("+123.45. is number: " + Demo.isNumber("+123.45. "));
    }

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

    @Test
    public void testcase13() {
        String result = Demo.multiply("080", "0.125");
        System.out.println(result + " = 10");
        Assert.assertEquals(result, "10");
    }

    @Test
    public void testcase14() {
        String result = Demo.multiply("080", "0.125");
        System.out.println(result + " = 10");
        Assert.assertEquals(result, "10");
    }

    @Test
    public void testcase15() {
        String result = Demo.multiply("-.1", "10");
        System.out.println(result + " = -1");
        Assert.assertEquals(result, "-1");
    }

    @Test
    public void testcase16() {
        String result = Demo.multiply("-0.", "10.");
        System.out.println(result + " = 0");
        Assert.assertEquals(result, "0");
    }

    @Test
    public void testcase17() {
        String result = Demo.multiply("-0.001", "10.");
        System.out.println(result + " = -0.01");
        Assert.assertEquals(result, "-0.01");
    }

    @Test
    public void testcase18() {
        String result = Demo.multiply("-.00", "10.");
        System.out.println(result + " = 0");
        Assert.assertEquals(result, "0");
    }

    @Test
    public void testcase19() {
        String result = Demo.multiply("+.00", "10.");
        System.out.println(result + " = 0");
        Assert.assertEquals(result, "0");
    }


    @Test
    public void testcase20() {
        String result = Demo.multiply("9999.999", "99999.99");
        System.out.println(result + " = 999999800.00001");
        Assert.assertEquals(result, "999999800.00001");
    }


    @Test
    public void testcase21() {
        String result = Demo.multiply("10000000", "9999999999");
        System.out.println(result + " = 99999999990000000");
        Assert.assertEquals(result, "99999999990000000");
    }

    @Test
    public void testcase22() {
        String result = Demo.multiply("20000000", "50000000");
        System.out.println(result + " = 1000000000000000");
        Assert.assertEquals(result, "1000000000000000");
    }
}
