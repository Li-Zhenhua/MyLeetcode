package linkedlist.medium;

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
  * 给你一个链表的头节点 head ，旋转链表，将链表每个节点向右移动 k 个位置。
  */

  //感觉可以根据19题思路，找到倒数第k个节点，因为右移k个相当于将后k个节点前移
  //注意循环即可
  //双指针法，但是时间好像有点久
  //采用两遍循环，计数方法反而在这里更好
class Solution {
    public ListNode rotateRight(ListNode head, int k) {

        /*
        //注意还有k=0的特殊情况
        if(head == null || head.next == null || k == 0) return head;
        ListNode pre = new ListNode(0,head);
        ListNode curr = pre;
        for (int i = 0; i < k; i++) {
            //k大于节点数导致循环时
            if(curr.next == null){
                curr = head;
            }else{
                curr = curr.next;
            }
        }
        if(curr.next == null) return head;

        //找到倒数k个节点
        while(curr.next != null){
            pre = pre.next;
            curr = curr.next;
        }
        ListNode start = pre.next;
        pre.next = null;
        curr.next = head;
        return start;*/
    
        if(head == null || head.next == null || k == 0) return head;
        int count = 1;
        ListNode l = head;
        while(l.next != null){
            l = l.next;
            count++;
        }
        //倒数k % count位，对应正数count - k % count位
        k = count - k % count;
        if(k == count) return head;
        l.next = head;
        while(k > 0){
            l = l.next;
            k--;
        }
        ListNode start = l.next;
        l.next = null;
        return start;

    }
}

public class Question61 {
    
}
