
Problem description:

```

You are given a string s consisting only of the characters '0' and '1'. In one operation, you can change any '0' to '1' or vice versa.

The string is called alternating if no two adjacent characters are equal. For example, the string "010" is alternating, while the string "0100" is not.

Return the minimum number of operations needed to make s alternating.

 

Example 1:

Input: s = "0100"
Output: 1
Explanation: If you change the last character to '1', s will be "0101", which is alternating.
Example 2:

Input: s = "10"
Output: 0
Explanation: s is already alternating.
Example 3:

Input: s = "1111"
Output: 2
Explanation: You need two operations to reach "0101" or "1010".
 

Constraints:

1 <= s.length <= 104
s[i] is either '0' or '1'.

```

Basic Idea:

如果一个数组是依次的，那么不是 "0101" 就是 "1010"，所以不管怎样都是两种情况比较，有很多实现，
这里就实现一个最基本的：

Python 解法如下：

```Python

class Solution:
    def minOperations(self, s: str) -> int:
        # op1: keep the 1st char as what it is
        # op2: keep the 1st char to be reversed 

        if len(s)==0:
            return 0

        reverse_first_char_s = ('0' if s[0]=='1' else '1')+s[1:]
        return min(self.min_op(list(s)),1+self.min_op(list(reverse_first_char_s)))

    
    def min_op(self,s):
        cnt = 0
        for i in range(len(s)-1):
            if s[i]!=s[i+1]:
                continue
            else:
                s[i+1]=('1' if s[i+1]=='0' else '0')
                cnt += 1
        return cnt        


```