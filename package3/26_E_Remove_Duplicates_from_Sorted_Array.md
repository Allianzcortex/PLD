
Java SOlution

```Java

class Solution {
    public int removeDuplicates(int[] nums) {
        int left=0,right=0;
        while(right<nums.length) {
            // 1 1 1 2 2 3 4
            while(right+1<nums.length && nums[right]==nums[right+1])
                right += 1;
            nums[left++]=nums[right++];
        }
        
        return left;
    }
}

```