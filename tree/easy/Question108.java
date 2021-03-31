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
 * 给你一个整数数组 nums ，其中元素已经按 升序 排列，请你将其转换为一棵 高度平衡 二叉搜索树。
 * 高度平衡 二叉树是一棵满足「每个节点的左右两个子树的高度差的绝对值不超过 1 」的二叉树。

 */

//就是类似二分的思想，递归调用
class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        if(nums.length == 0) return null;
        if(nums.length == 1){
            TreeNode t = new TreeNode(nums[0],null,null);
            return t;
        }
        TreeNode t = new TreeNode();
        t.val = nums[nums.length/2];
        int[] head = new int[nums.length/2];
        int[] back = new int[nums.length - nums.length/2-1];
        System.arraycopy(nums, 0, head, 0, head.length);
        System.arraycopy(nums, nums.length/2+1, back, 0, back.length);
        t.left = sortedArrayToBST(head);
        t.right = sortedArrayToBST(back);
        return t;
    }
}
