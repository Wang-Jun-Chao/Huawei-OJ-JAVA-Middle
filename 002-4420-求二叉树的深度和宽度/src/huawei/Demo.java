package huawei;

import java.util.LinkedList;
import java.util.List;

public final class Demo {

    public static class BiNode {

        public char data;
        public BiNode left;
        public BiNode right;

        public BiNode(char data) {
            this.data = data;

        }
    }

    public static class BiNodeInfo {
        public int width = 0;
        public int height = 0;
    }

    /*
     * Description 给定一个二叉树，获取该二叉树的宽度深度。
     * Input Param: head  需要获取深度的二叉树头结点
     * Return Value: width 宽度 height 高度
     */
    public static BiNodeInfo getBiNodeInfo(BiNode head) {
        BiNodeInfo bni = new BiNodeInfo();

        if (head != null) {
            // 当前层
            List<BiNode> currLevel = new LinkedList<BiNode>();
            // 下一层
            List<BiNode> nextLevel = new LinkedList<BiNode>();

            currLevel.add(head);
            // 记录高度
            bni.height++;
            // 记录最大的那一层的结点个数
            bni.width = currLevel.size();

            while (!currLevel.isEmpty()) {
                BiNode bn = currLevel.remove(0);
                // 左子树不为空
                if (bn.left != null) {
                    nextLevel.add(bn.left);
                }

                // 右子树不为空
                if (bn.right != null) {
                    nextLevel.add(bn.right);
                }

                // 当前层已经处理完了
                if (currLevel.isEmpty()) {

                    // 处理下一层
                    List<BiNode> tmp = currLevel;
                    currLevel = nextLevel;
                    nextLevel = tmp;

                    // 有数代处理
                    if (!currLevel.isEmpty()) {
                        // 高度增加
                        bni.height++;

                        // 更新宽度
                        if (bni.width < currLevel.size()) {
                            bni.width = currLevel.size();
                        }
                    }
                }
            }
        }

        return bni;
    }

}