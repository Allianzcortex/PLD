
Compared with problem 51,

We donot need to put `Q` in the actual position.

Just use a boolean array to judge whether column/diagonal is occupied
should be enough.

```Java

class Solution {
    public int totalNQueens(int n) {
        boolean[] column = new boolean[n];
        boolean[] diag1 = new boolean[2*n];
        boolean[] diag2 = new boolean[2*n];
        
        return dfs(n,0,column,diag1,diag2,0);
    }
    
    public int dfs(int n,int row,boolean[] column,boolean[] diag1,boolean[] diag2,int count) {
        if(row==n)
            count++;
    
        for(int col=0;col<n;col++) {
            int i1 = col + row;
            // col-row can be negative so we add n
            int i2 = col-row + n;
            if(column[col] || diag1[i1] || diag2[i2])
                continue;
            column[col] = diag1[i1] = diag2[i2] = true;
            count = dfs(n,row+1,column,diag1,diag2,count);
            column[col] = diag1[i1] = diag2[i2] = false;
        }
        
        return count;
    }
}

```

TODO add python solution