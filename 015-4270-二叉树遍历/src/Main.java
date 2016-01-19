import java.util.Scanner;

/**
 * Author: 王俊超
 * Date: 2016-01-19 10:33
 * CSDN: http://blog.csdn.net/derrantcm
 * Github: https://github.com/Wang-Jun-Chao
 * Declaration: All Rights Reserved !!!
 */
public class Main {
    public static void main(String[] args) {
        //Scanner scanner = new Scanner(System.in);
        Scanner scanner = new Scanner(Main.class.getClassLoader().getResourceAsStream("data.txt"));
        while (scanner.hasNext()) {
            String preOrder = scanner.nextLine();
            String inOrder = scanner.nextLine();

//            System.out.println(preOrder + "-" + inOrder);

            TreeNode root = createTree(preOrder, 0, preOrder.length() - 1, inOrder, 0, inOrder.length() -1);
            StringBuilder builder = new StringBuilder();
            postVisit(root, builder);
            System.out.println(builder);
        }

        scanner.close();
    }

    private static void postVisit(TreeNode root, StringBuilder builder) {
        if (root != null) {
            postVisit(root.left, builder);
            postVisit(root.right, builder);
            builder.append(root.val);
        }
    }

    private static TreeNode createTree(String preOrder, int preBeg, int preEnd,
                                       String inOrder, int inBeg, int inEnd) {

        if (preBeg <= preEnd) {

            TreeNode root = new TreeNode(preOrder.charAt(preBeg));

            // 在中序序列中找根结点元素的位置
            int inIdx = inBeg;

            while (inIdx <= inEnd && inOrder.charAt(inIdx) != preOrder.charAt(preBeg)) {
                inIdx++;
            }

            // 左子树的元素个数
            int leftNum = inIdx - inBeg;

            root.left = createTree(preOrder, preBeg + 1, preBeg + leftNum, inOrder, inBeg, inIdx - 1);
            root.right = createTree(preOrder, preBeg + leftNum + 1, preEnd, inOrder, inIdx + 1, inEnd);


            return root;
        }


        return null;
    }


    public static class TreeNode {
        private char val;
        private TreeNode left;
        private TreeNode right;

        public TreeNode(char val) {
            this.val = val;
        }
    }
}
