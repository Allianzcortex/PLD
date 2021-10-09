
Problem description:

```
Given an array nums of n integers where nums[i] is in the range [1, n], return an array of all the integers in the range [1, n] that do not appear in nums.

 

Example 1:

Input: nums = [4,3,2,7,8,2,3,1]
Output: [5,6]
Example 2:

Input: nums = [1,1]
Output: [2]
 

Constraints:

n == nums.length
1 <= n <= 105
1 <= nums[i] <= n
 

Follow up: Could you do it without extra space and in O(n) runtime? You may assume the returned list does not count as extra space.

```

Basic idea:

这道题和 442 非常类似，都是把 `abs(va)-1` 作为 index
然后这道题只要出现过一次，就置负，那么数字为正的 index+1
就是需要的数字

AC 解法如下：

```Python

class Solution:
    def findDisappearedNumbers(self, nums: List[int]) -> List[int]:
        
        res = []
        
        for num in nums:
            index = abs(num)-1
            nums[index] = -1*abs(nums[index])
        
        res = [index+1 for index,num in enumerate(nums) if num>0]
        
        return res

```