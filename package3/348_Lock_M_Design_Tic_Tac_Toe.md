
Problem description:

```

Design a Tic-tac-toe game that is played between two players on anxngrid.

You may assume the following rules:

A move is guaranteed to be valid and is placed on an empty block.
Once a winning condition is reached, no more moves is allowed.
A player who succeeds in placing n of their marks in a horizontal, vertical, or diagonal row wins the game.
Example:

Given n = 3, assume that player 1 is "X" and player 2 is "O" in the board.

TicTacToe toe = new TicTacToe(3);

toe.move(0, 0, 1); -> Returns 0 (no one wins)
|X| | |
| | | |    // Player 1 makes a move at (0, 0).
| | | |

toe.move(0, 2, 2); -> Returns 0 (no one wins)
|X| |O|
| | | |    // Player 2 makes a move at (0, 2).
| | | |

toe.move(2, 2, 1); -> Returns 0 (no one wins)
|X| |O|
| | | |    // Player 1 makes a move at (2, 2).
| | |X|

toe.move(1, 1, 2); -> Returns 0 (no one wins)
|X| |O|
| |O| |    // Player 2 makes a move at (1, 1).
| | |X|

toe.move(2, 0, 1); -> Returns 0 (no one wins)
|X| |O|
| |O| |    // Player 1 makes a move at (2, 0).
|X| |X|

toe.move(1, 0, 2); -> Returns 0 (no one wins)
|X| |O|
|O|O| |    // Player 2 makes a move at (1, 0).
|X| |X|

toe.move(2, 1, 1); -> Returns 1 (player 1 wins)
|X| |O|
|O|O| |    // Player 1 makes a move at (2, 1).
|X|X|X|

```

Basic idea:

这道题还是很经典的 design 题，基本思路如下：

```
要检测 row，用一个 array 来存储

要检测 column，也用一个 array 来存储

要检测对角线，就用 2 个 integer 来存储

所有的值，对 player1 来 +1，对 player2 来 -1

假如是一个 `3*3` 的 board，然后

diagonal == 3，就说明 player1 赢
diagonal == -3，就说明 player2 赢

```


Java 算法如下：

```Java

public class TiaTacToe {

    private int[] rows;
    private int[] cols;
    private int diagonal;
    private int antiDiagonal;

    public TiaTacToe(int n) {
        rows = new int[n];
        cols = new int[n];
    }

    public int move(int row,int col,int player) {
        
        int toAdd = player==1?1:-1;
        int size = rows.length;

        rows[row] += toAdd;
        cols[col] += toAdd;

        if(row==col) {
            diagonal += toAdd;
        }

        if(row+col == (rows.length-1)) {
            antiDiognal += toAdd;
        }

        // now compare whether the player has got full score
        if(Math.abs(rows[row])==size ||
           Math.abs(cols[col])==size ||
           Math.abs(diagonal)==size ||
           Math.abs(antiDiagonal)==size
        ) {
            return player;
        }

        return 0;
    }
}



```