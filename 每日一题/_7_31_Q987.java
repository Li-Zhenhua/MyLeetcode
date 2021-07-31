package 每日一题;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/**
 * 给你二叉树的根结点 root ，请你设计算法计算二叉树的 垂序遍历 序列。

对位于 (row, col) 的每个结点而言，其左右子结点分别位于 (row + 1, col - 1) 和 (row + 1, col + 1) 。树的根结点位于 (0, 0) 。

二叉树的 垂序遍历 从最左边的列开始直到最右边的列结束，按列索引每一列上的所有结点，形成一个按出现位置从上到下排序的有序列表。如果同行同列上有多个结点，则按结点的值从小到大进行排序。

返回二叉树的 垂序遍历 序列。

提示：

树中结点数目总数在范围 [1, 1000] 内
0 <= Node.val <= 1000
 */

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

 //之前想复杂了
 //直接先遍历一遍，用map记录下每个节点的行、列和值
 //然后自定义comparator排序就行
 //看了一些题解后发现，其实可以不用map，直接遍历时将行、列和值记录在list中即可
 //然后排序(本身map记录)
 //或者直接用一个优先队列来代替map，这样后面就不用做较为复杂的处理
class Solution {
    List<int[]> list = new ArrayList<>();
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        //用来记录每个节点的行、列和值
        
        dfs(root,0,0);
        Collections.sort(list, (a,b) -> {
            if(a[0] != b[0]) return a[0] - b[0];
            else if(a[1] != b[1]) return a[1] - b[1];
            else return a[2] - b[2];
        });

        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        temp.add(list.get(0)[2]);
        int colPrev = list.get(0)[0];
        for (int i = 1; i < list.size(); i++) {
            int colCurr = list.get(i)[0];
            if(colCurr != colPrev){
                ans.add(temp);
                temp = new ArrayList<>();
            }
            colPrev = colCurr;
            temp.add(list.get(i)[2]);
        }
        //最后一部分的数据
        ans.add(temp);
        return ans;
    }

    public void dfs(TreeNode root, int row, int col){
        if(root == null) return;
        list.add(new int[]{col, row, root.val});
        dfs(root.left, row+1, col-1);
        dfs(root.right, row+1, col+1);
    }
}

public class _7_31_Q987 {
    
}
