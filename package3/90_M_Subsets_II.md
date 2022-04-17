Problem Description:

```
Given an integer array nums that may contain duplicates, return all possible subsets (the power set).

The solution set must not contain duplicate subsets. Return the solution in any order.

 

Example 1:

Input: nums = [1,2,2]
Output: [[],[1],[1,2],[1,2,2],[2],[2,2]]
Example 2:

Input: nums = [0]
Output: [[],[0]]
 

Constraints:

1 <= nums.length <= 10
-10 <= nums[i] <= 10
```

Solution:

There are multiple solutions, you can check here: https://leetcode.wang/leetCode-90-SubsetsII.html

Now the most basic one, sort and check whether item is duplciated with previous one, should be enough

It's very like the problem 78 Subsets, but this problem contains duplciated numbers

```Python
class Solution:
    def subsetsWithDup(self, nums: List[int]) -> List[List[int]]:
        res = []
        self.solve(sorted(nums),res,[],-1)
        return res
        
    
    def solve(self,nums,res,temp,index):
        if index>len(nums)-1:
            return
        res.append(temp[::])
        for i in range(index+1,len(nums)):
            if i>(index+1) and nums[i]==nums[i-1]:
                continue
            temp.append(nums[i])
            self.solve(nums,res,temp,i)
            temp.pop()
```