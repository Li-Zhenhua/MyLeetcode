package stack.medium;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 
根据 逆波兰表示法，求表达式的值。

有效的算符包括 +、-、*、/ 。
每个运算对象可以是整数，也可以是另一个逆波兰表达式。

逆波兰表达式：

逆波兰表达式是一种后缀表达式，所谓后缀就是指算符写在后面。

平常使用的算式则是一种中缀表达式，如 ( 1 + 2 ) * ( 3 + 4 ) 。
该算式的逆波兰表达式写法为 ( ( 1 2 + ) ( 3 4 + ) * ) 。
 */

 //栈
class Solution {
    public int evalRPN(String[] tokens) {
        Deque<Integer> stack = new ArrayDeque<>();
        for (String token : tokens) {
            if("+".equals(token)){
                int num1 = stack.pop();
                int num2 = stack.pop();
                num1 = num1 + num2;
                stack.push(num1);
            }else if("-".equals(token)){
                int num1 = stack.pop();
                int num2 = stack.pop();
                num1 = num2 - num1;
                stack.push(num1);
            }else if("*".equals(token)){
                int num1 = stack.pop();
                int num2 = stack.pop();
                num1 = num1 * num2;
                stack.push(num1);
            }else if("/".equals(token)){
                int num1 = stack.pop();
                int num2 = stack.pop();
                num1 = num2 / num1;
                stack.push(num1);
            }else{
                stack.push(Integer.parseInt(token));
            }
        }
        return stack.pop();
    }
}

public class Question150 {
    
}
