
Problem Description :

```

A transformation sequence from word beginWord to word endWord using a dictionary wordList is a sequence of words beginWord -> s1 -> s2 -> ... -> sk such that:

Every adjacent pair of words differs by a single letter.
Every si for 1 <= i <= k is in wordList. Note that beginWord does not need to be in wordList.
sk == endWord
Given two words, beginWord and endWord, and a dictionary wordList, return the number of words in the shortest transformation sequence from beginWord to endWord, or 0 if no such sequence exists.

 

Example 1:

Input: beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","log","cog"]
Output: 5
Explanation: One shortest transformation sequence is "hit" -> "hot" -> "dot" -> "dog" -> cog", which is 5 words long.
Example 2:

Input: beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","log"]
Output: 0
Explanation: The endWord "cog" is not in wordList, therefore there is no valid transformation sequence.

```

这道题还是挺有趣的。一开始会想是不是应该用 Trie 来做，最后发现想的太复杂了。
用 BFS 来解决问题，并且用 hash 来检测一个词是否之前已经背转换过

Python 解法如下：

```Python

class Solution:
    def ladderLength(self, beginWord: str, endWord: str, wordList: List[str]) -> int:
        
        wordList = set(wordList)
        queue = collections.deque([[beginWord,1]])
        
        while queue:
            word,length = queue.popleft()
            
            if word==endWord:
                return length
            
            for i in range(len(word)):
                for ch in 'abcdefghijklmnopqrstuvwxyz':
                    new_word = word[:i]+ch+word[i+1:]
                    
                    if new_word in wordList:
                        wordList.remove(new_word)
                        queue.append([new_word,length+1])
            
        return 0

```