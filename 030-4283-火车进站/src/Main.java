import java.util.*;

/**
 * Author: 王俊超
 * Date: 2016-02-03 08:17
 * CSDN: http://blog.csdn.net/derrantcm
 * Github: https://github.com/Wang-Jun-Chao
 * Declaration: All Rights Reserved !!!
 */
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
//        Scanner scanner = new Scanner(Main.class.getClassLoader().getResourceAsStream("data2.txt"));
        while (scanner.hasNext()) {
            int n = scanner.nextInt();

            // 等待进栈的火车栈
            Deque<Integer> waitTrain = new LinkedList<Integer>();
            // 火车站中的火车栈
            Deque<Integer> inTrain = new LinkedList<Integer>();
            // 当前解，已经出站的火车，当所有火车都出站，就是一个解
            List<Integer> currRst = new LinkedList<Integer>();
            // 所有解
            List<List<Integer>> wholeRst = new LinkedList<List<Integer>>();

            for (int i = 0; i < n; i++) {
                waitTrain.add(scanner.nextInt());
            }

            trainDispatch(waitTrain, inTrain, currRst, wholeRst);

            System.out.print(resultToString(wholeRst));
        }

    }

    /**
     * 将结果转成字符串
     *
     * @param wholeRst
     * @return
     */
    private static String resultToString(List<List<Integer>> wholeRst) {

        StringBuilder builder = new StringBuilder(wholeRst.size() * 16);
        for (List<Integer> list : wholeRst) {
            for (Integer i : list) {
                builder.append(i).append(' ');
            }
            builder.setCharAt(builder.length() - 1, '\n');
        }
        return builder.toString();
    }

    /**
     * 火车调度
     *
     * @param waitTrain 等待进栈的火车栈
     * @param inTrain   火车站中的火车栈
     * @param currRst   当前解
     * @param wholeRst  所有解
     */
    private static void trainDispatch(Deque<Integer> waitTrain,
                                      Deque<Integer> inTrain,
                                      List<Integer> currRst,
                                      List<List<Integer>> wholeRst) {
        // 是否有等待入站的火车
        boolean hasWait = true;
        // 是否有等待出站的火车
        boolean hasIn = true;

        if (waitTrain.isEmpty()) {
            hasWait = false;
        }

        if (inTrain.isEmpty()) {
            hasIn = false;
        }


        // 情况1：没有等待的火车，火车站中也没有火车
        // 这就是其中的一种解
        if (!hasWait && !hasIn) {

            List<Integer> rst = new LinkedList<Integer>();
            for (Integer i : currRst) {
                rst.add(i);
            }

            wholeRst.add(rst);

            return;
        }
        // 情况2：火车站中有火车要出站
        if (hasIn) {

            // 出站的列车号
            int outTrainNumber = inTrain.pop();
            // 添加到出站的队列中
            currRst.add(outTrainNumber);
            trainDispatch(waitTrain, inTrain, currRst, wholeRst);
            // 现场还原
            currRst.remove(currRst.size() - 1);
            inTrain.push(outTrainNumber);
        }
        // 情况3：有等待的火车要进站
        if (hasWait) {

            // 进站的火车号
            int inTrainNumber = waitTrain.pop();
            // 添加到进站的队列中
            inTrain.push(inTrainNumber);
            trainDispatch(waitTrain, inTrain, currRst, wholeRst);
            // 现场还原
            waitTrain.push(inTrainNumber);
            inTrain.pop();
        }
    }
}
