
Problem description:

```
Given an integer num, return a string of its base 7 representation.

 

Example 1:

Input: num = 100
Output: "202"
Example 2:

Input: num = -7
Output: "-10"

Constraints:

-107 <= num <= 107
```

Basic idea:

这道题是把一个数转化为七进制，和把一个数转化为二进制的过程是一样的

Python 代码如下：

```Python

class Solution:
    def convertToBase7(self, num: int) -> str:
        """
        first location : 0-6
        second location: 7*1-7*6
        third  location: 14*1-14*6
        
        """
        # flag = 1 if num>0 else False
        n,res = abs(num),""
        
        while n>0:
            res = str(n%7)+res
            n //= 7
        
        if num<0:
            res = '-'+res
        
        return res or "0"
```