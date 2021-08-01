package hot100;

import java.util.PriorityQueue;

/**
 * 给你一个链表数组，每个链表都已经按升序排列。

请你将所有链表合并到一个升序链表中，返回合并后的链表。
 */

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

 //第一想法是两两合并,但是好像挺复杂的
 //然后想到了优先队列，直接小根堆完事
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists == null || lists.length == 0) return null;
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a,b) -> {
            return a.val - b.val;
        });

        for (int i = 0; i < lists.length; i++) {
            ListNode temp = lists[i];
            while(temp != null){
                pq.offer(temp);
                temp = temp.next;
            }
        }

        ListNode dummyHead = new ListNode(0);
        ListNode curr = dummyHead;
        while(!pq.isEmpty()){
            curr.next = pq.poll();
            curr = curr.next;
        }
        //最后一个节点的next置为空
        curr.next = null;

        return dummyHead.next;
    }
}

public class Q23 {
    
}
