
Problem description:

```

Given an array of integers nums, you start with an initial positive value startValue.

In each iteration, you calculate the step by step sum of startValue plus elements in nums (from left to right).

Return the minimum positive value of startValue such that the step by step sum is never less than 1.

 

Example 1:

Input: nums = [-3,2,-3,4,2]
Output: 5
Explanation: If you choose startValue = 4, in the third iteration your step by step sum is less than 1.
                step by step sum
                startValue = 4 | startValue = 5 | nums
                  (4 -3 ) = 1  | (5 -3 ) = 2    |  -3
                  (1 +2 ) = 3  | (2 +2 ) = 4    |   2
                  (3 -3 ) = 0  | (4 -3 ) = 1    |  -3
                  (0 +4 ) = 4  | (1 +4 ) = 5    |   4
                  (4 +2 ) = 6  | (5 +2 ) = 7    |   2
Example 2:

Input: nums = [1,2]
Output: 1
Explanation: Minimum start value should be positive. 
Example 3:

Input: nums = [1,-2,-3]
Output: 5
 

Constraints:

1 <= nums.length <= 100
-100 <= nums[i] <= 100

```

Basic idea:

一道 easy 题，题目很直观，这是自己做的第一次 AC 解法：

```Python

class Solution:
    def minStartValue(self, nums: List[int]) -> int:
        
        maxRes = 1 - nums[0]
        curr = 1
        length = len(nums)
        
        for i in range(1,length):
            curr += nums[i]
            if curr<=0:
                maxRes += (1-curr)
                curr = 1
        return maxRes if maxRes>0 else 1

```

另外一种解法时间复杂度也是 O(N)，是遍历包括第一个元素然后找出 min_sum，解法如下：

```Python

class Solution:
    def minStartValue(self, nums: List[int]) -> int:
        
        sum_,min_sum = 0,0
        
        for num in nums:
            sum_ += num
            min_sum = min(min_sum,sum_)
        
        return 1-min_sum

```