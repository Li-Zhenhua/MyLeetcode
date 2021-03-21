package stack.easy;
import java.util.LinkedList;
import java.util.Stack;

class MinStack{
    Stack<Integer> stack;
    LinkedList<Integer> min ;
    public MinStack(){
        stack = new Stack<>();    
        min = new LinkedList<>();
    }

    public void push(int x){
        if(stack.isEmpty()){
            stack.push(x);
            min.addLast(x);
        } else {
            stack.push(x);
            if(x<=min.peekLast())
                min.addLast(x);
        }    

    }

    public void pop() {
        if(stack.isEmpty()) System.out.println("栈空");
        else{
            //注意这里Integer类型要用equals，不能用==
            if(stack.peek().equals(min.peekLast())){
                stack.pop();
                min.pollLast();
            } else {
                stack.pop();
            }   
        }
    }

    public int top(){
        return stack.peek();
    }

    public int getMin(){
        return min.peekLast();
    }
}
//英文leetcode高票答案
/*class MinStack {
    private Node head;
    
    public void push(int x) {
        if(head == null) 
            head = new Node(x, x);
        else 
            head = new Node(x, Math.min(x, head.min), head);
    }

    public void pop() {
        head = head.next;
    }

    public int top() {
        return head.val;
    }

    public int getMin() {
        return head.min;
    }
    
    private class Node {
        int val;
        int min;
        Node next;
        
        private Node(int val, int min) {
            this(val, min, null);
        }
        
        private Node(int val, int min, Node next) {
            this.val = val;
            this.min = min;
            this.next = next;
        }
    }
}*/
