
Problem description:

```
You are given an integer array arr of length n that represents a permutation of the integers in the range [0, n - 1].

We split arr into some number of chunks (i.e., partitions), and individually sort each chunk. After concatenating them, the result should equal the sorted array.

Return the largest number of chunks we can make to sort the array.

 

Example 1:

Input: arr = [4,3,2,1,0]
Output: 1
Explanation:
Splitting into two or more chunks will not return the required result.
For example, splitting into [4, 3], [2, 1, 0] will result in [3, 4, 0, 1, 2], which isn't sorted.
Example 2:

Input: arr = [1,0,2,3,4]
Output: 4
Explanation:
We can split into two chunks, such as [1, 0], [2, 3, 4].
However, splitting into [1, 0], [2], [3], [4] is the highest number of chunks possible.
 

Constraints:

n == arr.length
1 <= n <= 10
0 <= arr[i] < n
All the elements of arr are unique.

```

Basic idea:

这道题是 768 `Max Chunks To Make Sorted II` 的变种，变种就在于所有的 input 满足 2 个条件：

a. input 不存在重复数字
b. input 的数字是从 0~n-1，也就是说 input sort 之后的结果就是它的 index

基本思路是用一个 `prev_max` 来纪录当前出现的最大值，然后根据排序后的结果分段比较

Python 代码如下：

```Python

class Solution:
    def maxChunksToSorted(self, arr: List[int]) -> int:
        stack = []
        prev_max = -1
        cnt = 0
        
        # solution 1 : for the value is only betweeen 0~n-1,so
        # the index is actually the sorted value
        # for index,num in enumerate(arr):
        #     prev_max = max(prev_max,num)
        #     if index==prev_max:
        #         cnt += 1
        
        # solution 2 : more generic, used to handle case like value is not between 
        # 0~n-1. sort the array
        target = sorted(arr)
        for index,num in enumerate(arr):
            prev_max = max(prev_max,num)
            if prev_max == target[index]:
                cnt += 1
        
        return cnt

```

