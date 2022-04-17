
Problem Description:

```

Given an m x n board of characters and a list of strings words, return all words on the board.

Each word must be constructed from letters of sequentially adjacent cells, where adjacent cells are horizontally or vertically neighboring. The same letter cell may not be used more than once in a word.

 

Example 1:


Input: board = [["o","a","a","n"],["e","t","a","e"],["i","h","k","r"],["i","f","l","v"]], words = ["oath","pea","eat","rain"]
Output: ["eat","oath"]
Example 2:


Input: board = [["a","b"],["c","d"]], words = ["abcb"]
Output: []
 
```

Idea :

这道题就是 Trie 与 DFS 结合。
关键注意几点：

1. 注意 temp 什么时候 + board[i][j]
2. 注意是 `board[i][j] not in root.children`\

以下是 Python 解法：

```Python


class TrieNode(object):
    def __init__(self,val):
        self.val = val
        self.children = {}
        self.isEnd = False
        

class Trie(object):
    
    def __init__(self):
        
        self.root = TrieNode(-1)
    
    def add_word(self,word):
        cur = self.root
        for ch in word:
            if ch not in cur.children:
                cur.children[ch] = TrieNode(ch)
            
            cur = cur.children[ch]
        
        cur.isEnd = True
        

class Solution:
    def findWords(self, board: List[List[str]], words: List[str]) -> List[str]:
        
        trie = Trie()
        for word in words:
            trie.add_word(word)
        
        row,column = len(board),len(board[0])
        res = []
        
        for i in range(row):
            for j in range(column):
                self.check(board,i,j,trie.root,"",res)
        
        return res
    
    def check(self,board,i,j,root,temp,res):
        if i<0 or i>len(board)-1 or j<0 or j>(len(board[0])-1):
            return
        if board[i][j] == '.':
            return
        if board[i][j] not in root.children:
            return
        
        ch = board[i][j]
        root = root.children[ch]
        temp += ch
        
        if root.isEnd:
            res.append(temp)
            root.isEnd = False
        
        for x,y in [(0,1),(0,-1),(-1,0),(1,0)]:

            board[i][j] = '.'
            self.check(board,i+x,j+y,root,temp,res)
            board[i][j] = ch
        
```
---

This problem will combine `DFS` + `Trie` together.

for cases like :

```
[['a'],['a]]

'a'
```

Our result will be `['a','a']` rather than `['a']`.We ned to handle
the duplicated items.

---

We have 2 solutions to do it :

1. Use Hashset and convert it into List<> finally

2. change the insert function,add the logic:

```
if(cur.isEnd==true){
        cur.isEnd=false;
        return true;
    }
return cur.isEnd;

```

It means if we find a word, will remove it from the trie (:

---

Solution 1:

```Java
class Solution {
    
    class TrieNode {
        boolean isEnd;
        TrieNode[] nodes;
        
        public TrieNode() {
            isEnd = false;
            nodes = new TrieNode[26];
        }
    }
    
    class Trie {
        TrieNode root;
        
        public Trie() {
            root = new TrieNode();
        }
        
        public void insert(String str) {
            TrieNode cur = root;
            for(char ch:str.toCharArray()) {
                int index=ch-'a';
                if(cur.nodes[index]==null)
                    cur.nodes[index]=new TrieNode();
                cur = cur.nodes[index];
            }
            cur.isEnd =  true;
        }
        
        public boolean startsWith(String str) {
            TrieNode cur = root;
            for(char ch:str.toCharArray()) {
                int index=ch-'a';
                if(cur.nodes[index]==null)
                    return false;
                cur = cur.nodes[index];
            }
            return true;
        }
        
        public boolean search(String str) {
            TrieNode cur =root;
            for(char ch:str.toCharArray()) {
                int index=ch-'a';
                if(cur.nodes[index]==null)
                    return false;
                cur = cur.nodes[index];
            }
            if(cur.isEnd==true){
                cur.isEnd=false;
                return true;
            }
            return cur.isEnd;
        }
    }
    
    public List<String> findWords(char[][] board, String[] words) {
        Set<String> res = new HashSet<>();
        if(board==null || board.length==0 || words==null || words.length==0)
            return new ArrayList<String>();
        
        Trie trie = new Trie();
        for(String word:words)
            trie.insert(word);
        boolean used[][] = new boolean[board.length][board[0].length];
        for(int i=0;i<board.length;i++) {
            for(int j=0;j<board[0].length;j++) {
                solve(board,used,i,j,res,"",trie);
            }
        }
        
        return new ArrayList<>(res);
    }
    
    
    public void solve(char[][] board,boolean[][] used,int i,int j,Set<String> res,String str,Trie trie) {
        if(i<0 || i>=board.length || j<0 || j>=board[0].length || used[i][j])
            return;
        
        // also here we need to add str first
        str+=board[i][j];
        if(!trie.startsWith(str))
            return;
        if(trie.search(str)) {
            res.add(str);
            // Donot return here,for there can be other cases
        }
        used[i][j]=true;
        solve(board,used,i,j+1,res,str,trie);
        solve(board,used,i,j-1,res,str,trie);
        solve(board,used,i-1,j,res,str,trie);
        solve(board,used,i+1,j,res,str,trie);
        used[i][j]=false;
        
    }
}

```

---

Solution 2 :

```Java

class Solution {
    
    class TrieNode {
        boolean isEnd;
        TrieNode[] nodes;
        
        public TrieNode() {
            isEnd = false;
            nodes = new TrieNode[26];
        }
    }
    
    class Trie {
        TrieNode root;
        
        public Trie() {
            root = new TrieNode();
        }
        
        public void insert(String str) {
            TrieNode cur = root;
            for(char ch:str.toCharArray()) {
                int index=ch-'a';
                if(cur.nodes[index]==null)
                    cur.nodes[index]=new TrieNode();
                cur = cur.nodes[index];
            }
            cur.isEnd =  true;
        }
        
        public boolean startsWith(String str) {
            TrieNode cur = root;
            for(char ch:str.toCharArray()) {
                int index=ch-'a';
                if(cur.nodes[index]==null)
                    return false;
                cur = cur.nodes[index];
            }
            return true;
        }
        
        public boolean search(String str) {
            TrieNode cur =root;
            for(char ch:str.toCharArray()) {
                int index=ch-'a';
                if(cur.nodes[index]==null)
                    return false;
                cur = cur.nodes[index];
            }
            if(cur.isEnd==true){
                cur.isEnd=false;
                return true;
            }
            return cur.isEnd;
        }
    }
    
    public List<String> findWords(char[][] board, String[] words) {
        List<String> res = new ArrayList<>();
        if(board==null || board.length==0 || words==null || words.length==0)
            return res;
        
        Trie trie = new Trie();
        for(String word:words)
            trie.insert(word);
        boolean used[][] = new boolean[board.length][board[0].length];
        for(int i=0;i<board.length;i++) {
            for(int j=0;j<board[0].length;j++) {
                solve(board,used,i,j,res,"",trie);
            }
        }
        
        return res;
    }
    
    
    public void solve(char[][] board,boolean[][] used,int i,int j,List<String> res,String str,Trie trie) {
        if(i<0 || i>=board.length || j<0 || j>=board[0].length || used[i][j])
            return;

        // also here we need to add str first
        str+=board[i][j];
        if(!trie.startsWith(str))
            return;
        if(trie.search(str)) {
            res.add(str);
        }
        used[i][j]=true;
        solve(board,used,i,j+1,res,str,trie);
        solve(board,used,i,j-1,res,str,trie);
        solve(board,used,i-1,j,res,str,trie);
        solve(board,used,i+1,j,res,str,trie);
        used[i][j]=false;
        
    }
}


```

For Java Implementaion, logic is really a bit complex :

Here is my Python Implementation :

```Python

class TrieNode(object):
    
    def __init__(self):
        self.children = {}
        self.is_word = False

class Trie(object):
    
    def __init__(self):
        self.root = TrieNode()
    
    def insert(self,word):
        current = self.root
        
        for w in word:
            if w not in current.children:
                current.children[w] = TrieNode()
            current = current.children[w]
        
        current.is_word = True


class Solution:
    def findWords(self, board: List[List[str]], words: List[str]) -> List[str]:
        
        if not board or len(board) == 0:
            return []
        
        res = []
        trie = Trie()
        for w in words:
            trie.insert(w)
        for i in range(len(board)):
            for j in range(len(board[0])):
                self.check(board,i,j,trie.root,res,"")
                
        return res
    
    def check(self,board,i,j,node,res,path):
        if node.is_word:
            res.append(path)
            node.is_word = False
            # here should not return , for words like [oath]/[oathk]
            # even if we find oath, we still need to continue to find oathk
            # return
        
        if i<0 or i>=len(board) or j<0 or j>=len(board[0]):
            return
        
        cur_char = board[i][j]
        if cur_char not in node.children:
            return
        node = node.children[cur_char]
        board[i][j] = '#'
        directions = [(0,1),(0,-1),(-1,0),(1,0)]
        for x,y in directions:
            self.check(board,i+x,j+y,node,res,path+cur_char)
        board[i][j] = cur_char

```