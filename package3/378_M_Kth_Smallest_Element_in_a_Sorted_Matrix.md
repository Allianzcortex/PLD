
Problem description:

```
Given an n x n matrix where each of the rows and columns are sorted in ascending order, return the kth smallest element in the matrix.

Note that it is the kth smallest element in the sorted order, not the kth distinct element.

 

Example 1:

Input: matrix = [[1,5,9],[10,11,13],[12,13,15]], k = 8
Output: 13
Explanation: The elements in the matrix are [1,5,9,10,11,12,13,13,15], and the 8th smallest number is 13
Example 2:

Input: matrix = [[-5]], k = 1
Output: -5
 

Constraints:

n == matrix.length
n == matrix[i].length
1 <= n <= 300
-109 <= matrix[i][j] <= 109
All the rows and columns of matrix are guaranteed to be sorted in non-decreasing order.
1 <= k <= n2

```

Basic idea:

这道题自己一开始确实没思路...因为向右和向下都有可能 LOL

所以第一种解法类似 merge k sorted list，用一个 heap 来解决：

Python 解法如下：

```Python

from heapq import heappush,heappop

class Solution:
    def kthSmallest(self, matrix: List[List[int]], k: int) -> int:
        
        queue = []
        row,column = len(matrix),len(matrix[0])
        
        # 这里是压入每行首位的数字
        # 也可以选择压入每列首位的数字
        for i in range(row):
            heappush(queue,(matrix[i][0],i,0))
        
        for _ in range(k-1):
            val,new_x,new_y = heappop(queue)
            if new_y==column-1:
                continue

            heappush(queue,(matrix[new_x][new_y+1],new_x,new_y+1))
        
        return heappop(queue)[0]

```

第二种解法则是用 Binary Search，实现起来有一定难度，思路是把
左上角的值设置为起始值，右下角的值设置为最终值，然后比较 count

参考：https://leetcode.com/problems/kth-smallest-element-in-a-sorted-matrix/discuss/85173/Share-my-thoughts-and-Clean-Java-Code

实现如下：

```Python




```