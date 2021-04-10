package linkedlist.easy;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */

 /**
  * 编写一个程序，找到两个单链表相交的起始节点
  如果两个链表没有交点，返回 null.
在返回结果后，两个链表仍须保持原有的结构。
可假定整个链表结构中没有循环。
程序尽量满足 O(n) 时间复杂度，且仅用 O(1) 内存。

  */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        
    }
}

//官方双指针法
//题解：设链表A的长度为a+c，链表B的长度为b+c，a为链表A不公共部分，b为链表B不公共部分，c为链表A、B的公共部分
//将两个链表连起来，A->B和B->A，长度之和：a+c+b+c=b+c+a+c，
//若链表AB相交，则a+c+b与b+c+a就会抵消，它们就会在c处相遇；
//若不相交，则c为0，则a+b=b+a，它们各自移动到尾部循环结束，即返回null
/*public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
    if (headA == null || headB == null) return null;
    ListNode pA = headA, pB = headB;
    while (pA != pB) {
        pA = pA == null ? headB : pA.next;
        pB = pB == null ? headA : pB.next;
    }
    return pA;
}*/


public class Question160 {
    
}
