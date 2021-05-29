package tree.medium;

import java.util.LinkedList;
import java.util.List;

import javax.swing.tree.TreeNode;

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
  * 给你一个整数 n ，请你生成并返回所有由 n 个节点组成且节点值
  从 1 到 n 互不相同的不同 二叉搜索树 。可以按 任意顺序 返回答案。
  */

//日常回溯方法,多练练就行
class Solution {
    public List<TreeNode> generateTrees(int n) {
        return buildTree(1, n);
    }

    public List<TreeNode> buildTree(int left, int right){
        List<TreeNode> ans = new LinkedList<>();
        if(left > right){
            ans.add(null);
            return ans;
        }

        for (int i = left; i <= right; i++) {
            List<TreeNode> leftTree = buildTree(left, i-1);
            List<TreeNode> rightTree = buildTree(i+1, right);

            for (TreeNode treeNode : leftTree) {
                for (TreeNode treeNode2 : rightTree) {
                    TreeNode curr = new TreeNode(i);
                    curr.left = treeNode;
                    curr.right = treeNode2;
                    ans.add(curr);
                }
            }
        }

        return ans;
    }
}

public class Question95 {
    
}
