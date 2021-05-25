package linkedlist.medium;

import java.util.HashMap;
import java.util.Map;

/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

/**
 * 给你一个长度为 n 的链表，每个节点包含一个额外增加的随机指针 random ，
 * 该指针可以指向链表中的任何节点或空节点。

构造这个链表的 深拷贝。 深拷贝应该正好由 n 个 全新 节点组成，
其中每个新节点的值都设为其对应的原节点的值。
新节点的 next 指针和 random 指针也都应指向复制链表中的新节点，
并使原链表和复制链表中的这些指针能够表示相同的链表状态。
复制链表中的指针都不应指向原链表中的节点 。

例如，如果原链表中有 X 和 Y 两个节点，其中 X.random --> Y 。
那么在复制链表中对应的两个节点 x 和 y ，同样有 x.random --> y 。

返回复制链表的头节点。

用一个由 n 个节点组成的链表来表示输入/输出中的链表。
每个节点用一个 [val, random_index] 表示：

val：一个表示 Node.val 的整数。
random_index：随机指针指向的节点索引（范围从 0 到 n-1）；
如果不指向任何节点，则为  null 。
你的代码 只 接受原链表的头节点 head 作为传入参数。
 */

class Solution {
    //map存储一个新旧节点的键值对
    Map<Node,Node> map = new HashMap<>();
    public Node copyRandomList(Node head) {
        if(head == null) return null;
        //else if(head.next == null) return new Node(head.val);
        if(map.containsKey(head)) return map.get(head);

        Node newHead = new Node(head.val);
        map.put(head, newHead);
        newHead.next = copyRandomList(head.next);
        newHead.random = copyRandomList(head.random);
        return newHead;
    }
}

//官方构造新旧节点交错的链表，很巧妙
/*class Solution {
    public Node copyRandomList(Node head) {
  
      if (head == null) {
        return null;
      }
  
      // Creating a new weaved list of original and copied nodes.
      Node ptr = head;
      while (ptr != null) {
  
        // Cloned node
        Node newNode = new Node(ptr.val);
  
        // Inserting the cloned node just next to the original node.
        // If A->B->C is the original linked list,
        // Linked list after weaving cloned nodes would be A->A'->B->B'->C->C'
        newNode.next = ptr.next;
        ptr.next = newNode;
        ptr = newNode.next;
      }
  
      ptr = head;
  
      // Now link the random pointers of the new nodes created.
      // Iterate the newly created list and use the original nodes' random pointers,
      // to assign references to random pointers for cloned nodes.
      while (ptr != null) {
        ptr.next.random = (ptr.random != null) ? ptr.random.next : null;
        ptr = ptr.next.next;
      }
  
      // Unweave the linked list to get back the original linked list and the cloned list.
      // i.e. A->A'->B->B'->C->C' would be broken to A->B->C and A'->B'->C'
      Node ptr_old_list = head; // A->B->C
      Node ptr_new_list = head.next; // A'->B'->C'
      Node head_old = head.next;
      while (ptr_old_list != null) {
        ptr_old_list.next = ptr_old_list.next.next;
        ptr_new_list.next = (ptr_new_list.next != null) ? ptr_new_list.next.next : null;
        ptr_old_list = ptr_old_list.next;
        ptr_new_list = ptr_new_list.next;
      }
      return head_old;
    }
}*/

public class Question138 {
    
}
