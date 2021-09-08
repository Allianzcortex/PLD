
Problem description:

```

A transformation sequence from word beginWord to word endWord using a dictionary wordList is a sequence of words beginWord -> s1 -> s2 -> ... -> sk such that:

Every adjacent pair of words differs by a single letter.
Every si for 1 <= i <= k is in wordList. Note that beginWord does not need to be in wordList.
sk == endWord
Given two words, beginWord and endWord, and a dictionary wordList, return all the shortest transformation sequences from beginWord to endWord, or an empty list if no such sequence exists. Each sequence should be returned as a list of the words [beginWord, s1, s2, ..., sk].

 

Example 1:

Input: beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","log","cog"]
Output: [["hit","hot","dot","dog","cog"],["hit","hot","lot","log","cog"]]
Explanation: There are 2 shortest transformation sequences:
"hit" -> "hot" -> "dot" -> "dog" -> "cog"
"hit" -> "hot" -> "lot" -> "log" -> "cog"
Example 2:

Input: beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","log"]
Output: []
Explanation: The endWord "cog" is not in wordList, therefore there is no valid transformation sequence.

```

Basic idea : 和 126 类似，也是穷尽所有的可能

Python 解法如下

```Python

class Solution:
    def findLadders(self, beginWord: str, endWord: str, wordList: List[str]) -> List[List[str]]:
        hash_ = {}
        
        queue = deque([(beginWord,1)])
        res = []
        min_len = -1
        
        while queue:
            word , length = queue.popleft()
            
            for i in range len(word):
                for ch in "abcdefghijklmnopqrstuvwxyz":
                    new_word = word[:i]+ch+word[i+1:]
                    
                    if new_word==word and min_len == -1:
                        min_len = length + 1
                    
                    if new_word==word and min_len!=-1:
                        if length==min_len-1:
                            # add to list
                        elif length>min_len-1:
                            return res
                    if new_word 
                
                
        
        return res

```