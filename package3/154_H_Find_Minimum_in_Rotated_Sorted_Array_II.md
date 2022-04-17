
Problem description:

```

Suppose an array of length n sorted in ascending order is rotated between 1 and n times. For example, the array nums = [0,1,4,4,5,6,7] might become:

[4,5,6,7,0,1,4] if it was rotated 4 times.
[0,1,4,4,5,6,7] if it was rotated 7 times.
Notice that rotating an array [a[0], a[1], a[2], ..., a[n-1]] 1 time results in the array [a[n-1], a[0], a[1], a[2], ..., a[n-2]].

Given the sorted rotated array nums that may contain duplicates, return the minimum element of this array.

You must decrease the overall operation steps as much as possible.

 

Example 1:

Input: nums = [1,3,5]
Output: 1
Example 2:

Input: nums = [2,2,2,0,1]
Output: 0
 

Constraints:

n == nums.length
1 <= n <= 5000
-5000 <= nums[i] <= 5000
nums is sorted and rotated between 1 and n times.
 

Follow up: This problem is similar to Find Minimum in Rotated Sorted Array, but nums may contain duplicates. Would this affect the runtime complexity? How and why?

```

Basic idea:

这道题是 153 的变种，题意相同，不过数组可能存在重复元素。

基本思路仍然是一样的，求出 nums[middle] 和 nums[right] 的值，作比较：

1. `nums[middle]>nums[right]`: 说明 pivot 在 nums[right] 区域，`left = middle + 1`

2. `nums[middle]<nums[right]`: 说明 pivot 在 `left->middle` 区域，保存当下最新值并 `right=middle-1`

3. `nums[middle]==nums[right]`: 这种情况下 pivot 可能在左边也可能在右边，所以保存当下最新值并缩小范围：
`right-=1` 而不是 `right = middle-1`

```Python

class Solution:
    def findMin(self, nums: List[int]) -> int:
        
        left,right = 0,len(nums)-1
        res = float('inf')
        
        while left<=right:
            
            middle = left + (right-left)//2
            
            if nums[middle]>nums[right]:
                # pivot be in the right area
                left = middle+1
            elif nums[middle]<nums[right]:
                # pivot be in the left area
                res = min(res,nums[middle])
                right = middle-1
            else:
                res = min(res,nums[middle])
                right -= 1

        return res

```