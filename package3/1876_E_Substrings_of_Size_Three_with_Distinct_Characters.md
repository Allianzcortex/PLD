
Problem description:

```

A string is good if there are no repeated characters.

Given a string s​​​​​, return the number of good substrings of length three in s​​​​​​.

Note that if there are multiple occurrences of the same substring, every occurrence should be counted.

A substring is a contiguous sequence of characters in a string.

 

Example 1:

Input: s = "xyzzaz"
Output: 1
Explanation: There are 4 substrings of size 3: "xyz", "yzz", "zza", and "zaz". 
The only good substring of length 3 is "xyz".
Example 2:

Input: s = "aababcabc"
Output: 4
Explanation: There are 7 substrings of size 3: "aab", "aba", "bab", "abc", "bca", "cab", and "abc".
The good substrings are "abc", "bca", "cab", and "abc".
 

Constraints:

1 <= s.length <= 100
s​​​​​​ consists of lowercase English letters.

```

Basic idea:

如果不讲求效率的话可以用如下的方法来做...

```Python

class Solution:
    def countGoodSubstrings(self, s: str) -> int:
        
        visited = set()
        
        left,right = 0,0
        length = len(s)
        cnt = 0
        
        for i in range(len(s)-2):
            if len(set(s[i:i+3]))==3:
                cnt += 1
        
        return cnt

```

但正规思路还是应该用 sliding window 解决