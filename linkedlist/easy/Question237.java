package linkedlist.easy;

 /**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

 /**
 * 请编写一个函数，使其可以删除某个链表中给定的（非末尾）节点。
 * 传入函数的唯一参数为 要被删除的节点 。
 * 链表头结点为head
 * 
链表至少包含两个节点。
链表中所有节点的值都是唯一的。
给定的节点为非末尾节点并且一定是链表中的一个有效节点。
不要从你的函数中返回任何结果。
 */
class Solution {
    public void deleteNode(ListNode node) {
        //感觉是等同于将要删除的节点重新赋值
        //删除了给定节点的下一个节点
        node.val = node.next.val;
        node.next = node.next.next;
    }
}

public class Question237 {
    
}
