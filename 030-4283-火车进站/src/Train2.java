import java.util.*;

/**
 * Author: 王俊超
 * Date: 2016-02-03 08:47
 * CSDN: http://blog.csdn.net/derrantcm
 * Github: https://github.com/Wang-Jun-Chao
 * Declaration: All Rights Reserved !!!
 */
public class Train2 {

    public static void main(String[] args) {
//        Scanner cin = new Scanner(System.in);
        Scanner cin = new Scanner(Main.class.getClassLoader().getResourceAsStream("data2.txt"));
        while (cin.hasNext()) {
            int n = cin.nextInt();
            Queue<Integer> waitTrain = new LinkedList<Integer>();//等待进栈的火车队列
            Stack<Integer> inTrain = new Stack<Integer>();//火车站中的火车栈
            StringBuffer outTrain = new StringBuffer();//出站的火车
            List<Integer> currRst = new LinkedList<Integer>(); // 当前解
            List<List<Integer>> wholeRst = new LinkedList<List<Integer>>(); // 所有解

            for (int i = 0; i < n; i++) {
                waitTrain.add(cin.nextInt());
            }


            stationDispatch(waitTrain, inTrain, outTrain, currRst, wholeRst);

            for (List<Integer> li : wholeRst) {
                System.out.println(li);
            }
        }

    }

    private static void stationDispatch(Queue<Integer> waitTrain,
                                        Stack<Integer> inTrain,
                                        StringBuffer outTrain,
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


        //情况1：没有等待的火车，火车站中也没有火车
        if (!hasWait && !hasIn) {
            String out = outTrain.toString();
            System.out.println(out.substring(0, out.length() - 1));

            List<Integer> rst = new LinkedList<Integer>();
            for (Integer i : currRst) {
                rst.add(i);
            }

            //currRst.clear();

            wholeRst.add(rst);

            return;
        }
        //情况2：火车站中有火车要出站
        if (hasIn) {
            Queue<Integer> waitTmp = new LinkedList<Integer>(waitTrain);//等待进栈的火车队列
            Stack<Integer> inTmp = (Stack<Integer>) inTrain.clone();//火车站中的火车堆
            StringBuffer outTmp = new StringBuffer(outTrain);//出站的火车
            currRst.add(inTmp.peek());
            outTmp.append(inTmp.pop().toString()).append(' ');
            stationDispatch(waitTmp, inTmp, outTmp, currRst, wholeRst);
            currRst.remove(currRst.size() - 1);
        }
        //情况3：有等待的火车要进站
        if (hasWait) {
            Queue<Integer> waitTmp = new LinkedList<Integer>(waitTrain);//等待进栈的火车队列
            Stack<Integer> inTmp = (Stack<Integer>) inTrain.clone();//火车站中的火车堆
            StringBuffer outTmp = new StringBuffer(outTrain);//出站的火车
            inTmp.push(waitTmp.poll());
            stationDispatch(waitTmp, inTmp, outTmp, currRst, wholeRst);
        }
    }
}
