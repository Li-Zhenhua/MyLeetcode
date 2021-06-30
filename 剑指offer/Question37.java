package 剑指offer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 请实现两个函数，分别用来序列化和反序列化二叉树。

你需要设计一个算法来实现二叉树的序列化与反序列化。这里不限定你的序列 / 反序列化算法执行逻辑，
你只需要保证一个二叉树可以被序列化为一个字符串并且将这个字符串反序列化为原始的树结构。

提示：输入输出格式与 LeetCode 目前使用的方式一致，
详情请参阅 LeetCode 序列化二叉树的格式。
你并非必须采取这种方式，你也可以采用其他的方法解决这个问题。
 */

 /**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

 //与Leetcode第297题一样
 //层序遍历，前序遍历均可，官方题解用前序遍历，这里看思路后自己写一遍
/*public class Codec {

    private StringBuilder sb = new StringBuilder();
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        serializeHelper(root);
        return sb.toString();
    }

    public void serializeHelper(TreeNode root){
        if(root == null){
            sb.append("None,");
            return;
        }
        sb.append(root.val).append(",");
        serialize(root.left);
        serialize(root.right);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] dataArray = data.split(",");
        List<String> dataList = new ArrayList<>(Arrays.asList(dataArray));
        return deserialize(dataList);
    }

    public TreeNode deserialize(List<String> dataList){
        if(dataList.get(0).equals("None")){
            dataList.remove(0);
            return null;
        }

        //先序遍历先遍历根节点，故才能够进行恢复
        TreeNode root = new TreeNode(Integer.parseInt(dataList.get(0)));
        dataList.remove(0);
        //根左右的顺序
        root.left = deserialize(dataList);
        root.right = deserialize(dataList);
        return root;
    }
}*/

//这里用层序遍历会快得多，也就是bfs
public class Codec {
    public String serialize(TreeNode root) {
        StringBuffer s = new StringBuffer();
        List<TreeNode> next = new ArrayList<TreeNode>();
        if(root != null) next.add(root);//入队列
        while(next.size() != 0){
            List<TreeNode> temp = new ArrayList<TreeNode>(next);
            next.clear();
            for(int i = 0; i < temp.size(); i++){
                TreeNode tempNode = temp.get(i);
                if(tempNode != null){
                    s.append(String.valueOf(tempNode.val) + " ");
                    next.add(tempNode.left);
                    next.add(tempNode.right);
                } else {
                    s.append("n ");
                }
            }
        }
        return s.toString();
    }
    public TreeNode deserialize(String data) {
        if(data.length() == 0) return null;

        TreeNode root = null;
        List<TreeNode> temp = new ArrayList<TreeNode>();
        TreeNode tempNode = null;
        boolean flag = false;
        for(int i = 0; i < data.length(); i++){
            if(data.charAt(i) == '-'){
                flag = true;
            } else if(data.charAt(i) == 'n'){
                if(tempNode == null) {
                    tempNode = temp.remove(0);
                }
                else tempNode = null;
                i++;
            } else {
                int val = 0;
                while(data.charAt(i) != ' '){
                    val = val * 10 + data.charAt(i) - '0';
                    i++;
                }
                if(flag) {
                    val = -val;
                    flag = false;
                }
                if(root == null){
                    root = new TreeNode(val);
                    temp.add(root);
                } else{
                    if(tempNode == null){
                        tempNode = temp.remove(0);
                        TreeNode nodeLeft = new TreeNode(val);
                        tempNode.left = nodeLeft;
                        temp.add(nodeLeft);
                    } else {
                        TreeNode nodeRight = new TreeNode(val);
                        tempNode.right = nodeRight;
                        temp.add(nodeRight);
                        tempNode = null;
                    }
                }
            }          
        }
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));

public class Question37 {
    
}
