
Problem description:

```

Design a data structure that is initialized with a list of different words. Provided a string, you should determine if you can change exactly one character in this string to match any word in the data structure.

Implement the MagicDictionary class:

MagicDictionary() Initializes the object.
void buildDict(String[] dictionary) Sets the data structure with an array of distinct strings dictionary.
bool search(String searchWord) Returns true if you can change exactly one character in searchWord to match any string in the data structure, otherwise returns false.
 

Example 1:

Input
["MagicDictionary", "buildDict", "search", "search", "search", "search"]
[[], [["hello", "leetcode"]], ["hello"], ["hhllo"], ["hell"], ["leetcoded"]]
Output
[null, null, false, true, false, false]

Explanation
MagicDictionary magicDictionary = new MagicDictionary();
magicDictionary.buildDict(["hello", "leetcode"]);
magicDictionary.search("hello"); // return False
magicDictionary.search("hhllo"); // We can change the second 'h' to 'e' to match "hello" so we return True
magicDictionary.search("hell"); // return False
magicDictionary.search("leetcoded"); // return False
 

Constraints:

1 <= dictionary.length <= 100
1 <= dictionary[i].length <= 100
dictionary[i] consists of only lower-case English letters.
All the strings in dictionary are distinct.
1 <= searchWord.length <= 100
searchWord consists of only lower-case English letters.
buildDict will be called only once before search.
At most 100 calls will be made to search.

```

Basic idea:

这道题也是一道 Trie 的题目，看到只允许变一个字符的时候自己就应该意识到
要把 `count` 作为参数传入到函数里

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
    
    def search(self,word,count,node):
        if  count<0:
            return False

        if not word:
            if count==0 and node.isEnd:
                return True
            else:
                return False
        
        flag = False
        for ch,child in node.children.items():
            if ch==word[0]:
                flag = flag or self.search(word[1:],count,child)
            else:
                flag = flag or self.search(word[1:],count-1,child)
        
        return flag
    
class MagicDictionary:

    def __init__(self):
        self.trie = Trie()

    def buildDict(self, dictionary: List[str]) -> None:
        for word in dictionary:
            self.trie.add(word)

    def search(self, searchWord: str) -> bool:
        return self.trie.search(searchWord,1,self.trie.root)

```