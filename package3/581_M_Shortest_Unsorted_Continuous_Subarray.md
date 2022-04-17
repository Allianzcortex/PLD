
Problem description:

```
Given an integer array nums, you need to find one continuous subarray that if you only sort this subarray in ascending order, then the whole array will be sorted in ascending order.

Return the shortest such subarray and output its length.

 

Example 1:

Input: nums = [2,6,4,8,10,9,15]
Output: 5
Explanation: You need to sort [6, 4, 8, 10, 9] in ascending order to make the whole array sorted in ascending order.
Example 2:

Input: nums = [1,2,3,4]
Output: 0
Example 3:

Input: nums = [1]
Output: 0
 

Constraints:

1 <= nums.length <= 104
-105 <= nums[i] <= 105
 

Follow up: Can you solve it in O(n) time complexity?

```

Basic idea:

第一种解法是比较直观的方法，用 sorting() 然后找出最左边和最右边的边界，
时间复杂度是 O(nlogn+2*n)

Python 解法如下：

```Python

class Solution:
    def findUnsortedSubarray(self, nums: List[int]) -> int:
                
        sorted_nums = sorted(nums)
        if nums==sorted_nums:
            return 0
        
        start,end = 0,len(nums)-1
        
        while start<=end:
            if nums[start]==sorted_nums[start]:
                start+=1
            else:
                break
        
        while start<=end:
            if nums[end]==sorted_nums[end]:
                end-=1
            else:
                break
        
        return end-start+1

```

---

关于如何优化：

其实我们没有必要排序也可以用遍历一遍 `O(n)` 的方法找出最小和最大值

另外这道题也可以用 monostack 方法来解：

参考：
https://leetcode.com/problems/shortest-unsorted-continuous-subarray/discuss/1562340/Python-stack-solution-O(n)-solution

