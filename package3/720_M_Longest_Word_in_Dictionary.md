
Problem description:

```

Given an array of strings words representing an English Dictionary, return the longest word in words that can be built one character at a time by other words in words.

If there is more than one possible answer, return the longest word with the smallest lexicographical order. If there is no answer, return the empty string.

 

Example 1:

Input: words = ["w","wo","wor","worl","world"]
Output: "world"
Explanation: The word "world" can be built one character at a time by "w", "wo", "wor", and "worl".
Example 2:

Input: words = ["a","banana","app","appl","ap","apply","apple"]
Output: "apple"
Explanation: Both "apply" and "apple" can be built from other words in the dictionary. However, "apple" is lexicographically smaller than "apply".
 

Constraints:

1 <= words.length <= 1000
1 <= words[i].length <= 30
words[i] consists of lowercase English letters.

```

Basic idea:

这道题也是很典型的 trie 题(虽然题意真的是...)
只要判断在每次 ch 迭代的过程中找到的 node 是否是一个单词的 end 就行

Python 代码如下：

```Python

class TrieNode(object):
    
    def __init__(self):
        self.children = {}
        self.isEnd = False

class Trie(object):
    
    def __init__(self):
        self.root = TrieNode()
    
    def add(self,word):
        curr = self.root
        
        for ch in word:
            if ch not in curr.children:
                curr.children[ch] = TrieNode()
            curr = curr.children[ch]
        
        curr.isEnd = True
    
    def check(self,word):
        curr = self.root
        
        for ch in word:
            if ch not in curr.children:
                return False
            curr = curr.children[ch]
            if not curr.isEnd:
                return False
        
        return True
    

class Solution:
    def longestWord(self, words: List[str]) -> str:
        
        trie = Trie()
        for word in words:
            trie.add(word)
        
        words.sort(key=lambda word:(-1*len(word),word))
        
        for word in words:

            if trie.check(word):
                return word
        
        return ""

```