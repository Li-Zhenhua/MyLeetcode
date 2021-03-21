package stack;

import java.util.ArrayList;
/**
 * 整数 x - 表示本回合新获得分数 x
"+" - 表示本回合新获得的得分是前两次得分的总和。题目数据保证记录此操作时前面总是存在两个有效的分数。
"D" - 表示本回合新获得的得分是前一次得分的两倍。题目数据保证记录此操作时前面总是存在一个有效的分数。
"C" - 表示前一次得分无效，将其从记录中移除。题目数据保证记录此操作时前面总是存在一个有效的分数。

示例：
输入：ops = ["5","2","C","D","+"]
输出：30
解释：
"5" - 记录加 5 ，记录现在是 [5]
"2" - 记录加 2 ，记录现在是 [5, 2]
"C" - 使前一次得分的记录无效并将其移除，记录现在是 [5].
"D" - 记录加 2 * 5 = 10 ，记录现在是 [5, 10].
"+" - 记录加 5 + 10 = 15 ，记录现在是 [5, 10, 15].
所有得分的总和 5 + 10 + 15 = 30
 */

class Solution{
    public int calPoints(String[] ops){
        ArrayList<Integer> aList = new ArrayList<>();
        int index = -1;
        int sum = 0;
        for (String s : ops) {
            switch (s) {
                case "+":
                    aList.add(aList.get(index) + aList.get(index-1));
                    index++;
                    break;
                case "C":
                    aList.remove(index);
                    index--;
                    break;
                case "D":
                    aList.add(aList.get(index) * 2);
                    index++;
                    break;
                default:
                    aList.add(Integer.parseInt(s));
                    index++;
                    break;
            }
        }
        for (int i = 0; i < aList.size(); i++) {
            sum = sum + aList.get(i);
        }
        
        return sum;
    }
}

//别人的方法用数组好像性能好一点
/*
class Solution {
    public int calPoints(String[] ops) {
        //数组长度
        int length = ops.length;

        //建立一个数字数组，用来存储每次的操作结果
        int[] num = new int[length];
        //数字数组的当前下标
        int index = 0;

        //遍历符号数组
        for(int i = 0; i < length; i++)
        {
            //当前符号为“C”，需要清除一个数字
            if(ops[i].equals("C"))
            {
                //下标回退一格，且回退后位置上的数字置零
                index --;
                num[index] = 0;
            }
            //当前符号为“D”，需要翻倍
            else if(ops[i].equals("D"))
            {
                //当前数字等于前一个数字的两倍
                num[index] = 2 * num[index - 1];
                index ++;
            }
            //当前符号为“+”，需要相加
            else if(ops[i].equals("+"))
            {
                //当前数字等于前两个数字之和
                num[index] = num[index - 1] + num[index - 2];
                index ++;
            }
            //当前符号为数字，直接填入数字数组
            else
            {
                num[index] = Integer.parseInt(ops[i]);
                index ++;
            }
        }

        //对数字数组进行求和
        int sum = 0;
        for(int j = 0; j < length; j++)
        {
            sum += num[j];
        }

        return sum;

    }
}*/


public class Question682 {
    
}
