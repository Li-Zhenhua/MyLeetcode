package remaining200_gt.medium;

import java.lang.reflect.Array;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * 序列化二叉树的一种方法是使用前序遍历。
 * 当我们遇到一个非空节点时，我们可以记录下这个节点的值。
 * 如果它是一个空节点，我们可以使用一个标记值记录，例如 #
 * 
 * 给定一串以逗号分隔的序列，验证它是否是正确的二叉树的前序序列化。
 * 编写一个在不重构树的条件下的可行算法。

每个以逗号分隔的字符或为一个整数或为一个表示 null 指针的 '#' 。

你可以认为输入格式总是有效的
 */

 //剑指37题可以运用类似思想做,就相当于反序列化
/*class Solution {
    public boolean isValidSerialization(String preorder) {
        //if(preorder.length() == 0) return false;
        String[] numArray = preorder.split(",");
        Deque<String> stack = new ArrayDeque<>();
        //boolean count = false;
        stack.push(numArray[0]);
        for (int i = 1; i < numArray.length; i++) {
            // if(numArray[i].equals("#")){
            //     if(stack.peek().equals("#")){
            //         stack.pop();
            //         stack.pop(); 
            //     }
            //     //如果是#，不论前面一个栈中元素是否为#，
            //     //最后都会要将一个#加入栈中
            //     //除了最后一个元素
            //     if(i != numArray.length-1){
            //         stack.push("#");
            //     }
                
            // }else{
            //     stack.push(numArray[i]);
            // }
            if(!numArray[i].equals("#")){
                stack.push(numArray[i]);
                continue;
            }

            //当前numArray[i].equals("#")时
            while(!stack.isEmpty() && stack.peek().equals("#")){
                stack.pop();
                stack.pop(); 
            }
            
            if(i != numArray.length-1){
                stack.push("#");
            }
            

        }
        return stack.isEmpty();
    }
}*/

//优化空间，用一个计数就行，模拟栈中的个数
//定义一个概念，叫做槽位。
//一个槽位可以被看作「当前二叉树中正在等待被节点填充」的那些位置。

/*
如果遇到了空节点，则要消耗一个槽位；

如果遇到了非空节点，则除了消耗一个槽位外，还要再补充两个槽位。（因为非空节点有两个子节点）
 */
class Solution {
    public boolean isValidSerialization(String preorder) {
        int n = preorder.length();
        int i = 0;
        int slots = 1;
        while (i < n) {
            if (slots == 0) {
                return false;
            }
            if (preorder.charAt(i) == ',') {
                i++;
            } else if (preorder.charAt(i) == '#'){
                slots--;
                i++;
            } else {
                // 读一个数字
                while (i < n && preorder.charAt(i) != ',') {
                    i++;
                }
                slots++; // slots = slots - 1 + 2
            }
        }
        return slots == 0;
    }
}

public class Question331 {
    
}
