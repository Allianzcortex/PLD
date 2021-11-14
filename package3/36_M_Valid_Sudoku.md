
Problem description:

```

Determine if a 9 x 9 Sudoku board is valid. Only the filled cells need to be validated according to the following rules:

Each row must contain the digits 1-9 without repetition.
Each column must contain the digits 1-9 without repetition.
Each of the nine 3 x 3 sub-boxes of the grid must contain the digits 1-9 without repetition.
Note:

A Sudoku board (partially filled) could be valid but is not necessarily solvable.
Only the filled cells need to be validated according to the mentioned rules.
 

Example 1:


Input: board = 
[["5","3",".",".","7",".",".",".","."]
,["6",".",".","1","9","5",".",".","."]
,[".","9","8",".",".",".",".","6","."]
,["8",".",".",".","6",".",".",".","3"]
,["4",".",".","8",".","3",".",".","1"]
,["7",".",".",".","2",".",".",".","6"]
,[".","6",".",".",".",".","2","8","."]
,[".",".",".","4","1","9",".",".","5"]
,[".",".",".",".","8",".",".","7","9"]]
Output: true
Example 2:

Input: board = 
[["8","3",".",".","7",".",".",".","."]
,["6",".",".","1","9","5",".",".","."]
,[".","9","8",".",".",".",".","6","."]
,["8",".",".",".","6",".",".",".","3"]
,["4",".",".","8",".","3",".",".","1"]
,["7",".",".",".","2",".",".",".","6"]
,[".","6",".",".",".",".","2","8","."]
,[".",".",".","4","1","9",".",".","5"]
,[".",".",".",".","8",".",".","7","9"]]
Output: false
Explanation: Same as Example 1, except with the 5 in the top left corner being modified to 8. Since there are two 8's in the top left 3x3 sub-box, it is invalid.
 

Constraints:

board.length == 9
board[i].length == 9
board[i][j] is a digit 1-9 or '.'.

```

Basic idea:

下面第一种解法是最好的解法，关键就是 blcok 里的 `x/y` 生成方法
面试里很难直接想到吧

```Java

class Solution {
    public boolean isValidSudoku(char[][] board) {
        if(board==null || board.length==0)
            return false;
    
        for(int i=0;i<9;i++) {
        
            Set<Character> rows = new HashSet<>();
            Set<Character> columns = new HashSet<>();
            Set<Character> blocks = new HashSet<>();
        
            for(int j=0;j<9;j++) {
                
                // check rows
                if(board[i][j]!='.' && !rows.add(board[i][j]))
                    return false;
                
                // check columns
                if(board[j][i]!='.' && !columns.add(board[j][i]))
                    return false;
                
                // check blocks
                int x = 3*(i/3)+j/3;
                int y = 3*(i%3)+j%3;
                // System.out.println(x+" "+y);
                if(board[x][y]!='.' && !blocks.add(board[x][y]))
                    return false;
            }
        }
        
        return true;
    }
}
```

Python 解法如下：

```Python

class Solution:
    def isValidSudoku(self, board: List[List[str]]) -> bool:
        
        for i in range(9):
            rows = set()
            columns = set()
            block = set()
            
            for j in range(9):
                
                # check row
                if board[i][j]!='.' and board[i][j] in rows:
                    return False
                rows.add(board[i][j])
                
                # check column
                if board[j][i]!='.' and board[j][i] in columns:
                    return False
                columns.add(board[j][i])
                
                # check block
                x = 3*(i//3)+j//3
                y = 3*(i%3)+j%3
                if board[x][y]!='.' and board[x][y] in block:
                    return False
                block.add(board[x][y])
        
        return True

```

So the 2nd solution looks pretty nice and easier to come up
in an interview: key will be to find a unique identifier for 
each row / each column / each block

```Java

class Solution {
    public boolean isValidSudoku(char[][] board) {
        if(board==null || board.length==0)
            return false;
    
        Set<String> set = new HashSet<>();    
        
        for(int i=0;i<9;i++) {    
            for(int j=0;j<9;j++) {
                if(board[i][j]=='.')
                    continue;
                char val = board[i][j];
                if(!set.add(val+" in row "+i) ||
                   !set.add(val+" in column "+j) ||
                   !set.add(val+" in block "+i/3+"-"+j/3))
                    return false;
            }
        }
        
        return true;
    }
}

```

TODO : add Python solution