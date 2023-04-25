
Problem description:

```

Given an array of positive integers nums, return the maximum possible sum of an ascending subarray in nums.

A subarray is defined as a contiguous sequence of numbers in an array.

A subarray [numsl, numsl+1, ..., numsr-1, numsr] is ascending if for all i where l <= i < r, numsi  < numsi+1. Note that a subarray of size 1 is ascending.

 

Example 1:

Input: nums = [10,20,30,5,10,50]
Output: 65
Explanation: [5,10,50] is the ascending subarray with the maximum sum of 65.
Example 2:

Input: nums = [10,20,30,40,50]
Output: 150
Explanation: [10,20,30,40,50] is the ascending subarray with the maximum sum of 150.
Example 3:

Input: nums = [12,17,15,13,10,11,12]
Output: 33
Explanation: [10,11,12] is the ascending subarray with the maximum sum of 33.
 

Constraints:

1 <= nums.length <= 100
1 <= nums[i] <= 100

```

Basic Idea:

这道题是求单调递增区间，关键是找出`nums[i]<nums[i+1]` 这个条件停止之后它会落在哪里

```Python

class Solution:
    def maxAscendingSum(self, nums: List[int]) -> int:
        # the number can't be negative number so it makes our life easier

        if(len(nums))==0:
            return 0
        
        res = nums[0]
        i = 0
        while i<len(nums)-1:
            temp = 0
            while i<len(nums)-1 and nums[i]<nums[i+1]:
                temp+=nums[i]
                i+=1
            if i<len(nums):
                temp+=nums[i]
            
            res = max(res,temp)
            i+=1
            
        return res

```