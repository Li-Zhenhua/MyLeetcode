package tree.medium;

import java.util.LinkedList;
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
  * 给你一棵 完全二叉树 的根节点 root ，求出该树的节点个数。

完全二叉树 的定义如下：在完全二叉树中，除了最底层节点可能没填满外，
其余每层节点数都达到最大值，并且最下面一层的节点都集中在该层最左边的若干位置。
若最底层为第 h 层，则该层包含 1~ 2h 个节点。
  */

//没有用到给出的性质，效率肯定较低，而且还有额外空间
/*class Solution {
    public int countNodes(TreeNode root) {
        if(root == null) return 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int count = 0;
        while(!queue.isEmpty()){
            TreeNode r = queue.poll();
            if(r.left != null){
                queue.offer(r.left);
            }
            if(r.right != null){
                queue.offer(r.right);
            }
            count++;
        }
        return count;
    }
}*/

//递归做法，这个比较普适，但是也没有用到完全二叉树的性质
/*class Solution {
    public int countNodes(TreeNode root) {
    	if(root == null) {
    		return 0;
    	}
    	int left = countNodes(root.left);
    	int right = countNodes(root.right);
    	
    	return left+right+1;
    	
    }
}*/


//利用完全二叉树性质
//若left == right。这说明，左子树一定是满二叉树，因为节点已经填充到右子树了，
//左子树必定已经填满了。所以左子树的节点总数我们可以直接得到，是 2^left - 1，
//加上当前这个 root 节点，则正好是 2^left。再对右子树进行递归统计。

//若left != right。说明此时最后一层不满，但倒数第二层已经满了，
//可以直接得到右子树的节点个数。同理，右子树节点 +root 节点，总数为 2^right。
//再对左子树进行递归查找。

class Solution {
    public int countNodes(TreeNode root) {
        if(root == null){
           return 0;
        } 
        int left = countLevel(root.left);
        int right = countLevel(root.right);
        if(left == right){
            return countNodes(root.right) + (1<<left); //位运算表示2^left
        }else{
            return countNodes(root.left) + (1<<right);
        }

        //非递归写法
        /*int left = countLevel(root.left);
        int count = 0;
        while(root != null){
            int right = countLevel(root.right);
            if(right == left){
                count+=(1<<left);
                root = root.right;
            }else{
                count+=(1<<right);
                root = root.left;
            }
            left--;
        }*/
    }
    private int countLevel(TreeNode root){
        int level = 0;
        while(root != null){
            level++;
            root = root.left;
        }
        return level;
    }
}

public class Question222 {
    
}
