
Problem description:

```
There is an integer array nums sorted in non-decreasing order (not necessarily with distinct values).

Before being passed to your function, nums is rotated at an unknown pivot index k (0 <= k < nums.length) such that the resulting array is [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]] (0-indexed). For example, [0,1,2,4,4,4,5,6,6,7] might be rotated at pivot index 5 and become [4,5,6,6,7,0,1,2,4,4].

Given the array nums after the rotation and an integer target, return true if target is in nums, or false if it is not in nums.

You must decrease the overall operation steps as much as possible.

 

Example 1:

Input: nums = [2,5,6,0,0,1,2], target = 0
Output: true
Example 2:

Input: nums = [2,5,6,0,0,1,2], target = 3
Output: false
 

Constraints:

1 <= nums.length <= 5000
-104 <= nums[i] <= 104
nums is guaranteed to be rotated at some pivot.
-104 <= target <= 104
 

Follow up: This problem is similar to Search in Rotated Sorted Array, but nums may contain duplicates. Would this affect the runtime complexity? How and why?


```

Basic idea:

这道题是 33 的变种，增加了非严格递增-两个元素可能相等的情况

所以就分三种情况考虑：

Python 解法如下：

```Python

class Solution:
    def search(self, nums: List[int], target: int) -> bool:
        
        left,right = 0,len(nums)-1
        
        while left<=right:
            middle = left+(right-left)//2
            
            if nums[middle]==target:
                return True
            
            if nums[right]<nums[middle]:
                # right part is not sorted,eg left part is sorted
                if nums[left]<=target<nums[middle]:
                    right = middle-1
                else:
                    left = middle+1
            elif nums[right]>nums[middle]:
                # right part is sorted
                if nums[middle]<target<=nums[right]:
                    left = middle+1
                else:
                    right = middle-1
            else:
                # nums[right]==nums[middle] and it's not returned so 
                # we can never find a result in right part,try left part
                right -= 1
        
        return False

```