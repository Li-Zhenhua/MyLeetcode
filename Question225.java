import java.util.Deque;
import java.util.LinkedList;

//刚开始的时候不太会，看了看提示
//用一个queue2接收入栈元素，然后将queue1元素加到queue2后面
//最后交换queue1和queue2
class MyStack{
    Deque<Integer> queue1 = new LinkedList<>();
    Deque<Integer> queue2 = new LinkedList<>();
    public MyStack(){

    }
    
    public void push(int x){
        if(queue1.isEmpty())
            queue1.offer(x);
        else{
            queue2.offer(x);
            while(!queue1.isEmpty()){
                queue2.offer(queue1.poll());
            }
            Deque<Integer> temp = queue1;
            queue1 = queue2;
            queue2 = temp;
        }

    }

    public int pop(){
        return queue1.poll();
    }

    public int top(){
        return queue1.peek();
    }

    public boolean empty(){
        return queue1.isEmpty();
    }
}

