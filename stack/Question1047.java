package stack;


/**
 * 给出由小写字母组成的字符串 S，重复项删除操作会选择两个相邻且相同的字母，并删除它们。

在 S 上反复执行重复项删除操作，直到无法继续删除。

在完成所有重复项删除操作后返回最终的字符串。答案保证唯一。

 */

 //这个慢应该是后面的reverse影响
/*class Solution {
    public String removeDuplicates(String S) {
        Stack<Character> stack = new Stack<>();
        for(char c : S.toCharArray()){
            if(stack.isEmpty()) stack.push(c);
            else{
                if(stack.peek().equals(c)){
                    stack.pop();
                    continue;
                }
                stack.push(c);
            }
        }
        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()){
            sb.append(stack.pop()); 
        }
        return sb.reverse().toString();
    }
}*/

class Solution {
    public String removeDuplicates(String S) {
        //char[] cs = new char[S.length()];
        StringBuilder sb = new StringBuilder();
        int count = -1;
        for(char c : S.toCharArray()){
            if(count == -1){
                 sb.append(c);
                 count++;            
            }
            else{
                if(sb.charAt(count) == c){
                    sb.deleteCharAt(count--);
                    continue;
                }
                sb.append(c);
                count++;
            }
        }
        return sb.toString();

    }
}

public class Question1047 {
    
}
