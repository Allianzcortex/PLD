Problem Description:

```
Given an integer array nums of unique elements, return all possible subsets (the power set).

The solution set must not contain duplicate subsets. Return the solution in any order.

 

Example 1:

Input: nums = [1,2,3]
Output: [[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
Example 2:

Input: nums = [0]
Output: [[],[0]]
 

Constraints:

1 <= nums.length <= 10
-10 <= nums[i] <= 10
All the numbers of nums are unique.

```

---

My Solution , the most intuitive、recursive one :

```Python
class Solution:
    def subsets(self, nums: List[int]) -> List[List[int]]: 
        res = []
        self.solve(nums,res,[],-1)
        return res
        
    
    def solve(self,nums,res,temp,index):
        if index>len(nums)-1:
            return
        res.append(temp[::])
        for i in range(index+1,len(nums)):
            temp.append(nums[i])
            self.solve(nums,res,temp,i)
            temp.pop()

```

TODO : need to check other languages and other kinds of solutions(e.g. iterative)