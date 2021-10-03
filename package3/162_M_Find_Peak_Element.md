
Problem description:

```

A peak element is an element that is strictly greater than its neighbors.

Given an integer array nums, find a peak element, and return its index. If the array contains multiple peaks, return the index to any of the peaks.

You may imagine that nums[-1] = nums[n] = -∞.

You must write an algorithm that runs in O(log n) time.

 

Example 1:

Input: nums = [1,2,3,1]
Output: 2
Explanation: 3 is a peak element and your function should return the index number 2.
Example 2:

Input: nums = [1,2,1,3,5,6,4]
Output: 5
Explanation: Your function can return either index number 1 where the peak element is 2, or index number 5 where the peak element is 6.

```

这道题算是二分搜索的变种，其实挺有趣的：

1. 不需要对数组排序也可以用 binary search

2. 基本逻辑是这样：

找到 middle 然后


Python 解法如下：

```Python

class Solution:
    def findPeakElement(self, nums: List[int]) -> int:
        
        left,right = 0,len(nums)-1
        
        while left<right:
            middle = left+(right-left)//2
            
            if nums[middle]>nums[middle-1] and nums[middle]>nums[middle+1]:
                return middle
            
            if nums[middle]<nums[middle+1]:
                left = middle+1
            else:
                right = middle-1
        
        return left

```