
Problem description:

```

You are given an integer array values where values[i] represents the value of the ith sightseeing spot. Two sightseeing spots i and j have a distance j - i between them.

The score of a pair (i < j) of sightseeing spots is values[i] + values[j] + i - j: the sum of the values of the sightseeing spots, minus the distance between them.

Return the maximum score of a pair of sightseeing spots.

 

Example 1:

Input: values = [8,1,5,2,6]
Output: 11
Explanation: i = 0, j = 2, values[i] + values[j] + i - j = 8 + 5 + 0 - 2 = 11
Example 2:

Input: values = [1,2]
Output: 2
 

Constraints:

2 <= values.length <= 5 * 104
1 <= values[i] <= 1000

```

Basic idea:

这道题也是偏 `DP` 向，关键是对公式的转化

`score = values[i]+values[j]+i-j ` 可以转化为：

` score = (values[i]+i) + (values[j]-j)`

所以从左向右迭代，每次都可以更新最大的 (values[i]+i)，从而进一步更新 score

Python 代码如下：

```Python

class Solution:
    def maxScoreSightseeingPair(self, values: List[int]) -> int:
        """
        i , j
        
        val = values[i]+values[j]+i-j = (values[i]+i)+(values[j]-j)
        
        """
        
        left_max = values[0]+0
        res = 0
        
        for j in range(1,len(values)):
            res = max(res,left_max+values[j]-j)
            left_max = max(left_max,values[j]+j)
        
        return res

```
