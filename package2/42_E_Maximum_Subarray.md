
```Java

class Solution {
    public int maxSubArray(int[] nums) {
        int preSum=nums[0];
        int maxSum=preSum;
        for(int i=1;i<nums.length;i++) {
            if(preSum>0)
                preSum+=nums[i];
            else
                preSum=nums[i];
            maxSum = Math.max(maxSum,preSum);
        }

        return maxSum;
    }
}

```