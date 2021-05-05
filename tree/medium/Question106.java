package tree.medium;

import java.util.HashMap;
import java.util.Map;

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
 * 根据一棵树的中序遍历与后序遍历构造二叉树。

注意:
你可以假设树中没有重复的元素。
 */

 //后序是左-右-中，反过来就是中右左，与前序很类似
class Solution {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return buildTree(inorder, 0, inorder.length-1, postorder, 0, postorder.length-1, map);
    }

    public TreeNode buildTree(int[] inorder, int inLeft, int inRight, 
    int[] postorder, int postLeft, int postRight, Map<Integer,Integer> map){
        if(postLeft > postRight) return null;

        int inRootIndex = map.get(postorder[postRight]);
        TreeNode t = new TreeNode(postorder[postRight]);


        //构造右子树
        int rightNum = inRight - inRootIndex;
        t.right = buildTree(inorder, inRootIndex+1, inRight, postorder, postRight-rightNum, postRight-1, map);

        //构造左子树
        t.left = buildTree(inorder, inLeft, inRootIndex-1, postorder, postLeft, postRight-rightNum-1, map);
        return t;
    }
}

public class Question106 {
    
}
