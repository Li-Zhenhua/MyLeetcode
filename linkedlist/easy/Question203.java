package linkedlist.easy;

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
 * 给你一个链表的头节点 head 和一个整数 val ，
 * 请你删除链表中所有满足 Node.val == val 的节点，
 * 并返回 新的头节点 。
 */
 
class Solution {
    public ListNode removeElements(ListNode head, int val) {
        if (head == null) return null;
        while(head.val == val){
            head = head.next;
            if(head == null) return null;
        }
        ListNode prev = head;
        while(prev.next != null){
            if(prev.next.val == val){
                prev.next = prev.next.next;
            }else {
                prev = prev.next;
            }
        }
        return head;
    }
}

public class Question203 {
    
}
