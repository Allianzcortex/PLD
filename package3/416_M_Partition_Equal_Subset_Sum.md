
Problem description:

```

Given a non-empty array nums containing only positive integers, find if the array can be partitioned into two subsets such that the sum of elements in both subsets is equal.

Example 1:

Input: nums = [1,5,11,5]
Output: true
Explanation: The array can be partitioned as [1, 5, 5] and [11].
Example 2:

Input: nums = [1,2,3,5]
Output: false
Explanation: The array cannot be partitioned into equal sum subsets.
 

Constraints:

1 <= nums.length <= 200
1 <= nums[i] <= 100

```

---

Basic idea:

这道题其实等价于：

从数组中选几个数，确保它们的和等于原来数组和的一半。而每个数字又只能选一次，
这就是很典型的 `0-1 背包问题`

Python 代码如下：

```Python

class Solution:
    def canPartition(self, nums: List[int]) -> bool:
        
        sum_ = sum(nums)
        
        if sum_%2!=0:
            return False
        
        target = sum_//2
        n = len(nums)
        
        dp = [[False]*(target+1) for _ in range(n+1)]
        
        # initialize the array
        dp[0][0] = True
        # 从 0-0 中选择数，也就是不选数，肯定全为 False
        for i in range(1,target+1):
            dp[0][i] = False
        
        # 从 1-n 中选数，只要每个都不选，结果肯定为 True
        for i in range(1,n+1):
            dp[i][0] = True
        
        # 每个数字只有选和不选两种情况：
        # a. 选：那么 dp[i][j]=dp[i-1][j-nums[i-1]]
        # b. 不选: 那么 dp[i][j]=dp[i-1][j]
        for i in range(1,n+1):
            for j in range(1,target+1):
                dp[i][j] = dp[i-1][j]
                if j>=nums[i-1]:
                    dp[i][j] = dp[i-1][j] or dp[i-1][j-nums[i-1]]
        
        return dp[-1][-1]

```

Golang 代码如下：

```Golang

func canPartition(nums []int) bool {
    
    sum:=0
    
    for _,val := range nums {
        sum += val
    }
    
    if sum%2!=0 {
        return false
    }
    
    target := sum/2
    length := len(nums)
    
    // initialize array
    dp:=make([][]bool,length+1)
    for i:=0;i<=length;i++ {
        dp[i] = make([]bool,target+1)
    }
    
    for i:=0;i<=length;i++ {
        dp[i][0] = true
    }
    
    for i:=1;i<=length;i++ {
        for j:=1;j<=target;j++ {
            dp[i][j] = dp[i-1][j]
            
            if(nums[i-1]<=j) {
                dp[i][j] = dp[i][j] || dp[i-1][j-nums[i-1]]
            }
        }
    }
    
    return dp[length][target]
}

```