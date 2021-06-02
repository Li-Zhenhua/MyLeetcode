package tree.medium;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import javax.swing.tree.TreeNode;

import jdk.dynalink.linker.MethodTypeConversionStrategy;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

 /**
  * 给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。

百度百科中最近公共祖先的定义为：“对于有根树 T 的两个节点 p、q，
最近公共祖先表示为一个节点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大
（一个节点也可以是它自己的祖先）。”
  */

/*class Solution {
    Map<TreeNode,TreeNode> map = new HashMap<>();
    Set<Integer> set = new HashSet<>();
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        //用map记录父节点，因为val互不相同，故可以用此作为是否访问过的依据
        dfs(root);
        while(p != null){
            set.add(p.val);
            p = map.get(p); //找其父节点
        }
        while(q != null){
            if(set.contains(q.val)){
                return q;
            }
            q = map.get(q);
        }
        return null;
    }

    public void dfs(TreeNode root){
        if(root == null) return;
        if(root.left != null){
            map.put(root.left, root);
            dfs(root.left);
        }
        if(root.right != null){
            map.put(root.right, root);
            dfs(root.right);
        }
    }
}*/

//递归的方法
//公共祖先条件：
//(flson && frson) ∣∣ ((x = p ∣∣ x = q) && (flson∣∣frson))
class Solution {
    private TreeNode ans = null;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        dfs(root, p, q);
        return ans;
    }

    public boolean dfs(TreeNode root, TreeNode p, TreeNode q){
        if(root == null) return false;

        boolean left = dfs(root.left, p, q);
        boolean right = dfs(root.right, p, q);
        if((left && right) || ((root == p||root == q) && (left || right))){
            ans = root;
            return true;
        }

        return left || right || root == p || root == q;
    }
}


public class Question236 {
    
}
