
Problem description:

```
You are given an array prices where prices[i] is the price of a given stock on the ith day.

Find the maximum profit you can achieve. You may complete as many transactions as you like (i.e., buy one and sell one share of the stock multiple times) with the following restrictions:

After you sell your stock, you cannot buy stock on the next day (i.e., cooldown one day).
Note: You may not engage in multiple transactions simultaneously (i.e., you must sell the stock before you buy again).

 

Example 1:

Input: prices = [1,2,3,0,2]
Output: 3
Explanation: transactions = [buy, sell, cooldown, buy, sell]
Example 2:

Input: prices = [1]
Output: 0

```

---

Basic idea:

这道题也是股票买卖问题里的经典题，这道题不同的解法有很多变种，我选择一个
我觉得最容易理解的吧：

https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/discuss/75927/Share-my-thinking-process/173646

基本思路是这样的：

1. 用 `buy[i]` 来表示: 从 0..i 天中，最近一次 action 是 buy 时的最大利润
ith 天可能是 buy 结尾(如 cooldown cooldown buy)，ith 天可能是 cooldown 结尾
（如 buy cooldown)

如果这一天 cooldown，那么 buy[i]=buy[i-1]；如果这一天是 buy，那么 buy[i]=sell[i-2]-prices[i](因为 cooldown 需要休息一天，所以是 sell[i-2] 而不是 sell[i-1])

2. 用 `sell[i]` 来表示：从 0..i 天中，最近一次 action 是 sell 时的最大利润

ith 天可能是 sell 结尾(如 buy sell)，ith 天可能是 cooldown 结尾(如 buy sell cooldown)

如果这一天 cooldown，那么 sell[i]=sell[i-1]；如果这一天是 sell，那么 sell[i]=buy[i-1]+prices[i](卖
产品得到的利润)

综合一下代码如下所示：

和有 transaction fee 的那道题做法是一样的

```Python

class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        """
        Here we define 2 arrays: buy & sell
        
        1. buy[i] means maxprofit of ith day which ends with buy/cooldown
        
        buy[i]=max(buy[i-1],sell[i-2]-price)
        
        2. sell[i] means maxprofit of ith day which ends with sell/cooldown
        
        sell[i]=max(sell[i-1],buy[i-1]+price)
        
        """
        
        n = len(prices)
        
        buy,sell=[0]*(n+1),[0]*(n+1)
        # buy[0] is placeholder
        # for sell[1] , it's impossible. 
        
        buy[1]=-1*prices[0]
        
        for i in range(2,n+1):
            buy[i]=max(buy[i-1],sell[i-2]-prices[i-1])
            
            sell[i]=max(sell[i-1],buy[i-1]+prices[i-1])
        
        return sell[-1]

```



