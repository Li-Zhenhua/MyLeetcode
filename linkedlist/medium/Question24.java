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
  * 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。

你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
  */
/*class Solution {
    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode pre = new ListNode(0,head);
        ListNode curr = head;
        ListNode next;
        ListNode start = head.next; //记录修改后链表的头结点，节点数大于1则一定是原始链表的第二个节点
        int count = 0;
        while(curr != null){
            //记录原来链表下一个节点
            next = curr.next;
            //奇数位置
            if(count % 2 == 0){
                if(curr.next == null) {
                    //这里空只是为了能够进行下面的判断
                }else if(curr.next.next == null){
                    curr.next = null;
                }else if(curr.next.next.next == null){
                    curr.next = curr.next.next;
                }else{
                    curr.next = curr.next.next.next;
                }
            }else{//偶数位置
                curr.next = pre;
            }
            count++;
            pre = curr;
            curr = next;
        }
        return start;
    }
}*/

//更简洁的迭代方法
//每次需要交换 temp 后面的两个节点
//如果 temp 的后面没有节点或者只有一个节点，则没有更多的节点需要交换，因此结束交换。
//否则，获得 temp 后面的两个节点 node1 和 node2，通过更新节点的指针关系实现两两交换节点
//交换之前的节点关系是 temp -> node1 -> node2，
//交换之后的节点关系要变成 temp -> node2 -> node1
class Solution {
    public ListNode swapPairs(ListNode head) {
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode temp = dummyHead;
        while (temp.next != null && temp.next.next != null) {
            ListNode node1 = temp.next;//原来的链表的下一个节点
            ListNode node2 = temp.next.next;
            temp.next = node2;
            node1.next = node2.next;
            node2.next = node1;
            temp = node1;//链表变成temp -> node2 -> node1后temp相当于跳了两步，正好符合两两一组
        }
        return dummyHead.next;
    }
}


//递归方法
/*class Solution {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = head.next;//以两两一组为例，记录第二个节点地址
        head.next = swapPairs(newHead.next);//更新第一个节点指向的位置
        newHead.next = head;//更新第二个节点指向的位置
        return newHead;
    }
}*/


public class Question24 {
    
}
