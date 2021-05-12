package array.medium;

/**
 * 根据 百度百科 ，生命游戏，简称为生命，是英国数学家约翰·何顿·康威
 * 在 1970 年发明的细胞自动机。

给定一个包含 m × n 个格子的面板，每一个格子都可以看成是一个细胞。
每个细胞都具有一个初始状态：1 即为活细胞（live），或 0 即为死细胞（dead）。
每个细胞与其八个相邻位置（水平，垂直，对角线）的细胞都遵循以下四条生存定律：

如果活细胞周围八个位置的活细胞数少于两个，则该位置活细胞死亡；
如果活细胞周围八个位置有两个或三个活细胞，则该位置活细胞仍然存活；
如果活细胞周围八个位置有超过三个活细胞，则该位置活细胞死亡；
如果死细胞周围正好有三个活细胞，则该位置死细胞复活；

下一个状态是通过将上述规则同时应用于当前状态下的每个细胞所形成的，
其中细胞的出生和死亡是同时发生的。
给你 m x n 网格面板 board 的当前状态，返回下一个状态。

 */

class Solution {
    public void gameOfLife(int[][] board) {
        int row = board.length;
        int column = board[0].length;
        int[][] copy = new int[row+2][column+2];
        //周围补零可以使得边界不用判断那么多
        for (int i = 1; i < row+1; i++) {
            for (int j = 1; j < column+1; j++) {
                copy[i][j] = board[i-1][j-1];
            }
        }
        int[] neighbor = {0,1,-1};
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                //因为下面for循环计数把中间的数也加进去了，这里要减回去
                int count = -copy[i+1][j+1];

                for (int k = 0; k < 3; k++) {
                    int rowOffset = neighbor[k];
                    for (int k2 = 0; k2 < 3; k2++) {
                        int columnOffset = neighbor[k2];
                        if(copy[i+1+rowOffset][j+1+columnOffset] == 1){
                            count++;
                        }
                    }
                }

                if(count < 2 || count > 3){
                    board[i][j] = 0;
                } else if(count == 3){
                    board[i][j] = 1;
                }//周围只有两个活细胞的时候，状态不变，故不需要再判断

            }
        }
    }
}

//另一种思路：使用额外的状态
//-1 代表这个细胞原来是活的后面死了，-1的话就可以取绝对值，这样也不会少计算这个数
// 2 代表这个细胞原来是死的后面活了
//此时就不需要额外数组了

public class Question289 {
    
}
