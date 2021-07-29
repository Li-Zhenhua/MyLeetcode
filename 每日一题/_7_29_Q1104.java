package 每日一题;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * 在一棵无限的二叉树上，每个节点都有两个子节点，树中的节点 逐行 依次按 “之” 字形进行标记。

如下图所示，在奇数行（即，第一行、第三行、第五行……）中，按从左到右的顺序进行标记；

而偶数行（即，第二行、第四行、第六行……）中，按从右到左的顺序进行标记。

给你树上某一个节点的标号 label，请你返回从根节点到该标号为 label 节点的路径，该路径是由途经的节点标号所组成的
 */

class Solution666 {
    public List<Integer> pathInZigZagTree(int label) {
        List<Integer> ans = new ArrayList<>();
        Deque<Integer> stack = new ArrayDeque<>();
        //这个log是以e为底数的，要进行转换
        int depth = (int)(Math.log(label)/Math.log(2)) + 1;
        // stack.push(label);
        // depth--;
        // label /= 2;
        // label = (int)Math.pow(2, depth)-1 + (int)Math.pow(2, depth-1) - label; //对称找父节点
        while(label > 1){
            stack.push(label);
            depth--;
            label /= 2;
            label = (int)Math.pow(2, depth)-1 + (int)Math.pow(2, depth-1) - label; //对称找父节点 
        }
        ans.add(1); //根节点
        while(!stack.isEmpty()){
            ans.add(stack.pop());
        }
        return ans;
    }
}

public class _7_29_Q1104 {
    public static void main(String[] args) {
        Solution666 s = new Solution666();
        s.pathInZigZagTree(50);
    }
}
