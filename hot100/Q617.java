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

 //遍历树直接dfs完事
 class Solution {
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if(root1 == null && root2 == null) return null;
        else if(root1 == null) return root2;
        else if(root2 == null) return root1;
        root1.val += root2.val;
        dfs(root1.left,root2.left,root1,true);
        dfs(root1.right,root2.right,root1,false);
        return root1;
    }

    public void dfs(TreeNode root1, TreeNode root2, TreeNode pre, boolean isLeft){
        if(root1 == null && root2 == null) return;
        if(root1 == null){
            if(isLeft){
                pre.left = root2;
            }else{
                pre.right = root2;
            }
            return;
        }

        if(root2 == null){
            if(isLeft){
                pre.left = root1;
            }else{
                pre.right = root1;
            }
            return;
        }
        root1.val += root2.val;
        dfs(root1.left,root2.left,root1,true);
        dfs(root1.right,root2.right,root1,false);
    }
}

public class Q617 {
    
}
