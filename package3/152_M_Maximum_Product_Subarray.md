
DP Solution, using 2 arrays to store the value.

```Java

class Solution {
    public int maxProduct(int[] nums) {
        int len = nums.length;
        int[] dpMax = new int[len];
        int[] dpMin = new int[len];
        int maxValue;
        dpMax[0]=dpMin[0]=maxValue=nums[0];
        
        for(int i=1;i<len;i++) {
            dpMax[i]=Math.max(nums[i],Math.max(dpMax[i-1]*nums[i],dpMin[i-1]*nums[i]));
            if(dpMax[i]>maxValue)
                maxValue = dpMax[i];
            dpMin[i] = Math.min(nums[i],Math.min(dpMax[i-1]*nums[i],dpMin[i-1]*nums[i]));
        }
        
        return maxValue;
    }
}

```