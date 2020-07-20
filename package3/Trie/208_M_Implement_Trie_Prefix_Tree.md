
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