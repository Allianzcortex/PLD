
Problem description:

```

You are given an array prices where prices[i] is the price of a given stock on the ith day.

Find the maximum profit you can achieve. You may complete at most two transactions.

Note: You may not engage in multiple transactions simultaneously (i.e., you must sell the stock before you buy again).

 

Example 1:

Input: prices = [3,3,5,0,0,3,1,4]
Output: 6
Explanation: Buy on day 4 (price = 0) and sell on day 6 (price = 3), profit = 3-0 = 3.
Then buy on day 7 (price = 1) and sell on day 8 (price = 4), profit = 4-1 = 3.
Example 2:

Input: prices = [1,2,3,4,5]
Output: 4
Explanation: Buy on day 1 (price = 1) and sell on day 5 (price = 5), profit = 5-1 = 4.
Note that you cannot buy on day 1, buy on day 2 and sell them later, as you are engaging multiple transactions at the same time. You must sell before buying again.
Example 3:

Input: prices = [7,6,4,3,1]
Output: 0
Explanation: In this case, no transaction is done, i.e. max profit = 0.
Example 4:

Input: prices = [1]
Output: 0

```

Basic idea : 最多只允许交易股票 2 次

这是一道典型的 DP 解法

### TODO need to understand more

```Python

class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        """
        formula:
        dp[k, i] = max(dp[k, i-1], prices[i] - prices[j] + dp[k-1, j-1]), j=[0..i-1]
        
        # i transactions on jth day
        dp[2,len(list)]
        dp[i, j] = max(dp[i, j-1], prices[j]-prices[k]+dp[i-1,k-1]) k={0...j}
        
        """
        dp = [[0 for _ in prices] for _ in range(3)] 
        res = 0
        
        for i in range(1,3):
            min_val = prices[0]
            for j in range(1,len(prices)):
                min_val = min(min_val,prices[j]-dp[i-1][j-1])
                dp[i][j] = max(dp[i][j-1],prices[j]-min_val)

        return dp[2][len(prices)-1]
```