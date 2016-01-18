package huawei;

public final class Demo {

    /* 功能：
     * 输入：n
     * 输出：
     * 返回：N阶楼梯的走法
     */
    public static long stairs(int n) {

        if (n < 1) {
            return 0;
        } else if (n == 1) {
            return 1;
        } else if (n == 2) {
            return 2;
        }

        long closer = 1;
        long closest = 2;
        long kind = 0;

        for (int i = 3; i <= n; i++) {
            kind = closer + closest;
            closer = closest;
            closest = kind;
        }

        return kind;
    }
}


