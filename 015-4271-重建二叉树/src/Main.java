import java.util.Scanner;

/**
 * Author: 王俊超
 * Date: 2016-01-19 11:11
 * CSDN: http://blog.csdn.net/derrantcm
 * Github: https://github.com/Wang-Jun-Chao
 * Declaration: All Rights Reserved !!!
 */
public class Main {
    public static void main(String[] args) {
        //Scanner scanner = new Scanner(System.in);
        Scanner scanner = new Scanner(Main.class.getClassLoader().getResourceAsStream("data.txt"));
        while (scanner.hasNext()) {

            int n = scanner.nextInt();

            int[] preOrder = new int[n];
            int[] inOrder = new int[n];

            for (int i = 0; i < n; i++) {
                preOrder[i] = scanner.nextInt();
            }

            for (int i = 0; i < n; i++) {
                inOrder[i] = scanner.nextInt();
            }

            boolean[] result = {true};
            TreeNode root = createTree(preOrder, 0, preOrder.length - 1, inOrder, 0, inOrder.length -1, result);

            if (!result[0]) {
                System.out.println("No");
            } else {
                StringBuilder builder = new StringBuilder();
                postVisit(root, builder);
                System.out.println(builder);
            }


        }

        scanner.close();
    }

    private static void postVisit(TreeNode root, StringBuilder builder) {
        if (root != null) {
            postVisit(root.left, builder);
            postVisit(root.right, builder);
            builder.append(root.val).append(' ');
        }
    }

    private static TreeNode createTree(int[] preOrder, int preBeg, int preEnd,
                                       int[] inOrder, int inBeg, int inEnd, boolean[] result) {

        if (preBeg <= preEnd && result[0]) {

            TreeNode root = new TreeNode(preOrder[preBeg]);

            // 在中序序列中找根结点元素的位置
            int inIdx = inBeg;

            while (inIdx <= inEnd && inOrder[inIdx] != preOrder[preBeg]) {
                inIdx++;
            }

            if (inIdx > inEnd) {
                result[0] = false;
                return null;
            }

            // 左子树的元素个数
            int leftNum = inIdx - inBeg;

            root.left = createTree(preOrder, preBeg + 1, preBeg + leftNum, inOrder, inBeg, inIdx - 1, result);
            root.right = createTree(preOrder, preBeg + leftNum + 1, preEnd, inOrder, inIdx + 1, inEnd, result);


            return root;
        }


        return null;
    }


    public static class TreeNode {
        private int val;
        private TreeNode left;
        private TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }
}
