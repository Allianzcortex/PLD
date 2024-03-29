
Problem description:

```
A perfect number is a positive integer that is equal to the sum of its positive divisors, excluding the number itself. A divisor of an integer x is an integer that can divide x evenly.

Given an integer n, return true if n is a perfect number, otherwise return false.

 

Example 1:

Input: num = 28
Output: true
Explanation: 28 = 1 + 2 + 4 + 7 + 14
1, 2, 4, 7, and 14 are all divisors of 28.
Example 2:

Input: num = 6
Output: true
Example 3:

Input: num = 496
Output: true
Example 4:

Input: num = 8128
Output: true
Example 5:

Input: num = 2
Output: false
 

Constraints:

1 <= num <= 108

```

---

Basic idea:

注意 1 的这种特殊情况，其他就是把所有的参数加起来就好，同时注意防止重复：


```Python

import math

class Solution:
    def checkPerfectNumber(self, num: int) -> bool:
        
        root = int(math.sqrt(num))
        s = set()
        if num==1:
            return False

        s.add(1)
        
        for i in range(2,root+1):
            if num%i==0:
                s.add(i)
                s.add(num//i)
        
        return sum(s)==num

```