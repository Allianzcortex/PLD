
The item in the array must be >=0 

```Java

class Solution {
    public int maxSubArray(int[] nums) {
        if(nums==null || nums.length==0)
            return 0;
        
        int[] dp=new int[nums.length];
        dp[0] = nums[0];
        int maxRes = dp[0];
        for(int i=1;i<nums.length;i++) {
            if(dp[i-1]>0)
                dp[i]=dp[i-1]+nums[i];
            else
                dp[i]=nums[i];
            maxRes=Math.max(dp[i],maxRes);
        }
        
        return maxRes;
    }
}

```


```Python

class Solution:
    def maxSubArray(self, nums: List[int]) -> int:
        dp=[0]*len(nums)
        dp[0]=nums[0]
        for i in range(1,len(nums)):
            dp[i] = max(dp[i-1]+nums[i], nums[i])
        return max(dp)
        

```