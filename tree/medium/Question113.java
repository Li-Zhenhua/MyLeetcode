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
  * 给你二叉树的根节点 root 和一个整数目标和 targetSum ，
  找出所有 从根节点到叶子节点 路径总和等于给定目标和的路径。

叶子节点 是指没有子节点的节点。
  */

//其实也就是dfs
class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    List<Integer> list = new ArrayList<>();
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        if(root == null) return new ArrayList<>();
        findSum(root, targetSum);
        return ans;
    }

    public void findSum(TreeNode root, int target){
        if(root == null) return;
        list.add(root.val);
        if(root.left == null && root.right == null){
            if(target == root.val){
                //list.add(root.val);
                ans.add(new ArrayList<>(list));
                //list.clear();
            }
            list.remove(list.size()-1);//把这一轮的叶子节点删除
            return;
        }
        findSum(root.left, target-root.val);
        findSum(root.right, target-root.val);
        list.remove(list.size()-1);
        return;
    }
}

public class Question113 {
    
}
