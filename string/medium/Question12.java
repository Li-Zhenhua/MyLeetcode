package string.medium;

/**联合13题一起看
 * 给你一个整数，将其转为罗马数字。
 * 
字符          数值
I             1
V             5
X             10
L             50
C             100
D             500
M             1000

I 可以放在 V (5) 和 X (10) 的左边，来表示 4 和 9。
X 可以放在 L (50) 和 C (100) 的左边，来表示 40 和 90。 
C 可以放在 D (500) 和 M (1000) 的左边，来表示 400 和 900。

注：1 <= num <= 3999
 */

/*class Solution {
    StringBuilder sb = new StringBuilder();
    public String intToRoman(int num) {   
        int i = 0;
        while(num > 0){
            int temp = num % 10;
            addString(i, temp);
            num = num / 10;
            i++;
        }
        return sb.reverse().toString();
    }

    public void addString(int i, int index){
        char c1;
        char c2;
        char c3;
        if(i == 0){
            c1 = 'I';
            c2 = 'V';
            c3 = 'X';
        }else if(i == 1){
            c1 = 'X';
            c2 = 'L';
            c3 = 'C';
        }else if(i == 2){
            c1 = 'C';
            c2 = 'D';
            c3 = 'M';
        }else{
            c1 = 'M';
            c2 = 'M';
            c3 = 'M';
        }
        switchCase(c1, c2, c3, index);
    }

    public void switchCase(char c1, char c2, char c3, int index){
        switch(index){
            case 0: break;
            case 1: sb.append(c1);break;
            case 2: sb.append(c1);sb.append(c1);break;
            case 3: sb.append(c1);sb.append(c1);sb.append(c1);break;
            case 4: sb.append(c2);sb.append(c1);break;
            case 5: sb.append(c2);break;
            case 6: sb.append(c1);sb.append(c2);break;
            case 7: sb.append(c1);sb.append(c1);sb.append(c2);break;
            case 8: sb.append(c1);sb.append(c1);sb.append(c1);sb.append(c2);break;
            case 9: sb.append(c3);sb.append(c1);break;
            default: break;
        }
    }
}*/

//官方办法，比我简洁多了orz
//直接从高往低减
class Solution {
    int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
    String[] symbols = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

    public String intToRoman(int num) {
        StringBuffer roman = new StringBuffer();
        for (int i = 0; i < values.length; ++i) {
            int value = values[i];
            String symbol = symbols[i];
            while (num >= value) {
                num -= value;
                roman.append(symbol);
            }
            if (num == 0) {
                break;
            }
        }
        return roman.toString();
    }
}


public class Question12 {
    
}
