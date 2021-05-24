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
 * 给你一个链表的头节点 head 和一个特定值 x ，
 * 请你对链表进行分隔，使得所有 小于 x 的节点都出现在 大于或等于 x 的节点之前。

你应当 保留 两个分区中每个节点的初始相对位置。
 */

//第一反应就是像下面这样构造两个链表，再连接起来
/*class Solution {
    public ListNode partition(ListNode head, int x) {
        if(head == null || head.next == null) return head;
        //小于x的数构成的链表
        ListNode dummyHead1 = new ListNode(0);
        //大于等于x的数构成的链表
        ListNode dummyHead2 = new ListNode(0);
        ListNode cur1 = dummyHead1;
        ListNode cur2 = dummyHead2;
        while(head != null){
            if(head.val < x){
                cur1.next = head;
                cur1 = cur1.next;
            }else{
                cur2.next = head;
                cur2 = cur2.next;
            }
            head = head.next;
        }
        //将大于等于x的数构成的链表连接到小于x的数构成的链表之后
        cur1.next = dummyHead2.next;
        //注意将于等于x的数构成的链表的最后一个节点的next置为null
        cur2.next = null;
        return dummyHead1.next;
    }
}*/

//别人的分情况讨论方法
//直接更改原始链表的节点链接
class Solution {
    public ListNode partition(ListNode head, int x) {
        if (head == null || head.next == null){
            return head;
        }
        ListNode firstHead = new ListNode(-101);
        firstHead.next = head;
        ListNode cur = firstHead,pre = firstHead,p = firstHead.next,pt = firstHead;
        while (p != null){
            //当都是连续小于x或者大于等于x的情况下直接移动到下一个位置即可
            if (pre.val < x && p.val < x){
                p = p.next;
                cur = cur.next;
                pre = pre.next;
                continue;
            }
            if ((pre.val >= x && p.val >= x )||(pre.val < x && p.val >= x) ){
                p = p.next;
                pre = pre.next;
                continue;
            }
            
            if (pre.val >= x && p.val < x){
                
                //存储原始链表的下一个节点
                pt = p.next;
                //这里将找到的每一个小于x的节点指向大于等于x的第一个节点
                //后续再找到另一个小于x的节点时再重新将该节点指向下一个小于x的节点
                //而此时下一个小于x的节点又将指向大于等于x的第一个节点
                //妙啊！
                p.next = cur.next;
                cur.next = p;

                cur = cur.next;
                pre.next = pt;
                p = pt;
                continue;
            }

        }
        return firstHead.next;
    }
}

public class Question86 {
    
}
