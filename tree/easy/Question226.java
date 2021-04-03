package tree.easy;
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

/**
 * 翻转一棵二叉树。
 */

class Solution {
    public TreeNode invertTree(TreeNode root) {
        if(root == null) return null;
        root.left = invertTree(root.left);
        root.right = invertTree(root.right);
        TreeNode temp;
        temp = root.left;
        root.left = root.right;
        root.right = temp;

        //简化版
        /*TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);
        root.left = right;
        root.right = left;*/

        return root;
    }
}