
Problem description:

```

Given a string s and a dictionary of strings wordDict, add spaces in s to construct a sentence where each word is a valid dictionary word. Return all such possible sentences in any order.

Note that the same word in the dictionary may be reused multiple times in the segmentation.

 

Example 1:

Input: s = "catsanddog", wordDict = ["cat","cats","and","sand","dog"]
Output: ["cats and dog","cat sand dog"]
Example 2:

Input: s = "pineapplepenapple", wordDict = ["apple","pen","applepen","pine","pineapple"]
Output: ["pine apple pen apple","pineapple pen apple","pine applepen apple"]
Explanation: Note that you are allowed to reuse a dictionary word.
Example 3:

Input: s = "catsandog", wordDict = ["cats","dog","sand","and","cat"]
Output: []


```

Idea : 这道题我一看就想到用 DFS 来做

Python 解法如下：

两点：

1. 得到一个 maxLength() 可以限制步数，也等价于 memorization 了吧

2. 一开始没有用 i = index, 而是用 `for i in range(index,len(s))`，这是错误的，
因为我们需要把整个 string 都进行切分，最左边必须固定

```Python

class Solution:
    def wordBreak(self, s: str, wordDict: List[str]) -> List[str]:
        res = []
        maxLength = max(len(item) for item in wordDict)
        self.dfs(s,wordDict,[],0,res,maxLength)
        
        return res
    
    
    def dfs(self,s,wordDict,path,index,res,maxLength):
        if index==len(s):
            res.append(' '.join(path))
            return

        i = index
        for gap in range(1,maxLength+1):
            if (i+gap<=len(s) and s[i:i+gap] in wordDict):
                self.dfs(s,wordDict,path+[s[i:i+gap]],i+gap,res,maxLength)

```