
Problem description:

```
You have n coins and you want to build a staircase with these coins. The staircase consists of k rows where the ith row has exactly i coins. The last row of the staircase may be incomplete.

Given the integer n, return the number of complete rows of the staircase you will build.

 

Example 1:


Input: n = 5
Output: 2
Explanation: Because the 3rd row is incomplete, we return 2.
Example 2:


Input: n = 8
Output: 3
Explanation: Because the 4th row is incomplete, we return 3.
 

Constraints:

1 <= n <= 231 - 1

```

Basic idea:

我的解法如下，就是最基本的模拟逻辑

```Python

class Solution:
    def arrangeCoins(self, n: int) -> int:
        res=1
        
        while n>=res:
            n-=res
            res+=1
        
        return res-1

```

当然也有一种办法是找出数学规律，如下：

```

According to sum of arithmetic series formula: 1 + 2 + 3 + ... + k = (1 + k) * k/ 2
We can make quadratic equation out of it: (1 + k) * k/ 2 = n
Meaning:
k^2 + k - 2 * n = 0
Which corresponds to general quadratic equation form:
ax^2 + bx + c = 0

By quadratic formula we can find: k = -b + sqrt(b^2 - 4ac)/2a
Which in our case is: k = -1 + sqrt(1 + 8n)/2

Answer is the solution of the equation taking the floor int value.

def arrangeCoins(self, n: int) -> int:
    return int((-1 + (1 + 8*n) ** 0.5) // 2)

```