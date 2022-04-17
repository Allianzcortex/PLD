
Problem description:

```

A sentence is a string of single-space separated words where each word consists only of lowercase letters.

A word is uncommon if it appears exactly once in one of the sentences, and does not appear in the other sentence.

Given two sentences s1 and s2, return a list of all the uncommon words. You may return the answer in any order.

 

Example 1:

Input: s1 = "this apple is sweet", s2 = "this apple is sour"
Output: ["sweet","sour"]
Example 2:

Input: s1 = "apple apple", s2 = "banana"
Output: ["banana"]
 

Constraints:

1 <= s1.length, s2.length <= 200
s1 and s2 consist of lowercase English letters and spaces.
s1 and s2 do not have leading or trailing spaces.
All the words in s1 and s2 are separated by a single space.

```

---

Basic idea:

这道题肯定要用 Coutner 来做。自己的解法如下：

```Python

class Solution:
    def uncommonFromSentences(self, s1: str, s2: str) -> List[str]:
        
        c1,c2 = Counter(s1.split(" ")),Counter(s2.split(" "))
        
        res = []
        
        # 1
        for c in c1.most_common():
            if c[1]==1 and c2[c[0]]==0:
                res.append(c[0])
        # 2
        for c in c2.most_common():
            if c[1]==1 and c1[c[0]]==0:
                res.append(c[0])
        
        return res

```

另外还有优化的空间就是再看看题意，"一个词在一个 string1 中只出现一次，在另一个 string2 中不出现"
那么也就是在 "这个 word 在 string1+" "+string2 中只出现一次"，用两行就可以搞定

```Python

class Solution:
    def uncommonFromSentences(self, s1: str, s2: str) -> List[str]:
        
        c = Counter((s1+" "+s2).split(" "))
        
        return [word for word,freq in c.most_common() if freq==1]
        

```