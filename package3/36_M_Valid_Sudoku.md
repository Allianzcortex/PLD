
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

The drawbacks of 1st solution is :

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