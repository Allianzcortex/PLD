
Standford DFS Backtrack solution : 

```Java

class Solution {
    public void solveSudoku(char[][] board) {
        if(board==null || board.length==0)
            return;
        solve(board);
    }
    
    public boolean solve(char[][] board) {
        for(int i=0;i<board.length;i++) {
            for(int j=0;j<board[0].length;j++) {
                if(board[i][j]!='.')
                    continue;
                for(char ch='1';ch<='9';ch++) {
                    if(isValid(board,i,j,ch)) {
                        board[i][j]=ch;
                        
                        if(solve(board))
                            return true;
                        else
                            board[i][j]='.';
                    }
                }
                
                return false;
            }
        }
        
        return true;
    }


    public boolean isValid(char[][] board,int row,int column,char ch) {
        for(int i=0;i<9;i++) {
            // check row
            if(board[i][column]==ch)
                return false;
            
            // check column
            if(board[row][i]==ch)
                return false;
            
            // check column
            int x = row/3*3 + i/3;
            int y = (column/3)*3 + i%3;
            if(board[x][y]==ch)
                return false;
        }
        
        return true;
    }
}

```

TODO : add Python solution