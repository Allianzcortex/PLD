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