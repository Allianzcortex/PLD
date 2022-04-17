Problem Description:

```
Suppose an array of length n sorted in ascending order is rotated between 1 and n times. For example, the array nums = [0,1,2,4,5,6,7] might become:

[4,5,6,7,0,1,2] if it was rotated 4 times.
[0,1,2,4,5,6,7] if it was rotated 7 times.
Notice that rotating an array [a[0], a[1], a[2], ..., a[n-1]] 1 time results in the array [a[n-1], a[0], a[1], a[2], ..., a[n-2]].

Given the sorted rotated array nums of unique elements, return the minimum element of this array.

 

Example 1:

Input: nums = [3,4,5,1,2]
Output: 1
Explanation: The original array was [1,2,3,4,5] rotated 3 times.
Example 2:

Input: nums = [4,5,6,7,0,1,2]
Output: 0
Explanation: The original array was [0,1,2,4,5,6,7] and it was rotated 4 times.
Example 3:

Input: nums = [11,13,15,17]
Output: 11
Explanation: The original array was [11,13,15,17] and it was rotated 4 times. 
 

Constraints:

n == nums.length
1 <= n <= 5000
-5000 <= nums[i] <= 5000
All the integers of nums are unique.
nums is sorted and rotated between 1 and n times.

```

Basic idea :

The basic idea is like problem 154,only compare middle with right : 

基本思路如下，如果 num

1. 如果 nums[middle]>nums[right]，就肯定说明 `pivot` 在 `middle->right` 之间。同时
因为最少有一个数比 nums[middle] 小，所以可以赋值 `left=middle+1`

2. 其他情况下说明最小值就在 `left->middle` 之间，可能是 `nums[middle]` 也可能是其他值，用
一个 res 来存储每次的最小值。这样就符合标准的二分搜索 template


```
Space Complexity : O(1)
TIme  Complexity : Classic Binary Search Problem, should be O(log(N))

```

```Python

class Solution:
    def findMin(self, nums: List[int]) -> int:
        
        left,right = 0,len(nums)-1
        res = float('inf')
        
        while left<=right:
            middle = left+(right-left)//2
            
            if nums[middle]>nums[right]:
                # pivot be in the right part
                left = middle + 1
            else:
                res = min(res,nums[middle])
                right = middle-1

        return res

```

