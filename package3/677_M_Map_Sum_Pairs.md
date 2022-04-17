
Problem description:

```

Design a map that allows you to do the following:

Maps a string key to a given value.
Returns the sum of the values that have a key with a prefix equal to a given string.
Implement the MapSum class:

MapSum() Initializes the MapSum object.
void insert(String key, int val) Inserts the key-val pair into the map. If the key already existed, the original key-value pair will be overridden to the new one.
int sum(string prefix) Returns the sum of all the pairs' value whose key starts with the prefix.
 

Example 1:

Input
["MapSum", "insert", "sum", "insert", "sum"]
[[], ["apple", 3], ["ap"], ["app", 2], ["ap"]]
Output
[null, null, 3, null, 5]

Explanation
MapSum mapSum = new MapSum();
mapSum.insert("apple", 3);  
mapSum.sum("ap");           // return 3 (apple = 3)
mapSum.insert("app", 2);    
mapSum.sum("ap");           // return 5 (apple + app = 3 + 2 = 5)
 

Constraints:

1 <= key.length, prefix.length <= 50
key and prefix consist of only lowercase English letters.
1 <= val <= 1000
At most 50 calls will be made to insert and sum.

```

---

Basic idea:

这道题自己想到的肯定是经典的 Trie 解法，变化是把 `isEnd` 这个值
变成 `value`

自己 AC 的 Python 解法如下：
注意用 BFS-queue 来循环取得 prfix 所有对应的 value

看题解还有一种思路是用 HashMap 有机会的时候再看吧

```Python

class TrieNode(object):
    
    def __init__(self):
        self.children = {}
        self.value = -1

class Trie(object):
    
    def __init__(self):
        self.root = TrieNode()
    
    def add(self,word,value):
        curr = self.root
        
        for ch in word:
            if ch not in curr.children:
                curr.children[ch] = TrieNode()
            curr = curr.children[ch]
        
        curr.value = value
    
    def search(self,key):
        curr = self.root
        
        for ch in key:
            if ch not in curr.children:
                return 0
            curr = curr.children[ch]
        
        # next we need to get all values attached to current node
        queue = deque([curr])
        res = 0
        
        while queue:
            curr = queue.popleft()

            if curr.value!=-1:
                res += curr.value
                # continue
            # else:
            queue.extend(list(curr.children.values()))
        return res

class MapSum:

    def __init__(self):
        self.trie = Trie()
        

    def insert(self, key: str, val: int) -> None:
        self.trie.add(key,val)
        

    def sum(self, prefix: str) -> int:
        return self.trie.search(prefix)

```