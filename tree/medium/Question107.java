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
 * 给定一个二叉树，返回其节点值自底向上的层序遍历。 
 * （即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历）
 */

 //类似102题，只不过因为遍历顺序问题，需要用一个栈临时存储自顶向下的层序遍历
 //或者直接类似addFirst,ArrayList用add（0，list）方法
class Solution {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        if(root == null) return new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();
        Deque<TreeNode> queue = new LinkedList<>();
        Deque<List<Integer>> stack = new LinkedList<>();
        TreeNode temp = root;
        queue.offer(root);
        List<Integer> list = new ArrayList<>();
        while(!queue.isEmpty()){       
            TreeNode r = queue.poll();
            list.add(r.val);
            if(r.left != null){
                queue.offer(r.left);
            }
            if(r.right != null){
                queue.offer(r.right);
            }
            if(r == temp){
                stack.push(list);
                //如果用这个，上面括号里面就必须是new ArrayList<>(list)
                //因为需要开辟新的空间才会使得原引用指向的地址的内容不会被处理掉
                //list.clear(); 
                list = new ArrayList<>();
                temp = queue.peekLast();
            }
        }
        while(!stack.isEmpty()){
            ans.add(stack.pop());
        }

        return ans;
    }
}

public class Question107 {
    
}
