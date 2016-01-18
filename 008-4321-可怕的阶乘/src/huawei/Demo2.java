package huawei;

public final class Demo2 {

    public static String calcNN(int n) {

        if (n < 0) {
            throw new IllegalArgumentException("参数不能小于0");
        }

        if (n < 2) {
            return "1";
        }

        int count = countDigit(n);

        // 保存结果
        int[] rst = new int[count * n];
        // 中间结果
        int[] partialRst = new int[count * n];

        partialRst[0] = 1;

        for (int v = 2; v <= n; v++) {
            int[] mul = getNumArr(v);

//            System.out.println(Arrays.toString(mul));
            clear(rst);

//            if (v> 10) {
//                System.out.println("-" + Arrays.toString(mul));
//                System.out.println("-" + Arrays.toString(partialRst));
//            }


            for (int i = 0; i < mul.length; i++) {
                int carry = 0;
                boolean hasRun = false;

                for (int j = 0; j < partialRst.length && mul[i] != 0; j++) {

//                    if (v > 10) {
//                        System.out.println("I am in.");
//                    }

                    // mul[i]*partialRst[j]的积要算在i+j位上，
                    // rst[i + j]上原来的值
                    // carry，来自低位的进位
                    int sum = mul[i] * partialRst[j] + rst[i + j] + carry;

//                    if (sum > 0) {
//                        hasRun = true;
//                    }

//                    if (v > 10) {
//
//                    }

                    // 此处一定会执行，因为i+partialRst.length短很多，
                    // 会有partialRst[i]=0，并且partialRst[i+j]=0，carry=0
                    // 为了防止[0, 2, 1, 0, 0, 0] *[6]样子的情况，第一次相乘时sum为0，就不执行下面的乘法，
                    // 使用hasRun进行保证
                    if (sum == 0 && i + j >= rst.length - 1) {
//                        if (v > 10) {
//                            System.out.println(Arrays.toString(rst) + "===");
//                        }
                        break;
                    } else {
                        // 下一位的进位
                        carry = sum / 10;
                        // 当前位的和
                        rst[i + j] = sum % 10;
                    }
                }
            }

            // 新计算出来的结果，作为新的中间结果，

            System.arraycopy(rst, 0, partialRst, 0, rst.length);


//            System.out.println(Arrays.toString(partialRst));
        }


//        System.out.println(Arrays.toString(partialRst));

        // 从后向前找，找第一个非0数字
        int idx = partialRst.length - 1;
        while (partialRst[idx] == 0) {
            idx--;
        }

        StringBuilder builder = new StringBuilder();
        for (int i = idx; i >= 0; i--) {
            builder.append(partialRst[i]);
        }

        return builder.toString();
    }

    private static void clear(int[] rst) {
        for (int i = 0; i < rst.length; i++) {
            rst[i] = 0;
        }
    }

    // 计算一个数有多少位
    private static int countDigit(int v) {
        int count = 0;
        do {
            count++;
            v /= 10;
        } while (v != 0);
        return count;
    }

    private static int[] getNumArr(int n) {


        String s = n + "";
        int[] rst = new int[s.length()];
        for (int i = 0, j = s.length() - 1; i < s.length(); i++, j--) {
            rst[i] = s.charAt(j) - '0';
        }

        return rst;
    }


}