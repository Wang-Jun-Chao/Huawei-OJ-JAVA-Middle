import java.util.LinkedList;
import java.util.List;

/**
 * Author: 王俊超
 * Date: 2016-01-23 22:56
 * CSDN: http://blog.csdn.net/derrantcm
 * Github: https://github.com/Wang-Jun-Chao
 * Declaration: All Rights Reserved !!!
 */
public class Game24Points {

    // a, b, c, d都在[1, 10]内
    public static boolean game24Points(int a, int b, int c, int d) {
        int[] arr = {a, b, c, d, '+', '-', '*', '/'};
        boolean[] used = new boolean[arr.length];
        LinkedList<Integer> list = new LinkedList<Integer>();

        boolean[] rst = {false};

        // 构造组合的逆波兰表达式
        for (int i = 0; i < 4; i++) {
            used[i] = true;
            list.add(arr[i]);
            to24(arr, used, 1, 0, list, rst);

            if (rst[0]) {
                return true;
            }

            // 现场还原
            list.removeLast();
            used[i] = false;
        }


        return false;
    }

    /**
     * @param arr
     * @param used
     * @param numCnt
     * @param optCnt
     * @param list
     * @param rst
     * @return
     */
    private static void to24(int[] arr, boolean[] used, int numCnt, int optCnt,
                             LinkedList<Integer> list, boolean[] rst) {


        // 如果已经找到答案就不进行操作了
        if (rst[0]) {
            return;
        }
        // 已经完成了逆波兰式的构造
        if (numCnt > optCnt && numCnt + optCnt == 7) {
            calInversePoland(list, rst);
        }
        // 还要构造逆波兰式
        else if (numCnt > optCnt) {

            for (int i = 0; i < arr.length; i++) {
                // 如果arr[i]还没有被使用过，或者arr[i]是运算符
                if (!used[i] || arr[i] < 0 || arr[i] > 10) {
                    // 如果是数字
                    if (arr[i] >= 0 && arr[i] <= 10) {
                        list.add(arr[i]);
                        numCnt++;
                        used[i] = true;


                        to24(arr, used, numCnt, optCnt, list, rst);

                        // 找到了一个答案就返回
                        if (rst[0]) {
                            return;
                        }

                        list.removeLast();
                        numCnt--;
                        used[i] = false;

                    }
                    // 如果是操作符，则放入arr[i]之前，操作数必须比操作符多两个
                    else if (numCnt + 1 > optCnt) {
                        list.add(arr[i]);
                        optCnt++;
                        used[i] = true;


                        to24(arr, used, numCnt, optCnt, list, rst);

                        // 找到了一个答案就返回
                        if (rst[0]) {
                            return;
                        }

                        list.removeLast();
                        optCnt--;
                        used[i] = false;
                    }
                }
            }

        }


    }

    // 计算逆波兰式的值
    private static void calInversePoland(LinkedList<Integer> list, boolean[] rst) {

//        for (int i : list) {
//            if (i >= 0 && i <= 10) {
//                System.out.print(i + " ");
//            } else {
//                System.out.print((char) i + " ");
//            }
//        }
//
//        System.out.println();


        LinkedList<Integer> stack = new LinkedList<Integer>();

        for (int v : list) {

            // 如果是数字
            if (v >= 0 && v <= 10) {
                stack.add(v);
            } else {
                int a = stack.removeLast();
                int b = stack.removeLast();
                int c = 0;
                switch ((char) v) {
                    case '+':
                        c = a + b;
                        break;
                    case '-':
                        c = a - b;
                        break;
                    case '*':
                        c = a * b;
                        break;
                    case '/':
                        // 除数不能为0
                        if (b == 0) {
                            return;
                        }
                        c = a / b;
                        break;
                }

                stack.add(c);
            }

//            System.out.println(stack + "===");
        }

        //System.out.println(stack);

        rst[0] = stack.getFirst() == 24;
    }

}
