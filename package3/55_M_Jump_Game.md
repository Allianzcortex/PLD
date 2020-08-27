
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

```python

class Solution:
    def canJump(self, nums: List[int]) -> bool:
        maxReach = 0
        for index,step in enumerate(nums):
            if(index>maxReach):
                return False
            maxReach = max(index+step,maxReach)
        
        return True
        

```