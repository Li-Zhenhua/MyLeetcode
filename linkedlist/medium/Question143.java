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
 * 给定一个单链表 L：L0→L1→…→Ln-1→Ln ， 将其重新排列后变为： L0→Ln→L1→Ln-1→L2→Ln-2→…
 * 
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 */

 //最初的想法，用一个map
/*class Solution {
	public void reorderList(ListNode head) {
		if (head == null || head.next == null || head.next.next == null) return;
		ListNode curr = head;
		Map<Integer,ListNode> map = new HashMap<>();
		int count = 0;
		while(curr != null){
			count++;
			map.put(count,curr);
			curr = curr.next;
		}
		curr = head;
		int n = 1;
		while(n < (count+1)/2 ){
			ListNode insertNode = map.get(count+1-n);
			ListNode temp = curr.next;
			curr.next = insertNode;
			insertNode.next = temp;
			curr = temp;
			n++;
		}
		if(count % 2 == 0){
			curr.next.next = null;
		}else{
			curr.next = null;
		}

		return;
    }
}*/

//看了官方题解的思路写的
//寻找链表中点 + 链表逆序 + 合并链表
class Solution {
    public void reorderList(ListNode head) {
		
	}
}

//迭代的方法，学一下写法
/*public void reorderList(ListNode head) {

    if (head == null || head.next == null || head.next.next == null) {
        return;
    }
    int len = 0;
    ListNode h = head;
    //求出节点数
    while (h != null) {
        len++;
        h = h.next;
    }

    reorderListHelper(head, len);
}

private ListNode reorderListHelper(ListNode head, int len) {
    if (len == 1) {
        ListNode outTail = head.next;
        head.next = null;
        return outTail;
    }
    if (len == 2) {
        ListNode outTail = head.next.next;
        head.next.next = null;
        return outTail;
    }
    //得到对应的尾节点，并且将头结点和尾节点之间的链表通过递归处理
    ListNode tail = reorderListHelper(head.next, len - 2);
    ListNode subHead = head.next;//中间链表的头结点
    head.next = tail;
    ListNode outTail = tail.next;  //上一层 head 对应的 tail
    tail.next = subHead;
    return outTail;
}*/

public class Question143 {

}
