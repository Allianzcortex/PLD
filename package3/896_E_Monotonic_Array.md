
Problem description:

```

An array is monotonic if it is either monotone increasing or monotone decreasing.

An array nums is monotone increasing if for all i <= j, nums[i] <= nums[j]. An array nums is monotone decreasing if for all i <= j, nums[i] >= nums[j].

Given an integer array nums, return true if the given array is monotonic, or false otherwise.

 

Example 1:

Input: nums = [1,2,2,3]
Output: true
Example 2:

Input: nums = [6,5,4,4]
Output: true
Example 3:

Input: nums = [1,3,2]
Output: false
Example 4:

Input: nums = [1,2,4,5]
Output: true
Example 5:

Input: nums = [1,1,1]
Output: true
 

Constraints:

1 <= nums.length <= 105
-105 <= nums[i] <= 105


```

---

Basic idea:

第一种最直观的解法：

```Python

return nums==sorted(nums) or nums==sorted(nums,reverse=True)

```

第二种是比较 & 确立 flag，注意前两个数相等的情况：

```Python
class Solution:
    def isMonotonic(self, nums: List[int]) -> bool:
        
        if len(nums)==1:
            return True

        flag = nums[-1]>nums[0]
        
        for i in range(1,len(nums)):
            if nums[i]!=nums[i-1] and ((nums[i]>nums[i-1])!=flag):
                return False
        
        return True

```