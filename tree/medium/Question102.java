package tree.medium;

import java.util.ArrayList;
import java.util.Deque;
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
  * 给你一个二叉树，请你返回其按 层序遍历 得到的节点值。 
  （即逐层地，从左到右访问所有节点）。
  */

//就类似BFS
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root == null) return new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        Deque<TreeNode> queue = new LinkedList<>();
        //此时temp记录第一层的最后一个节点root
        TreeNode temp = root;
        queue.offer(root);
        while(!queue.isEmpty()){
            TreeNode r = queue.poll();
            list.add(r.val);
            if(r.left != null)
                queue.offer(r.left);
            if(r.right != null)
                queue.offer(r.right);
            //到达一层的最后一个节点时
            if(r == temp){
                ans.add(new ArrayList<>(list));
                list.clear();
                //记录下一层的最后一个节点
                temp = queue.peekLast();
            }
        }

        //好像可以在队列中添加null
        return ans;
    }
}

//官方用size（）的方法
/*class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        if (root == null) {
            return ret;
        }

        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            List<Integer> level = new ArrayList<Integer>();
            int currentLevelSize = queue.size();
            for (int i = 1; i <= currentLevelSize; ++i) {
                TreeNode node = queue.poll();
                level.add(node.val);
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            ret.add(level);
        }
        
        return ret;
    }
}*/

public class Question102 {
    
}
