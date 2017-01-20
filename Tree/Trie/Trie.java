package Test;

import java.util.HashMap;

/**
 * 用 Trie 树来解析
 */

class TrieNode {
    private char val;
    private HashMap<Character, TrieNode> children;
    private boolean isEnd;

    TrieNode(char newVal) {
        this.val = newVal;
        this.children = new HashMap<Character, TrieNode>();
        this.isEnd = false;
    }

    public HashMap<Character, TrieNode> getChildren() {
        return children;
    }

    public void setIsEnd(Boolean judge) {
        this.isEnd = judge;
    }

    public boolean isEnd() {
        return isEnd;
    }

}

public class Trie {
    TrieNode root;

    // 负责创建一个 Trie，并写入
    public void insert(String input) {
        int length = input.length();
        TrieNode target = root;
        int level, prevMatch = 0;
        for (level = 0; level < length; level++) {
            char ch = input.charAt(level);
            HashMap<char, TreeNode> children = target.getChildren();
            if (children.containsKey(ch)) {
                target = children.get(ch);
            } else {
                TrieNode temp = new TrieNode(ch);
                children.put(ch, temp);
                target = temp;
            }
        }

        target.setIsEnd(true);
    }

    public String findPrefixMatch(String input) {
        StringBuilder builder = new StringBuilder();
        int length = input.length();
        TrieNode target = root;
        int level;
        int prevMatch = 0;
        for (level = 0; level < length; level++) {
            char ch = input.charAt(level);
            HashMap children = root.getChildren();
            if (children.containsKey(ch)) {
                builder.append(ch);
                target = children.get(ch);

                // 如果这是最后一个词
                if (target.isEnd())
                    prevMatch = level + 1;
            } else {
                break;
                ;
            }
        }
        String result = builder.toString();
        if (!target.isEnd())
            return result.substring(0, prevMatch);
        else
            return result;
    }

    public String getCommonPrefix(TreeNode root) {
        // 返回一系列字串的公共最长字串
    }

    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.root = new TrieNode(); // pass

        // 还有一道题目是
    }
}

