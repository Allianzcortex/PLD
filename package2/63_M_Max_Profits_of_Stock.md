Classic DP Problem

```Java

class Solution {
    public int maxProfit(int[] prices) {
        if(prices==null || prices.length==0)
            return 0;
        int minPrice=prices[0];
        int[] dp=new int[prices.length];
        for(int i=0;i<prices.length;i++) {
            if(i==0)
                dp[i]=0;
            else {
                dp[i]=Math.max(dp[i-1],prices[i]-minPrice);
                minPrice = Math.min(minPrice,prices[i]);
            }
        }
        return dp[prices.length-1];
    
    }
}

```