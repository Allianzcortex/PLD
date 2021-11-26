
Problem descriptioN:

```
You are given an array prices where prices[i] is the price of a given stock on the ith day.

You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock.

Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.

 

Example 1:

Input: prices = [7,1,5,3,6,4]
Output: 5
Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
Note that buying on day 2 and selling on day 1 is not allowed because you must buy before you sell.
Example 2:

Input: prices = [7,6,4,3,1]
Output: 0
Explanation: In this case, no transactions are done and the max profit = 0.
 

Constraints:

1 <= prices.length <= 105
0 <= prices[i] <= 104

```

Basic idea:

下面是一种解法，几乎到了 O(N^2) O(N squard) 的时间复杂度
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

第二种解法就比较正常，在依次遍历时找出前面的最小值并更新最小值，看当下的 value
和前面最小值的差就是可以获得的最大利润

Solution 2

```Java
class Solution {
public int maxProfit(int[] prices) {
    int n = prices.length;
    if (n == 0) return 0;
    int soFarMin = prices[0];
    int max = 0;
    for (int i = 1; i < n; i++) {
        if (soFarMin > prices[i]) soFarMin = prices[i];
        else max = Math.max(max, prices[i] - soFarMin);
    }
    return max;
}
}

```

对应的 Python 解法如下：

```Python

class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        
        prev_min = prices[0]
        max_profit = 0
        
        for i in range(1,len(prices)):
            max_profit = max(max_profit,prices[i]-prev_min)
            prev_min = min(prev_min,prices[i])
        
        return max_profit

```