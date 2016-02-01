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

    @Test
    public void testCase02() {
        Demo.initQueue();
        for (int i = 0; i < 12; i++) {
            EnQueueInf endata = new EnQueueInf();
            endata.enElem = i;
            System.out.println(Demo.enQueue(endata));
            Demo.printQueue();
        }

        for (int i = 0; i < 12; i++) {
            DeQueueInf dedata = new DeQueueInf();
            int rst = Demo.deQueue(dedata);
            System.out.println(rst + " " + dedata.deElem);
            Demo.printQueue();
        }
    }
}