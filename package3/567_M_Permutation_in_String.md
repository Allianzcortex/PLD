
Problem description:

```

Given two strings s1 and s2, return true if s2 contains a permutation of s1, or false otherwise.

In other words, return true if one of s1's permutations is the substring of s2.

Example 1:

Input: s1 = "ab", s2 = "eidbaooo"
Output: true
Explanation: s2 contains one permutation of s1 ("ba").
Example 2:

Input: s1 = "ab", s2 = "eidboaoo"
Output: false
 

Constraints:

1 <= s1.length, s2.length <= 104
s1 and s2 consist of lowercase English letters.

```

Basic idea:

使用 sliding window 来解决这个问题：

对原始的 `s1` 做一个 counter，然后对 `s2`，从 `[0..len(s1)-1]` 到
`[len(s1)..len(s2)-1]`，依次比较是否达到相同的状态

```Python

class Solution:
    def checkInclusion(self, s1: str, s2: str) -> bool:
        """
        absolutely we can use sliding window to solve this problem
        """
        target=[0]*26
        new = [0]*26
        
        for val in s1:
            target[ord(val)-ord('a')] += 1
        
        for i in range(len(s2)):
            new[ord(s2[i])-ord('a')] += 1
            
            if i>=len(s1):
                new[ord(s2[i-len(s1)])-ord('a')] -= 1
            
            if target==new:
                return True
        
        return False

```

Golang 解法如下：

```Golang

func checkInclusion(s1 string, s2 string) bool {
    
    counter:=[26]int{}
    newCounter := [26]int{}
    
    for _,val := range s1 {
        counter[val-'a'] += 1
    }
    
    
    for left:=0;left<len(s2);left++ {
        newCounter[s2[left]-'a'] += 1
        
        if(left>=len(s1)) {
            newCounter[s2[left-len(s1)]-'a'] -= 1
        }
        
        if(isEqual(counter,newCounter)) {
            return true
        }
    }
    
    return false
}

func isEqual(counter,newCounter [26]int) bool {
    for i:=0;i<26;i++ {
        if(counter[i]!=newCounter[i]) {
            return false
        }
    }
    
    return true
}

```