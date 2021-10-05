
Problem description:

```

You are given a string s consisting of n characters which are either 'X' or 'O'.

A move is defined as selecting three consecutive characters of s and converting them to 'O'. Note that if a move is applied to the character 'O', it will stay the same.

Return the minimum number of moves required so that all the characters of s are converted to 'O'.

 

Example 1:

Input: s = "XXX"
Output: 1
Explanation: XXX -> OOO
We select all the 3 characters and convert them in one move.
Example 2:

Input: s = "XXOX"
Output: 2
Explanation: XXOX -> OOOX -> OOOO
We select the first 3 characters in the first move, and convert them to 'O'.
Then we select the last 3 characters and convert them so that the final string contains all 'O's.
Example 3:

Input: s = "OOOO"
Output: 0
Explanation: There are no 'X's in s to convert.
 

Constraints:

3 <= s.length <= 1000
s[i] is either 'X' or 'O'.

```

Basic idea:

这道题和 1573 Number of Ways to Split a String 有很相似的地方

基本思路就是只要遇到一个 `X`，我们并不关心它后面三位跟的是什么，只需要知道要用一次 convert chance

Python 解法如下：

```Python

class Solution:
    def minimumMoves(self, s: str) -> int:
        """
        oxxxo
        """
        res,i = 0,0
        
        while i<len(s):
            
            index = i
            cnt = 0
            while index<len(s) and s[index]=='O':
                index += 1
            
            if index<len(s):
                res += 1
            i = index+3
            
        return res

```