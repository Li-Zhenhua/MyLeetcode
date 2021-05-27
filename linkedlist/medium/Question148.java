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
  * 给你链表的头结点 head ，请将其按 升序 排列并返回 排序后的链表 。

进阶：

你可以在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序吗
  */

//快速排序  
//自顶向下归并排序
class Solution {
    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode leftHead = head;
        ListNode mid = getMidNode(head);
        ListNode rightHead = mid.next;
        mid.next = null;//将左右两边分开
        return mergeList(sortList(leftHead), sortList(rightHead));

    }

    public ListNode getMidNode(ListNode head){
        ListNode fast = head, slow = head;
        while(fast.next != null && fast.next.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    public ListNode mergeList(ListNode left,ListNode right){
        ListNode newHead = new ListNode(0);
        ListNode curr = newHead;
        while(left != null && right != null){
            if(left.val < right.val){
                curr.next = left;
                left = left.next;
            }else{
                curr.next = right;
                right = right.next;
            }
            curr = curr.next;
        }
        if(left != null){
            curr.next = left;
        }else if(right != null){
            curr.next = right;
        }
        return newHead.next;
    }
}

//自底向上
/**
 * 第一轮合并时intv = 1，即将整个链表切分为多个长度为1的单元，
 * 并按顺序两两排序合并，合并完成的已排序单元长度为2。
 * 
第二轮合并时intv = 2，即将整个链表切分为多个长度为2的单元，
并按顺序两两排序合并，合并完成已排序单元长度为4。

以此类推，直到单元长度intv >= 链表长度，代表已经排序完成。
 */
/*class Solution {
    public ListNode sortList(ListNode head) {
        ListNode h, h1, h2, pre, res;
        h = head;
        int length = 0, intv = 1;
        while (h != null) {
            h = h.next;
            length++;
        }
        res = new ListNode(0);
        res.next = head;
        while (intv < length) {
            pre = res;
            h = res.next;
            while (h != null) {
                int i = intv;
                h1 = h;
                while (i > 0 && h != null) {
                    h = h.next;
                    i--;
                }
                //当h1的节点数已经小于intv时，h2即为没有节点，故不需要合并
                if (i > 0) break;
                
                i = intv;
                h2 = h;
                while (i > 0 && h != null) {
                    h = h.next;
                    i--;
                }
                int c1 = intv, c2 = intv - i;
                while (c1 > 0 && c2 > 0) {
                    if (h1.val < h2.val) {
                        pre.next = h1;
                        h1 = h1.next;
                        c1--;
                    } else {
                        pre.next = h2;
                        h2 = h2.next;
                        c2--;
                    }
                    pre = pre.next;
                }
                pre.next = c1 == 0 ? h2 : h1;
                while (c1 > 0 || c2 > 0) {
                    pre = pre.next;
                    c1--;
                    c2--;
                }
                pre.next = h;
            }
            intv *= 2;
        }
        return res.next;
    }
}*/

public class Question148 {
    
}
