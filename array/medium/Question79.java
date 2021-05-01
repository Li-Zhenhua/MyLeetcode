package array.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个 m x n 二维字符网格 board 和一个字符串单词 word 。
 * 如果 word 存在于网格中，返回 true ；否则，返回 false 。

单词必须按照字母顺序，通过相邻的单元格内的字母构成，
其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。
同一个单元格内的字母不允许被重复使用

 */

class Solution {
    public boolean exist(char[][] board, String word) {
        //boolean[][] flag = new boolean[board.length][board[0].length]; 
        char c = word.charAt(0);
        boolean ans = false;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if(board[i][j] == c){
                    if(check(board, word, 0, i, j)) return true;
                }
            }
        }
        return false;
    }

    public boolean check(char[][] board, String word, int index,
                     int row, int column){
        if(index == word.length()) return true;

        //判断上下左右四个边界是不是有越界的
        if(row < 0 || row >= board.length || column < 0 || column >= board[0].length){
            return false;
        }
        char c = word.charAt(index);
        if(c == board[row][column]){
            char temp = board[row][column];
            //flag[row][column] = true;
            //将已经使用过的位置进行更改
            //注意不能用字母
            board[row][column] = ' ';
            if(check(board, word, index+1, row+1, column) ||
            check(board, word, index+1, row-1, column) ||
            check(board, word, index+1, row, column+1) ||
            check(board, word, index+1, row, column-1)){
                return true;
            }
            //注意这里要还原状态！！！
            //第一次写的时候就忘记了orz
            board[row][column] = temp;
        }
        return false;
    }
}

public class Question79 {
    
}
