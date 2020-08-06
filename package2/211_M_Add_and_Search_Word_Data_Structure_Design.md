
The basic idea is still to use `Trie` , but because of the existence of
`.` ,so we need to use recursive method when trying to search the string.

```Java
class WordDictionary {

    /** Initialize your data structure here. */
    
    class TrieNode {
        boolean isWords;
        TrieNode[] nodes;
        
        public TrieNode() {
            isWords = false;
            nodes = new TrieNode[26];
        }
    }
    
     TrieNode root;
    
    public WordDictionary() {
        root = new TrieNode();
        
    }
    
    /** Adds a word into the data structure. */
    public void addWord(String word) {
        TrieNode cur = root;
        for(char ch:word.toCharArray()) {
            int index=ch-'a';
            if(cur.nodes[index]==null)
                cur.nodes[index]=new TrieNode();
            cur = cur.nodes[index];
        }
        cur.isWords = true;
        
    }
    
    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        return match(word,0,root);
    }
    
    public boolean match(String word,int k,TrieNode cur) {
        if(k==word.length())
            return cur.isWords;
        if(word.charAt(k)=='.') {
            for(int i=0;i<26;i++) {
                if(cur.nodes[i]!=null && match(word,k+1,cur.nodes[i]))
                    return true;
            }
        } else {
            int index=word.charAt(k)-'a';
            return cur.nodes[index]!=null && match(word,k+1,cur.nodes[index]);
        }
        
        return false;
    }
}


```