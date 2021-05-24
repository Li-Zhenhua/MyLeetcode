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
 * 给你单链表的头指针 head 和两个整数 left 和 right ，其中 left <= right 。
 * 请你反转从位置 left 到位置 right 的链表节点，返回 反转后的链表 。
 */
class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if(head == null || head.next == null || left == right) return head;
        ListNode dummyHead = new ListNode(0,head);
        int count = 0;
        ListNode curr = dummyHead;
        while(count < left-1){
            curr = curr.next;
            count++;
        }

        //记录翻转部分的前一个节点
        ListNode preHead = curr;
        curr = curr.next;
        count++;

        ListNode pre = curr;
        //记录翻转部分的头一个节点
        ListNode start = curr;
        curr = curr.next;
        count++;

        
        while(count <= right){
            ListNode temp = curr.next;
            curr.next = pre;
            pre = curr;
            curr = temp;
            count++;
        }

        start.next = curr;
        preHead.next = pre;

        return dummyHead.next;
    }
}

//官方更简洁的方法
/*class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        // 设置 dummyNode 是这一类问题的一般做法
        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;
        ListNode pre = dummyNode;
        for (int i = 0; i < left - 1; i++) {
            pre = pre.next;
        }
        ListNode cur = pre.next;
        ListNode next;
        for (int i = 0; i < right - left; i++) {
            next = cur.next;
            cur.next = next.next;
            next.next = pre.next;
            pre.next = next;
        }
        return dummyNode.next;
    }
}*/

public class Question92 {
    
}
