
Problem description:

```

A string s is nice if, for every letter of the alphabet that s contains, it appears both in uppercase and lowercase. For example, "abABB" is nice because 'A' and 'a' appear, and 'B' and 'b' appear. However, "abA" is not because 'b' appears, but 'B' does not.

Given a string s, return the longest substring of s that is nice. If there are multiple, return the substring of the earliest occurrence. If there are none, return an empty string.

 

Example 1:

Input: s = "YazaAay"
Output: "aAa"
Explanation: "aAa" is a nice string because 'A/a' is the only letter of the alphabet in s, and both 'A' and 'a' appear.
"aAa" is the longest nice substring.
Example 2:

Input: s = "Bb"
Output: "Bb"
Explanation: "Bb" is a nice string because both 'B' and 'b' appear. The whole string is a substring.
Example 3:

Input: s = "c"
Output: ""
Explanation: There are no nice substrings.
Example 4:

Input: s = "dDzeE"
Output: "dD"
Explanation: Both "dD" and "eE" are the longest nice substrings.
As there are multiple longest nice substrings, return "dD" since it occurs earlier.
 

Constraints:

1 <= s.length <= 100
s consists of uppercase and lowercase English letters.

```

Basic idea:

使用 `divide & conquer` 的方法，找到不符合 `Nice String` 定义的
那个字符，然后分别计算左边和右边，最后再得出答案

Python 代码如下：

```Python

class Solution:
    def longestNiceSubstring(self, s: str) -> str:
        
        if not s:
            return ""
        
        visited = set()
        
        for ch in s:
            visited.add(ch)
        
        for index,ch in enumerate(s):
            lower,upper = ch.lower(),ch.upper()
            
            if (lower in visited and upper in visited):
                continue
            
            left_part = self.longestNiceSubstring(s[:index])
            right_part = self.longestNiceSubstring(s[index+1:])
            
            return left_part if len(left_part)>=len(right_part) else right_part

        return s

```