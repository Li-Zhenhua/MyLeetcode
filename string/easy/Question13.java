package string.easy;



/**
 * 给定一个罗马数字，将其转换成整数。输入确保在 1 到 3999 的范围内。
 * 
字符          数值
I             1
V             5
X             10
L             50
C             100
D             500
M             1000

 * I 可以放在 V (5) 和 X (10) 的左边，来表示 4 和 9。
 * X 可以放在 L (50) 和 C (100) 的左边，来表示 40 和 90。 
 * C 可以放在 D (500) 和 M (1000) 的左边，来表示 400 和 900。
 */

class Solution {
    public int romanToInt(String s) {
        char[] cs = s.toCharArray();
        int ans = 0;
        for (int i = 0; i < cs.length; i++) {
            switch (cs[i]) {
                case 'M':
                    ans +=1000;
                    break;
                case 'D':
                    ans +=500;
                    break;
                case 'C':
                    if(i == cs.length -1){
                        ans += 100;
                    }else if(cs[i+1] == 'M' || cs[i+1] == 'D'){
                        ans -= 100;
                    } else {
                        ans += 100;
                    }
                    break;
                case 'L':
                    ans +=50;
                    break; 
                case 'X':
                    if(i == cs.length -1){
                        ans += 10;
                    }else if(cs[i+1] == 'L' || cs[i+1] == 'C'){
                        ans -= 10;
                    } else {
                        ans += 10;
                    }
                    break;   
                case 'V':
                    ans +=5;
                    break;
                case 'I':
                    if(i == cs.length -1){
                        ans += 1;
                    } else if(cs[i+1] == 'V' || cs[i+1] == 'X'){
                        ans -= 1;
                    } else {
                        ans += 1;
                    }
                    break;  
                default:
                    break;
            }
        } 
        return ans;
    }
}

//别人的精简做法
//把一个小值放在大值的左边，就是做减法，否则为加法。
/*class Solution {
    public int romanToInt(String s) {
        int sum = 0;
        int preNum = getValue(s.charAt(0));
        for(int i = 1;i < s.length(); i ++) {
            int num = getValue(s.charAt(i));
            if(preNum < num) {
                sum -= preNum;
            } else {
                sum += preNum;
            }
            preNum = num;
        }
        sum += preNum;
        return sum;
    }
    
    private int getValue(char ch) {
        switch(ch) {
            case 'I': return 1;
            case 'V': return 5;
            case 'X': return 10;
            case 'L': return 50;
            case 'C': return 100;
            case 'D': return 500;
            case 'M': return 1000;
            default: return 0;
        }
    }
}*/


public class Question13 {
    
}
