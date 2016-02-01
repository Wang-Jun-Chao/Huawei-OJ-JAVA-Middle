package testcase;

import huawei.Demo;

import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;


public class DemoTest {


    @Test
    public void testcase01() {


        String result = Demo.multiply("", "999999999");
        Assert.assertEquals(result, null);

        result = Demo.multiply("23", "12");
        Assert.assertEquals(result, "276");

    }


}
