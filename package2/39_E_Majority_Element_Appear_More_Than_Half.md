
Vote-like algorithm.
All (non-tareget) value will be regarded as -1.

```Java

class Solution {
    public int majorityElement(int[] nums) {
        int count=1;
        int target=nums[0];
        for(int i=1;i<nums.length;i++) {
            if(count==0) {
                target = nums[i];
            }
            if(nums[i]==target)
                count+=1;
            else
                count-=1;
        }

        return target;
    }
}


```