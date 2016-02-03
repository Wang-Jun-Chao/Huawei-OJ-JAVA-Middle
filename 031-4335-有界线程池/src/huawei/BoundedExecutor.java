package huawei;

import com.sun.org.apache.xpath.internal.operations.Bool;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 实现一个有界线程池，确保所有提交的任务都能保证执行。
 */
public class BoundedExecutor extends ThreadPoolExecutor {
    private static final int CORESIZE = 10;
    private static final int MAXSIZE = 15;
    private static final int ALIVETIME = 30;
    private static final int QUEUESIZE = 5;

    public BoundedExecutor() {
        super(CORESIZE, MAXSIZE, ALIVETIME, TimeUnit.SECONDS,
                new ArrayBlockingQueue<Runnable>(QUEUESIZE));
    }

    //提示，需要自定义拒绝策略
    public static class RejectedExecution implements RejectedExecutionHandler {

        private Map<Runnable, Boolean> runnableSet = new HashMap<Runnable, Boolean>();

        /**
         * 实现一个有界线程池，当线程池满时，阻塞等待，等到有空闲线程时，再继续提交。
         * 保证所有提交的任务都能执行但是不会多次重复提交。
         *
         * @param r
         * @param executor
         */
        public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
            if (runnableSet.containsKey(runnableSet)) {
                return;
            }


        }
    }
}
