
Problem description:

```

On an 8 x 8 chessboard, there is exactly one white rook 'R' and some number of white bishops 'B', black pawns 'p', and empty squares '.'.

When the rook moves, it chooses one of four cardinal directions (north, east, south, or west), then moves in that direction until it chooses to stop, reaches the edge of the board, captures a black pawn, or is blocked by a white bishop. A rook is considered attacking a pawn if the rook can capture the pawn on the rook's turn. The number of available captures for the white rook is the number of pawns that the rook is attacking.

Return the number of available captures for the white rook.

 

Example 1:


Input: board = [[".",".",".",".",".",".",".","."],[".",".",".","p",".",".",".","."],[".",".",".","R",".",".",".","p"],[".",".",".",".",".",".",".","."],[".",".",".",".",".",".",".","."],[".",".",".","p",".",".",".","."],[".",".",".",".",".",".",".","."],[".",".",".",".",".",".",".","."]]
Output: 3
Explanation: In this example, the rook is attacking all the pawns.
Example 2:


Input: board = [[".",".",".",".",".",".",".","."],[".","p","p","p","p","p",".","."],[".","p","p","B","p","p",".","."],[".","p","B","R","B","p",".","."],[".","p","p","B","p","p",".","."],[".","p","p","p","p","p",".","."],[".",".",".",".",".",".",".","."],[".",".",".",".",".",".",".","."]]
Output: 0
Explanation: The bishops are blocking the rook from attacking any of the pawns.
Example 3:


Input: board = [[".",".",".",".",".",".",".","."],[".",".",".","p",".",".",".","."],[".",".",".","p",".",".",".","."],["p","p",".","R",".","p","B","."],[".",".",".",".",".",".",".","."],[".",".",".","B",".",".",".","."],[".",".",".","p",".",".",".","."],[".",".",".",".",".",".",".","."]]
Output: 3
Explanation: The rook is attacking the pawns at positions b5, d6, and f5.
 

Constraints:

board.length == 8
board[i].length == 8
board[i][j] is either 'R', '.', 'B', or 'p'
There is exactly one cell with board[i][j] == 'R'

```

Basic idea :

也是一道 easy 题

自己当时做的 Java 解法如下：

```Java

class Solution {
    public int numRookCaptures(char[][] board) {
        int[][] dir=new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
        int res=0;
        for(int i=0;i<board.length;i++) {
            for(int j=0;j<board.length;j++) {
                if(board[i][j]=='R') {
                    for(int k=0;k<4;k++) {
                        int newx=i,newy=j;
                        while(true) {
                            newx+=dir[k][0];
                            newy+=dir[k][1];
                            if(newx<0 || newx>=board.length || newy<0 || newy>=board[0].length || board[newx][newy]=='B')
                                break;
                            if(board[newx][newy]=='p'){
                                res+=1;
                                break;
                            }
                        }
                    }

                    return res;
                }
            }
        }

        return res;
    }
}

```