
Problem description:

```

There is an integer array nums sorted in ascending order (with distinct values).

Prior to being passed to your function, nums is possibly rotated at an unknown pivot index k (1 <= k < nums.length) such that the resulting array is [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]] (0-indexed). For example, [0,1,2,4,5,6,7] might be rotated at pivot index 3 and become [4,5,6,7,0,1,2].

Given the array nums after the possible rotation and an integer target, return the index of target if it is in nums, or -1 if it is not in nums.

You must write an algorithm with O(log n) runtime complexity.

Example 1:

Input: nums = [4,5,6,7,0,1,2], target = 0
Output: 4
Example 2:

Input: nums = [4,5,6,7,0,1,2], target = 3
Output: -1
Example 3:

Input: nums = [1], target = 0
Output: -1
 

Constraints:

1 <= nums.length <= 5000
-104 <= nums[i] <= 104
All values of nums are unique.
nums is an ascending array that is possibly rotated.
-104 <= target <= 104

```

Basic idea:

cases like `[3,1] 1` must be handled.

这道题仍然是二分搜索的思路，找到 middle 然后如果 nums[middle]==target 就直接返回，如果不是的话有
两种情况：

1. `nums[left]<=nums[middle]`，这就说明从 `left->middle` 的部分是有序的。再分两种情况：
   - 如果 `nums[left]<=target<nums[middle]`，就说明 target 在 left->middle 之间，下一步操作是 right = middle-1
   - 其他情况下 left = middle+1

2. `nums[left]>nums[middle]`，这就说明从 `middle->right` 的部分时有序的。再分两种情况：
   - 如果 `nums[middle]<=target<nums[right]`，就说明 target 在 middle->right 之间，下一步操作是 left = middle+1
   - 其他情况下 right = middle-1

上面这四种已经涵盖了所有的情况

Python 解法如下：

```Python

class Solution:
    def search(self, nums: List[int], target: int) -> int:
        if not nums:
            return -1
        
        left,right = 0,len(nums)-1
        
        while left<=right:
            
            middle = left + (right-left)//2
            if nums[middle]==target:
                return middle
            
            # case 1 ,left-middle part is sorted
            if nums[left]<=nums[middle]:
                if nums[left]<=target and target<nums[middle]:
                    right = middle-1
                else:
                    left = middle+1
            # case 2 , right-middle part is sorted
            else:
                if nums[middle]<target and target<=nums[right]:
                    left = middle+1
                else:
                    right = middle-1
        
        return -1

```

```Java
class Solution {
    public int search(int[] nums, int target) {
        if(nums==null || nums.length==0)
            return -1;
        
        int left=0,right=nums.length-1;
        while(left<=right) {
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