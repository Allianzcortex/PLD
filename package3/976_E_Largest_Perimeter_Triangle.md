
Problem description:

```

Given an integer array nums, return the largest perimeter of a triangle with a non-zero area, formed from three of these lengths. If it is impossible to form any triangle of a non-zero area, return 0.

 

Example 1:

Input: nums = [2,1,2]
Output: 5
Example 2:

Input: nums = [1,2,1]
Output: 0
Example 3:

Input: nums = [3,2,3,4]
Output: 10
Example 4:

Input: nums = [3,6,2,3]
Output: 8
 

Constraints:

3 <= nums.length <= 104
1 <= nums[i] <= 106

```

Basic idea:

基本的数学道理，给定三个数字，任意两边之和大于第三边

所以先排序，然后从大到小依次试，只要找到一个就返回，因为它一定是最大的

Python 解法如下：

```Python

class Solution:
    def largestPerimeter(self, nums: List[int]) -> int:
        
        s_nums = sorted(nums)
        
        for i in range(len(nums)-1,1,-1):
            if s_nums[i-1]+s_nums[i-2]>s_nums[i]:
                return s_nums[i-1]+s_nums[i-2]+s_nums[i]
        
        return 0

````