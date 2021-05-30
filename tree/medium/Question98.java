package tree.medium;

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
 * 给定一个二叉树，判断其是否是一个有效的二叉搜索树。

假设一个二叉搜索树具有如下特征：

节点的左子树只包含小于当前节点的数。
节点的右子树只包含大于当前节点的数。
所有左子树和右子树自身必须也是二叉搜索树。
 */

class Solution {
    public boolean isValidBST(TreeNode root) {
        //注意为了防止极端情况，即节点值为Integer.MIN_VALUE,Integer.MAX_VALUE
        //要将左右边界最大最小值设置成long的
        return isValidBST(root,Long.MIN_VALUE,Long.MAX_VALUE);
    }

    public boolean isValidBST(TreeNode root, long maxLeft, long minRight){
        if(root == null) return true;

        if(maxLeft < root.val && minRight > root.val){
            return isValidBST(root.left, maxLeft, root.val) && isValidBST(root.right,root.val,minRight);
        }
        return false;
    }

}

//看题解思路，用中序遍历的方式的做法
//中序遍历是一个升序序列
/*class Solution {
    Long temp = Long.MIN_VALUE;
    public boolean isValidBST(TreeNode root) {
        if(root == null) return true;

        boolean left  = isValidBST(root.left);
        //注意，两个数值相等也是false
        if(root.val <= temp) return false;
        temp = (long)root.val;
        boolean right = isValidBST(root.right);
        return left && right;
    }

    
}*/

public class Question98 {
    
}
