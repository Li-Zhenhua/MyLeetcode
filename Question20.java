import java.util.ArrayDeque;
import java.util.Deque;

//吐槽一下，这题的官方题解效果咋这么差 
class Solution{
     public boolean isValid(String s){
          //Stack<String> stack = new Stack<>();建议用deque
          Deque<Character> stack = new ArrayDeque<>();
          for(char c : s.toCharArray() ){
              if(c == '(' || c == '{' || c == '['){
                 stack.push(c); 
              }else if(c == ')'){
                 if(stack.isEmpty() || stack.pop() != '(') return false;
              }else if(c == '}'){
                 if(stack.isEmpty() || stack.pop() != '{') return false;
              }else if(c == ']'){
                 if(stack.isEmpty() || stack.pop() != '[') return false;
              }
          }
          if(!stack.isEmpty())
               return false;
          return true;
     }
}

//看别人的方法1
/*class Solution {
     public boolean isValid(String s) {
         Stack<Character>stack = new Stack<Character>();
         for(char c: s.toCharArray()){
             if(c=='(')stack.push(')');
             else if(c=='[')stack.push(']');
             else if(c=='{')stack.push('}');
             else if(stack.isEmpty()||c!=stack.pop())return false;
         }
         return stack.isEmpty();
     }
 }*/

 //看别人的方法1，思路挺好，就是效率有点低
 /*class Solution {
     public boolean isValid(String s) {
         int length = s.length() / 2;
           for (int i = 0; i < length; i++) {
                s = s.replace("()", "").replace("{}", "").replace("[]", "");
           }
 
           return s.length() == 0;
     }
 }*/

public class Question20{
     public static void main(String[] args) {
          Solution test = new Solution();
          String s = new String("[({}]");
          System.out.println(test.isValid(s));
     }
}
