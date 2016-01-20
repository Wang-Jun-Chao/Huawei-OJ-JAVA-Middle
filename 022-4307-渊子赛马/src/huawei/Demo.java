package huawei;

/*
 功能:判断yuanzi 的马是否会赢？yuanzi 的马赢了，返回 YES. 否则返回 NO

 输入参数：
 int num: 赛马的数量；   (1<= num <=1000)
 int[] speedYz: yuanzi 的马的速度；
 int[] speedOp: 对手的马的速度；

 返回值：
 String型，yuanzi 的马赢了，返回 YES. 否则返回 NO；
 */

import java.util.Arrays;

public class Demo {
    public String isYuanziWin(int num, int[] speedYz, int[] speedOp) {


        Arrays.sort(speedYz);
        Arrays.sort(speedOp);

        int count = 0;

        int idx = speedOp.length - 1;
        for (int i = speedYz.length - 1; i >= 0; i--) {

            // 在idx位置向前找，批speedYz[i]速度慢的马
            while (idx >= 0 && speedYz[i] <= speedOp[idx]) {
                idx--;
            }
            // 找到所求的马，就可以赢得比赛
            if (idx >= 0) {
                count++;
                // speedOp中下一次要找的马
                idx--;
                if (count > speedYz.length / 2) {
                    return "YES";
                }
            }
        }


        return "NO";
    }
}
