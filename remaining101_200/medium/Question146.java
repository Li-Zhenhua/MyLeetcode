package remaining101_200.medium;

import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

/**
 * 运用你所掌握的数据结构，设计和实现一个  LRU (最近最少使用) 缓存机制 。
实现 LRUCache 类：

LRUCache(int capacity) 以正整数作为容量 capacity 初始化 LRU 缓存
int get(int key) 如果关键字 key 存在于缓存中，则返回关键字的值，否则返回 -1 。
void put(int key, int value) 如果关键字已经存在，则变更其数据值；如果关键字不存在，则插入该组「关键字-值」。当缓存容量达到上限时，它应该在写入新数据之前删除最久未使用的数据值，从而为新的数据值留出空间。
 

进阶：你是否可以在 O(1) 时间复杂度内完成这两种操作？
 */
//双向链表 + hashmap，看的答案，学习学习，学会了才是自己的！
//java中有一个linkedHashMap就是这题内部封装好的数据结构
class LRUCache {
    class DoubleLinkedNode{
        int key;
        int val;
        DoubleLinkedNode prev;
        DoubleLinkedNode next;
        public DoubleLinkedNode(){

        }

        public DoubleLinkedNode(int key, int val){
            this.key = key;
            this.val = val;
        }
    }


    private int capacity;
    private int size; // 用于记录map中存在了多少个元素
    private Map<Integer,DoubleLinkedNode> cache = new HashMap<>();
    private DoubleLinkedNode headNode, tailNode;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        //哑头结点和尾结点
        headNode = new DoubleLinkedNode();
        tailNode = new DoubleLinkedNode();
        headNode.next = tailNode;
        tailNode.prev = headNode;
    }
    
    public int get(int key) {
        DoubleLinkedNode node = cache.get(key);
        if(node == null){
            return -1;
        }
        moveToHead(node);
        return node.val;
    }
    
    public void put(int key, int value) {
        DoubleLinkedNode node = cache.get(key);
        if(node == null){
            DoubleLinkedNode newNode = new DoubleLinkedNode(key,value);
            cache.put(key, newNode);
            addToHead(newNode);
            size++;
            //超出容量，删除最久未使用的节点
            if(size > capacity){
                DoubleLinkedNode tail = deleteTailNode();
                cache.remove(tail.key);
                size--;
            }
        }else{
            //此时key存在
            node.val = value;
            moveToHead(node);
        }
    }

    public void moveToHead(DoubleLinkedNode node){
        // node.prev.next = node.next;
        // node.next.prev = node.prev;
        deleteNode(node);
        addToHead(node);
    }

    public void addToHead(DoubleLinkedNode node){
        node.next = headNode.next;
        node.prev = headNode;
        headNode.next.prev = node;
        headNode.next = node;
    }

    public DoubleLinkedNode deleteTailNode(){
        DoubleLinkedNode deNode = tailNode.prev;
        // deNode.next.prev = deNode.prev;
        // deNode.prev.next = deNode.next;
        deleteNode(deNode);
        return deNode;
    }

    public void deleteNode(DoubleLinkedNode node){
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */

//根据测试数据大小将map转换成数组实现
/*class LRUCache {

    private static class DLNode {
        int key, value;
        DLNode prev, next;

        public DLNode() {
        }

        public DLNode(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private int capacity, size;
    private DLNode head, tail;
    private DLNode[] cache = new DLNode[3001];

    public LRUCache(int capacity) {
        this.size = 0;
        this.capacity = capacity;
        head = new DLNode();
        tail = new DLNode();
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        DLNode node = cache[key];
        if (node == null) {
            return -1;
        }
        removeNode(node);
        insertNode(node);
        return node.value;
    }

    private void removeNode(DLNode node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void insertNode(DLNode node) {
        node.next = head.next;
        head.next.prev = node;
        node.prev = head;
        head.next = node;
    }

    public void put(int key, int value) {
        DLNode node = cache[key];
        if (node == null) {
            insertNode(cache[key] = new DLNode(key, value));
            size++;
            if (size > capacity) {
                DLNode last = tail.prev;
                removeNode(last);
                cache[last.key] = null;
                size--;
            }
        } else {
            node.value = value;
            removeNode(node);
            insertNode(node);
        }
    }
}*/

public class Question146 {
    
}
