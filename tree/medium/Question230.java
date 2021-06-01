package tree.medium;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

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
  * 给定一个二叉搜索树的根节点 root ，和一个整数 k ，
  请你设计一个算法查找其中第 k 个最小元素（从 1 开始计数）。
  */

//怎么会一下想到优先队列去了orz
//后面想想因为是二叉搜索树，直接中序遍历不就完事了嘛。。。
class Solution {
    //或者不用list存，直接找到第k个完事
    //List<Integer> list = new ArrayList<>();
    private int count = 0;
    private int ans;
    public int kthSmallest(TreeNode root, int k) {
        inorderTraversal(root,k);
        //return list.get(k-1);
        return ans;
    }

    public void inorderTraversal(TreeNode root, int k){
        if(root == null) return;
        inorderTraversal(root.left,k);
        //list.add(root.val);
        count++;
        if(count == k){
            ans = root.val;
            return;
        }
        inorderTraversal(root.right,k);
    }
}

public class Question230 {
    
}
