
Problem description:

```

A conveyor belt has packages that must be shipped from one port to another within days days.

The ith package on the conveyor belt has a weight of weights[i]. Each day, we load the ship with packages on the conveyor belt (in the order given by weights). We may not load more weight than the maximum weight capacity of the ship.

Return the least weight capacity of the ship that will result in all the packages on the conveyor belt being shipped within days days.

 
Example 1:

Input: weights = [1,2,3,4,5,6,7,8,9,10], days = 5
Output: 15
Explanation: A ship capacity of 15 is the minimum to ship all the packages in 5 days like this:
1st day: 1, 2, 3, 4, 5
2nd day: 6, 7
3rd day: 8
4th day: 9
5th day: 10

Note that the cargo must be shipped in the order given, so using a ship of capacity 14 and splitting the packages into parts like (2, 3, 4, 5), (1, 6, 7), (8), (9), (10) is not allowed.
Example 2:

Input: weights = [3,2,2,4,1,4], days = 3
Output: 6
Explanation: A ship capacity of 6 is the minimum to ship all the packages in 3 days like this:
1st day: 3, 2
2nd day: 2, 4
3rd day: 1, 4
Example 3:

Input: weights = [1,2,3,1,1], days = 4
Output: 3
Explanation:
1st day: 1
2nd day: 2
3rd day: 3
4th day: 1, 1
 

Constraints:

1 <= days <= weights.length <= 5 * 104
1 <= weights[i] <= 500

```

这道题开始的思路是：

- 既然要求 `within D days`，那么就一定是在 `D days` 最好

- 自己开始的思路是 DFS , 生成所有可能的结果，但这样做的话时间复杂度就太高了

- 所以换种办法，用 Binary Search 来解

- 对于 `weight` 的最小和最大值，分别是 `max(weights)` 和 `sum(weights)`

- 然后找到 middle，尝试是否可以在 D days 里运完

Python 代码如下：

```Python

class Solution:
    def shipWithinDays(self, weights: List[int], days: int) -> int:
        
        left,right = max(weights),sum(weights)
        res = -1
        
        while left<=right:
            middle = left+(right-left)//2
            need_days = 1
            curr = 0
            
            for weight in weights:
                if curr+weight>middle:
                    need_days += 1
                    curr = 0
                curr += weight
            
            if need_days>days:
                left = middle + 1
            elif need_days<=days:
                res = middle
                right = middle - 1
        
        return res

```