package linkedlist.medium;

import java.util.HashMap;
import java.util.Map;

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
 * 给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。

进阶：你能尝试使用一趟扫描实现吗？
 */

 //这是两遍扫描的办法
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode l = head;
        int count = 0;
        while(l != null){
            count++;
            l = l.next;
        }
        //删除的是第一个节点时
        if(count == n){
            return head.next;
        }
        
        l = head;
        while( l != null){
            //找到要删除节点的上一个节点
            if(count == n+1){
                l.next = l.next.next;
                return head;
            }else{
                count--;
                l = l.next;
            }
        }
        return head;
    }
}

//一趟扫描
/*class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode l = head;
        int count = 0;
        Map<Integer,ListNode> map = new HashMap<>();
        while(l != null){
            count++;
            map.put(count,l);
            l = l.next;
        }
        //删除的是第一个节点时
        if(count == n){
            return head.next;
        }

        //找到要删除节点的上一个节点
        l = map.get(count-n);
        l.next = l.next.next;
        return head;
    }
}*/

//官方双指针法，其实感觉是两次遍历
//思路是：可以使用两个指针 first 和 second 同时对链表进行遍历，
//并且 first 比 second 超前 n 个节点。当 first 遍历到null时，
//second 就恰好处于倒数第 n 个节点前一个节点。

/*class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0, head);
        ListNode first = head;
        ListNode second = dummy;
        for (int i = 0; i < n; ++i) {
            first = first.next;
        }
        while (first != null) {
            first = first.next;
            second = second.next;
        }
        second.next = second.next.next;
        ListNode ans = dummy.next;
        return ans;
    }
}*/

public class Question19 {
    
}
