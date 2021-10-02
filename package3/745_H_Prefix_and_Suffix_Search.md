
Problem description:

```

Design a special dictionary with some words that searchs the words in it by a prefix and a suffix.

Implement the WordFilter class:

WordFilter(string[] words) Initializes the object with the words in the dictionary.
f(string prefix, string suffix) Returns the index of the word in the dictionary, which has the prefix prefix and the suffix suffix. If there is more than one valid index, return the largest of them. If there is no such word in the dictionary, return -1.
 

Example 1:

Input
["WordFilter", "f"]
[[["apple"]], ["a", "e"]]
Output
[null, 0]

Explanation
WordFilter wordFilter = new WordFilter(["apple"]);
wordFilter.f("a", "e"); // return 0, because the word at index 0 has prefix = "a" and suffix = 'e".

```

Basic idea :

自己在一开始的时候有一个这种解法：

``` Java
class WordFilter {
    HashMap<String, Integer> map = new HashMap<>();

    public WordFilter(String[] words) {
        for(int w = 0; w < words.length; w++){
            for(int i = 0; i <= 10 && i <= words[w].length(); i++){
                for(int j = 0; j <= 10 && j <= words[w].length(); j++){
                    map.put(words[w].substring(0, i) + "#" + words[w].substring(words[w].length()-j), w);
                }
            }
        }
    }

    public int f(String prefix, String suffix) {
        return (map.containsKey(prefix + "#" + suffix))? map.get(prefix + "#" + suffix) : -1;
    }
}

```

但这道题，就是非常典型的 Trie 题目，首先要对 trie 本身进行一些细微的变化：

1. 不用添加一个是否是 isEnd 的字段，把 isEnd 字段转成 index，因为题目里已经说了：

` If there is more than one valid index, return the largest of them.` 所以
在遍历添加 word 的时候更新 index

2. 在构建树的时候，根据 prefix 添加一个，再根据 suffix[::-1] 添加一个。搜索的时候也是如此，根据 prefix 搜索一次，得到所有的索引；再根据 suffix[::-1] 来搜索

3. 实际运行中很明显对同一个 prefix，会有多个可能对应的 word，在一次
遍历的时候会找到一个 TrieNode，然后再根据这个 TrieNode 得到所有的 indexes。对应方法如下：

```Python

 res = []
        self._get_all_indexes(res,curr)
        return res
    
    def _get_all_indexes(self,res,node):
        if len(node.children)==0:
            res.append(node.index)
            return
        
        for child in node.children.values():
            self._get_all_indexes(res,child)

```

所以最后 AC 的代码为：

```Python


class TrieNode(object):
    
    def __init__(self):
        self.children = {}
        self.index = -1

class Trie(object):
    
    def __init__(self):
        
        self.root = TrieNode()
    
    def add(self,word,index):
        curr = self.root
        for w in word:
            if w not in curr.children:
                curr.children[w] = TrieNode()
            curr = curr.children[w]
        curr.index = index
    
    def searchWord(self,word):
        curr = self.root
        
        for w in word:
            if w not in curr.children:
                return [-1]
            curr = curr.children[w]
        
        # next is to get the tail node()
        res = []
        self._get_all_indexes(res,curr)
        return res
    
    def _get_all_indexes(self,res,node):
        if len(node.children)==0:
            res.append(node.index)
            return
        
        for child in node.children.values():
            self._get_all_indexes(res,child)

class WordFilter:

    def __init__(self, words: List[str]):
        
        self.prefixTrie =  Trie()
        self.suffixTrie =  Trie()
        
        for index,word in enumerate(words):
            self.prefixTrie.add(word,index)
            self.suffixTrie.add(word[::-1],index)    

    def f(self, prefix: str, suffix: str) -> int:
        
        p = self.prefixTrie.searchWord(prefix)
        s = self.suffixTrie.searchWord(suffix[::-1])
        
        for elem in sorted(p)[::-1]:
            if elem in s:
                return elem
        
        return -1

```