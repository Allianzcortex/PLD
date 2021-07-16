
Problem Description:

```
Given an integer array nums, return the number of triplets chosen from the array that can make triangles if we take them as side lengths of a triangle.

 

Example 1:

Input: nums = [2,2,3,4]
Output: 3
Explanation: Valid combinations are: 
2,3,4 (using the first 2)
2,3,4 (using the second 2)
2,2,3
Example 2:

Input: nums = [4,2,3,4]
Output: 4
 

Constraints:

1 <= nums.length <= 1000
0 <= nums[i] <= 1000

```

Basic Idea :

Initially I was thinkg like :

三角形成立的条件是:
- 任意两边之和大于第三边
- 任意两边之差小于第三边

So the solution is not efficient and TLE like below :

```Python

class Solution:
    def triangleNumber(self, nums: List[int]) -> int:
        res = 0
        for i in range(0,len(nums)-2):
            for j in range(i+1,len(nums)-1):
                for k in range(j+1,len(nums)):
                    if self.isTriangle([nums[i],nums[j],nums[k]]):
                        res += 1
        
        return res
                    
    def isTriangle(self,num):
        """
        There are 3 values in num
        
        """
        order = {(0,1):2,(0,2):1,(1,2):0}
        for two_sides,c in order.items():
            a , b = two_sides
            if not (num[a]+num[b]>num[c] and abs(num[a]-num[b])<num[c]):
                return False
        
        return True
```

However we still have another better way :

首先排序 -> 如果最小的两边大于第三边 -> 一定成立

So it will be like below :

```Python

class Solution:
    def triangleNumber(self, nums: List[int]) -> int:
        nums.sort()
        res = 0

        for i in range(len(nums)-1,1,-1):
            left ,right = 0,i-1
            
            while left<=right:
                if nums[right]+nums[left]>nums[i]:
                    res += (right-left)
                    right -= 1
                else:
                    left += 1
        
        return res

```