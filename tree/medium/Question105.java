package tree.medium;

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
        return buildTree(preorder, 0, preorder.length-1, inorder, 0, inorder.length-1);
    }

    public TreeNode buildTree(int[] preorder, int preLeft, int preRight, 
    int[] inorder, int inLeft, int inRight) {
        if(preLeft == preRight) return new TreeNode(preorder[preLeft]);
        else if(preLeft > preRight) return null;

        TreeNode t = new TreeNode(preorder[preLeft]);

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
    }
}

public class Question105 {
    
}
