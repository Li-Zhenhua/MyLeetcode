package string.medium;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 给你一个字符串表达式 s ，请你实现一个基本计算器来计算并返回它的值。

整数除法仅保留整数部分。

提示：

1 <= s.length <= 3 * 105
s 由整数和算符 ('+', '-', '*', '/') 组成，中间由一些空格隔开
s 表示一个 有效表达式
表达式中的所有整数都是非负整数，且在范围 [0, 2^31 - 1] 内
题目数据保证答案是一个 32-bit 整数
 */


 //略臃肿了
/*class Solution {
    public int calculate(String s) {
        Deque<Character> stack = new LinkedList<>();
        int n = s.length();
        for (int i = 0; i < n; i++) {
            if(s.charAt(i) == ' ') continue;
            if(s.charAt(i) == '*'){
                int temp = 0, factor = 1;
                while(!stack.isEmpty() && stack.peek() >= '0' && stack.peek() <= '9'){
                    temp += (stack.pop()-'0') * factor;
                    factor = factor * 10;
                }
                int index = i+1;
                int temp2 = 0;
                while(index < n){
                    //这样写是为了排除中间的空格
                    if(s.charAt(index) >= '0' && s.charAt(index) <= '9'){
                        temp2 = temp2*10 + (s.charAt(index)-'0');
                    }else if(s.charAt(index) == ' '){
                        
                    }else{
                        break;
                    }
                    index++;
                }
                String sTemp = String.valueOf(temp * temp2);
                for (int j = 0; j < sTemp.length(); j++) {
                    stack.push(sTemp.charAt(j));
                }
                i = index-1;
                continue;
            }else if(s.charAt(i) == '/'){
                int temp = 0, factor = 1;
                while(!stack.isEmpty() && stack.peek() >= '0' && stack.peek() <= '9'){
                    temp += (stack.pop()-'0') * factor;
                    factor = factor * 10;
                }
                int index = i+1;
                int temp2 = 0;
                while(index < n){
                    if(s.charAt(index) >= '0' && s.charAt(index) <= '9'){
                        temp2 = temp2*10 + (s.charAt(index)-'0');
                    }else if(s.charAt(index) == ' '){
                        
                    }else{
                        break;
                    }
                    index++;
                }
                String sTemp = String.valueOf(temp / temp2);
                for (int j = 0; j < sTemp.length(); j++) {
                    stack.push(sTemp.charAt(j));
                }
                i = index -1;
                continue;
            }
            stack.push(s.charAt(i));
        }
        int result = 0;
        int temp = 0, factor = 1;
        while(!stack.isEmpty()){
            
            if(stack.peek() >= '0' && stack.peek() <= '9'){
                temp += (stack.pop()-'0') * factor;
                factor = factor * 10;
                continue;
            }

            if(stack.peek() == '+'){
                result += temp;
                temp = 0;factor = 1;
                stack.pop();
                continue;
            }

            if(stack.peek() == '-'){
                result -= temp;
                temp = 0;factor = 1;
                stack.pop();
                continue;
            }
        }
        result += temp;
        return result;
    }
}*/

//官方简洁的写法，但是速度比上面自己写的慢了挺多的
// 加号：将数字压入栈；
// 减号：将数字的相反数压入栈；
// 乘除号：计算数字与栈顶元素，并将栈顶元素替换为计算结果
class Solution {
    public int calculate(String s) {
        Deque<Integer> stack = new LinkedList<Integer>();
        char preSign = '+';
        int num = 0;
        int n = s.length();
        for (int i = 0; i < n; ++i) {
            if (Character.isDigit(s.charAt(i))) {
                num = num * 10 + s.charAt(i) - '0';
            }
            if (!Character.isDigit(s.charAt(i)) && s.charAt(i) != ' ' || i == n - 1) {
                switch (preSign) {
                    case '+':
                        stack.push(num);
                        break;
                    case '-':
                        stack.push(-num);
                        break;
                    case '*':
                        stack.push(stack.pop() * num);
                        break;
                    default:
                        stack.push(stack.pop() / num);
                }
                preSign = s.charAt(i);
                num = 0;
            }
        }
        int ans = 0;
        while (!stack.isEmpty()) {
            ans += stack.pop();
        }
        return ans;
    }
}

public class Question227 {
    
}
