
Problem description:

```

You are given an integer array arr.

We split arr into some number of chunks (i.e., partitions), and individually sort each chunk. After concatenating them, the result should equal the sorted array.

Return the largest number of chunks we can make to sort the array.

 

Example 1:

Input: arr = [5,4,3,2,1]
Output: 1
Explanation:
Splitting into two or more chunks will not return the required result.
For example, splitting into [5, 4], [3, 2, 1] will result in [4, 5, 1, 2, 3], which isn't sorted.
Example 2:

Input: arr = [2,1,3,4,4]
Output: 4
Explanation:
We can split into two chunks, such as [2, 1], [3, 4, 4].
However, splitting into [2, 1], [3], [4], [4] is the highest number of chunks possible.
 

Constraints:

1 <= arr.length <= 2000
0 <= arr[i] <= 108

```

这道题就直接上自己的解法吧：

思路是先排序，比如：`[2,1,3,4,4]`，排序后的结果为：`[1,2,3,4,4]`

然后进行比较：

[2,1,3,4,4]

[1,2,3,4,4]

因为 `2+1==1+2`，所以前两个必须放在一个 partition 里，然后依此类推
还有一种解法是用 `stack`，也很好。

```Python

class Solution:
    def maxChunksToSorted(self, arr: List[int]) -> int:

        prev_max = -1
        cnt = 0

        target = sorted(arr)
        sum1,sum2 = 0,0
        
        for index,num in enumerate(arr):
            sum1 += num
            sum2 += target[index]
            if sum1 == sum2:
                cnt += 1
        
        return cnt
```
