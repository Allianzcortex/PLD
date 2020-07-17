Classic DP Problem.

This is my initial solution,from bottom-top.

```Java

class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int row = triangle.size();
        int column = triangle.get(triangle.size()-1).size();

        int[][] dp = new int[row][column];
        dp[0][0]=triangle.get(0).get(0);
        for(int i=1;i<row;i++) {
            // List<Integer> pre = triangle.get(i-1);
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