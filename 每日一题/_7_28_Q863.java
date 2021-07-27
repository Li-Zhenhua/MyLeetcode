package 每日一题;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
 * 给定一个二叉树（具有根结点 root）， 一个目标结点 target ，和一个整数值 K 。

返回到目标结点 target 距离为 K 的所有结点的值的列表。 答案可以以任何顺序返回。

提示：

给定的树是非空的。
树上的每个结点都具有[唯一]的值 0 <= node.val <= 500 。
目标结点 target 是树上的结点。
0 <= K <= 1000.
 */
class Solution {
    List<Integer> ans = new ArrayList<>();
    Map<TreeNode,TreeNode> map = new HashMap<>();
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        //用map记录每个节点的父节点
        dfs(root);

        //寻找合适的节点
        dfs(target, null, k, 0);
        
        return ans;
    }

    public void dfs(TreeNode root){
        //if(root == null) return;
        if(root.left != null){
            map.put(root.left, root);
            dfs(root.left);
        }
        if(root.right != null){
            map.put(root.right, root);
            dfs(root.right);
        }
    }

    public void dfs(TreeNode target, TreeNode prev, int k, int depth){
        if(target == null) return;
        if(depth == k){
            ans.add(target.val);
        }
        if(target.left != prev){
            dfs(target.left, target, k, depth+1);
        }
        if(target.right != prev){
            dfs(target.right, target, k, depth+1);
        }
        
        TreeNode parentMap = map.get(target);
        if(parentMap == prev) return;
        // if(depth + 1 == k){
        //     ans.add(parentMap.val);
        // }
        // if(parentMap.left == target){
        //     dfs(parentMap.right, parentMap, k, depth+2);
        // }else{
        //     dfs(parentMap.left, parentMap, k, depth+2);
        // }
        dfs(parentMap, target, k, depth+1);

    }


}

public class _7_28_Q863 {
    
}
