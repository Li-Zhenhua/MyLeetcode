package tree.medium;

import java.util.Deque;
import java.util.LinkedList;

import org.w3c.dom.Node;

/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

/**
 * 
给定一个 完美二叉树 ，其所有叶子节点都在同一层，
每个父节点都有两个子节点。二叉树定义如下：

struct Node {
  int val;
  Node *left;
  Node *right;
  Node *next;
}
填充它的每个 next 指针，让这个指针指向其下一个右侧节点。
如果找不到下一个右侧节点，则将 next 指针设置为 NULL。

初始状态下，所有 next 指针都被设置为 NULL。
 */

 //BFS
 /*class Solution {
    public Node connect(Node root) {
        if(root == null) return null;
        Deque<Node> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            int n = queue.size();
            Node r = null;
            for (int i = 0; i < n; i++) {
                r = queue.poll();
                if(r.left != null){
                    queue.offer(r.left);
                }
                if(r.right != null){
                    queue.offer(r.right);
                }
                if(i == n-1){
                    r.next = null;
                }else{
                    r.next = queue.peek();
                }
                
            }
        }
        return root;
    }
}*/

//精简空间复杂度
class Solution {
    public Node connect(Node root) {
        if(root==null){
            return root;
        }
        //因为一个父节点的两个左子节点只可能指向右子节点
        //而右子节点根据父节点是否存在next，分成指向next的左子节点或是null
        //妙啊
        /*if(root.left!=null){
            root.left.next=root.right;
            root.right.next=root.next!=null?root.next.left:null;
            connect(root.left);
            connect(root.right);
        }
        return root;*/

        //非递归写法
        Node start = root; //每一层最左边节点
        //因为是完美二叉树，即满二叉树
        while(start.left != null){
            Node curr = start;
            while(curr != null){
                curr.left.next = curr.right;
                if(curr.next != null){
                    curr.right.next = curr.next.left;
                }
                curr = curr.next;
            }
            start = start.left;
        }
        return root;
    }
}

public class Question116 {
    
}
