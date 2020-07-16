
Standard two pointer problem

```Java
class Solution {
    public int searchInsert(int[] nums, int target) {
        int left=0,right=nums.length-1;
        while(left<=right) {
            int middle = left + (right-left)/2;
            if(nums[middle]==target){
                return middle;
            } else if(nums[middle]>target){
                right = middle-1;
            } else {
                left = middle+1;
            }
        }
        return left;
        // return nums[left]<target?left+1:left;
    }
}

```