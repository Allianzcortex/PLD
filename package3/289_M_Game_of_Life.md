
Problem Description:

```

According to Wikipedia's article: "The Game of Life, also known simply as Life, is a cellular automaton devised by the British mathematician John Horton Conway in 1970."

The board is made up of an m x n grid of cells, where each cell has an initial state: live (represented by a 1) or dead (represented by a 0). Each cell interacts with its eight neighbors (horizontal, vertical, diagonal) using the following four rules (taken from the above Wikipedia article):

Any live cell with fewer than two live neighbors dies as if caused by under-population.
Any live cell with two or three live neighbors lives on to the next generation.
Any live cell with more than three live neighbors dies, as if by over-population.
Any dead cell with exactly three live neighbors becomes a live cell, as if by reproduction.
The next state is created by applying the above rules simultaneously to every cell in the current state, where births and deaths occur simultaneously. Given the current state of the m x n grid board, return the next state.

Example 1:

0 1 0              0 0 0
0 0 1     ------>  1 0 1
1 1 1              0 1 1
0 0 0              0 1 0

Input: board = [[0,1,0],[0,0,1],[1,1,1],[0,0,0]]
Output: [[0,0,0],[1,0,1],[0,1,1],[0,1,0]]
Example 2:


Input: board = [[1,1],[1,0]]
Output: [[1,1],[1,1]]
 

Constraints:

m == board.length
n == board[i].length
1 <= m, n <= 25
board[i][j] is 0 or 1.
 

Follow up:

Could you solve it in-place? Remember that the board needs to be updated simultaneously: You cannot update some cells first and then use their updated values to update other cells.
In this question, we represent the board using a 2D array. In principle, the board is infinite, which would cause problems when the active area encroaches upon the border of the array (i.e., live cells reach the border). How would you address these problems?

```

Solution, with Python:

The key here is: when a cell from live->die, it should be mark as dead finally , but should be mark
as alive when other cells are calculating. So we use :

1 -> alive cell
3 -> alive cell after dying
0 -> dead cell
2 -> dead cell after becoming alive

When we calculate it , the equation is : `board[i+dx][j+dy]%2`

```Python

class Solution:
    def gameOfLife(self, board: List[List[int]]) -> None:
        """
        Do not return anything, modify board in-place instead.
        
        live cell : <2 die; 2-3 live; >3 die;
        dead cell : 3 live;
        """
        
        if board is None or len(board)==0:
            return
        
        row,column = len(board),len(board[0])
        
        for i in range(row):
            for j in range(column):
                nbr_count = self.count(board,i,j)
                if board[i][j] == 1:
                    if nbr_count<2 or nbr_count>3:
                        board[i][j] = 3 # 1 -> 3
                else:
                    if nbr_count == 3:
                        board[i][j] = 2 # 0 -> 2
        
        for i in range(row):
            for j in range(column):
                if board[i][j] == 3:
                    board[i][j] = 0
                elif board[i][j] == 2:
                    board[i][j] = 1
                            
    
    
    def count(self,board,i,j):
        res = 0
        directions = [(-1,-1),(-1,0),(-1,1),(0,-1),(0,1),(1,-1),(1,0),(1,1)]
        
        for dx,dy in directions:
            if 0<=i+dx<len(board) and 0<=j+dy<len(board[0]):
                res += board[i+dx][j+dy]%2
        
        return res

```