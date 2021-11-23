


DP 的第一种解法，显然不够优化，104/106 passed

```Python

class Solution:
    def jump(self, nums: List[int]) -> int:
        """
        create a dp array to represent the 
        dp[i] -> the minimum step to reach position i
        
        """
        
        length = len(nums)
        dp = [float('inf')]*(length)
        dp[0] =  0
        
        for i in range(1,length):
            for j in range(i-1,-1,-1):
                if (nums[j]+j>=i):
                    dp[i] = min(dp[i],dp[j]+1)
        
        return dp[-1]
```

DP 的第二种解法,AC 过，但效率很低

```Python

class Solution:
    def jump(self, nums: List[int]) -> int:
        """
        create a dp array to represent the 
        dp[i] -> the minimum step to reach position i
        
        """
        
        length = len(nums)
        dp = [float('inf')]*(length)
        dp[0] =  0
        
        for i in range(0,length):
            for j in range(1,nums[i]+1):
                
                next_ = min(i+j,length-1)
                
                dp[next_] = min(dp[next_],dp[i] + 1)
        
        return dp[-1]
        

```