
Problem Description:

```
Given an array nums of n integers, return an array of all the unique quadruplets [nums[a], nums[b], nums[c], nums[d]] such that:

0 <= a, b, c, d < n
a, b, c, and d are distinct.
nums[a] + nums[b] + nums[c] + nums[d] == target
You may return the answer in any order.

Example 1:

Input: nums = [1,0,-1,0,-2,2], target = 0
Output: [[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]
Example 2:

Input: nums = [2,2,2,2,2], target = 8
Output: [[2,2,2,2]]
 

Constraints:

1 <= nums.length <= 200
-109 <= nums[i] <= 109
-109 <= target <= 109

```

Basic idea : 

we can convert 4sum to 3sum and solve it.

Here I will provide 2 versions : 

- version1 is to use python slice
- version2 is to not use python slide and use index 

For both versions, the key is still to avoid duplicated items.

Python Solution 1 : with Slice

```Python
class Solution:
    def fourSum(self, nums: List[int], target: int) -> List[List[int]]:
        """a b c d"""
        nums.sort()
        results = []

        for i in range(len(nums)-3):
            if i>0 and nums[i]==nums[i-1]:
                continue
            three_results = self.threeSum(nums[i+1:],target-nums[i],[nums[i]])
            for res in three_results:
                results.append([nums[i]]+res)
        
        return results
        
    
    def threeSum(self,nums,target,prefix):
        
        res = []
        
        for i in range(len(nums)-2):
            left,right = i+1,len(nums)-1
            
            if i>0 and nums[i]==nums[i-1]:
                continue
            
            while left<right:
                _sum = nums[i]+nums[left]+nums[right]

                if _sum == target:
                    res.append([nums[i],nums[left],nums[right]])
                    
                    left += 1
                    while left<right and nums[left]==nums[left-1]:
                        left += 1
                    
                    right -= 1
                    while left<right and nums[right]==nums[right+1]:
                        right -= 1
                
                elif _sum < target:
                    left += 1
                else:
                    right -= 1
            
        return res
```

---

Python Solution 2 : without slide, use index

```Python

class Solution:
    def fourSum(self, nums: List[int], target: int) -> List[List[int]]:
        """a b c d"""
        nums.sort()
        results = []

        for i in range(len(nums)-3):
            if i>0 and nums[i]==nums[i-1]:
                continue
            three_results = self.threeSum(nums,target-nums[i],[nums[i]],i)
            for res in three_results:
                results.append([nums[i]]+res)
        
        return results
        
    
    def threeSum(self,nums,target,prefix,index):
        
        res = []
        
        for i in range(index+1,len(nums)-2):
            left,right = i+1,len(nums)-1
            
            if i>index+1 and nums[i]==nums[i-1]:
                continue
            
            while left<right:
                _sum = nums[i]+nums[left]+nums[right]

                if _sum == target:
                    res.append([nums[i],nums[left],nums[right]])
                    
                    left += 1
                    while left<right and nums[left]==nums[left-1]:
                        left += 1
                    
                    right -= 1
                    while left<right and nums[right]==nums[right+1]:
                        right -= 1
                
                elif _sum < target:
                    left += 1
                else:
                    right -= 1
            
        return res
```