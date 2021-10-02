
Problem description:

```

You are given a 0-indexed integer array nums. For each index i (1 <= i <= nums.length - 2) the beauty of nums[i] equals:

2, if nums[j] < nums[i] < nums[k], for all 0 <= j < i and for all i < k <= nums.length - 1.
1, if nums[i - 1] < nums[i] < nums[i + 1], and the previous condition is not satisfied.
0, if none of the previous conditions holds.
Return the sum of beauty of all nums[i] where 1 <= i <= nums.length - 2.

 

Example 1:

Input: nums = [1,2,3]
Output: 2
Explanation: For each index i in the range 1 <= i <= 1:
- The beauty of nums[1] equals 2.
Example 2:

Input: nums = [2,4,6,4]
Output: 1
Explanation: For each index i in the range 1 <= i <= 2:
- The beauty of nums[1] equals 1.
- The beauty of nums[2] equals 0.
Example 3:

Input: nums = [3,2,1]
Output: 0
Explanation: For each index i in the range 1 <= i <= 1:
- The beauty of nums[1] equals 0.

```

Basic idea :

这道题自己一开始的想法是没问题的，就是用 2 个变量存储

a) 储存从左到右的最大值，然后每次遇到这个值，leftVal = max(leftVal,nums[i])

b) 储存从右到左的最小值。自己一开始想的和 a) 一致，用一个变量来表示，但这样从左往右
   推的时候实际上无法知道当前元素的最右的最小值，所以换用 prefix 的思路，用一组数组来表示

对应的 Python 代码如下：

中间设立新数组这块对应的的 index 还有点 tricky，以后有机会再写一遍

```Python

class Solution:
    def sumOfBeauties(self, nums: List[int]) -> int:
        
        #step:1 get minimum
        maximum_prefix = nums[0]
        
        # 2 get maximum
        minimum_suffix = [float('inf')]*(len(nums))
        minimum_suffix[-1] = nums[-1]
        for i in range(len(nums)-2,1,-1):
            minimum_suffix[i]=min(nums[i] , minimum_suffix[i+1])
        
        # tarverse throught the whole array 
        res = 0
        for i in range(1,len(nums)-1):
            if maximum_prefix<nums[i]<minimum_suffix[i+1]:
                res+=2
            elif nums[i-1]<nums[i]<nums[i+1]:
                res+=1
            
            maximum_prefix = max(maximum_prefix,nums[i])
        
        return res

```