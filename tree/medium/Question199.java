package tree.medium;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

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
  * 给定一棵二叉树，想象自己站在它的右侧，
  按照从顶部到底部的顺序，返回从右侧所能看到的节点值。
  */
class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        if(root == null) return new ArrayList<>();
        Deque<TreeNode> queue = new LinkedList<>();
        List<Integer> ans = new ArrayList<>();
        queue.offer(root);
        TreeNode last = queue.peekLast();
        while(!queue.isEmpty()){
            TreeNode r = queue.poll();
            if(r.left != null){
                queue.offer(r.left);
            }
            if(r.right != null){
                queue.offer(r.right);
            }
            if(r == last){
                ans.add(r.val);
                last = queue.peekLast();
            }
        }
        return ans;
    }
}

public class Question199 {
    
}
