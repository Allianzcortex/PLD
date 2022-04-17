
Problem description:

```

Given an m x n binary matrix filled with 0's and 1's, find the largest square containing only 1's and return its area.

Example 1:


Input: matrix = [["1","0","1","0","0"],["1","0","1","1","1"],["1","1","1","1","1"],["1","0","0","1","0"]]
Output: 4
Example 2:


Input: matrix = [["0","1"],["1","0"]]
Output: 1
Example 3:

Input: matrix = [["0"]]
Output: 0
 

Constraints:

m == matrix.length
n == matrix[i].length
1 <= m, n <= 300
matrix[i][j] is '0' or '1'.

```

Basic idea:

这是一道动态规划题。题目要求是：

用 `dp[i][j]` 表示以 `matrix[i][j]` 为右下角，可能的最大矩阵距离

这里主要是理解，如果 `matrix` 中存在一个 `0`，那么：

1 1      1 0      0 1
0 1 以及 1 1 以及  1 1 

就都不是一个 2*2 的矩形。换句话说，对 matrix[i][j]，只要

matrix[i][j-1],matrix[i-1][j],matrix[i-1][j-1] 这三个坐标存在一个为 0，就说明
这个大矩形无法成立

而如：

1 1 1
1 1 1
1 1 1

这个矩形，对最右下角矩形来说，`dp[i][j-1]` 为 2，`dp[i-1][j]` 为 2，`dp[i-1][j-1]` 也为 2
所以才可以得出最大长度为 `min(2,2,2)+1 = 3` 的结论

Python 解法如下：

Time Complexity : `O(m*n)`
Space Complexity : `O(m*n)`

```Python

class Solution:
    def maximalSquare(self, matrix: List[List[str]]) -> int:
        
        row,column = len(matrix),len(matrix[0])
        
        dp = [[0]*(column+1) for _ in range(row+1)]
        max_side = 0
        
        for i in range(row):
            for j in range(column):
                if matrix[i][j]=='1':
                    dp[i+1][j+1] = min(dp[i+1][j],dp[i][j+1],dp[i][j])+1
                    max_side = max(max_side,dp[i+1][j+1])
        
        return max_side*max_side

```

Java 解法如下：

```Java

public class Solution {
    public int maximalSquare(char[][] matrix) {

        if(matrix==null || matrix.length==0)
            return 0;
        int m=matrix.length;
        int n=matrix[0].length;
        int max=Integer.MIN_VALUE;
        int[][] dp=new int[m+1][n+1];
        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
                if(matrix[i-1][j-1]=='1'){
        
                    dp[i][j]=Math.min(Math.min(dp[i-1][j],dp[i-1][j-1]),dp[i][j-1])+1;
                    max=Math.max(max,dp[i][j]);
                }
            }
        }
        
        return max*max;
    }
}

```

Golang 解法如下：

```Golang

func maximalSquare(matrix [][]byte) int {
    
    row,column := len(matrix),len(matrix[0])
    dp:=make([][]int,row+1)
    for i:=0;i<=row;i++ {
        dp[i] = make([]int,column+1)
    }
    
    res := 0
    
    for i:=1;i<=row;i++ {
        for j:=1;j<=column;j++ {
            if matrix[i-1][j-1]=='1' {
                dp[i][j] = min(min(dp[i-1][j],dp[i][j-1]),dp[i-1][j-1])+1
                if(dp[i][j]>res) {
                    res = dp[i][j]
                }
            }
        }
    }
    
    return res*res
}

func min(a,b int) int {
    if(a<b) {
        return a
    }
    
    return b
}

```