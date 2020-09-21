
The classic DP Problem.

One thing we need to notice is that :

if there is an obstacle in first row or first column,then 
dp in the whole row/column after this obstacle will be 0.

while if this obstacle is not in the first row/column, it will be 0.

So the key is to find one way to calculate the DP matrix properly.


```Java

class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if(obstacleGrid==null || obstacleGrid.length==0)
            return 1;
        int row = obstacleGrid.length,column = obstacleGrid[0].length;
        int[][] dp = new int[row+1][column+1];
        dp[1][0] = 1;
        for(int i=1;i<=row;i++) {
            for(int j=1;j<=column;j++) {
                if(obstacleGrid[i-1][j-1]==0) {
                   dp[i][j] = dp[i-1][j] + dp[i][j-1];
                } 
            }
        }
        return dp[row][column];
    }
}

```

TODO : check more explanations , add more solutions later.