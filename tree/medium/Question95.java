package tree.medium;

import java.util.LinkedList;
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
  * 给你一个整数 n ，请你生成并返回所有由 n 个节点组成且节点值
  从 1 到 n 互不相同的不同 二叉搜索树 。可以按 任意顺序 返回答案。
  */

//日常回溯
class Solution {
    public List<TreeNode> generateTrees(int n) {
        return buildTree(1, n);
    }

    public List<TreeNode> buildTree(int left, int right){
        List<TreeNode> ans = new LinkedList<>();
        if(left > right){
            ans
        }
    }
}

public class Question95 {
    
}
