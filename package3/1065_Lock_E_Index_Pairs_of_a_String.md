
Problem Description :

```

Given a text string and words (a list of strings), return all index pairs [i, j] so that the substring text[i]…text[j] is in the list of words. 

Example 1:

Input: text = “thestoryofleetcodeandme”, words = [“story”,”fleet”,”leetcode”]
Output: [[3,7],[9,13],[10,17]]
Example 2:

Input: text = “ababa”, words = [“aba”,”ab”]
Output: [[0,1],[0,2],[2,3],[2,4]]
Explanation: 
Notice that matches can overlap, see “aba” is found in [0,2] and [2,4].
Note:

All strings contains only lowercase English letters.
It’s guaranteed that all strings in words are different.
1 <= text.length <= 100
1 <= words.length <= 20
1 <= words[i].length <= 50
Return the pairs [i,j] in sorted order (i.e. sort them by their first coordinate in case of ties sort them by their second coordinate).

```

If we solve this problem with other complex methods like `KMP` or `Trie` 
then it seems overkill. 

We just need to continue using the built-in method to find the index

Java Solution:

```Java

class Solution {
    public int[][] indexPairs(String text, String[] words) {
        List<int[]> pairs = new LinkedList<>();
        for (int i = 0; i < words.length; i++) {
            int index = 0;
            
            while (true) {
                index = text.indexOf(words[i], index);
                
                if (index == - 1)
                    break;
                
                pairs.add(new int[]{ index, index + words[i].length() - 1 });
                index++;
            }
        }
        
        Collections.sort(pairs,(a,b)->(a[0]==b[0]?a[1]-b[1]:a[0]-b[0]));
        
        return pairs.toArray(new int[pairs.size()][2]);
    }
}


```

This is Python Solution :

```Python

    def indexPairs(self, text: str, words: List[str]) -> List[List[int]]:
        res = []

        for word in words:
            pos = 0
            while True:
                index = text[pos:].find(word)
                if index != -1:
                    res.append([index + pos, index + pos + len(word) - 1])
                    pos = index + pos+1
                else:
                    break
        return sorted(res)

```