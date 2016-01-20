import huawei.Demo;

/**
 * Author: Íõ¿¡³¬
 * Date: 2016-01-19 16:48
 * CSDN: http://blog.csdn.net/derrantcm
 * Github: https://github.com/Wang-Jun-Chao
 * All Rights Reserved !!!
 */
public class Test {
    public static void main(String[] args) {
        Demo demo = new Demo();
        int[] yanZi = {2, 3, 3, 4, 5};
        int[] other = {1, 2, 3, 3, 4};
        System.out.println(demo.isYuanziWin(yanZi.length, yanZi, other));

         yanZi = new int[]{2, 2, 1, 2};
         other = new int[]{2, 2, 3, 1};
        System.out.println(demo.isYuanziWin(yanZi.length, yanZi, other));
    }
}
