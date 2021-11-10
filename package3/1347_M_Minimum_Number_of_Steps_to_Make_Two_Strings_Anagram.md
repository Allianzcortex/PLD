
Problem description:

```

Given two equal-size strings s and t. In one step you can choose any character of t and replace it with another character.

Return the minimum number of steps to make t an anagram of s.

An Anagram of a string is a string that contains the same characters with a different (or the same) ordering.

 

Example 1:

Input: s = "bab", t = "aba"
Output: 1
Explanation: Replace the first 'a' in t with b, t = "bba" which is anagram of s.
Example 2:

Input: s = "leetcode", t = "practice"
Output: 5
Explanation: Replace 'p', 'r', 'a', 'i' and 'c' from t with proper characters to make t anagram of s.
Example 3:

Input: s = "anagram", t = "mangaar"
Output: 0
Explanation: "anagram" and "mangaar" are anagrams. 
Example 4:

Input: s = "xxyyzz", t = "xxyyzz"
Output: 0
Example 5:

Input: s = "friend", t = "family"
Output: 4
 

Constraints:

1 <= s.length <= 50000
s.length == t.length
s and t contain lower-case English letters only.

```

Basic idea:

这道题首先是 count occurence of character，然后就以题目中的例子为例：

"bab" vs "aba"，对应的 count 分别是

`b:2,a:1` 和 `b:1,a:2`

对 b 来说，因为 1<2，所以不用做任何操作
对 a 来说，因为 2>1，所以需要有操作来把 `a` 减少一个

Python 代码如下：

```Python

class Solution:
    def minSteps(self, s: str, t: str) -> int:
        
        c1 = Counter(s)
        c2 = Counter(t)
        cnt = 0
        
        for char,count in c2.most_common():
            c1_count = c1[char]
            
            if c1_count<count:
                cnt += abs(c1_count-count)
        
        return cnt

```

如果只用一个 counter 的话方法如下：

```Python

class Solution:
    def minSteps(self, s: str, t: str) -> int:
        
        counter = Counter(s)
        cnt = 0
        
        for ch in t:
            
            if counter[ch]>0:
                counter[ch]-=1
            else:
                cnt += 1

        return cnt

```