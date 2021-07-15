
Problem Description:

```

Given an m x n grid of characters board and a string word, return true if word exists in the grid.

The word can be constructed from letters of sequentially adjacent cells, where adjacent cells are horizontally or vertically neighboring. The same letter cell may not be used more than once.

 

Example 1:


Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
Output: true
Example 2:


Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "SEE"
Output: true
Example 3:


Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCB"
Output: false
 

Constraints:

m == board.length
n = board[i].length
1 <= m, n <= 6
1 <= word.length <= 15
board and word consists of only lowercase and uppercase English letters.


```

```Java
class Solution {
    
    public boolean exist(char[][] board, String word) {
        if(board==null || board.length==0 || word==null || word.length()==0)
            return false;
        boolean[][] used =new boolean[board.length][board[0].length];
        char start=word.charAt(0);
        for(int i=0;i<board.length;i++) {
            for(int j=0;j<board[0].length;j++) {
                    if(exists(board,word,used,i,j,0))
                        return true;
            }
        }
        
        return false;
        
    }
    
    public boolean exists(char[][] board,String word,boolean[][] used,int i,int j,int index) {
        if(index>=word.length()) {
            return true;
        }
        if(i<0 || i>=board.length || j<0 || j>=board[0].length || used[i][j] || board[i][j]!=word.charAt(index))
            return false;
        used[i][j]=true;
        boolean flag=
            exists(board,word,used,i,j+1,index+1) ||
            exists(board,word,used,i,j-1,index+1) ||
            exists(board,word,used,i-1,j,index+1) ||
            exists(board,word,used,i+1,j,index+1);
        used[i][j]=false;
        return flag;
        
    }
}

```

Basic idea : this is a very classic DFS solution,  I do it easily in Python here :

```Python

class Solution:
    def exist(self, board: List[List[str]], word: str) -> bool:
        row,column = len(board),len(board[0])
        
        for i in range(row):
            for j in range(column):
                if board[i][j] == word[0]:
                    is_visited =[[False]*column for _ in range(row)]
                    if self.check(board,is_visited,i,j,word):
                        return True
        
        return False
    
    def check(self,board,is_visited,i,j,word):
        
        if word == "":
            return True
        if i<0 or i>=len(board) or j<0 or j>=len(board[0]) or is_visited[i][j]:
            return False


        check_result = False
        if board[i][j] == word[0]:
            is_visited[i][j] = True
            directions = [(0,-1),(0,1),(1,0),(-1,0)]
            for x,y in directions:
                check_result = check_result | self.check(board,is_visited,i+x,j+y,word[1:])
            is_visited[i][j] = False
        
        return check_result

```