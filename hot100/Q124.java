package hot100;

/**
 * 路径 被定义为一条从树中任意节点出发，沿父节点-子节点连接，达到任意节点的序列。同一个节点在一条路径序列中 至多出现一次 。该路径 至少包含一个 节点，且不一定经过根节点。

路径和 是路径中各节点值的总和。

给你一个二叉树的根节点 root ，返回其 最大路径和 。
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
class Solution {
    int ans = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        dfs(root);
        return ans;
    }  

    public int dfs(TreeNode root){
        //递归，对于一个基本的二叉树来说
        //只可能有三种链路，其中根节点一定是包含的
        if(root == null) return 0;
        int leftMax = dfs(root.left);
        int rightMax = dfs(root.right);
        //注意节点的值有可能是负数
        int horizen = root.val + Math.max(0, leftMax) + Math.max(0, rightMax);
        int vertical = root.val + Math.max(0, Math.max(leftMax, rightMax));
        ans = Math.max(ans, Math.max(horizen, vertical));
        return vertical;
    }
}

public class Q124 {
    
}
