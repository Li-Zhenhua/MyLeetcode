package linkedlist.easy;

import java.util.ArrayList;

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
 * 请判断一个链表是否为回文链表。
 */
//不太会orz
//方法一：复制到数组中再双指针法，栈的思想也是一样
/*class Solution {
    public boolean isPalindrome(ListNode head) {
        //if(head == null) return true;测试集head非空
        ArrayList<Integer> list = new ArrayList<>();
        while(head != null){
            list.add(head.val);
            head = head.next;
        }
        int prev = 0;
        int back = list.size()-1;
        while(prev < back){
            if(list.get(prev) == list.get(back)){
                prev++;
                back--;
                continue;
            }else{
                return false;
            }
        }
        return true;
    }
}*/

//方法二：快慢指针法找中点,同时构造半个翻转链表
class Solution {
    public boolean isPalindrome(ListNode head) {
        if(head.next == null) return true;
        ListNode slow = head;
        ListNode fast = head;
        ListNode prev = null,curr = null;
        while(fast != null && fast.next != null){
            curr = slow;
            //先得保证slow不受curr影响
            slow = slow.next;
            fast = fast.next.next;
            curr.next = prev;
            prev = curr;
        }
        //奇数链表时，中位数可以不算入
        if(fast != null){
            slow = slow.next;
        }
        while(slow != null){//对称所以只用判断一个
            if(slow.val == curr.val){
                slow = slow.next;
                curr = curr.next;
            }else{
                return false;
            }
        }
        return true;
    }
}

//方法三：递归，启发于逆序链表打印
/* private void printListNode(ListNode head) {
    if (head == null)
        return;
    printListNode(head.next);
    System.out.println(head.val);
} */

/*ListNode temp;//正向遍历的全局节点

public boolean isPalindrome(ListNode head) {
    temp = head;
    return check(head);
}

private boolean check(ListNode head) {
    if (head == null)
        return true;
    boolean res = check(head.next) && (temp.val == head.val);
    temp = temp.next;
    return res;
}*/


public class Question234 {
    
}
