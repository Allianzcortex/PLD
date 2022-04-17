
Problem description:

```
You are given a string s of lowercase English letters and an integer array shifts of the same length.

Call the shift() of a letter, the next letter in the alphabet, (wrapping around so that 'z' becomes 'a').

For example, shift('a') = 'b', shift('t') = 'u', and shift('z') = 'a'.
Now for each shifts[i] = x, we want to shift the first i + 1 letters of s, x times.

Return the final string after all such shifts to s are applied.

 

Example 1:

Input: s = "abc", shifts = [3,5,9]
Output: "rpl"
Explanation: We start with "abc".
After shifting the first 1 letters of s by 3, we have "dbc".
After shifting the first 2 letters of s by 5, we have "igc".
After shifting the first 3 letters of s by 9, we have "rpl", the answer.
Example 2:

Input: s = "aaa", shifts = [1,2,3]
Output: "gfd"

```

Basic idea :

这道题其实不是很难的类型，但真的有很多波折

一开始是想用最直观的方法来模拟，毫无疑问的 TLE 了 ：

Python 代码如下：

```Python

class Solution:
    def shiftingLetters(self, s: str, shifts: List[int]) -> str:
        
        s = list(s)
        
        for index,val in enumerate(shifts):
            for _ in range(val):
                for i in range(index+1):
                    s[i] = self.shift(s[i])
        
        return ''.join(s)
    
    
    def shift(self, char):
        if char=='z':
            return 'a'
        
        return chr(ord(char)+1)
```

然后开始考虑优化，自己考虑了两个优化点：

1. 求出每一个字符需要被 shift() 的数量，然后 %26 就是最终需要翻转的结果
2. 对 shift，不用一次一次移动，而是计算好偏移量后一次性移动

优化后的代码如下，但仍然 TLE ：

```Python

class Solution:
    def shiftingLetters(self, s: str, shifts: List[int]) -> str:
        
        s = list(s)
        cnt = [0]*len(s)
        
        for index,val in enumerate(shifts):
            for i in range(index+1):
                cnt[i] = (cnt[i]+val)%26
        
        print(cnt)
        for i,cnt in enumerate(cnt):
                s[i] = self.shift(s[i],cnt)
        
        return ''.join(s)
    
    
    def shift(self, char, cnt):
        targetChar = chr(ord(char)+cnt)
        
        if targetChar <= 'z':
            return targetChar
        else:
            return self.shift('a',cnt-1-(ord('z')-ord(char)))
```

瓶颈就是在计算 `cnt` 数组里，因为重复计算的步骤实在太多了，重新梳理下，如果
shift 为 [1,3,5,7]，那么对 s[0]，要 shift 的次数为 1+3+5+7，对 s[1] 要
shift 的次数为 3+5+7，依次类推，对 s[3] 就只需要 shift 次数为 [7]

所以思路优化就是从后往前，只用一个 cnt 来存储要翻转的次数，然后每次 cnt 加上 shfit[i]
代码如下：

```Python

class Solution:
    def shiftingLetters(self, s: str, shifts: List[int]) -> str:
        
        s = list(s)
        cnt = 0
        
        a = ord('a')
        
        for i in range(len(s)-1,-1,-1):
            cnt += shifts[i]
            s[i] = chr((ord(s[i])-a+cnt)%26 + a)
        
        return ''.join(s)

```