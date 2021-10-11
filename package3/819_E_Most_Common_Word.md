
Problem description:

```

Given a string paragraph and a string array of the banned words banned, return the most frequent word that is not banned. It is guaranteed there is at least one word that is not banned, and that the answer is unique.

The words in paragraph are case-insensitive and the answer should be returned in lowercase.

 

Example 1:

Input: paragraph = "Bob hit a ball, the hit BALL flew far after it was hit.", banned = ["hit"]
Output: "ball"
Explanation: 
"hit" occurs 3 times, but it is a banned word.
"ball" occurs twice (and no other word does), so it is the most frequent non-banned word in the paragraph. 
Note that words in the paragraph are not case sensitive,
that punctuation is ignored (even if adjacent to words, such as "ball,"), 
and that "hit" isn't the answer even though it occurs more because it is banned.
Example 2:

Input: paragraph = "a.", banned = []
Output: "a"
 

Constraints:

1 <= paragraph.length <= 1000
paragraph consists of English letters, space ' ', or one of the symbols: "!?',;.".
0 <= banned.length <= 100
1 <= banned[i].length <= 10
banned[i] consists of only lowercase English letters.

```
Basic idea:

关键是要除去各种符号，用 `\w+` 的正则来提取所有单词：

Python 代码如下：

```Python

class Solution:
    def mostCommonWord(self, paragraph: str, banned: List[str]) -> str:
        
        s = re.findall("\w+",paragraph.lower())
        c = Counter(s)
        
        for word,_ in c.most_common():
            if word not in banned:
                return word
```