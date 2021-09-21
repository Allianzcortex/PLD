
Problem description:

```
Design a data structure that supports adding new words and finding if a string matches any previously added string.

Implement the WordDictionary class:

WordDictionary() Initializes the object.
void addWord(word) Adds word to the data structure, it can be matched later.
bool search(word) Returns true if there is any string in the data structure that matches word or false otherwise. word may contain dots '.' where dots can be matched with any letter.
 

Example:

Input
["WordDictionary","addWord","addWord","addWord","search","search","search","search"]
[[],["bad"],["dad"],["mad"],["pad"],["bad"],[".ad"],["b.."]]
Output
[null,null,null,null,false,true,true,true]

Explanation
WordDictionary wordDictionary = new WordDictionary();
wordDictionary.addWord("bad");
wordDictionary.addWord("dad");
wordDictionary.addWord("mad");
wordDictionary.search("pad"); // return False
wordDictionary.search("bad"); // return True
wordDictionary.search(".ad"); // return True
wordDictionary.search("b.."); // return True
 

Constraints:

1 <= word.length <= 500
word in addWord consists lower-case English letters.
word in search consist of  '.' or lower-case English letters.
At most 50000 calls will be made to addWord and search.

```

Basic idea : 使用 trie 来解决问题

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