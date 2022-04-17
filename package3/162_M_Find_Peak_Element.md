
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

这道题算是二分搜索的变种，其实挺有趣的，虽然输入数组不是有序的，但仍然可以用 binary search 的思想来做：

1. 找到 middle 然后比较 left_val 和 right_val，如果找到的是 peak 就返回

2. 如果 `nums[middle]<nums[middle+1]`，那么就说明在 `(middle+1->right]` 部分一定存在一个 peak，证明如下 如果 right->right 部分
   a. 继续递增：那么最右的元素一定是 Peak
   b. 继续递减：那么 middle+1 就是 Peak
   c. 先递增后递减/先递减后递增：都可以在数据变化的区间内找到 Peak

3. 同理 `nums[middle]>nums[middle+1]`,也可以在 `(left->middle-1]` 范围内找到 Peak


Python 解法如下：

```Python

class Solution:
    def findPeakElement(self, nums: List[int]) -> int:
        
        left,right = 0,len(nums)-1
        res = -1
        
        while left<=right:
            middle = left+(right-left)//2
            
            prev_val = float('-inf') if middle==0 else nums[middle-1]
            next_val = float('-inf') if middle==len(nums)-1 else nums[middle+1]  
            
            if prev_val < nums[middle] and nums[middle]> next_val:
                return middle
            
            if nums[middle]<nums[middle+1]:
                left = middle+1
            else:
                right = middle-1
        
        return left

```