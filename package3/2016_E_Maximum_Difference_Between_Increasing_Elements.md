
Problem description:

```

Given a 0-indexed integer array nums of size n, find the maximum difference between nums[i] and nums[j] (i.e., nums[j] - nums[i]), such that 0 <= i < j < n and nums[i] < nums[j].

Return the maximum difference. If no such i and j exists, return -1.

 

Example 1:

Input: nums = [7,1,5,4]
Output: 4
Explanation:
The maximum difference occurs with i = 1 and j = 2, nums[j] - nums[i] = 5 - 1 = 4.
Note that with i = 1 and j = 0, the difference nums[j] - nums[i] = 7 - 1 = 6, but i > j, so it is not valid.
Example 2:

Input: nums = [9,4,3,2]
Output: -1
Explanation:
There is no i and j such that i < j and nums[i] < nums[j].
Example 3:

Input: nums = [1,5,2,10]
Output: 9
Explanation:
The maximum difference occurs with i = 0 and j = 3, nums[j] - nums[i] = 10 - 1 = 9.

```

Basic idea :

这道题一开始自己想的是用最直接的方法，依次循环遍历，这是 AC 的解法：

```Python

class Solution:
    def maximumDifference(self, nums: List[int]) -> int:
        res = -1
        
        for i in range(len(nums)):
            for j in range(i+1,len(nums)):
                if res<nums[j]-nums[i]:
                    res = nums[j]-nums[i]
        
        return -1 if res==0 else res

```

很快就意识到其实这种解法并不高效，是 O(n^2)，实际只需要在每一次循环时候更新前面最小的值，
类似 best time to buy and sell stock，对应解法如下：

最后需要 handle 一下 res==0 的情况

```Python

class Solution:
    def maximumDifference(self, nums: List[int]) -> int:
        res = -1
        
        minimum = nums[0]
        
        for i in range(1,len(nums)):
            res = max(res,nums[i]-minimum)
            minimum = min(minimum,nums[i])
        
        return -1 if res==0 else res

```