package 每日一题;

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
  * 给定一个非空特殊的二叉树，每个节点都是正数，并且每个节点的子节点数量只能为 2 或 0。如果一个节点有两个子节点的话，那么该节点的值等于两个子节点中较小的一个。

更正式地说，root.val = min(root.left.val, root.right.val) 总成立。

给出这样的一个二叉树，你需要输出所有节点中的第二小的值。如果第二小的值不存在的话，输出 -1 。
  */
class Solution {
    public int findSecondMinimumValue(TreeNode root) {
        if(root.left==null) return -1;
        int leftSecondMin=-1;
        int rightSecondMin=-1;
        if(root.left.val!=root.val){
            leftSecondMin=root.left.val;
        }else{
            leftSecondMin=findSecondMinimumValue(root.left);
        }
        if(root.right.val!=root.val){
            rightSecondMin=root.right.val;
        }else{
            rightSecondMin=findSecondMinimumValue(root.right);
        }
        
        if(leftSecondMin==-1 && rightSecondMin==-1) return -1;
        
        if(leftSecondMin==-1) return rightSecondMin;
       
        else if(rightSecondMin==-1) return leftSecondMin;
        
        return Math.min(leftSecondMin,rightSecondMin);
    }
}

public class _7_27_Q671 {
    
}
