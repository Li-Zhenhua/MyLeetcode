package tree.medium;

import java.util.Deque;
import java.util.LinkedList;

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
  * 给你二叉树的根结点 root ，请你将它展开为一个单链表：

展开后的单链表应该同样使用 TreeNode ，
其中 right 子指针指向链表中下一个结点，而左子指针始终为 null 。
展开后的单链表应该与二叉树 先序遍历 顺序相同。
  */

//额外使用了一个队列存储先序遍历节点
/*class Solution {
    Deque<TreeNode> queue = new LinkedList<>();
    public void flatten(TreeNode root) {
        if(root == null) return;
        enQuene(root);
        root = queue.poll();
        TreeNode pre = root;
        TreeNode curr = root;
        while(!queue.isEmpty()){
            curr = queue.poll();
            pre.left = null;
            pre.right = curr;
            pre = curr;
        }
        //最后一个节点
        curr.left = null;
        curr.right = null;
        return;

    }

    public void enQuene(TreeNode root){
        if(root == null) return;
        queue.offer(root);
        enQuene(root.left);
        enQuene(root.right);
        return;
    }
}*/

//官方原地解法，O（1）空间复杂度，寻找前驱节点
//如果一个节点的左子节点不为空，则该节点的左子树中的最后一个节点被访问之后，该节点的右子节点被访问。
//该节点的左子树中最后一个被访问的节点是左子树中的最右边的节点，
//也是该节点的前驱节点。因此，问题转化成寻找当前节点的前驱节点。
class Solution {
    public void flatten(TreeNode root) {
        TreeNode curr = root;
        while(curr != null){
            if(curr.left != null){
                TreeNode next = curr.left;
                TreeNode pre = next;//前驱节点
                while(pre.right != null){
                    pre = pre.right;
                }
                pre.right = curr.right;
                curr.right = curr.left;
                curr.left = null;
            }   
        }
        curr = curr.right;//此时的right相当于原来的left节点
    }
}

public class Question114 {
    
}
