package 每日一题;

/**
 * 输入两个链表，找出它们的第一个公共节点。
 */

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
  * 注意：

如果两个链表没有交点，返回 null.
在返回结果后，两个链表仍须保持原有的结构。
可假定整个链表结构中没有循环。
程序尽量满足 O(n) 时间复杂度，且仅用 O(1) 内存。
本题与主站 160 题相同：https://leetcode-cn.com/problems/intersection-of-two-linked-lists/
  */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null) return null;
        ListNode currA = headA, currB = headB;
        while(currA.next != null || currB.next != null){
            if(currA.next == null){
                currA = headB;
                currB = currB.next;
                continue;
            }else if(currB.next == null){
                currB = headA;
                currA = currA.next;
                continue;
            }else if(currA == currB){
                return currA;
            }
            currA = currA.next;
            currB = currB.next;
        }
        //交点在最后一个位置时
        if(currA == currB){
            return currA;
        }
        return null;
    }
}

public class _7_21_剑指Q52 {
    
}
