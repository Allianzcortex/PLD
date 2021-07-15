
Problem Description :

```

A trie (pronounced as "try") or prefix tree is a tree data structure used to efficiently store and retrieve keys in a dataset of strings. There are various applications of this data structure, such as autocomplete and spellchecker.

Implement the Trie class:

Trie() Initializes the trie object.
void insert(String word) Inserts the string word into the trie.
boolean search(String word) Returns true if the string word is in the trie (i.e., was inserted before), and false otherwise.
boolean startsWith(String prefix) Returns true if there is a previously inserted string word that has the prefix prefix, and false otherwise.
 

Example 1:

Input
["Trie", "insert", "search", "search", "startsWith", "insert", "search"]
[[], ["apple"], ["apple"], ["app"], ["app"], ["app"], ["app"]]
Output
[null, null, true, false, true, null, true]

Explanation
Trie trie = new Trie();
trie.insert("apple");
trie.search("apple");   // return True
trie.search("app");     // return False
trie.startsWith("app"); // return True
trie.insert("app");
trie.search("app");     // return True
 

Constraints:

1 <= word.length, prefix.length <= 2000
word and prefix consist only of lowercase English letters.
At most 3 * 104 calls in total will be made to insert, search, and startsWith.

```

Below is Java Solution : 

```Java

class Trie {
    
    class TrieNode {
        boolean isWord;
        TrieNode[] nodes;
        
        public TrieNode() {
            isWord=false;
            nodes=new TrieNode[26];
        }
    }

    TrieNode root;
   
    public Trie() {
        root = new TrieNode();
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode curr = root;
        for(char ch:word.toCharArray()) {
            int index=ch-'a';
            if(curr.nodes[index]==null)
                curr.nodes[index]=new TrieNode();
            curr = curr.nodes[index];
        }
        
        curr.isWord=true;
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode curr = root;
        for(char ch:word.toCharArray()) {
            int idx=ch-'a';
            if(curr.nodes[idx]==null)
                return false;
            curr = curr.nodes[idx];
        }
        return curr.isWord;
        
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode curr = root;
        for(char ch:prefix.toCharArray()) {
            int idx=ch-'a';
            if(curr.nodes[idx]==null)
                return false;
            curr = curr.nodes[idx];
        }
        return true;
        
    }
}


```

This is what I did in Python, easier to understand:

```Python

from collections import defaultdict

class TrieNode(object):
    def __init__(self):
        self.children = {}
        self.is_word = False

class Trie:

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.root = TrieNode()
        

    def insert(self, word: str) -> None:
        """
        Inserts a word into the trie.
        """
        current = self.root
        for w in word:
            if w not in current.children:
                current.children[w] = TrieNode()
            current = current.children[w]
        
        current.is_word = True

    def search(self, word: str) -> bool:
        """
        Returns if the word is in the trie.
        """
        current = self.root
        for w in word:
            if w not in current.children:
                return False
            current = current.children[w]
        
        return current.is_word
        

    def startsWith(self, prefix: str) -> bool:
        """
        Returns if there is any word in the trie that starts with the given prefix.
        """
        current = self.root
        for s in prefix:
            if s not in current.children:
                return False
            current = current.children[s]
        
        return True

```

And another Python solution in to use defaultdict , the same idea but can be a little bit more elegant :

```Python

class TrieNode:
# Initialize your data structure here.
def __init__(self):
    self.children = collections.defaultdict(TrieNode)
    self.is_word = False

class Trie:

def __init__(self):
    self.root = TrieNode()

def insert(self, word):
    current = self.root
    for letter in word:
        current = current.children[letter]
    current.is_word = True

def search(self, word):
    current = self.root
    for letter in word:
        current = current.children.get(letter)
        if current is None:
            return False
    return current.is_word

def startsWith(self, prefix):
    current = self.root
    for letter in prefix:
        current = current.children.get(letter)
        if current is None:
            return False
    return True

```