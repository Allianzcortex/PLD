
Problem description:

```

You are given an integer array nums. In one move, you can pick an index i where 0 <= i < nums.length and increment nums[i] by 1.

Return the minimum number of moves to make every value in nums unique.

 

Example 1:

Input: nums = [1,2,2]
Output: 1
Explanation: After 1 move, the array could be [1, 2, 3].
Example 2:

Input: nums = [3,2,1,2,1,7]
Output: 6
Explanation: After 6 moves, the array could be [3, 4, 1, 2, 5, 7].
It can be shown with 5 or less moves that it is impossible for the array to have all unique values.
 

Constraints:

1 <= nums.length <= 105
0 <= nums[i] <= 105

```

这道题虽然是 Medium 难度但还是很直观的

以给定的 input 为例：

`[3,2,1,2,1,7]`

自己一开始就想到了肯定要排序，排序后的结果为：

`[1 1 2 2 3 7]`

然后每一次要至少确保后面的数比前一个数大 1：

```
3 2 1  2 1 7
1 1 2  2 3 7
  +1+1+2+2
1 2 3  4 5 7
```

所以对应的思路就很顺理成章了：

time complexity: O(NlogN)
space complexity: O(1)

Python 解法如下：

```Python

class Solution:
    def minIncrementForUnique(self, nums: List[int]) -> int:

        nums.sort()
        length = len(nums)
        cnt = 0
        
        for i in range(1,length):
            if nums[i]>nums[i-1]:
                continue
            else:
                cnt += (nums[i-1]+1-nums[i])
                nums[i] = nums[i-1]+1
        
        return cnt

```
