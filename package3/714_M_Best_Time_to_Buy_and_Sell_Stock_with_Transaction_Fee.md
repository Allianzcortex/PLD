
Problem description:

```

You are given an array prices where prices[i] is the price of a given stock on the ith day, and an integer fee representing a transaction fee.

Find the maximum profit you can achieve. You may complete as many transactions as you like, but you need to pay the transaction fee for each transaction.

Note: You may not engage in multiple transactions simultaneously (i.e., you must sell the stock before you buy again).

 

Example 1:

Input: prices = [1,3,2,8,4,9], fee = 2
Output: 8
Explanation: The maximum profit can be achieved by:
- Buying at prices[0] = 1
- Selling at prices[3] = 8
- Buying at prices[4] = 4
- Selling at prices[5] = 9
The total profit is ((8 - 1) - 2) + ((9 - 4) - 2) = 8.
Example 2:

Input: prices = [1,3,7,5,10,3], fee = 3
Output: 6
 

Constraints:

1 <= prices.length <= 5 * 104
1 <= prices[i] < 5 * 104
0 <= fee < 5 * 104

```

Basic idea:

这是一开始的解法，LOL，想法很好很可惜是错的：

比如对给定的 input `prices = [1,3,7,5,10,3], fee = 3`
按照下面的思路，会是： price 在 1 的时候买，在 7 的时候卖，盈利为 3，
price 在 5 的时候买，在 10 的时候卖，盈利为 2。最后总和盈利为 5。

但如果只进行一次操作，在 1 的时候买，在 10 的时候卖，总和盈利会为 6。

```Python

class Solution:
    def maxProfit(self, prices: List[int], fee: int) -> int:
        
        max_profit = 0
        prev_min = prices[0]
        
        for i in range(1,len(prices)):
            if(prices[i]-prev_min > fee):
                max_profit += prices[i]-prev_min-fee
                prev_min = prices[i]
            else:
                prev_min = min(prev_min,prices[i])      
        return max_profit

```


正确的 `dp` 解法如下：

buy[i] 表示在从 0..i 的天数里，最近一次的操作是买时的最大盈利
sell[i] 表示在从 0..i 的天数里，最近一次的操作是卖时的最大盈利

所以 buy[i] 有 2 个选项，如果在第 i 天不做任何操作，buy[i]=buy[i-1]；如果在
第 i 天买，那么 buy[i]=sell[i-1]-prices[i]

所以 sell[i] 有 2 个选项，如果在第 i 天不做任何操作，sell[i]=sell[i-1]；如果在
第 i 天卖，那么 sell[i]=buy[i-1]+prices[i]-fee

对应代码如下：

```Python

class Solution:
    def maxProfit(self, prices: List[int], fee: int) -> int:
        
        length = len(prices)
        buy = [0]*length
        sell = [0]*length
        
        buy[0] = -1*prices[0]
        
        for i in range(1,length):
            
            buy[i] = max(buy[i-1],sell[i-1]-prices[i])
            
            sell[i] = max(sell[i-1],buy[i-1]+prices[i]-fee)
        
        return sell[length-1]

```