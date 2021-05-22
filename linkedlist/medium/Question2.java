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
 * 给你两个 非空 的链表，表示两个非负的整数。
 * 它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。

请你将两个数相加，并以相同形式返回一个表示和的链表。

你可以假设除了数字 0 之外，这两个数都不会以 0 开头。

提示：

每个链表中的节点数在范围 [1, 100] 内
0 <= Node.val <= 9
题目数据保证列表表示的数字不含前导零
 */

 //因为位数大，换种方式做
/*class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        //注意这里有可能溢出的！！！节点个数最大100
        long num1 = getNum(l1);
        long num2 = getNum(l2);
        num1 = num1 + num2;
        ListNode ans = new ListNode(num1 % 10);
        ListNode start = ans;
        num1 /= 10;
        while(num1 != 0){
            ans.next = new ListNode(num1 % 10);
            num1 /= 10;
            ans = ans.next;
        }
        return start;
    }

    public long getNum(ListNode l){
        long num = 0,factor = 1;
        while(l != null){
            num += l.val * factor;
            factor *= 10;
            l = l.next;
        }
        return num;
    }
}*/

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        //利用l1链表存储答案
        ListNode ans = l1;
        int carry = (l1.val + l2.val) / 10;
        l1.val = (l1.val + l2.val) % 10 ;

        while(l1.next != null && l2.next != null){
            l1 = l1.next;
            l2 = l2.next;
            int sum = l1.val + l2.val + carry;
            l1.val = sum % 10 ;
            carry = sum / 10;
        }

        while(l1.next != null){
            l1 = l1.next;
            int sum = l1.val + carry;
            l1.val = sum % 10 ;
            carry = sum / 10;
        }

        //当只有l1为空时,切换链表指到l2去
        if(l2.next != null){
            l1.next = l2.next;
            while(l1.next != null){
                l1 = l1.next;
                int sum = l1.val + carry;
                l1.val = sum % 10 ;
                carry = sum / 10;
            }
        }

        //当最后出现进位导致多一位数的情况时
        if(carry != 0){
            l1.next = new ListNode(carry);
        }
        return ans;
    }
}
public class Question2 {
    
}
