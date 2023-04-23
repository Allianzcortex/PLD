
Problem description:

```
Given an integer array arr, return the mean of the remaining integers after removing the smallest 5% and the largest 5% of the elements.

Answers within 10-5 of the actual answer will be considered accepted.

 

Example 1:

Input: arr = [1,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,3]
Output: 2.00000
Explanation: After erasing the minimum and the maximum values of this array, all elements are equal to 2, so the mean is 2.
Example 2:

Input: arr = [6,2,7,5,1,2,0,3,10,2,5,0,5,5,0,8,7,6,8,0]
Output: 4.00000
Example 3:

Input: arr = [6,0,7,0,7,5,7,8,3,4,0,7,8,1,6,8,1,1,2,4,8,1,9,5,4,3,8,5,10,8,6,6,1,0,6,10,8,2,3,4]
Output: 4.77778
 

Constraints:

20 <= arr.length <= 1000
arr.length is a multiple of 20.
0 <= arr[i] <= 105

```

idea:

这道题没什么特别的技巧，就按照正常的 slice 操作得到 output_array 后再计算 mean
比较神奇的是自己一开始 index 没有想清楚...用的是 `arr[removed_nums:len(arr)-removed_nums+1]`
的操作来去除最大的元素，真的是一段时间没刷题就手生

Python 解法如下：

```Python

class Solution:
    def trimMean(self, arr: List[int]) -> float:
        removed_nums = int(len(arr)/20)
        arr.sort()
        output_arr = arr[removed_nums:len(arr)-removed_nums]
        return sum(output_arr)/len(output_arr)

```