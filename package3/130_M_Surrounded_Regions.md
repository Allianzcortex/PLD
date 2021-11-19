
Problem description:

```

Given an m x n matrix board containing 'X' and 'O', capture all regions that are 4-directionally surrounded by 'X'.

A region is captured by flipping all 'O's into 'X's in that surrounded region.

 

Example 1:


Input: board = [["X","X","X","X"],["X","O","O","X"],["X","X","O","X"],["X","O","X","X"]]
Output: [["X","X","X","X"],["X","X","X","X"],["X","X","X","X"],["X","O","X","X"]]
Explanation: Surrounded regions should not be on the border, which means that any 'O' on the border of the board are not flipped to 'X'. Any 'O' that is not on the border and it is not connected to an 'O' on the border will be flipped to 'X'. Two cells are connected if they are adjacent cells connected horizontally or vertically.
Example 2:

Input: board = [["X"]]
Output: [["X"]]

```

Explanations:

```

这道题题意一开始有点困惑，理解应该是这样的：

所以在边界的 'O' 与边界相连的 'O' 都应该保持原有的 'O' 不变
其他的 'O' 则必然是被 'X' 包围，需要翻转为 'X'

所以解法应该是在第一次循环中找出 `在边界的 'O' 与边界相连的 'O'`，并用特殊符号
标记，然后在第二次循环中把 'O' 标记为 'X'，把特殊符号标记为 'O'

```

---

Python DFS solution:

```Python

class Solution:
    def solve(self, board: List[List[str]]) -> None:
        """
        Do not return anything, modify board in-place instead.
        """
        
        if not board or not board[0]:
            return
        
        row,column = len(board),len(board[0])
        
        # check the 1st and last row
        for i in [0,row-1]:
            for j in range(column):
                self.dfs(board,i,j)
        
        # check the 1st and last column
        for i in range(row):
            for j in [0,column-1]:
                self.dfs(board,i,j)
        
        for i in range(row):
            for j in range(column):
                if board[i][j] == 'O':
                    board[i][j] = 'X'
                elif board[i][j] == '.':
                    board[i][j] = 'O'
    
    
    def dfs(self,board,i,j):
        if i<0 or i>len(board)-1 or j<0 or j>len(board[0])-1:
            return
        
        if board[i][j] == 'O':
            board[i][j] = '.'
            self.dfs(board,i-1,j)
            self.dfs(board,i+1,j)
            self.dfs(board,i,j-1)
            self.dfs(board,i,j+1)

```

And below is Python BFS solution:

```Python

class Solution:
    def solve(self, board: List[List[str]]) -> None:
        """
        Do not return anything, modify board in-place instead.
        """
        queue = deque([])
        
        row,column = len(board),len(board[0])
        
        # add boarder 
        for i in range(row):
            for j in range(column):
                if (i in [0,row-1] or j in [0,column-1] ) and board[i][j]=='O':
                    queue.append((i,j))
        
        while queue:
            r,c = queue.popleft()
            if r>=0 and r<row and c>=0 and c<column and board[r][c]=='O':
                board[r][c] = '.'
                queue.extend([(r-1,c),(r+1,c),(r,c-1),(r,c+1)])
        
        for i in range(row):
            for j in range(column):
                if board[i][j]=='O':
                    board[i][j] = 'X'
                elif board[i][j]=='.':
                    board[i][j] = 'O'
        

```

对应的 Java DFS 解法如下：

```Java

class Solution {
    public void solve(char[][] board) {
        
        int row = board.length;
        int column = board[0].length;
        
        for(int i=0;i<row;i++) {
            dfs(board,i,0);
            dfs(board,i,column-1);
        }
        
        for(int j=0;j<column;j++) {
            dfs(board,0,j);
            dfs(board,row-1,j);
        }
        
        for(int i=0;i<row;i++) {
            for(int j=0;j<column;j++) {
                if(board[i][j]=='O') {
                    board[i][j]='X';
                }else if(board[i][j]=='C') {
                    board[i][j]='O';
                }
            }
        }
    }
    
    private void dfs(char[][] board,int i,int j) {
        if(i<0 || i>board.length-1 || j<0 || j>board[0].length-1) {
            return;
        }
        if(board[i][j]!='O') {
            return;
        }
        
        board[i][j]='C';
        int[][] direcs ={{0,1},{0,-1},{-1,0},{1,0}};
        
        for(int k=0;k<4;k++) {
            dfs(board,i+direcs[k][0],j+direcs[k][1]);
        }
    }
}

```