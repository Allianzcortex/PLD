
cases like `[3,1] 1` must be handled.

```Java
class Solution {
    public int search(int[] nums, int target) {
        if(nums==null || nums.length==0)
            return -1;
        
        int left=0,right=nums.length-1;
        while(left<=right) {
            // System.out.println(left+" "+right);
            int middle = left + (right-left)/2;
            if(nums[middle]==target)
                return middle;
            
            if(nums[left]<=nums[middle]) {
                // left -> middle part is ordered
                if(nums[left]<=target && target<nums[middle])
                    right = middle -1;
                else
                    left = middle + 1 ;
            } else {
                // middle -> right part is ordered
                if(nums[middle+1]<=target && target<=nums[right]) {
                    left = middle + 1;
                } else 
                    right = middle -1;
            }
        }
        
        return -1;
    }
}
```

Or we can foloow the next logic :  Notice the minor difference between `<=` and `<`

```Java
 if(nums[left]<nums[middle]) {
        // left -> middle part is ordered
        if(nums[left]<=target && target<nums[middle])
            right = middle -1;
        else
            left = middle + 1 ;
            } else {
            // middle -> right part is ordered
            if(middle<=right-1 && nums[middle+1]<=target && target<=nums[right]) {
                left = middle + 1;
            } else 
                right = middle -1;
            }
        }

```