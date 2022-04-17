
Problem description:

```

Given an integer array nums, find three numbers whose product is maximum and return the maximum product.

Example 1:

Input: nums = [1,2,3]
Output: 6
Example 2:

Input: nums = [1,2,3,4]
Output: 24
Example 3:

Input: nums = [-1,-2,-3]
Output: -6
 

Constraints:

3 <= nums.length <= 104
-1000 <= nums[i] <= 1000

```

Basic idea:

这道题背后的逻辑是，最大的三个数乘积，一定是下面两个选项之一：

a. 全为正数：最大的为排序后的后三个数相乘

b. 全为负数：最大的仍然为排序后的后三个数相乘

c. 前面为负，后面为正：可能是排序后的后三个数相乘，也有可能前面两个
最小的负数相乘后产生一个极大的正数

对应解法如下：

```Python

class Solution:
    def maximumProduct(self, nums: List[int]) -> int:
        """
        [-7,-6,-5,5,6,7]
        """
        nums.sort()
        max_1 = nums[0]*nums[1]*nums[-1]
        max_2 = nums[-1]*nums[-2]*nums[-3]
        
        return max(max_1,max_2)

```

另外一种方法也是同样的思路，但不需要排序：

`positive max, second max, third max, and negative min, negative second min`

一遍循环就行：

#### TODO 后续再做