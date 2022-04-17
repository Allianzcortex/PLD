
Problem description:

```

Given an array of strings words, return the words that can be typed using letters of the alphabet on only one row of American keyboard like the image below.

In the American keyboard:

the first row consists of the characters "qwertyuiop",
the second row consists of the characters "asdfghjkl", and
the third row consists of the characters "zxcvbnm".

 

Example 1:

Input: words = ["Hello","Alaska","Dad","Peace"]
Output: ["Alaska","Dad"]
Example 2:

Input: words = ["omk"]
Output: []
Example 3:

Input: words = ["adsdf","sfd"]
Output: ["adsdf","sfd"]
 

Constraints:

1 <= words.length <= 20
1 <= words[i].length <= 100
words[i] consists of English letters (both lowercase and uppercase). 

```

Basic idea:

自己的解法已经基本是正常逻辑里最优的了，如下：

```Python

class Solution:
    def findWords(self, words: List[str]) -> List[str]:
        res = []
        
        s1 = "qwertyuiop"
        s2 = "asdfghjkl"
        s3 = "zxcvbnm"
        maps = {}
        
        for index,sequence in enumerate([s1,s2,s3]):
            for ch in sequence:
                maps[ch.upper()] = index
        
        for word in words:
            if not word:
                continue
            
            index = maps[word[0].upper()]
            flag = True
            
            for ch in word[1:]:
                if maps[ch.upper()]!=index:
                    flag = False
                    break
            
            if flag:
                res.append(word)
        
        return res

```

但看到有一种解法是用 Python `set` 的特性：
看看 `<=` 在 set 里到底有什么含义

```Python

def findWords(self, words):
    line1, line2, line3 = set('qwertyuiop'), set('asdfghjkl'), set('zxcvbnm')
    ret = []
    for word in words:
      w = set(word.lower())
      if w <= line1 or w <= line2 or w <= line3:
        ret.append(word)
    return ret

```