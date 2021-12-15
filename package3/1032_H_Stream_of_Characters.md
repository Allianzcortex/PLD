
Problem description:

```

Design an algorithm that accepts a stream of characters and checks if a suffix of these characters is a string of a given array of strings words.

For example, if words = ["abc", "xyz"] and the stream added the four characters (one by one) 'a', 'x', 'y', and 'z', your algorithm should detect that the suffix "xyz" of the characters "axyz" matches "xyz" from words.

Implement the StreamChecker class:

StreamChecker(String[] words) Initializes the object with the strings array words.
boolean query(char letter) Accepts a new character from the stream and returns true if any non-empty suffix from the stream forms a word that is in words.
 

Example 1:

Input
["StreamChecker", "query", "query", "query", "query", "query", "query", "query", "query", "query", "query", "query", "query"]
[[["cd", "f", "kl"]], ["a"], ["b"], ["c"], ["d"], ["e"], ["f"], ["g"], ["h"], ["i"], ["j"], ["k"], ["l"]]
Output
[null, false, false, false, true, false, true, false, false, false, false, false, true]

Explanation
StreamChecker streamChecker = new StreamChecker(["cd", "f", "kl"]);
streamChecker.query("a"); // return False
streamChecker.query("b"); // return False
streamChecker.query("c"); // return False
streamChecker.query("d"); // return True, because 'cd' is in the wordlist
streamChecker.query("e"); // return False
streamChecker.query("f"); // return True, because 'f' is in the wordlist
streamChecker.query("g"); // return False
streamChecker.query("h"); // return False
streamChecker.query("i"); // return False
streamChecker.query("j"); // return False
streamChecker.query("k"); // return False
streamChecker.query("l"); // return True, because 'kl' is in the wordlist
 

Constraints:

1 <= words.length <= 2000
1 <= words[i].length <= 2000
words[i] consists of lowercase English letters.
letter is a lowercase English letter.
At most 4 * 104 calls will be made to query.

```

Basic idea:

这道题虽然是 hard 难度，但其实就是 medium level 吧，很容易想到 `Trie` 的思路：

值得一提的是 `check_word` 时用的是将 `sequence` 从后往前直接比较，自己在第一次实现的时候
是把 `list` 转换成 `string` 后再比较 `return self.trie.check_word(''.join(self.sequence[::-1]))`
这是完全没有必要的，结果也造成最后一个 testcase TLE

Python 解法如下：

```Python

class TrieNode(object):
    
    def __init__(self):
        
        self.children = {}
        self.isEnd = False
    
class Trie(object):
    
    def __init__(self,words):
        
        self.root = TrieNode()
        for word in words:
            self.append_word(word[::-1])
    
    def append_word(self,word):
        root = self.root
        
        for ch in word:
            if ch not in root.children:
                root.children[ch] = TrieNode()
            root = root.children[ch]
        
        root.isEnd = True
    
    def check_word(self,sequence):
        
        root = self.root
        
        for idx in range(len(sequence)-1,-1,-1):
            ch = sequence[idx]

            if ch not in root.children:
                return False
            root = root.children[ch]
            
            if root.isEnd:
                return True
        
        return False
    

class StreamChecker:

    def __init__(self, words: List[str]):
        
        self.trie = Trie(words)
        self.sequence = []

    def query(self, letter: str) -> bool:
        
        self.sequence.append(letter)
        return self.trie.check_word(self.sequence)

```

Build the trie from end to start

Pretty intuitive

Golang 解法如下，感觉还有优化的空间：

```Golang


type TrieNode struct {
    isEnd bool
    children map[byte]*TrieNode
}

func NewTrieNode() *TrieNode {
    return &TrieNode {
        isEnd:false,
        children:make(map[byte]*TrieNode),
    }
}

type Trie struct {
    root *TrieNode
}

func NewTrie(words []string) *Trie {
    trie:=&Trie{root:NewTrieNode()}
    
    for _,word := range words {
        trie.AppendWord(word)
    }
    
    return trie
    
}

func (t *Trie) AppendWord(word string) {
    root:=t.root
    
    for i:=len(word)-1;i>=0;i-- {
        ch := word[i]
        if _,ok := root.children[ch];!ok {
            root.children[ch] = NewTrieNode()
        }
        root = root.children[ch]
    }
    
    root.isEnd = true
}

func (t *Trie) CheckWord(sequence []byte) bool {
    root:=t.root
    
    for index:=len(sequence)-1;index>=0;index-- {
        ch := sequence[index]
        if _,ok:=root.children[ch];!ok {
            return false
        }
        
        if root=root.children[ch];root.isEnd==true {
            return true
        }
    }
    
    return false
}


type StreamChecker struct {
    trie *Trie
    sequence []byte
}


func Constructor(words []string) StreamChecker {
    
    trie := NewTrie(words)
    return StreamChecker {
        trie:trie,
    }
    
}


func (this *StreamChecker) Query(letter byte) bool {
    
    this.sequence = append(this.sequence,letter)
    
    return this.trie.CheckWord(this.sequence)
}

```

Java Solution

```Java

class StreamChecker {
    
    class TrieNode {
        boolean isWords;
        TrieNode[] nodes;
        
        public TrieNode() {
            isWords = false;
            nodes = new TrieNode[26];
        }
    }
    
    TrieNode root;
    StringBuilder builder;
    
    public StreamChecker(String[] words) {
        builder = new StringBuilder();
        root = new TrieNode();
        for(String word:words) {
            TrieNode cur = root;
            for(int i=word.length()-1;i>=0;i--) {
                int idx = word.charAt(i)-'a';
                if(cur.nodes[idx]==null)
                    cur.nodes[idx] = new TrieNode();
                cur = cur.nodes[idx];
            }
            cur.isWords = true;
        }
        
    }
    
    public boolean query(char letter) {
        builder.append(letter);
        TrieNode cur = root;
        for(int i=builder.length()-1;i>=0 && cur!=null;i--) {
            int index  = builder.charAt(i)-'a';
            cur = cur.nodes[index];
            if(cur!=null && cur.isWords)
                return true;
        }
        
        return false;
    }
}

```