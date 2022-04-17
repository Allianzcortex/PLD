
Problem description:

```
Given a string text, you want to use the characters of text to form as many instances of the word "balloon" as possible.

You can use each character in text at most once. Return the maximum number of instances that can be formed.

 

Example 1:



Input: text = "nlaebolko"
Output: 1
Example 2:



Input: text = "loonbalxballpoon"
Output: 2
Example 3:

Input: text = "leetcode"
Output: 0
```

Basic idea :

这道题就是很典型的 count 然后再计算

---

Python 解法如下：

```Python

class Solution:
    def maxNumberOfBalloons(self, text: str) -> int:
        """
        """
        
        maps = defaultdict(lambda :0)
        
        for ch in text:
            maps[ch] = maps[ch]+1
        
        b_num,a_num,n_num = maps['b'],maps['a'],maps['n']
        l_num,o_num = maps['l']//2,maps['o']//2
        
        return min([b_num,a_num,n_num,l_num,o_num])

```

---

Golang 解法如下：

```Golang

func maxNumberOfBalloons(text string) int {
    
    m:=make(map[rune]int)
    array:=[]rune(text)
    
    for i:=0;i<len(text);i++ {
        m[array[i]] += 1
    }
    
    // balloon
    
    res := len(text)
    for _,ch := range("balon") {
        if ch=='b' || ch=='a' || ch=='n' {
            res = min(res,m[ch])
        }
        
        if ch=='l' || ch=='o' {
            res = min(res,m[ch]/2)
        }
    }
    
    return res
}

func min(a,b int) int {
    if a<b {
        return a
    }
    
    return b
}

```