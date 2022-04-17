
Problem description:

```
You are given an integer array nums and an integer k. You want to find a subsequence of nums of length k that has the largest sum.

Return any such subsequence as an integer array of length k.

A subsequence is an array that can be derived from another array by deleting some or no elements without changing the order of the remaining elements.

 

Example 1:

Input: nums = [2,1,3,3], k = 2
Output: [3,3]
Explanation:
The subsequence has the largest sum of 3 + 3 = 6.
Example 2:

Input: nums = [-1,-2,3,4], k = 3
Output: [-1,3,4]
Explanation: 
The subsequence has the largest sum of -1 + 3 + 4 = 6.
Example 3:

Input: nums = [3,4,3,3], k = 2
Output: [3,4]
Explanation:
The subsequence has the largest sum of 3 + 4 = 7. 
Another possible subsequence is [4, 3].
 

Constraints:

1 <= nums.length <= 1000
-105 <= nums[i] <= 105
1 <= k <= nums.length

```

Basic idea:

这道题基本就类似于： 求 Top K 最大值然后保留原来的顺序

思路是用 heap 压入 (val,index) 然后用最大堆来存储，再然后根据 index 生成 string

```Python

class Solution:
    def maxSubsequence(self, nums: List[int], k: int) -> List[int]:
        
        # time complexity : O(N) + O(klogN) + O(klogk)
        nums = [(-1*num,index) for index,num in enumerate(nums)]
        
        heapify(nums)
        length = len(nums)
        res = []
        
        for _ in range(k):
            res.append(heappop(nums))
        
        return [-1*num[0] for num in sorted(res,key = lambda n:n[1])]

```