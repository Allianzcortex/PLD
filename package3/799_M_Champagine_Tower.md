
There are multiple solutions for it :

The 1st way is to simulate,pretty straight-forward

```Java

class Solution {
    public double champagneTower(int poured, int query_row, int query_glass) {
        double[][] triangle = new double[query_row+1][query_row+1];
        triangle[0][0] = poured;
        for(int i=0;i<query_row;i++) {
            for(int j=0;j<=i;j++) {
                if(triangle[i][j]>1) {
                    double remains = (triangle[i][j]-1);
                    triangle[i+1][j]+=remains/2;
                    triangle[i+1][j+1]+=remains/2;
                }
            }
        }
        
        return Math.min(1.0,triangle[query_row][query_glass]);
    }
}

```

---

The 2nd way is to use DP to solve it :

Actually its still the same idea but can reduce the time complexity

```Java

class Solution {
    public double champagneTower(int poured, int query_row, int query_glass) {
        double[] dp = new double[query_row+2];
        dp[0] = poured;
        for(int i=1;i<=query_row;i++) {
            for(int j=i;j>=0;j--) {
                dp[j]=Math.max(dp[j]-1,0.0)/2;
                dp[j+1]+=dp[j];
            }
        }
        
        return Math.min(1.0,dp[query_glass]);
    }
}
```

TODO : add Python solution later