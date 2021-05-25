package linkedlist.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
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

 /**
 * 给定一个单链表，其中的元素按升序排序，将其转换为高度平衡的二叉搜索树。

本题中，一个高度平衡二叉树是指
一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。
 */
class Solution {
    //用一个数组链表存放各个节点的值，第一反应
    //这样应该不是最好的做法，空间复杂度较大
    List<Integer> list = new ArrayList<>();
    public TreeNode sortedListToBST(ListNode head) {
        if(head == null) return null;
        if(head.next == null){
            return new TreeNode(head.val);
        }

        int n = 0;//数组长度
        while(head != null){
            list.add(head.val);
            head = head.next;
            n++;
        }
        return buildTree(0, n-1);

    }

    public TreeNode buildTree(int left, int right){
        if(left > right) return null;

        int mid = left + (right - left)/2;
        TreeNode root = new TreeNode();
        root.left = buildTree(left, mid-1);
        root.val = list.get(mid);
        root.right = buildTree(mid+1, right);
        return root;
    }
}

//快慢指针法，比较巧妙
/*class Solution {
    public TreeNode sortedListToBST(ListNode head) {
        //1. 特例处理
        if (head == null){
            return null;
        }else if(head.next == null){
            return new TreeNode(head.val);
        }
        //2. 利用快慢指针找链表中间节点
        ListNode slow = head, fast = head;
        ListNode pre = null;
        while( fast != null && fast.next != null){
            pre = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        //3. 创建树的根节点，并断开相应连接
        TreeNode root = new TreeNode(slow.val);
        pre.next = null;//使得分成两个子链表

        //4. 递归链表中间节点左右两边的子链表
        root.left = sortedListToBST(head);
        root.right = sortedListToBST(slow.next);
        return root;
    }
}*/

//官方分治+中序遍历结合思想，因为中序遍历本身就是从小到大找元素
/*class Solution {
    ListNode globalHead;

    public TreeNode sortedListToBST(ListNode head) {
        globalHead = head;
        int length = getLength(head);
        return buildTree(0, length - 1);
    }

    public int getLength(ListNode head) {
        int ret = 0;
        while (head != null) {
            ++ret;
            head = head.next;
        }
        return ret;
    }

    public TreeNode buildTree(int left, int right) {
        if (left > right) {
            return null;
        }
        int mid = (left + right + 1) / 2;
        TreeNode root = new TreeNode();
        root.left = buildTree(left, mid - 1);
        root.val = globalHead.val;
        globalHead = globalHead.next;
        root.right = buildTree(mid + 1, right);
        return root;
    }
}*/

public class Question109 {
    
}
