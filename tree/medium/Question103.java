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
 * 给定一个二叉树，返回其节点值的锯齿形层序遍历。
 * （即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。
 */

//双向队列
/*class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if(root == null) return new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();
        Deque<Integer> list = new LinkedList<>();
        Deque<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        //标志位用boolean更省空间
        //int level = 0;
        boolean level = true;
        while(!queue.isEmpty()){
            int n = queue.size();
            for (int i = 0; i < n; i++) {
                TreeNode r = queue.poll();
                // if(level % 2 == 1){
                //     list.offerFirst(r.val);
                // }else{
                //     list.offerLast(r.val);
                // }
                if(!level){
                    list.offerFirst(r.val);
                }else{
                    list.offerLast(r.val);
                }
                if(r.left != null){
                    queue.offer(r.left);
                }

                if(r.right != null){
                    queue.offer(r.right);
                }
            }
            //level++;
            level = !level;
            ans.add(new LinkedList<>(list));
            list.clear();
        }
        return ans;
    }
}*/

//一个队列一个栈的方法
class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
         List<List<Integer>> ret = new ArrayList<>();
        if(root==null){
            return ret;
        }
        Deque<TreeNode> queue = new ArrayDeque<>();
        Deque<TreeNode> stack = new ArrayDeque<>();

        queue.add(root);
        int level =1;///层数为奇数时，正常顺序遍历,层数为偶数,倒序遍历
        while (!queue.isEmpty()||!stack.isEmpty()){

            boolean isOrder = (level&1)==1; //奇数的二进制最后一位一定是1
            int n =isOrder?queue.size():stack.size();
            List<Integer> sub = new ArrayList<>();
            for(int i=0;i<n;i++){
                if(isOrder){
                    TreeNode curNode = queue.poll();
                    sub.add(curNode.val);
                    if(curNode.left!=null){
                        stack.push(curNode.left);
                    }
                    if(curNode.right!=null){
                        stack.push(curNode.right);
                    }
                }else{
                    TreeNode curNode = stack.poll();
                    sub.add(curNode.val);
                    if(curNode.right!=null){
                        queue.addFirst(curNode.right);
                    }
                    if(curNode.left!=null){
                        queue.addFirst(curNode.left);
                    }

                }
            }
            level++;
            ret.add(sub);
        }
        return ret;
    }
}

public class Question103 {
    
}
