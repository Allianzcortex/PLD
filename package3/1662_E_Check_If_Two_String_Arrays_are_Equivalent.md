
Problem description:

```

Given two string arrays word1 and word2, return true if the two arrays represent the same string, and false otherwise.

A string is represented by an array if the array elements concatenated in order forms the string.

 

Example 1:

Input: word1 = ["ab", "c"], word2 = ["a", "bc"]
Output: true
Explanation:
word1 represents string "ab" + "c" -> "abc"
word2 represents string "a" + "bc" -> "abc"
The strings are the same, so return true.
Example 2:

Input: word1 = ["a", "cb"], word2 = ["ab", "c"]
Output: false
Example 3:

Input: word1  = ["abc", "d", "defg"], word2 = ["abcddefg"]
Output: true
 

Constraints:

1 <= word1.length, word2.length <= 103
1 <= word1[i].length, word2[i].length <= 103
1 <= sum(word1[i].length), sum(word2[i].length) <= 103
word1[i] and word2[i] consist of lowercase letters.

```

Basic Idea:

这道题如果要按照 easy 题来做，那就很简单，什么语言基本都可以一行解决：

```Python

class Solution:
    def arrayStringsAreEqual(self, word1: List[str], word2: List[str]) -> bool:
        return ''.join(word1)==''.join(word2)

```

但如果要按照 Medium 来做，那么就是定义 4 个指针，两个指针迭代数组，两个指针迭代
数组里的单词

Python 解法如下：

```Python

class Solution:
    def arrayStringsAreEqual(self, word1: List[str], word2: List[str]) -> bool:
        
        l1,n1 = 0,0
        l2,n2 = 0,0

        while n1<len(word1) and n2<len(word2):
            if l1==len(word1[n1]):
                # we have iterated through this word,
                # should choose next word
                l1 = 0
                n1 += 1
            
            if l2==len(word2[n2]):
                l2 = 0
                n2 += 1
            
            if n1>=len(word1) and n2>=len(word2):
                return True
            if n1>=len(word1) or n2>=len(word2):
                return False

            if word1[n1][l1]!=word2[n2][l2]:
                return False
            
            l1+=1
            l2+=1
        
        return True

```