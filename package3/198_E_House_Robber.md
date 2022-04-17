
Although its an easy problem,but it can be a very common
DP problem.....

The basic idea is straight-forward : you can only choose 1st or 2nd,
either one.

Problem description:

```
You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed, the only constraint stopping you from robbing each of them is that adjacent houses have security systems connected and it will automatically contact the police if two adjacent houses were broken into on the same night.

Given an integer array nums representing the amount of money of each house, return the maximum amount of money you can rob tonight without alerting the police.

 

Example 1:

Input: nums = [1,2,3,1]
Output: 4
Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
Total amount you can rob = 1 + 3 = 4.
Example 2:

Input: nums = [2,7,9,3,1]
Output: 12
Explanation: Rob house 1 (money = 2), rob house 3 (money = 9) and rob house 5 (money = 1).
Total amount you can rob = 2 + 9 + 1 = 12.
 

Constraints:

1 <= nums.length <= 100
0 <= nums[i] <= 400

```

Basic idea:

`House Robber`是很经典的 DP 问题，推导公式如下：

# 对 dp[i] 表示到 i 为止的最大收益
a) dp[i] = dp[i-1]，说明选了前一个，不选这个
b) dp[i] = dp[i-2]+nums[i]，说明选了这一个，不选前一个

所以就可以得出公式：

dp[i] = max(dp[i-1],dp[i-2]+nums[i-1]) # 是 nums[i-1]而不是 nums[i]，防止溢出

对此的 Python 解法如下：

```Python

class Solution:
    def rob(self, nums: List[int]) -> int:
        
        n = len(nums)
        dp = [0]*(n+1)
        maxRes = dp[1] = nums[0]
        
        for i in range(2,n+1):
            dp[i] = max(dp[i-1],dp[i-2]+nums[i-1])
            
        return dp[-1] if n==1 else max(dp[-1],dp[-2])

```

```Java

class Solution {
    public int rob(int[] nums) {
        if(nums==null || nums.length==0)
            return 0;
        int len = nums.length;
        int[] dp = new int[len+1];
        dp[0] = 0;
        dp[1] = nums[0];
        int maxValue = nums[0];
        for(int i=2;i<=len;i++) {
            dp[i] = Math.max(dp[i-1],dp[i-2]+nums[i-1]);
            if(dp[i]>maxValue)
                maxValue = dp[i];
        }
        
        return maxValue;
    }
}

```