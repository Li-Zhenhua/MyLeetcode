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
  * 给定一个单链表，把所有的奇数节点和偶数节点分别排在一起。
  请注意，这里的奇数节点和偶数节点指的是节点编号的奇偶性，而不是节点的值的奇偶性。

请尝试使用原地算法完成。你的算法的空间复杂度应为 O(1)，
时间复杂度应为 O(nodes)，nodes 为节点总数。
  */
/*class Solution {
    public ListNode oddEvenList(ListNode head) {
        if(head == null || head.next == null || head.next.next == null) return head;
        int count = 0;
        ListNode curr = head;
        ListNode evenHead = head.next;
        //ListNode pre = head;
        while(curr.next != null){
            ListNode temp = curr.next;
            curr.next = temp.next;
            //pre = curr;
            curr = temp;
            count++;
        }

        //奇数时
        if(count % 2 == 0){
            //ListNode temp = curr.next;
            curr.next = evenHead;
        }else{
            //偶数时
            curr = head;
            while(curr.next != null){
                curr = curr.next;
            }
            curr.next = evenHead;
            //pre.next = evenHead;
        }
        return head;

    }
}*/

//官方方法，简洁多了orz
class Solution {
    public ListNode oddEvenList(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode evenHead = head.next;
        ListNode odd = head, even = evenHead;
        while (even != null && even.next != null) {
            odd.next = even.next;
            odd = odd.next;
            even.next = odd.next;
            even = even.next;
        }
        odd.next = evenHead;
        return head;
    }
}

public class Question328 {
    
}
