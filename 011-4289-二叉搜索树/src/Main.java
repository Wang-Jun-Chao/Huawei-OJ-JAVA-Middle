import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * Author: 王俊超
 * Date: 2016-01-19 08:51
 * CSDN: http://blog.csdn.net/derrantcm
 * Github: https://github.com/Wang-Jun-Chao
 * Declaration: All Rights Reserved !!!
 */
public class Main {
    public static void main(String[] args) {
        //Scanner scanner = new Scanner(System.in);
        Scanner scanner = new Scanner(Main.class.getClassLoader().getResourceAsStream("data.txt"));
        do {

            String first = scanner.nextLine();
            if ("0".equals(first)) {
                break;
            }


            String tree = scanner.nextLine();
            TreeNode root = createTree(tree);
            List<Character> rootList = new LinkedList<Character>();
            preOrder(root, rootList);


            int lines = Integer.parseInt(first);

            for (int i = 0; i < lines; i++) {
                String search = scanner.nextLine();

                TreeNode searchTree = createTree(search);
                List<Character> searchList = new LinkedList<Character>();
                preOrder(searchTree, searchList);

                if (equals(rootList, searchList)) {
                    System.out.println("YES");
                } else {
                    System.out.println("NO");
                }
            }

        } while (true);

        scanner.close();
    }

    private static boolean equals(List<Character> l1, List<Character> l2) {
        if (l1 == null || l2 == null || l1.size() != l2.size()) {
            return false;
        }

        Iterator<Character> itr1 = l1.iterator();
        Iterator<Character> itr2 = l2.iterator();

        while (itr1.hasNext() && itr2.hasNext()) {
            if (itr1.next() != itr2.next()) {
                return false;
            }
        }

        return true;
    }

    private static String isSearchPath(String tree, String search) {
        return null;
    }


    public static TreeNode createTree(String s) {
        if (s == null || s.length() < 1) {
            return null;
        }

        TreeNode root = new TreeNode(s.charAt(0));
        for (int i = 1; i < s.length(); i++) {
            insertTree(root, s.charAt(i));
        }

        return root;
    }

    public static void insertTree(TreeNode root, char c) {
        TreeNode node = new TreeNode(c);

        while (true) {
            // 新结点比当前根结点小，并且当前根结点有左子树
            if (root.val > c && root.left != null) {
                root = root.left;
            }
            // 新结点比当前根结点大，并且当前根结点有右子树
            else if (root.val < c && root.right != null) {
                root = root.right;
            }
            // 新结点比当前根结点小，并且当前根结点没有左子树
            else if (root.val > c) {
                root.left = node;
                break;
            }
            // 新结点比当前根结点大，并且当前根结点没有右子树
            else if (root.val < c) {
                root.right = node;
                break;
            }
            // 新结点的值与当前的结点值相等
            else {
                break;
            }

        }
    }

    public static void preOrder(TreeNode root, List<Character> rst) {
        if (root != null) {
            rst.add(root.val);
            preOrder(root.left, rst);
            preOrder(root.right, rst);
        }
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
