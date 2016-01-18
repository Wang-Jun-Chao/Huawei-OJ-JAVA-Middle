package huawei;


import java.util.ArrayList;
import java.util.List;

public final class Demo {

	/*
    功能: 约瑟夫问题众所周知，原始的约瑟夫问题是这样的：有n个人，编号为1,2,..., n，站成一圈，
	每次第m个将会被处决，直到只剩下一个人。约瑟夫通过给出m来决定赦免其中的一个人。
	例如当n=6,m=5时，5,4,6,2,3将会被依次处决，而1将会幸免。

	假如有k个好人，和k个坏人，所有人站成一圈，前k个人是好人，后k个人是坏人，
	编写程序计算一个最小的m，使k个坏人都被处决，而不处决任何好人。

	    
	输入: k 为正整数
	    
	输出: 
	     
	返回: 最小的m，使k个坏人都被处决，而不处决任何好人。
	     
	*/


    public static int getMinimumM(int K) {
        boolean flag = false;
        int c = 0;
        // m的取值
        int m = 0;
        while (!flag) {
            for (int i = (2 * c + 1) * K + 1; i <= 2 * K * (c + 1); i++) {
                List<Integer> tmp = new ArrayList<Integer>();
                for (int j = 0; j < 2 * K; j++) {
                    tmp.add(j + 1);
                }
                if (isFit(tmp, i)) {
                    flag = true;
                    m = i;
                    break;
                }
            }
            c++;
        }
        return m;
    }

    /**
     * 判断对链表取K是否合适
     *
     * @param list
     * @param k
     * @return
     */
    private static boolean isFit(List<Integer> list, int k) {
        //idx为元素下表，currNum代表当前idx要报的数
        int idx = 0;
        int currNum = 1;
        int length = list.size();
        int half = length / 2;

        while (length > half) {

            // 已经报到第k个数了
            if (currNum % k == 0) {
                // 取idx位位置的值
                int value = list.get(idx);
                // 说明好人被枪毙了，不合题意
                if (value <= half) {
                    return false;
                }

                // 否则就是枪毙坏人，将其删除，【注意此时idx又指向删除后的下一个元素，或者没有（删除最后一个的情况）】
                list.remove(idx);
                // 重新设置要报的数
                currNum = 1;
                // 集合中的长度减少
                length--;
            }
            // 没有报到第k个数
            else {
                // 将idx一步调调整到第k个数
                idx += k - 1;
                // currNum也一步调整到报第k个数，因为从算法中看出，currNum只能取1或者k
                currNum += k - 1;
            }

            // 索引超出了范围，更新索引
            if (idx >= length) {
                idx = idx % length;
            }
        }

        return true;
    }
}


