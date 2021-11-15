
Problem description:

```

Given the array of integers nums, you will choose two different indices i and j of that array. Return the maximum value of (nums[i]-1)*(nums[j]-1).
 

Example 1:

Input: nums = [3,4,5,2]
Output: 12 
Explanation: If you choose the indices i=1 and j=2 (indexed from 0), you will get the maximum value, that is, (nums[1]-1)*(nums[2]-1) = (4-1)*(5-1) = 3*4 = 12. 
Example 2:

Input: nums = [1,5,4,5]
Output: 16
Explanation: Choosing the indices i=1 and j=3 (indexed from 0), you will get the maximum value of (5-1)*(5-1) = 16.
Example 3:

Input: nums = [3,7]
Output: 12
 

Constraints:

2 <= nums.length <= 500
1 <= nums[i] <= 10^3

```

Basic idea:

这道题题目限制里有说：`1 <= nums[i] <= 10^3`，所以也就不考虑负数的情况。

只要求出两个最大的值就行，那就很简单了

Python 解法如下：

```Python

class Solution:
    def maxProduct(self, nums: List[int]) -> int:
        """
        first 2 are negative numbers:
        first 2 are positive numbers:
        
        first 2 : 1 is negative,one is positive
        
        """
        
        max1,max2 = float('-inf'),float('-inf')
        
        for num in nums:
            if num>max1:
                max1,max2 = num,max1
            elif num>max2:
                max2 = num

        return (max1-1)*(max2-1)

```

