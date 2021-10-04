
Problem description:

```

Given an integer array nums sorted in non-decreasing order, return an array of the squares of each number sorted in non-decreasing order.

 

Example 1:

Input: nums = [-4,-1,0,3,10]
Output: [0,1,9,16,100]
Explanation: After squaring, the array becomes [16,1,0,9,100].
After sorting, it becomes [0,1,9,16,100].
Example 2:

Input: nums = [-7,-3,2,3,11]
Output: [4,9,9,49,121]
 

Constraints:

1 <= nums.length <= 104
-104 <= nums[i] <= 104
nums is sorted in non-decreasing order.
 

Follow up: Squaring each element and sorting the new array is very trivial, could you find an O(n) solution using a different approach?

```

Basic idea :

两种思路吧，一种是最直观的，排序然后取值：

```Python

class Solution:
    def sortedSquares(self, nums: List[int]) -> List[int]:
        
        nums.sort(key=lambda x:abs(x))    
        return [x**2 for x in nums]

```

第二种是 O(N) 时间复杂度，用 two pointer 来做：

```Python

class Solution:
    def sortedSquares(self, nums: List[int]) -> List[int]:
        
        length = len(nums)
        
        left,right = 0,length-1
        res = [0]*(length)
        
        while length>0:
            
            if abs(nums[left])<abs(nums[right]):
                res[length-1]=nums[right]**2
                right-=1
            else:
                res[length-1]=nums[left]**2
                left+=1
            length-=1
        
        return res

```