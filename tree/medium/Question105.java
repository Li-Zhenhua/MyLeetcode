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
 * 根据一棵树的前序遍历与中序遍历构造二叉树。

注意:
你可以假设树中没有重复的元素。
 */

 //先得注意到中序遍历根节点在数组中是分割左右子树的位置
 //则根据中序遍历找到根节点然后可知左右子树的节点个数
 //先序遍历按照根-左-右的顺序，联合上面即可分离出左右子树对应的元素
 //从而递归调用
class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return buildTree(preorder, 0, preorder.length-1, inorder, 0, inorder.length-1,map);
    }

    /*public TreeNode buildTree(int[] preorder, int preLeft, int preRight, 
    int[] inorder, int inLeft, int inRight) {
        //if(preLeft == preRight) return new TreeNode(preorder[preLeft]);
        //else if(preLeft > preRight) return null;
        //可以简化为：
        if(preLeft > preRight) return null;

        TreeNode t = new TreeNode(preorder[preLeft]);

        //可以在主函数中用一个map，防止每次都需要循环查找
        int inRootIndex = 0;
        for (int i = inLeft; i <= inRight; i++) {
            if(inorder[i] == preorder[preLeft]){
                inRootIndex = i;
                break;
            }
        }

        //构造左子树
        int leftNum = inRootIndex - inLeft;
        t.left = buildTree(preorder, preLeft+1, preLeft+leftNum, inorder, inLeft, inRootIndex);

        //构造右子树
        //int rightNum = inRight - inRootIndex;
        t.right = buildTree(preorder, preLeft+leftNum+1, preRight, inorder, inRootIndex+1, inRight);
        return t;
    }*/

    public TreeNode buildTree(int[] preorder, int preLeft, int preRight, 
    int[] inorder, int inLeft, int inRight,Map<Integer,Integer> map) {
        if(preLeft > preRight) return null;

        int inRootIndex = map.get(preorder[preLeft]);
        TreeNode t = new TreeNode(preorder[preLeft]);

        int leftNum = inRootIndex - inLeft;
        t.left = buildTree(preorder, preLeft+1, preLeft+leftNum, inorder, inLeft, inRootIndex-1, map);

        t.right = buildTree(preorder, preLeft+leftNum+1, preRight, inorder, inRootIndex+1, inRight, map);
        return t;
    }
}

//另一种办法：迭代法
/*class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
    if (preorder.length == 0) {
        return null;
    }
    Stack<TreeNode> roots = new Stack<TreeNode>();
    int pre = 0;
    int in = 0;
    //先序遍历第一个值作为根节点
    TreeNode curRoot = new TreeNode(preorder[pre]);
    TreeNode root = curRoot;
    roots.push(curRoot);
    pre++;
    //遍历前序遍历的数组
    while (pre < preorder.length) {
        //出现了当前节点的值和中序遍历数组的值相等，寻找是谁的右子树
        if (curRoot.val == inorder[in]) {
            //每次进行出栈，实现倒着遍历
            while (!roots.isEmpty() && roots.peek().val == inorder[in]) {
                curRoot = roots.peek();
                roots.pop();
                in++;
            }
            //设为当前的右孩子
            curRoot.right = new TreeNode(preorder[pre]);
            //更新 curRoot
            curRoot = curRoot.right;
            roots.push(curRoot);
            pre++;
        } else {
            //否则的话就一直作为左子树
            curRoot.left = new TreeNode(preorder[pre]);
            curRoot = curRoot.left;
            roots.push(curRoot);
            pre++;
        }
    }
    return root;
    }

}*/

public class Question105 {
    
}
