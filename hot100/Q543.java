package hot100;

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
  * 给定一棵二叉树，你需要计算它的直径长度。
  一棵二叉树的直径长度是任意两个结点路径长度中的最大值。
  这条路径可能穿过也可能不穿过根结点。
  */
  
 //感觉类似124题
 class Solution {
    int ans = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        //dfs找左右呗
        dfs(root);
        return ans-1;
    }

    //这里记录的是节点的个数，注意路径长度要减一
    public int dfs(TreeNode root){
        if(root == null) return 0;
        int leftLen = dfs(root.left);
        int rightLen = dfs(root.right);
        int withoutParentRoot = 1 + leftLen + rightLen;
        ans = Math.max(ans, withoutParentRoot);

        return Math.max(leftLen, rightLen) + 1;
    }
}

public class Q543 {
    
}
