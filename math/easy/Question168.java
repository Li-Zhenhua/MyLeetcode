package math.easy;

/**
 * 给定一个正整数，返回它在 Excel 表中相对应的列名称。
 * 
 * 1 -> A
    2 -> B
    3 -> C
    ...
    26 -> Z
    27 -> AA
    28 -> AB 
*/

class Solution {
    public String convertToTitle(int columnNumber) {
        StringBuilder sb = new StringBuilder();
        int i;
        while(columnNumber > 0){
            /*i = columnNumber % 26;
            if(i == 0){
                sb.append('Z');
                columnNumber = columnNumber / 26 - 1;//整除的时候需要找另外的规律
            }else{
                sb.append((char)('A'+i-1));
                columnNumber = columnNumber / 26;
            }*/

            //另一种整合的方法
            columnNumber--;
            i = columnNumber % 26;
            sb.append((char)('A' + i));
            columnNumber = columnNumber / 26;
        }
        return sb.reverse().toString();
    }
}

public class Question168 {
    
}
