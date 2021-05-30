package tree.medium;

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
 * 给定一个二叉树

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

 //116题是完美二叉树，每一层的开头好找，而且next的指向可能性较为固定
 //如果用额外空间，类似116题，用BFS
 //官方O（1）方法，关键是用全局引用定位每一层开始
 /*class Solution {
     //记录每一层最后一个和下一层开始位置
    Node last = null, nextStart = null;

    public Node connect(Node root) {
        if (root == null) {
            return null;
        }
        Node start = root;
        while (start != null) {
            //每一层开始时重置
            last = null;
            nextStart = null;
            for (Node p = start; p != null; p = p.next) {
                if (p.left != null) {
                    handle(p.left);
                }
                if (p.right != null) {
                    handle(p.right);
                }
            }
            start = nextStart;
        }
        return root;
    }

    public void handle(Node p) {
        //在第一个节点时，没有前面的节点的next指向它，故不需要这一步
        // if (last != null) {
        //     last.next = p;
        // } 
        //找到每一层的第一个节点
        if (nextStart == null) {
            nextStart = p;
        }else{
            //不是第一个节点时
            last.next = p;
        }
        last = p;
    }
}*/

//看到的另一种用哑头结点的方法
class Solution {
    public Node connect(Node root) {
        Node dummy = new Node(0); // 每一层的头结点
        dummy.next = root;
        while(dummy.next!=null){
            Node cur = dummy.next;
            Node pre = dummy;
            dummy.next = null;//防止类似只有叶子节点的情况
            while(cur!=null){
                //最开始pre=dummy，故如果下一层有节点，一定会继续循环而不跳出
                if(cur.left!=null){
                    pre.next = cur.left;
                    pre = cur.left;
                }
                if(cur.right!=null){
                    pre.next = cur.right;
                    pre = cur.right;
                }
                cur = cur.next;
            }
        }
        return root;
    }
}

public class Question117 {
    
}
