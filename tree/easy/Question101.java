package tree.easy;

/**
 * 给定一个二叉树，检查它是否是镜像对称的。
 */

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
//就简单递归完事
class Solution {
    public boolean isSymmetric(TreeNode root) {
        //if (root == null) return true;
        return isSymmetric(root,root);
    }

    public boolean isSymmetric(TreeNode Nleft, TreeNode Nright) {
        if(Nleft == null && Nright == null) return true;
        if(Nleft == null || Nright == null) return false;//只有一边为空时
        if(Nleft.val == Nright.val){
            return (isSymmetric(Nleft.left, Nright.right) && isSymmetric(Nleft.right, Nright.left));
        }
        return false;
    }
}


