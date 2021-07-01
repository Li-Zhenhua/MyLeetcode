package remaining200_gt.medium;

import java.util.ArrayList;
import java.util.List;


/**
 * 在上次打劫完一条街道之后和一圈房屋后，
 * 小偷又发现了一个新的可行窃的地区。
 * 这个地区只有一个入口，我们称之为“根”。 
 * 除了“根”之外，每栋房子有且只有一个“父“房子与之相连。
 * 一番侦察之后，
 * 聪明的小偷意识到“这个地方的所有房屋的排列类似于一棵二叉树”。 
 * 如果两个直接相连的房子在同一天晚上被打劫，房屋将自动报警。
 * 
 * 计算在不触动警报的情况下，小偷一晚能够盗取的最高金额。
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

//完全懵逼orz
//可以用 f(o)表示选择 o节点的情况下，
//o节点的子树上被选择的节点的最大权值和；
//g(o)表示不选择 o 节点的情况下，
//o节点的子树上被选择的节点的最大权值和；
//l 和 r 代表 o 的左右孩子。

/*
 *1、当 o 被选中时，o 的左右孩子都不能被选中，故 o 被选中情况下
 子树上被选中点的最大权值和为 l 和 r 不被选中的最大权值和相加，
 即 f(o) = g(l) + g(r)
 2、当 o 不被选中时，o 的左右孩子可以被选中，也可以不被选中。
 对于 o 的某个具体的孩子 x，它对 o 的贡献是 x 被选中和不被选中情况下
 权值和的较大值。故 g(o)=max{f(l),g(l)}+max{f(r),g(r)}
 */

//学习了，这个转移方程有点难想
class Solution {
    //private int[] ans = new int[2]; 

    public int rob(TreeNode root) {
        int[] ans = robHelper(root);
        return Math.max(ans[0], ans[1]);
    }

    public int[] robHelper(TreeNode root){
        if(root == null){
            return new int[2];
        }
        int[] temp = new int[2];
        int[] leftArray = robHelper(root.left);
        int[] rightArray = robHelper(root.right);
        //temp[0]就表示上面的g，即不被选中时，temp[1]表示f，即被选中时
        temp[0] = Math.max(leftArray[0], leftArray[1]) + Math.max(rightArray[0], rightArray[1]);
        temp[1] = leftArray[0] + rightArray[0] + root.val;
        return temp;
    }
}

public class Question337 {
    
}
