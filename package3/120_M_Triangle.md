
Problem description:

```
Given a triangle array, return the minimum path sum from top to bottom.

For each step, you may move to an adjacent number of the row below. More formally, if you are on index i on the current row, you may move to either index i or index i + 1 on the next row.

 

Example 1:

Input: triangle = [[2],[3,4],[6,5,7],[4,1,8,3]]
Output: 11
Explanation: The triangle looks like:
   2
  3 4
 6 5 7
4 1 8 3
The minimum path sum from top to bottom is 2 + 3 + 5 + 1 = 11 (underlined above).
Example 2:

Input: triangle = [[-10]]
Output: -10
 

Constraints:

1 <= triangle.length <= 200
triangle[0].length == 1
triangle[i].length == triangle[i - 1].length + 1
-104 <= triangle[i][j] <= 104
 

Follow up: Could you do this using only O(n) extra space, where n is the total number of rows in the triangle?

```
Basic idea:

经典的 DP 题，用 `dp[i][j]` 来表示到 nums[i][j] 为止从上到下的最小值
对最左边的值注意没有 left_val，对最右边的值注意没有 right_val

Python 代码如下：

```Python

class Solution:
    def minimumTotal(self, triangle: List[List[int]]) -> int:
        
        n = len(triangle)
        dp = [[float('inf')]*n for _ in range(n)]
        
        for i in range(n):
            for j in range(i+1):
                if i==0:
                    dp[i][j] = triangle[i][j]
                    continue
                
                left_val = dp[i-1][j-1] if j>=1 else float('inf')
                right_val = dp[i-1][j] if j<i else float('inf')

                dp[i][j] = triangle[i][j]+min(left_val,right_val)
        
        return min(dp[-1])

```

Java 代码如下：

```Java

class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int row = triangle.size();
        int column = triangle.get(triangle.size()-1).size();

        int[][] dp = new int[row][column];
        dp[0][0]=triangle.get(0).get(0);
        for(int i=1;i<row;i++) {
            List<Integer> curr = triangle.get(i);
            // We can use if-else to make it simplier;
            for(int j=0;j<curr.size();j++) {
                int leftValue = (j==0?Integer.MAX_VALUE:dp[i-1][j-1]+curr.get(j));
                int rightValue = (j==curr.size()-1?Integer.MAX_VALUE:dp[i-1][j]+curr.get(j));
                dp[i][j]=Math.min(leftValue,rightValue);
            }
        }

        int result = Integer.MAX_VALUE;
        for(int i=0;i<column;i++)
            result = Math.min(result,dp[row-1][i]);
        return result;
    }
}

```

We have other approaches to optmize the usage of space and time.