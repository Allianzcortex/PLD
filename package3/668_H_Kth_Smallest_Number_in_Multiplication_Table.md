
Problem description:

```

Nearly everyone has used the Multiplication Table. The multiplication table of size m x n is an integer matrix mat where mat[i][j] == i * j (1-indexed).

Given three integers m, n, and k, return the kth smallest element in the m x n multiplication table.

 

Example 1:


Input: m = 3, n = 3, k = 5
Output: 3
Explanation: The 5th smallest number is 3.
Example 2:


Input: m = 2, n = 3, k = 6
Output: 6
Explanation: The 6th smallest number is 6.
 

Constraints:

1 <= m, n <= 3 * 104
1 <= k <= m * n

```

Basic idea:

这道题就是给定一个乘法表，要求里面第 K 小的元素。

这道题就有点像在 sorted array 里寻找元素，对于 middle 值，我们可以找到
有多少值比它小。然后根据这个值再更新 right/left。

这里一个很容易迷惑的地方在于如果 middle 值不在 matrix 里怎么办。比如对 Matrix:

```
1 2 3
2 4 6
3 6 9
```

假如我们要找第 8 小的数，我们有可能得到的 middle 值是 7 或 8，它们都满足我们的要求，
而我们希望得到的值是 6，所以我们就逐步逼近 left/right，确保它一定在 Matrix 上。比如
得到了 8，`right = middle`，所以 right 值为 8。然后 middle 值为 4 不满足，所以
`left = middle + 1`，范围就设在了 `5-8`，再进一步范围设在了 `6-8`，再进一步范围设在了
`6-7`，再进一步范围设在了 `6-6`，符合我们跳出的条件，返回 right 值

注意这里看是如何用 `calCount` 方法来计算有多少值比 target 小的

这道题因为题意限制，所以不能用 `left<=right` 这种经典的二分搜索模板，必须用 `left<right`

Python 解法如下：

```Python

class Solution:
    def findKthNumber(self, m: int, n: int, k: int) -> int:
        
        left,right = 1,m*n
        
        while left<right:
            middle = left+(right-left)//2
            
            count = self.calCount(middle,m,n)
            
            if count>=k:
                right = middle
            else:
                left = middle+1
        
        return right
            
    
    def calCount(self,val,m,n):
        
        count = 0
        for i in range(1,m+1):
            temp = min(val//i,n)
            if temp==0:
                break
            else:
                count += temp
        
        return count

```