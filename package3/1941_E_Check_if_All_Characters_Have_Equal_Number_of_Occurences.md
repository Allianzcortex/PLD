
Problem description:

```

Given a string s, return true if s is a good string, or false otherwise.

A string s is good if all the characters that appear in s have the same number of occurrences (i.e., the same frequency).

 

Example 1:

Input: s = "abacbc"
Output: true
Explanation: The characters that appear in s are 'a', 'b', and 'c'. All characters occur 2 times in s.
Example 2:

Input: s = "aaabb"
Output: false
Explanation: The characters that appear in s are 'a' and 'b'.
'a' occurs 3 times while 'b' occurs 2 times, which is not the same number of times.
 

Constraints:

1 <= s.length <= 1000
s consists of lowercase English letters.

```

Basic Idea:

既然是 easy 题那么就用 Python 的 counter 无脑解了

```Python

class Solution:
    def areOccurrencesEqual(self, s: str) -> bool:
        if s=="":
            return True
        c = Counter(s)
        frequency = c[s[0]]
        return True if all(frequency==freq for _,freq in c.items()) else False

```