package testcase;

import huawei.BoundedExecutor;
import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;

public class DemoTest {
    private static final int LENGTH = 50;

    @Test
    public void testCase1() {
        data = new Boolean[LENGTH];

        BoundedExecutor executor = new BoundedExecutor();

        for (int i = 0; i < LENGTH; i++) {
            executor.submit(new ExecutorThread(i));
        }

        long beginTime = System.currentTimeMillis();
        while (executor.getCompletedTaskCount() != LENGTH) {
            if (System.currentTimeMillis() - beginTime > 30000) {
                break;
            }
        }

        for (int i = 0; i < LENGTH; i++) {
            Assert.assertTrue(data[i]);
        }
    }

    public Boolean[] data;


    public class ExecutorThread extends Thread {
        private int index;

        public ExecutorThread(int index) {
            this.index = index;
        }

        @Override
        public void run() {
            data[index] = true;
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
            }
        }
    }

}
