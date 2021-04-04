package tree.easy;

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
  * 
给定一个二叉树，返回所有从根节点到叶子节点的路径。

说明: 叶子节点是指没有子节点的节点。
  */
class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        //if(root == null) return (new ArrayList<String>());
        List<String> list = new ArrayList<>();
        String s = new String();
        return binaryTreePaths(root, list, s);
    }

    //注意这里不能直接传stringbuild为参数，这样就会使得每次迭代使用同一个sb
    //后续删减处理起来就比较麻烦
    public List<String> binaryTreePaths(TreeNode root, List<String> list, String s) {
        if(root == null) return list;
        StringBuilder sb = new StringBuilder(s);
        sb.append(root.val);
        if(root.left == null && root.right == null){
            list.add(sb.toString());
            return list;
        }
        sb.append("->");
        list = binaryTreePaths(root.left, list, sb.toString());
        list = binaryTreePaths(root.right, list, sb.toString());
        return list;
    }
}

public class Question257 {
    
}
