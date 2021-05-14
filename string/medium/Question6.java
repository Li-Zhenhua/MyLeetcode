package string.medium;

/**
 * 将一个给定字符串 s 根据给定的行数 numRows ，以从上往下、从左到右进行 Z 字形排列。

比如输入字符串为 "PAYPALISHIRING" 行数为 3 时，排列如下：

P   A   H   N
A P L S I I G
Y   I   R
之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："PAHNAPLSIIGYIR"。

请你实现这个将字符串进行指定行数变换的函数：

string convert(string s, int numRows);
 */

 //咋感觉是数学题呢。。。。就是找规律
class Solution {
    public String convert(String s, int numRows) {
        if(numRows == 1) return s;
        int n = s.length();
        int skip = 2*(numRows-1);
        StringBuilder sb = new StringBuilder();
        //第一行
        for (int i = 0; i < n; i = i + skip) {
            sb.append(s.charAt(i));
        }
        //后面几行
        for (int i = 1; i < skip/2; i++) {
            //int skipIter = skip;
            int j = i;
            int k = skip - i;
            while(j < n && k < n){
                sb.append(s.charAt(j));
                sb.append(s.charAt(k));
                j = j + skip;
                k = k + skip;
            }
            //若最后j<n而k>n时
            if(j < n){
                sb.append(s.charAt(j));
            }
        }

        //最后一行
        for (int i = skip/2; i < n; i = i + skip) {
            sb.append(s.charAt(i));
        }
        return sb.toString();
    }
}

//官方比较直接的做法，就是到底或到底了转换方向
/*class Solution {
    public String convert(String s, int numRows) {

        if (numRows == 1) return s;

        List<StringBuilder> rows = new ArrayList<>();
        for (int i = 0; i < Math.min(numRows, s.length()); i++)
            rows.add(new StringBuilder());

        int curRow = 0;
        boolean goingDown = false;

        for (char c : s.toCharArray()) {
            rows.get(curRow).append(c);
            if (curRow == 0 || curRow == numRows - 1) goingDown = !goingDown;
            curRow += goingDown ? 1 : -1;
        }

        StringBuilder ret = new StringBuilder();
        for (StringBuilder row : rows) ret.append(row);
        return ret.toString();
    }
}*/

public class Question6 {
    
}
