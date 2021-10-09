
Problem description:

```

Given an integer n, return true if it is a power of four. Otherwise, return false.

An integer n is a power of four, if there exists an integer x such that n == 4x.

 

Example 1:

Input: n = 16
Output: true
Example 2:

Input: n = 5
Output: false
Example 3:

Input: n = 1
Output: true
 

Constraints:

-231 <= n <= 231 - 1

```

Basic idea:

先上自己当前的解法，也 AC 了：

```Python

class Solution:
    def isPowerOfFour(self, n: int) -> bool:
        
        # 注意 0 这个特殊情况...
        if n==0:
            return False

        while n%4==0:
            n //= 4
        
        return n==1

```

然后题目有一个 follow-up 是 `Could you solve it without loops/recursion?` 
这就牵扯到位计算了。