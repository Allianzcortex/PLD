
Problem description:

```
A self-dividing number is a number that is divisible by every digit it contains.

For example, 128 is a self-dividing number because 128 % 1 == 0, 128 % 2 == 0, and 128 % 8 == 0.
A self-dividing number is not allowed to contain the digit zero.

Given two integers left and right, return a list of all the self-dividing numbers in the range [left, right].

 

Example 1:

Input: left = 1, right = 22
Output: [1,2,3,4,5,6,7,8,9,11,12,15,22]
Example 2:

Input: left = 47, right = 85
Output: [48,55,66,77]
 

Constraints:

1 <= left <= right <= 104

```

---

Basic idea:

开始还觉得是有什么特殊的 tricky 吗...最后发现就是 brute force...

Python 解法如下：

```Python

class Solution:
    def selfDividingNumbers(self, left: int, right: int) -> List[int]:
        
        def is_dividing_number(val):
            
            for ch in str(val):
                if ch=='0' or val%(int(ch))!=0:
                    return False
            
            return True
        
        return [val for val in range(left,right+1) if is_dividing_number(val)]

```