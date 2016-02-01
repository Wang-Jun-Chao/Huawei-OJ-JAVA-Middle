package testcase;

import huawei.Demo;
import huawei.Demo.DeQueueInf;
import huawei.Demo.EnQueueInf;
import org.junit.Assert;
import org.junit.Test;

public class DemoTest {

    @Test
    public void testCase01() {
        EnQueueInf endata = new EnQueueInf();
        DeQueueInf dedata = new DeQueueInf();
        endata.enElem = 3;
        dedata.deElem = 0;
        int result = 0;
        int empty = 0;

        Demo.initQueue();
        result += Demo.enQueue(endata);
        result += Demo.deQueue(dedata);
        empty = Demo.isEmptyQueue();
        Assert.assertEquals(result, 0);
        Assert.assertEquals(endata.enElem, dedata.deElem);
        Assert.assertEquals(empty, 1);
    }
}