package tree.medium;

import java.util.ArrayList;
import java.util.List;

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
  * 
给你一个二叉树的根节点 root ，树中每个节点都存放有一个 0 到 9 之间的数字。
每条从根节点到叶节点的路径都代表一个数字：

例如，从根节点到叶节点的路径 1 -> 2 -> 3 表示数字 123 。
计算从根节点到叶节点生成的 所有数字之和 。

叶节点 是指没有子节点的节点。
  */
/*class Solution {
    List<Integer> ans = new ArrayList<>();
    public int sumNumbers(TreeNode root) {
        dfs(root, 0);
        int sumNum = 0;
        for (Integer integer : ans) {
            sumNum += integer;
        }
        return sumNum;
    }

    public void dfs(TreeNode root, int num){
        if(root == null) return;
        if(root.left == null && root.right == null){
            ans.add(num*10+root.val);
            return;
        }
        int temp = num*10+root.val;
        dfs(root.left, temp);
        dfs(root.right, temp);
        return;
    }
}*/

//官方写法，更简洁
class Solution {
    public int sumNumbers(TreeNode root) {
        return dfs(root, 0);
    }

    public int dfs(TreeNode root, int prevSum) {
        if (root == null) {
            return 0;
        }
        int sum = prevSum * 10 + root.val;
        if (root.left == null && root.right == null) {
            return sum;
        } else {
            return dfs(root.left, sum) + dfs(root.right, sum);
        }
    }
}

public class Question129 {
    
}
