
Although its an easy problem,but it can be a very common
DP problem.....

The basic idea is straight-forward : you can only choose 1st or 2nd,
either one.

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

TODO : add Python solution