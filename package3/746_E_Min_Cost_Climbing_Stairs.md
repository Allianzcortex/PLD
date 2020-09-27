
Actually I still have difficulty understanding the problem...

At the end : reach the last or the one near the last step ?

A very good link to explain all DP problems :

https://leetcode.com/problems/min-cost-climbing-stairs/discuss/476388/4-ways-or-Step-by-step-from-Recursion-greater-top-down-DP-greater-bottom-up-DP-greater-fine-tuning

```Java

class Solution {
    public int minCostClimbingStairs(int[] cost) {
        
        // formulation : dp[i] = Math.min(dp[i-1]+cost[i-1],dp[i-2]+cost[i-2])
        int len = cost.length;
        int[] dp = new int[len];
        if(len==1)
            return cost[0];
        dp[0]=cost[0];
        dp[1]=cost[1];
        for(int i=2;i<len;i++) {
            dp[i]=cost[i]+Math.min(dp[i-1],dp[i-2]);  
        }
        
        return Math.min(dp[len-1],dp[len-2]);
    }
}

```


TODO: Add Python Solution