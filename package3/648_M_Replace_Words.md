
Problem description:

```

In English, we have a concept called root, which can be followed by some other word to form another longer word - let's call this word successor. For example, when the root "an" is followed by the successor word "other", we can form a new word "another".

Given a dictionary consisting of many roots and a sentence consisting of words separated by spaces, replace all the successors in the sentence with the root forming it. If a successor can be replaced by more than one root, replace it with the root that has the shortest length.

Return the sentence after the replacement.

 

Example 1:

Input: dictionary = ["cat","bat","rat"], sentence = "the cattle was rattled by the battery"
Output: "the cat was rat by the bat"
Example 2:

Input: dictionary = ["a","b","c"], sentence = "aadsfasf absbs bbab cadsfafs"
Output: "a a b c"
Example 3:

Input: dictionary = ["a", "aa", "aaa", "aaaa"], sentence = "a aa a aaaa aaa aaa aaa aaaaaa bbb baba ababa"
Output: "a a a a a a a a bbb baba a"
Example 4:

Input: dictionary = ["catt","cat","bat","rat"], sentence = "the cattle was rattled by the battery"
Output: "the cat was rat by the bat"
Example 5:

Input: dictionary = ["ac","ab"], sentence = "it is abnormal that this solution is accepted"
Output: "it is ab that this solution is ac"

```

Basic idea:

这道题是很典型的 Trie 题目，自己实现如下：

因为最后不是要判断是否有这个单词，而是返回这个单词的 root，
所以不用 `self.index` ，而是用 `self.word` 来在 `add word`
时在最后的节点上保存插入的这个 word

另外 search 的逻辑也很重要，因为要返回 `replace it with the root that has the shortest length.`，所以只要找到一个节点并且这个节点上
有 word 这个属性，那么就立刻返回。

```Python


class TrieNode(object):
    
    def __init__(self):
        self.children = {}
        self.word = ""

class Trie(object):
    
    def __init__(self):
        self.root = TrieNode()
    
    def add(self,word):
        curr = self.root
        
        for ch in word:
            if ch not in curr.children:
                curr.children[ch]=TrieNode()
            curr = curr.children[ch]
        
        curr.word = word
    
    def search(self,prefix):
        curr = self.root
        
        for ch in prefix:
            if ch not in curr.children:
                return prefix
            curr = curr.children[ch]
            
            if curr.word:
                return curr.word
        
        # for example,"abc" in dict and "ab" in str
        return prefix
        
#         return self._get_smallest_words(curr)
    
#     def _get_smallest_words(self,curr):
        
#         queue = deque[curr.children.values()]
        
#         for node in queue:
#             if node.word:
#                 return word
#             queue.extend([node.children.values()])
        

class Solution:
    def replaceWords(self, dictionary: List[str], sentence: str) -> str:
        
        trie = Trie()
        for word in dictionary:
            trie.add(word)
        
        return " ".join([trie.search(item) for item in sentence.split(" ")])
```