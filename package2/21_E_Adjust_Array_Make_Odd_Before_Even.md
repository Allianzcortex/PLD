
Two Pointers 

```Java

class Solution {
    public int[] exchange(int[] nums) {
        int left=0,right=nums.length-1;
        while(left<right) {
            // not left<=right ,for there are cases that 
            // only odd/even numbers exist
            while(left<right && nums[left]%2==1)
                left++;
            while(right>left && nums[right]%2==0)
                right--;
            swap(nums,left++,right--);
        }
        return nums;
    }

    public void swap(int[] nums,int left,int right) {
        int temp=nums[left];
        nums[left]=nums[right];
        nums[right]=temp;
    }
}

```