
Problem description:

```

Given an integer array nums, move all 0's to the end of it while maintaining the relative order of the non-zero elements.

Note that you must do this in-place without making a copy of the array.

 

Example 1:

Input: nums = [0,1,0,3,12]
Output: [1,3,12,0,0]
Example 2:

Input: nums = [0]
Output: [0]

```

这里有两个思路：

1. 使用 insert index，把所有非 0 的数字都向数组前边移动，然后把更新后的 index 所有数都置 0

```Python

class Solution:
    def moveZeroes(self, nums: List[int]) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        zeroCnt = 0
        
        left,right = 0,len(nums)-1
        index = 0
        
        while left<=right:
            if nums[left]!=0:
                nums[index] = nums[left]
                index += 1
            left += 1
        
        while index<=right:
            nums[index] = 0
            index += 1

```

#### update 

在 revisit 这道题的时候自己想出了类似上面的解法，但用的是 2 pointers 实现

```Python

class Solution:
    def moveZeroes(self, nums: List[int]) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        left,right = 0,0

        while right<len(nums):
            # find the number that isn't 0
            while right<len(nums) and nums[right]==0:
                right += 1
            
            if right>len(nums)-1:
                break
            
            # swap left&right anyways
            nums[left],nums[right] = nums[right],nums[left]
            left += 1
            right += 1
        
        # fill remaining position
        while left<len(nums):
            nums[left]=0
            left += 1

```

2. 使用 two pointers，当 nums[slow]==0 和 nums[fast]!=0 的时候交换数字，然后在 nums[left]!=0 的时候再更新

```Python

class Solution:
    def moveZeroes(self, nums: List[int]) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        
        left,right = 0,0
        
        while right<=len(nums)-1:
            
            if nums[right]!=0 and nums[left]==0:
                nums[left],nums[right] = nums[right],nums[left]
            
            if nums[left]!=0:
                left += 1
            
            right += 1

```