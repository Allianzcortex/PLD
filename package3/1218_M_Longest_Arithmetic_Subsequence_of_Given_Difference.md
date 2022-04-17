
Problem description:

```

Given an integer array arr and an integer difference, return the length of the longest subsequence in arr which is an arithmetic sequence such that the difference between adjacent elements in the subsequence equals difference.

A subsequence is a sequence that can be derived from arr by deleting some or no elements without changing the order of the remaining elements.

 

Example 1:

Input: arr = [1,2,3,4], difference = 1
Output: 4
Explanation: The longest arithmetic subsequence is [1,2,3,4].
Example 2:

Input: arr = [1,3,5,7], difference = 1
Output: 1
Explanation: The longest arithmetic subsequence is any single element.
Example 3:

Input: arr = [1,5,7,8,5,3,4,2,1], difference = -2
Output: 4
Explanation: The longest arithmetic subsequence is [7,5,3,1].

```

Basic idea:

这道题是 DP 的思想，用一个 map 来存储
`{key : 以当前 key 结尾的满足要求的 subsequence 的长度`

Python 代码如下：

```Python
class Solution:
    def longestSubsequence(self, arr: List[int], difference: int) -> int:
        maps = {}
        res = 1
        
        for num in arr:
            maps[num] = maps.get(num-difference,0)+1
        
        return max(maps.values())

```