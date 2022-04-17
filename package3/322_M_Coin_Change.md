
Problem description:

```
You are given an integer array coins representing coins of different denominations and an integer amount representing a total amount of money.

Return the fewest number of coins that you need to make up that amount. If that amount of money cannot be made up by any combination of the coins, return -1.

You may assume that you have an infinite number of each kind of coin.

 

Example 1:

Input: coins = [1,2,5], amount = 11
Output: 3
Explanation: 11 = 5 + 5 + 1
Example 2:

Input: coins = [2], amount = 3
Output: -1
Example 3:

Input: coins = [1], amount = 0
Output: 0
Example 4:

Input: coins = [1], amount = 1
Output: 1
Example 5:

Input: coins = [1], amount = 2
Output: 2
 

Constraints:

1 <= coins.length <= 12
1 <= coins[i] <= 231 - 1
0 <= amount <= 104
```

Basic idea:

这道题是一个 DP 问题，但首先应该是一道二维 DP 题，
再然后才是一维 DP 的优化。



A classic DP problem. There will be 2 rounds for-loop:

loop1: iterate through from 1 to amount

loop2: iterate through different coin

Java Solution:

```Java
class Solution {
    public int coinChange(int[] coins, int amount) {
        if(coins==null || coins.length==0)
            return -1;
        int[] dp = new int[amount+1];
        Arrays.fill(dp,Integer.MAX_VALUE);
        dp[0] = 0;
        for(int i=1;i<=amount;i++) {
            for(int j=0;j<coins.length;j++) {
                if(coins[j]<=i && dp[i-coins[j]]!=Integer.MAX_VALUE)
                    dp[i] = Integer.min(dp[i-coins[j]]+1,dp[i]);
            }
        }
        return dp[amount]==Integer.MAX_VALUE ? -1 : dp[amount];
    }
}

```

---

Python :

```Python
class Solution:
    def coinChange(self, coins: List[int], amount: int) -> int:
        """
        `import math;math.inf` == float('inf')
        They all represent the infinite value
        """
        dp = [0]+[float('inf')]*amount
        for i in range(1,amount+1):
            for coin in coins:
                if(i-coin>=0):
                        # its really a maic how Python handles inf
                        # so we donot need to pre-judge 
                        # if(dp[i-coin]!=float('inf'))
                        dp[i]=min(dp[i],dp[i-coin]+1)
        return -1 if dp[amount]==float('inf') else dp[amount]
        

```