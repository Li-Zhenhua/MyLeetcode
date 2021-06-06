package remaining1_100.medium;

/**
 * 请你判断一个 9x9 的数独是否有效。只需要 根据以下规则 ，
 * 验证已经填入的数字是否有效即可。

数字 1-9 在每一行只能出现一次。
数字 1-9 在每一列只能出现一次。
数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。（请参考示例图）
数独部分空格内已填入了数字，空白格用 '.' 表示。

注意：

一个有效的数独（部分已被填充）不一定是可解的。
只需要根据以上规则，验证已经填入的数字是否有效即可。
 */

class Solution {
    public boolean isValidSudoku(char[][] board) {
        //记录每一行是否出现1-9对应数字
        boolean[][] rows = new boolean[9][9];
        //记录每一列是否出现1-9对应数字
        boolean[][] columns = new boolean[9][9];
        //记录每一方格是否出现1-9对应数字
        boolean[][] squares = new boolean[9][9];

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if(board[i][j] == '.') continue;
                int num = board[i][j] - '0' - 1;//因为index为0的时候其实指向数字1
                int squareIndex = (int)(i/3) * 3 + (int)(j/3); //注意是整数除，故第一步除以3有取整行为
                if(rows[i][num] || columns[j][num] || squares[squareIndex][num]){
                    return false;
                }else{
                    rows[i][num] = true;
                    columns[j][num] = true;
                    squares[squareIndex][num] = true;
                }
            }
        }
        return true;
    }
}

public class Question36 {
    
}
