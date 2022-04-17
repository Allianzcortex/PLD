
Problem description:

```

Given an array of integers nums, find the maximum length of a subarray where the product of all its elements is positive.

A subarray of an array is a consecutive sequence of zero or more values taken out of that array.

Return the maximum length of a subarray with positive product.

 

Example 1:

Input: nums = [1,-2,-3,4]
Output: 4
Explanation: The array nums already has a positive product of 24.
Example 2:

Input: nums = [0,1,-2,-3,-4]
Output: 3
Explanation: The longest subarray with positive product is [1,-2,-3] which has a product of 6.
Notice that we cannot include 0 in the subarray since that'll make the product 0 which is not positive.
Example 3:

Input: nums = [-1,-2,-3,0,1]
Output: 2
Explanation: The longest subarray with positive product is [-1,-2] or [-2,-3].
Example 4:

Input: nums = [-1,2]
Output: 1
Example 5:

Input: nums = [1,2,3,5,-6,4,0,10]
Output: 4
 

Constraints:

1 <= nums.length <= 10^5
-10^9 <= nums[i] <= 10^9

```

Basic idea:

这道题是很典型的 DP 题目，和 152 Maximum Product Subarray 一脉相承
基本思路就是用两个 array `pos[]` 和 `neg[]` 来表示，
pos[i] 表示到 i 为止乘积为 positive 的最大长度
neg[i] 表示到 i 为止乘积为 negative 的最大长度

Python 解法如下：

```Python

class Solution:
    def getMaxLen(self, nums: List[int]) -> int:
        
        length = len(nums)
        pos = [0]*length
        neg = [0]*length
        
        if nums[0]>0:
            pos[0] = 1
        elif nums[0]<0:
            neg[0] = 1
        
        res = pos[0]
        for i in range(1,length):
            if nums[i]>0:
                # 就算是 num[i-1] 为 0，也不影响 nums[i]>0 时 pos[i] 为 1
                # 而如果 neg[i-1] 为 0，就说明到 i-1 num 为止不存在使成绩为 neg 的序列
                # 恰好 nums[i]>0，就进一步说明 neg[i] 为 0
                pos[i] = pos[i-1]+1
                neg[i] = neg[i-1]+1 if neg[i-1]>0 else 0
            
            elif nums[i]<0:
                neg[i] = pos[i-1]+1
                pos[i] = neg[i-1]+1 if neg[i-1]>0 else 0
            
            else:
                pos[i],neg[i] = 0,0
            
            res = max(res,pos[i])
        
        return res

```

优化一下空间复杂度，只用两个变量来表示，结果如下：

```Python

class Solution:
    def getMaxLen(self, nums: List[int]) -> int:
        
        max_positive = 1 if nums[0]>0 else 0
        max_negative = 1 if nums[0]<0 else 0
        res = max_positive
        
        for num in nums[1:]:
            if num>0:
                max_positive +=  1 # max_positive+1
                max_negative = 1+max_negative if max_negative>0 else 0
                
            elif num<0:
                old_max_positive = max_positive
                max_positive = 1+max_negative if max_negative>0 else 0
                max_negative = old_max_positive+1
            
            else:
                max_positive,max_negative = 0,0
            
            res = max(res,max_positive)
            
        return res

```