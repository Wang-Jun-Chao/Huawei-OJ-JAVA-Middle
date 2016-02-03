import java.util.*;

/**
 * Author: 王俊超
 * Date: 2016-02-03 08:47
 * CSDN: http://blog.csdn.net/derrantcm
 * Github: https://github.com/Wang-Jun-Chao
 * Declaration: All Rights Reserved !!!
 */
public class Train {

    public static void main(String[] args) {
//        Scanner cin = new Scanner(System.in);
        Scanner cin = new Scanner(Main.class.getClassLoader().getResourceAsStream("data2.txt"));
        while (cin.hasNext()) {
            int n = cin.nextInt();

            // 等待进栈的火车队列
            Deque<Integer> waitTrain = new LinkedList<Integer>();
            // 火车站中的火车栈
            Deque<Integer> inTrain = new LinkedList<Integer>();
            // 当前解，已经出站的火车，当所有火车都出站，就是一个解
            List<Integer> currRst = new LinkedList<Integer>();
            // 所有解
            List<List<Integer>> wholeRst = new LinkedList<List<Integer>>();

            for (int i = 0; i < n; i++) {
                waitTrain.add(cin.nextInt());
            }

            stationDispatch(waitTrain, inTrain, currRst, wholeRst);

            for (List<Integer> li : wholeRst) {
                System.out.println(li);
            }
        }

    }

    private static void stationDispatch(Deque<Integer> waitTrain,
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
            stationDispatch(waitTrain, inTrain, currRst, wholeRst);
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
            stationDispatch(waitTrain, inTrain, currRst, wholeRst);
            // 现场还原
            waitTrain.push(inTrainNumber);
            inTrain.pop();
        }
    }
}
