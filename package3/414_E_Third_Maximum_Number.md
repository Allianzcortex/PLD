
Problem description:

```

Given an integer array nums, return the third distinct maximum number in this array. If the third maximum does not exist, return the maximum number.

 

Example 1:

Input: nums = [3,2,1]
Output: 1
Explanation:
The first distinct maximum is 3.
The second distinct maximum is 2.
The third distinct maximum is 1.
Example 2:

Input: nums = [1,2]
Output: 2
Explanation:
The first distinct maximum is 2.
The second distinct maximum is 1.
The third distinct maximum does not exist, so the maximum (2) is returned instead.
Example 3:

Input: nums = [2,2,3,1]
Output: 1
Explanation:
The first distinct maximum is 3.
The second distinct maximum is 2 (both 2's are counted together since they have the same value).
The third distinct maximum is 1.
 

Constraints:

1 <= nums.length <= 104
-231 <= nums[i] <= 231 - 1
 

Follow up: Can you find an O(n) solution?

```

Basic idea:

这道题用 Python 标准库来做很容易 AC:

```Python
class Solution:
    def thirdMax(self, nums: List[int]) -> int:
        
        s = sorted(set(nums))
        
        return s[-1] if len(s)<3 else s[-3]

```

但 `follow-up` 里问有没有 O(N) 的解法，也就是要求一次遍历：
对此的解法如下：

```Python

class Solution:
    def thirdMax(self, nums: List[int]) -> int:
        
        s = [float('-inf'),float('-inf'),float('-inf')]
        
        for num in nums:
            if num in s:
                continue
                
            if num>s[0]:
                # 把最大的放左边，其余的向右移动
                s = [num,s[0],s[1]]
            elif num>s[1]:
                # 把最大的放中间，其余的也向右移动
                s = [s[0],num,s[1]]
            elif num>s[2]:
                # 把最大的放最后一个
                s = [s[0],s[1],num]
        
        return s[2] if s[2]!=float('-inf') else s[0]

```