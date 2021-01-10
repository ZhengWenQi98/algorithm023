package cn.zwq.algorithm.middle;

import java.util.ArrayList;
import java.util.List;

/**
 * 144. 二叉树的前序遍历
 *
 * @author G20200343200113
 */
public class LeetCode144 {

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
     * 前序遍历顺序是根 -> 左 -> 右
     *
     * @param root
     * @return
     */
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> results = new ArrayList<>();
        if (root == null) {
            return results;
        }
        results.add(root.val);
        results.addAll(preorderTraversal(root.left));
        results.addAll(preorderTraversal(root.right));
        return results;
    }

}
