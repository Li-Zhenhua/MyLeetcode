package hot100;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;

/**
 * 给定一个经过编码的字符串，返回它解码后的字符串。

编码规则为: k[encoded_string]，表示其中方括号内部的 encoded_string 正好重复 k 次。注意 k 保证为正整数。

你可以认为输入字符串总是有效的；输入字符串中没有额外的空格，且输入的方括号总是符合格式要求的。

此外，你可以认为原始数据不包含数字，所有的数字只表示重复的次数 k ，例如不会出现像 3a 或 2[4] 的输入。
 */

/*class Solution {
    public String decodeString(String s) {
        int n = s.length();
        Deque<String> stack = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        int index = 0;
        while(index < n){
            char c= s.charAt(index);
            if(Character.isDigit(c)){
                String dString = "" + c;
                while(Character.isDigit(s.charAt(++index))){
                    dString += s.charAt(index);
                }
                stack.push(dString);
            }else if(Character.isLetter(c) || c == '['){
                stack.push(String.valueOf(c));
                index++;
            }else{
                //注意这里不应该用sb，应该用linkedlist，把每个弹出的字符串看成一整个节点
                //StringBuilder sbTemp = new StringBuilder();
                LinkedList<String> list = new LinkedList<>();
                while(!"[".equals(stack.peek())){
                    //sbTemp.append(stack.pop());
                    list.add(stack.pop());
                }
                Collections.reverse(list);
                
                //将左括号移出栈
                stack.pop();
                //解析重复次数
                int repeatTime = Integer.parseInt(stack.pop());

                //String repeatString = sbTemp.toString();
                StringBuilder sbTemp = new StringBuilder();
                for (String string : list) {
                    sbTemp.append(string);
                }
                String repeatString = sbTemp.toString();

                sbTemp = new StringBuilder();
                for (int i = 0; i < repeatTime; i++) {
                    sbTemp.append(repeatString);
                }
                stack.push(sbTemp.toString());
                //注意记着把index递增
                index++;
            }
        }
        while(!stack.isEmpty()){
            sb.append(stack.removeLast());
        }
        return sb.toString();
    }
}*/

//别人的用栈的写法
/*class Solution {
    public String decodeString(String s) {
        StringBuilder res = new StringBuilder();
        int multi = 0;
        LinkedList<Integer> stack_multi = new LinkedList<>();
        LinkedList<String> stack_res = new LinkedList<>();
        for(Character c : s.toCharArray()) {
            if(c == '[') {
                stack_multi.addLast(multi);
                stack_res.addLast(res.toString());
                multi = 0;
                res = new StringBuilder();
            }
            else if(c == ']') {
                StringBuilder tmp = new StringBuilder();
                int cur_multi = stack_multi.removeLast();
                for(int i = 0; i < cur_multi; i++) tmp.append(res);
                res = new StringBuilder(stack_res.removeLast() + tmp);
            }
            else if(c >= '0' && c <= '9') multi = multi * 10 + Integer.parseInt(c + "");
            else res.append(c);
        }
        return res.toString();
    }
}*/

//递归做法
class Solution {
    String src;
    int ptr;

    public String decodeString(String s) {
        src = s;
        ptr = 0;
        return getString();
    }

    public String getString() {
        if (ptr == src.length() || src.charAt(ptr) == ']') {
            // String -> EPS
            return "";
        }

        char cur = src.charAt(ptr);
        int repTime = 1;
        String ret = "";

        if (Character.isDigit(cur)) {
            // String -> Digits [ String ] String
            // 解析 Digits
            repTime = getDigits(); 
            // 过滤左括号
            ++ptr;
            // 解析 String
            String str = getString(); 
            // 过滤右括号
            ++ptr;
            // 构造字符串
            while (repTime-- > 0) {
                ret += str;
            }
        } else if (Character.isLetter(cur)) {
            // String -> Char String
            // 解析 Char
            ret = String.valueOf(src.charAt(ptr++));
        }
        
        return ret + getString();
    }

    public int getDigits() {
        int ret = 0;
        while (ptr < src.length() && Character.isDigit(src.charAt(ptr))) {
            ret = ret * 10 + src.charAt(ptr++) - '0';
        }
        return ret;
    }
}

public class Q394 {
    
}
