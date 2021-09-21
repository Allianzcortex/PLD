
Problem description:

```
Tic-tac-toe is played by two players A and B on a 3 x 3 grid.

Here are the rules of Tic-Tac-Toe:

Players take turns placing characters into empty squares (" ").
The first player A always places "X" characters, while the second player B always places "O" characters.
"X" and "O" characters are always placed into empty squares, never on filled ones.
The game ends when there are 3 of the same (non-empty) character filling any row, column, or diagonal.
The game also ends if all squares are non-empty.
No more moves can be played if the game is over.
Given an array moves where each element is another array of size 2 corresponding to the row and column of the grid where they mark their respective character in the order in which A and B play.

Return the winner of the game if it exists (A or B), in case the game ends in a draw return "Draw", if there are still movements to play return "Pending".

You can assume that moves is valid (It follows the rules of Tic-Tac-Toe), the grid is initially empty and A will play first.

 

Example 1:

Input: moves = [[0,0],[2,0],[1,1],[2,1],[2,2]]
Output: "A"
Explanation: "A" wins, he always plays first.
"X  "    "X  "    "X  "    "X  "    "X  "
"   " -> "   " -> " X " -> " X " -> " X "
"   "    "O  "    "O  "    "OO "    "OOX"
Example 2:

Input: moves = [[0,0],[1,1],[0,1],[0,2],[1,0],[2,0]]
Output: "B"
Explanation: "B" wins.
"X  "    "X  "    "XX "    "XXO"    "XXO"    "XXO"
"   " -> " O " -> " O " -> " O " -> "XO " -> "XO " 
"   "    "   "    "   "    "   "    "   "    "O  "
Example 3:

Input: moves = [[0,0],[1,1],[2,0],[1,0],[1,2],[2,1],[0,1],[0,2],[2,2]]
Output: "Draw"
Explanation: The game ends in a draw since there are no moves to make.
"XXO"
"OOX"
"XOX"
Example 4:

Input: moves = [[0,0],[1,1]]
Output: "Pending"
Explanation: The game has not finished yet.
"X  "
" O "
"   "

```

---

Basic idea:

这道题一个关键点是：输入的是有效的，也就是说，
只需要在最后一个输入结束后检测 `行/列/对角线`，就够了吗

第一种解法，就是遍历所有的情况，Python 代码如下：

```Python

class Solution:
    def tictactoe(self, moves: List[List[int]]) -> str:
        board = [['']*3 for _ in range(3)]
        
        for index,(x,y) in enumerate(moves):
            if index%2==0:
                board[x][y] = 'X'
            else:
                board[x][y] = 'O'
            
            if index==len(moves)-1:
                if self.check(board,x,y,board[x][y]):
                    return 'A' if board[x][y]=='X' else 'B'
        
        return "Draw" if len(moves)==9 else "Pending"
        
    
    def check(self,board,x,y,ch):
        
        # check row 
        isRowValid = True
        for i in range(len(board[0])):
            if board[x][i]!=ch:
                isRowValid = False
        
        # check column
        isColumnValid = True
        for i in range(len(board)):
            if board[i][y]!=ch:
                isColumnValid = False
        
        # check diagonal1
        isDiagonal1Valid = True
        for i in range(len(board)):
            if board[i][i]!=ch:
                isDiagonal1Valid = False
                
        # check diagonal2
        isDiagonal2Valid = True
        for i in range(len(board)):
            if board[i][len(board)-1-i]!=ch:
                isDiagonal2Valid = False
        
        return isRowValid or isColumnValid or isDiagonal1Valid or isDiagonal2Valid

```

---

第二种解法，用 rowA 来表示一个三个元素的数组，那么
rowA[0] 表示对 A 来说，第一行的 sum(所有元素之和)，
rowA[1] 表示对 A 来说，第二行的 sum(所有元素之和)，
rowA[2] 表示对 A 来说，第三行的 sum(所有元素之和)，

依此类推，rowB/colA/colB 也有类似的意义。
而 diagA1 表示对 A，左上到右下这个方向对角线的和，
diagA2 表示对 A，右上到左下这个方向对角线的和。

Python 代码如下：

```Python

class Solution:
    def tictactoe(self, moves: List[List[int]]) -> str:
        
        rowA,rowB = [0]*3,[0]*3
        colA,colB = [0]*3,[0]*3
        diagA1,diagA2 = 0,0
        diagB1,diagB2 = 0,0
        
        for index,(x,y) in enumerate(moves):
            if index%2==0:
                rowA[x]+=1
                colA[y]+=1
                if x==y:
                    diagA1+=1
                if x+y == 2:
                    diagA2+=1
            else:
                rowB[x]+=1
                colB[y]+=1
                if x==y:
                    diagB1+=1
                if x+y == 2:
                    diagB2+=1
            
            if rowA[x]==3 or colA[y]==3 or diagA1==3 or diagA2==3:
                return 'A'
            if rowB[x]==3 or colB[y]==3 or diagB1==3 or diagB2==3:
                return 'B'
        
        return "Draw" if len(moves)==9 else "Pending"

```
