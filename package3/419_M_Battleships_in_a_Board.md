
Problem description:

```

Given an m x n matrix board where each cell is a battleship 'X' or empty '.', return the number of the battleships on board.

Battleships can only be placed horizontally or vertically on board. In other words, they can only be made of the shape 1 x k (1 row, k columns) or k x 1 (k rows, 1 column), where k can be of any size. At least one horizontal or vertical cell separates between two battleships (i.e., there are no adjacent battleships).

 

Example 1:


Input: board = [["X",".",".","X"],[".",".",".","X"],[".",".",".","X"]]
Output: 2
Example 2:

Input: board = [["."]]
Output: 0
 

Constraints:

m == board.length
n == board[i].length
1 <= m, n <= 200
board[i][j] is either '.' or 'X'.
 

Follow up: Could you do it in one-pass, using only O(1) extra memory and without modifying the values board?

```

Basic idea:

这道题一看就和 rotten orange 很像，所以第一种解法还是很直观的：


```Python
class Solution:
    def countBattleships(self, board: List[List[str]]) -> int:
        
        cnt = 1
        row,column = len(board),len(board[0])
        
        for i in range(row):
            for j in range(column):
                if board[i][j]=='X':
                    self.dfs(board,i,j,cnt)
                    cnt += 1
        
        return cnt-1
    
    def dfs(self,board,i,j,cnt):
        if(i<0 or i>=len(board) or j<0 or j>=len(board[0])):
            return
        
        if(board[i][j]!='X'):
            return
        
        board[i][j] = str(cnt)
        
        for x,y in [(0,1),(0,-1),(-1,0),(1,0)]:
            self.dfs(board,i+x,j+y,cnt)
```

但 follow up 里也有新的要求：`do it in one-pass, using only O(1) extra memory `，这个时候
只要保证：在对 1×k 或者 k×1 进行 count 的时候，只计算第一个，后面的不计算就可以

Python 解法如下：

```Python

class Solution:
    def countBattleships(self, board: List[List[str]]) -> int:
        
        cnt = 0
        row,column = len(board),len(board[0])
        
        for i in range(row):
            for j in range(column):
                if board[i][j]=='.':
                    continue
                
                if (i>0 and board[i-1][j]=='X'):
                    continue
                
                if (j>0 and board[i][j-1]=='X'):
                    continue
                cnt += 1
        
        return cnt

```

Golang 解法如下：

```Golang

func countBattleships(board [][]byte) int {
    
    row,column := len(board),len(board[0])
    cnt := 0
    
    for i:=0;i<row;i++ {
        for j:=0;j<column;j++ {
            
            if(board[i][j]=='.') {
                continue
            }
            
            if(i>0 && board[i-1][j]=='X') {
                continue
            }
            
            if(j>0 && board[i][j-1]=='X') {
                continue
            }
            
            cnt += 1
        }
    }
    
    return cnt
}

```