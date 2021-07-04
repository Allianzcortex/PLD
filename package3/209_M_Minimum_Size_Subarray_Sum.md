
Problem Description:

```
Given an array of positive integers nums and a positive integer target, return the minimal length of a contiguous subarray [numsl, numsl+1, ..., numsr-1, numsr] of which the sum is greater than or equal to target. If there is no such subarray, return 0 instead.

 

Example 1:

Input: target = 7, nums = [2,3,1,2,4,3]
Output: 2
Explanation: The subarray [4,3] has the minimal length under the problem constraint.
Example 2:

Input: target = 4, nums = [1,4,4]
Output: 1
Example 3:

Input: target = 11, nums = [1,1,1,1,1,1,1,1]
Output: 0
 

Constraints:

1 <= target <= 109
1 <= nums.length <= 105
1 <= nums[i] <= 105
 

Follow up: If you have figured out the O(n) solution, try coding another solution of which the time complexity is O(n log(n)).

```

Idea :

This is the most classic sliding window solution :

```Python

class Solution:
    def minSubArrayLen(self, target: int, nums: List[int]) -> int:
        """
        
        """
        left,total = 0,0
        ans = len(nums)+1
        
        for right in range(len(nums)):
            total += nums[right]
            
            while total>=target:
                ans = min(ans,right-left+1)
                total -= nums[left]
                left += 1
        
        return 0 if ans==len(nums)+1 else ans

```

For sliding windows, time complexity will be O(n),the question also mentiones O(n logn)
Solutions, it ill be in this link :

https://leetcode.com/problems/minimum-size-subarray-sum/discuss/59123/O(N)O(NLogN)-solutions-both-O(1)-space

Will check it later