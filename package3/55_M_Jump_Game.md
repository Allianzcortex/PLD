
There are two ways to solve this problem:

- Greedy

- DP

---

Java Solution : The 1st is greedy solution

```Java

class Solution {
    public boolean canJump(int[] nums) {
        int maxReach = 0;
        for(int i=0;i<nums.length;i++) {
            if(i>maxReach)
                return false;
            maxReach = Math.max(i+nums[i],maxReach);
        }
        
        return true;
    }
}

```

The 2nd is DP solution

```Java

class Solution {
    public boolean canJump(int[] nums) {
        if(nums==null || nums.length<=1)
            return true;
        int len = nums.length;
        boolean[] dp = new boolean[len];
        dp[0] = true;
        for(int i=1;i<len;i++) {
            for(int j=0;j<i;j++) {
                if(!dp[j])
                    continue;
                if(j+nums[j]>=i) {
                    dp[i]=true;
                    break;
                }
            }
        }
        
        return dp[len-1];
    }
}

```

---

Python Solution

仍然是 max_reach 思路：

```python

class Solution:
    def canJump(self, nums: List[int]) -> bool:
        max_reach = 0
        
        for index,val in enumerate(nums):
            if index>max_reach:
                # 要能到达最后一点，那么就必须要能到达中间的任何一点
                return False
            max_reach = max(index + val,max_reach)
            if max_reach >= len(nums)-1:
                return True
        
        return False
        
```

下面是 DP 思路：

首先这个是一个 TLE 的解法

```Python

class Solution:
    def canJump(self, nums: List[int]) -> bool:
        dp = [True] + [False]*(len(nums)-1)
        
        for i in range(1,len(nums)):
            for j in range(0,i):
                if not dp[j]:
                    return False
                if j+nums[j]>=i:
                    dp[i] = True
                    break

        return dp[-1]

```

正确思路是不应该从前往后搜，因为对最后一个元素，最前一个大概率是到不了的。
反之，从后往前搜，会极大减少重复搜索的消耗。

```Python

class Solution:
    def canJump(self, nums: List[int]) -> bool:
        dp = [True] + [False]*(len(nums)-1)
        
        for i in range(1,len(nums)):
            for j in range(i-1,-1,-1):
                if dp[j] and i-j<=nums[j]:
                    dp[i] = True
                    break

        return dp[-1]

```