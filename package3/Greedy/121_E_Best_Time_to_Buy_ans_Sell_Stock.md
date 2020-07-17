This is not the optimal solution.
There should be a better way.

``` Java
class Solution {
    public int maxProfit(int[] prices) {
        if(prices == null || prices.length==0)
            return 0;
        int[] dp = new int[prices.length];
        Arrays.fill(dp,0);
        int res = 0;
        
        for(int i=1;i<prices.length;i++) {
            for(int j=0;j<i;j++) {
                
                if(dp[j]+prices[i]-prices[j]>dp[i])
                    dp[i]=dp[j]+prices[i]-prices[j];
            }
            res = Math.max(res,dp[i]);
        }
        
        return res;
    }
}


```