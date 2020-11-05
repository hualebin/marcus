package algorithm.leetcode;

import java.util.*;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
         this.val = val;
         this.left = left;
         this.right = right;
    }
}
public class PreorderTraversal {

    public static List<Integer> recursionSolution(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        recursion(root, result);
        return result;
    }

    public static void recursion(TreeNode root, List<Integer> result) {
        if (root != null) {
            result.add(root.val);
            recursion(root.left, result);
            recursion(root.right, result);
        }
    }

    public static List<Integer> traversalSolution(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root != null) {
            Stack<TreeNode> stack = new Stack<>();
            stack.add(root);

            while(!stack.isEmpty()) {
                TreeNode node = stack.pop();
                list.add(node.val);
                if (node.right != null) {
                    stack.add(node.right);
                }
                if (node.left != null) {
                    stack.add(node.left);
                }
            }
        }

        return list;
    }

    public static List<Integer> commonTraversalSolution(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root != null) {
            TreeNode curr = root;
            Stack<TreeNode> stack = new Stack<>();

            while(!stack.isEmpty() || curr != null) {
                while(curr != null) {
                    list.add(curr.val);
                    stack.add(curr);
                    curr = curr.left;
                }
                curr = stack.pop().right;
            }
        }
        Collections.reverse(list);
        return list;
    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1);
        treeNode.right = new TreeNode(2);
        treeNode.right.left = new TreeNode(3);

        List<Integer> result = recursionSolution(treeNode);

        for (Integer i : result) {
            System.out.println(i);
        }

        List<Integer> result1 = traversalSolution(treeNode);

        for (Integer i : result1) {
            System.out.println(i);
        }

        List<Integer> result2 = commonTraversalSolution(treeNode);

        for (Integer i : result2) {
            System.out.println(i);
        }
    }
}
