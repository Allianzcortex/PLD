
My Java Solution : 

```Java

class Solution {
    public List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n];
        for(char[] row:board)
            Arrays.fill(row,'.');
        List<List<String>> res = new ArrayList<>();
        dfs(board,0,n,res);
        return res;
        
    }
    
    public void dfs(char[][] board,int index,int n,List<List<String>> res) {
        if(index==n) {
            List<String> temp = new ArrayList<>();
            for(int i=0;i<n;i++) {
                temp.add(String.valueOf(board[i]));
            }
            res.add(temp);
            return;
        }
        
        // LOL,a mistake here,no need to iterate over the index
        // for(int i=index;i<n;i++) {
            for(int j=0;j<n;j++) {
                if(judge(board,n,index,j)) {
                    board[index][j] = 'Q';
                    dfs(board,index+1,n,res);
                    board[index][j] = '.';
                }
            }
        // }
    
    }
    
    public boolean judge(char[][] board,int n,int x,int y) {
       
        // check y ,no need to check x for we add row by row
        for(int i=0;i<x;i++) {
            if(board[i][y]=='Q')
                return false;
        }
        
        // check diagonal
        int i=x,j=y;
        while(i>=0 && j<n) {
            if(board[i--][j++]=='Q')
                return false;
        }
        
        while(x>=0 && y>=0) {
            if(board[x--][y--]=='Q')
                return false;
        }
        
        /**
        If we iterate over the whole matrix then it will be something like this :
        if ((i==x || Math.abs(x - i) == Math.abs(y - j)) && mat[i][j] == 'Q') {
          return false;
        
        **/
        
        return true;
    }
}


```