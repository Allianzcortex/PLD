
Problem description:

```

在一个 m*n 的棋盘的每一格都放有一个礼物，每个礼物都有一定的价值（价值大于 0）。你可以从棋盘的左上角开始拿格子里的礼物，并每次向右或者向下移动一格、直到到达棋盘的右下角。给定一个棋盘及其上面的礼物的价值，请计算你最多能拿到多少价值的礼物？

 

示例 1:

输入: 
[
  [1,3,1],
  [1,5,1],
  [4,2,1]
]
输出: 12
解释: 路径 1→3→5→2→1 可以拿到最多价值的礼物

```

Basic Idea :

这道题是类似 path sum 的 dp 问题，但有稍微变化：

基本公式很容易推，所以第一种思路如下，先计算行，再计算列，最后计算中间：

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

然后我们发现只要多加 1 行&1 列，就不用处理这么多情况，可以用一个公式统一代替：

Python 解法如下：

```Python

class Solution:
    def maxValue(self, grid: List[List[int]]) -> int:
        if not grid or not grid[0]:
            return 0
        
        row,column = len(grid),len(grid[0])

        dp = [ [0]*(column+1) for _ in range(row+1)]
        
        for i in range(row):
            for j in range(column):
                dp[i+1][j+1] = max(dp[i][j+1], dp[i+1][j])+grid[i][j]
        
        return max(max(item) for item in dp)

```