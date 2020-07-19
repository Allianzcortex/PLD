
```Java

class Solution {
    public int maxValue(int[][] grid) {
        int[][] dp=new int[grid.length][grid[0].length];
        dp[0][0]=grid[0][0];
        // Must plus + 1
        // cannot only assign 0 to the whole row/column
        for(int i=1;i<grid.length;i++)
            dp[i][0]=grid[i][0]+dp[i-1][0];
        for(int i=1;i<grid[0].length;i++)
            dp[0][i]=grid[0][i]+dp[0][i-1];
        for(int i=1;i<grid.length;i++){
            for(int j=1;j<grid[0].length;j++) {
                dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1])+grid[i][j];
            }
        }
        
        return dp[grid.length-1][grid[0].length-1];
    }
}

```