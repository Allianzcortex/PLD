
Problem description:

```

Given a binary array nums and an integer k, return the maximum number of consecutive 1's in the array if you can flip at most k 0's.

 

Example 1:

Input: nums = [1,1,1,0,0,0,1,1,1,1,0], k = 2
Output: 6
Explanation: [1,1,1,0,0,1,1,1,1,1,1]
Bolded numbers were flipped from 0 to 1. The longest subarray is underlined.
Example 2:

Input: nums = [0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1], k = 3
Output: 10
Explanation: [0,0,1,1,1,1,1,1,1,1,1,1,0,0,0,1,1,1,1]
Bolded numbers were flipped from 0 to 1. The longest subarray is underlined.
 

Constraints:

1 <= nums.length <= 105
nums[i] is either 0 or 1.
0 <= k <= nums.length

```

Basic idea:

这道题是一道很经典的滑动窗口题目

题目的意思是：maximum number of consecutive 1's in the array if you can flip at most k 0's. 本质上就是求最大窗口，窗口里最多可以包含 K 个 0.

按照滑动窗口的经典模板：

```markdown
1. right 主动右移：如果 nums[right]==0 则对 zeroes 的数量 + 1

2. 然后对 zeroes 在循环里进行判断，如果发现 zeroes 数量大于 k，则要进行左移直到 zeroes 的数量符合要求

3. 在每次循环里判断 `right-left+1` 是否为最大值
```

Python 代码如下：

```Python

class Solution:
    def longestOnes(self, nums: List[int], k: int) -> int:
        
        length = len(nums)
        left,right = 0,0
        res = 0
        zeroes = 0
        
        while right<length:
            if nums[right]==0:
                zeroes += 1
            
            while zeroes>k:
                if nums[left]==0:
                    zeroes-=1
                left+=1
            
            res = max(res,right-left+1)
            right += 1
        
        return res

```
