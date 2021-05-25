package linkedlist.medium;

/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */

 /**
  * 给定一个链表，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。

为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置
（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。
注意，pos 仅仅是用于标识环的情况，并不会作为参数传递到函数中。

说明：不允许修改给定的链表。

进阶：

你是否可以使用 O(1) 空间解决此题？
  */

//之前有道题的题解有证明来着，一时半会儿忘了在哪
//回头找证明
public class Solution {
    public ListNode detectCycle(ListNode head) {
        if(head == null || head.next == null) return null;
        ListNode dummyHead = new ListNode(0,head);
        ListNode slow = dummyHead;
        ListNode fast = dummyHead;
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow){
                //快慢指针相遇之后，将快指针重置回哑巴头结点
                //并将步长变成1，
                fast = dummyHead;
                while(fast != slow){
                    fast = fast.next;
                    slow = slow.next;
                }
                //当快慢指针再次相遇，相遇点即为入口
                return fast;
            }
        }
        return null;
    }
}

public class Question142 {
    
}
