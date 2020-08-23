
Build the trie from end to start

Pretty intuitive

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