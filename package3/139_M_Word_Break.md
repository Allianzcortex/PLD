
Problem Description:

```

Given a string s and a dictionary of strings wordDict, return true if s can be segmented into a space-separated sequence of one or more dictionary words.

Note that the same word in the dictionary may be reused multiple times in the segmentation.

 

Example 1:

Input: s = "leetcode", wordDict = ["leet","code"]
Output: true
Explanation: Return true because "leetcode" can be segmented as "leet code".
Example 2:

Input: s = "applepenapple", wordDict = ["apple","pen"]
Output: true
Explanation: Return true because "applepenapple" can be segmented as "apple pen apple".
Note that you are allowed to reuse a dictionary word.
Example 3:

Input: s = "catsandog", wordDict = ["cats","dog","sand","and","cat"]
Output: false
 

Constraints:

1 <= s.length <= 300
1 <= wordDict.length <= 1000
1 <= wordDict[i].length <= 20
s and wordDict[i] consist of only lowercase English letters.
All the strings of wordDict are unique.

```

Basic Idea : 经典的 DP 解法

we let dp[i] represent : for array[0:i], whether it can be segmented into other parts:

Here are two solutions for it :

```Python

class Solution:
    def wordBreak(self, s: str, wordDict: List[str]) -> bool:
        dp = [False]*(len(s)+1)
        dp[0] = True
        
        for i in range(1,len(s)+1):
            
            # solution 1 : iterate through string
            # for j in range(i):
            #     if dp[j] and s[j:i] in wordDict:
            #         dp[i] = True
            #         break
            
            # solution 2 : iterate through wordDict
            for w in wordDict:
                if dp[i-len(w)] and s[i-len(w):i]==w:
                    dp[i] = True
                    break

        return dp[-1]

```

---

对应的 Golang 解法如下：

```Golang

func wordBreak(s string, wordDict []string) bool {
    
    dp:=make([]bool,len(s)+1)
    dp[0] = true
    
    for i:=1;i<=len(s);i++ {
        for j:=0;j<len(wordDict);j++ {
            word := wordDict[j]
            
            if (i>=len(word) && dp[i-len(word)] && s[i-len(word):i]==word) {
                dp[i] = true
                break
            }
        }
    }
    
    return dp[len(s)]
}


```