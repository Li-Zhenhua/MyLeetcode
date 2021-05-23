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
  * 存在一个按升序排列的链表，给你这个链表的头节点 head ，
  请你删除链表中所有存在数字重复情况的节点，
  只保留原始链表中 没有重复出现 的数字。

返回同样按升序排列的结果链表。
*/

//用三个指针记录
class Solution {
  public ListNode deleteDuplicates(ListNode head) {
    if(head == null || head.next == null) return head;
    ListNode dummyHead = new ListNode(0,head);
    ListNode pre = dummyHead;
    ListNode curr = head;
    ListNode next = head.next;
    //记录每个数值重复出现的次数
    int count = 0;
    while(curr != null){
      while(next != null && curr.val == next.val){
        next = next.next;
        count++;
      }

      if(count == 0){
        curr = curr.next;
        pre = pre.next;
      }else{
        curr = next;
        pre.next = next;
      }

      if(next != null){
        next = next.next;
      }
      count = 0;
    }
    return dummyHead.next;
  }
}

/*class Solution {
    public ListNode deleteDuplicates(ListNode head) {
      if(head == null || head.next == null) return head;
      ListNode dummyHead = new ListNode(0,head);
      ListNode curr = dummyHead;
      while(curr.next != null && curr.next.next != null){
        if(curr.next.val == curr.next.next.val){
          //记录每次遍历到的数的数值
          int num = curr.next.val;
          //使得所有数值相同的curr.next都最终能够被删除
          while(curr.next != null && curr.next.val == num){
            curr.next = curr.next.next;
          }
        }else{
          //此时一定不会定位在诸如 1 1 1 2 3 的第三个1上面
          curr = curr.next;
        }
  
      }
      return dummyHead.next;
    }
}*/

public class Question82 {
    
}
