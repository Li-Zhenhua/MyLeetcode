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
  * 对链表进行插入排序。

  插入排序算法：

插入排序是迭代的，每次只移动一个元素，直到所有元素可以形成一个有序的输出列表。
每次迭代中，插入排序只从输入数据中移除一个待排序的元素，找到它在序列中适当的位置，并将其插入。
重复直到所有输入数据插入完为止。
  */
/*class Solution {
    public ListNode insertionSortList(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode dummyHead = new ListNode(Integer.MIN_VALUE,head);
        ListNode tail = dummyHead;//排序好的部分尾结点
        while(head != null){
            ListNode temp = head.next;
            //插入排序分情况
            if(head.val >= tail.val){
                tail.next = head;
                head.next = null;
                tail = head;
                head = temp;
            }else{
                ListNode curr = dummyHead;
                ListNode pre = dummyHead;
                while(curr.val < head.val){
                    pre = curr;
                    curr = curr.next;
                }
                pre.next = head;
                head.next = curr;
                head = temp;
            }
        }
        return dummyHead.next;
    }
}*/

//官方方法，思想和上面一样，但就简洁很多
class Solution {
    public ListNode insertionSortList(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode lastSorted = head, curr = head.next;
        while (curr != null) {
            if (lastSorted.val <= curr.val) {
                lastSorted = lastSorted.next;
            } else {
                ListNode prev = dummyHead;
                while (prev.next.val <= curr.val) {
                    prev = prev.next;
                }
                lastSorted.next = curr.next;
                curr.next = prev.next;
                prev.next = curr;
            }
            curr = lastSorted.next;
        }
        return dummyHead.next;
    }
}

public class Question147 {
    
}
