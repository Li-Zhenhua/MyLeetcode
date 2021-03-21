package stack.easy;
import java.util.Deque;
import java.util.LinkedList;
/**
 * 仅使用两个栈实现先入先出队列
 */
//哈哈，算是自己没有提示的情况下完成的比较好的第一个题
//虽然还是很菜但是也值得高兴一下
class MyQueue{
    Deque<Integer> stack1;
    Deque<Integer> stack2;
    public MyQueue(){
        stack1 = new LinkedList<>();
        stack2 = new LinkedList<>();
    }

    public void push(int x){
        if(stack1.isEmpty()){
            stack1.push(x);
        } else {
            while(!stack1.isEmpty()){
                stack2.push(stack1.pop());
            }
            stack2.push(x);
            while(!stack2.isEmpty()){
                stack1.push(stack2.pop());
            }
        }
    }

    public int pop(){
        return stack1.pop();
    }

    public int peek(){
        return stack1.peek();
    }   

    public boolean empty(){
        return stack1.isEmpty();
    }

}

public class Question232 {
    
}
