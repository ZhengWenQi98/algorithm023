package cn.zwq.algorithm.middle;

import java.util.ArrayList;
import java.util.List;

/**
 * 94. 二叉树的中序遍历
 *
 * @author G20200343200113
 */
public class LeetCode94 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    /**
     * 递归
     * 中序遍历顺序左 -> 根 -> 右
     *
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> results = new ArrayList<Integer>();
        if (root == null) {
            return results;
        }
        results.addAll(inorderTraversal(root.left));
        results.add(root.val);
        results.addAll(inorderTraversal(root.right));
        return results;
    }
}