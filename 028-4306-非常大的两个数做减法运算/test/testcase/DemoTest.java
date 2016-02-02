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
	}

	//用例1:
	@Test
	public void testCase01() {
		String minuend = "85";
		String subtrahend = "79";
		String result = Demo.decrease(minuend, subtrahend);
		System.out.println(result);
		Assert.assertEquals(result, "6");

	}

	// 用例2:
	@Test
	public void testCase02() {
		String minuend = "8.5";
		String subtrahend = "0.91";
		String result = Demo.decrease(minuend, subtrahend);
        System.out.println(result);
		Assert.assertEquals(result, "7.59");

	}

	// 用例3:
	@Test
	public void testCase03() {
		String minuend = "8.5";
		String subtrahend = "7.5";
		String result = Demo.decrease(minuend, subtrahend);
        System.out.println(result);
		Assert.assertEquals(result, "1");

	}

	// 用例4:
	@Test
	public void testCase04() {
		String minuend = "12.34";
		String subtrahend = "17.24";

		String result = Demo.decrease(minuend, subtrahend);
        System.out.println(result);
		Assert.assertEquals(result, "-4.9");

	}

    // 用例5:
    @Test
    public void testCase05() {
        String minuend = "12.34000";
        String subtrahend = "17.2400000";

        String result = Demo.decrease(minuend, subtrahend);
        System.out.println(result);
        Assert.assertEquals(result, "-4.9");

    }


    // 用例6:
    @Test
    public void testCase06() {
        String minuend = "12.0000";
        String subtrahend = "17.0000";

        String result = Demo.decrease(minuend, subtrahend);
        System.out.println(result);
        Assert.assertEquals(result, "-5");

    }

    // 用例7:
    @Test
    public void testCase07() {
        String minuend = "-12.0000";
        String subtrahend = "17.0000";

        String result = Demo.decrease(minuend, subtrahend);
        System.out.println(result);
        Assert.assertEquals(result, "-29");

    }

    // 用例8:
    @Test
    public void testCase08() {
        String minuend = "-12.0000";
        String subtrahend = "-17.0000";

        String result = Demo.decrease(minuend, subtrahend);
        System.out.println(result);
        Assert.assertEquals(result, "5");

    }

    // 用例9:
    @Test
    public void testCase09() {
        String minuend = "12.0000";
        String subtrahend = "-17.0000";

        String result = Demo.decrease(minuend, subtrahend);
        System.out.println(result);
        Assert.assertEquals(result, "29");

    }


    // 用例10:
    @Test
    public void testCase10() {
        String minuend = "012.0000";
        String subtrahend = "-017.0000";

        String result = Demo.decrease(minuend, subtrahend);
        System.out.println(result);
        Assert.assertEquals(result, "29");
    }

    // 用例11:
    @Test
    public void testCase11() {
        String minuend = "00012.0000";
        String subtrahend = "-000017.0000";

        String result = Demo.decrease(minuend, subtrahend);
        System.out.println(result);
        Assert.assertEquals(result, "29");
    }

    // 用例12:
    @Test
    public void testCase12() {
        String minuend = "1";
        String subtrahend = "-9999";

        String result = Demo.decrease(minuend, subtrahend);
        System.out.println(result);
        Assert.assertEquals(result, "10000");
    }
}
