
Problem description:

```

Given an array nums, return true if the array was originally sorted in non-decreasing order, then rotated some number of positions (including zero). Otherwise, return false.

There may be duplicates in the original array.

Note: An array A rotated by x positions results in an array B of the same length such that A[i] == B[(i+x) % A.length], where % is the modulo operation.

 

Example 1:

Input: nums = [3,4,5,1,2]
Output: true
Explanation: [1,2,3,4,5] is the original sorted array.
You can rotate the array by x = 3 positions to begin on the the element of value 3: [3,4,5,1,2].
Example 2:

Input: nums = [2,1,3,4]
Output: false
Explanation: There is no sorted array once rotated that can make nums.
Example 3:

Input: nums = [1,2,3]
Output: true
Explanation: [1,2,3] is the original sorted array.
You can rotate the array by x = 0 positions (i.e. no rotation) to make nums.

```

Basic Idea:

要想好，如果一个数组被 rotate，那么会有哪些特征，两个阶段的数组都是递增，然后比较最大和最小

Python 解法如下：

```Python

class Solution:
    def check(self, nums: List[int]) -> bool:

        i = 0
        while i<len(nums)-1 and nums[i]<=nums[i+1]:
            i+=1
        
        if i==len(nums)-1:
            return True
        
        # check the 2nd part of array
        for j in range(i+1,len(nums)-1):
            if nums[j]>nums[j+1]:
                return False

        # check the 1st part of array
        if nums[-1]>nums[0]:
            return False
        
        return True

```