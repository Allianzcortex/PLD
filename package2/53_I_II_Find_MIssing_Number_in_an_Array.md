
Problem I :

```Java

class Solution {
    public int search(int[] nums, int target) {
        if(nums==null || nums.length==0)
            return 0;
        int left=0,right=nums.length-1;
        int index=0;
        while(left<=right) {
            int middle = left+(right-left)/2;
            if(nums[middle]==target){
                index = middle;
                break;
            } else if(nums[middle]>target){
                right-=1;
            } else {
                left+=1;
            }
        }
        
        int cnt=0;
        if(nums[index]!=target)
            return cnt;
        left = index;
        right = index;
        while(left>0 && nums[left]==nums[--left])
            cnt+=1;
        while(right<nums.length-1 && nums[right]==nums[++right])
            cnt+=1;
        return cnt+1;
    }
}

```

Problem II :

```Java

class Solution {
    public int missingNumber(int[] nums) {
        int left=0,right=nums.length-1;
        while(left<=right) {
            int middle=left+(right-left)/2;
            if(middle-left == nums[middle]-nums[left])
                left=middle+1;
            else
                right=middle-1;
        }

        return left;
    }
}


```