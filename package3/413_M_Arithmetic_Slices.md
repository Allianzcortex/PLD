
Problem description:

```

An integer array is called arithmetic if it consists of at least three elements and if the difference between any two consecutive elements is the same.

For example, [1,3,5,7,9], [7,7,7,7], and [3,-1,-5,-9] are arithmetic sequences.
Given an integer array nums, return the number of arithmetic subarrays of nums.

A subarray is a contiguous subsequence of the array.

 

Example 1:

Input: nums = [1,2,3,4]
Output: 3
Explanation: We have 3 arithmetic slices in nums: [1, 2, 3], [2, 3, 4] and [1,2,3,4] itself.
Example 2:

Input: nums = [1]
Output: 0
 

Constraints:

1 <= nums.length <= 5000
-1000 <= nums[i] <= 1000

```

Basic idea:

这道题也算是 medium 难度吧：

比如 ` 1 2 3 4 5`

到 2 的时候有 `1 2 3` 算 1 个
到 3 的时候有 `2 3 4`，同时算上前面 `1 2 3` 的 1 个，1 + 1 = 2
依此类推，一共有 1+2+3 = 6 个

要证明 (:-

Python 解法如下：

```Python

class Solution:
    def numberOfArithmeticSlices(self, nums: List[int]) -> int:
        
        length = len(nums)
        dp = [0]*length
        
        for i in range(2,length):
            if nums[i]-nums[i-1] == nums[i-1]-nums[i-2]:
                dp[i] = dp[i-1]+1
        
        return sum(dp)

```

要优化空间复杂度，只用一个变量来存储：

```Python

class Solution:
    def numberOfArithmeticSlices(self, nums: List[int]) -> int:
        
        sum_,curr = 0,0
        
        for i in range(2,len(nums)):
            if nums[i]-nums[i-1] == nums[i-1]-nums[i-2]:
                curr += 1
                sum_ += curr
            else:
                curr = 0
        
        return sum_

```