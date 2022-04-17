
Problem description:

```
Given an array of strings arr. String s is a concatenation of a sub-sequence of arr which have unique characters.

Return the maximum possible length of s.

 

Example 1:

Input: arr = ["un","iq","ue"]
Output: 4
Explanation: All possible concatenations are "","un","iq","ue","uniq" and "ique".
Maximum length is 4.
Example 2:

Input: arr = ["cha","r","act","ers"]
Output: 6
Explanation: Possible solutions are "chaers" and "acters".
Example 3:

Input: arr = ["abcdefghijklmnopqrstuvwxyz"]
Output: 26

```

Basic idea:

自己一开始做这道题的时候，
不知道是不是没看清楚题目还是被题目误导，题目里说的是 combination，但自己理解成了
2 个元素的 combination...

下面是一个错误的解法：

```Python

class Solution:
    def maxLength(self, arr: List[str]) -> int:
        
        # sort the array , from left->right , length down
        arr.sort(key=lambda elem:-1*len(elem))
        
        for i in range(len(arr)):
            for j in range(i+1,len(arr)):
                res = arr[i]+arr[j]
                if not self.findDuplicates(res):
                    return len(res)
        
        if len(arr)==1 and not self.findDuplicates(arr[0]):
            return len(arr[0])
        
        return 0
    
    def findDuplicates(self,string:str) -> bool:
        """
        Give a string,we wanna know whether 
        we can find duplicated chars inside it.
        """
        s = set()
        for ch in string:
            if ch in s:
                return True
            else:
                s.add(ch)
        
        return False
```

正确的思路其实就是类似 DFS，把所有可能的组合生成然后一一判断，这是
非常经典的套路，代码如下：

```Python

class Solution:
    def maxLength(self, arr: List[str]) -> int:
        
        # sort the array , from left->right , length down
        res = ['']
        maxLen = 0
        
        for word in arr:
            for prev in res:
                temp = word+prev
                if not self.findDuplicates(temp):
                    res.append(temp)
                    maxLen = max(maxLen,len(temp))
        return maxLen
    
    def findDuplicates(self,string:str) -> bool:
        return len(string)!=len(set(string))

```