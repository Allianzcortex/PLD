Problem Description:

```

You are given a string text of words that are placed among some number of spaces. Each word consists of one or more lowercase English letters and are separated by at least one space. It's guaranteed that text contains at least one word.

Rearrange the spaces so that there is an equal number of spaces between every pair of adjacent words and that number is maximized. If you cannot redistribute all the spaces equally, place the extra spaces at the end, meaning the returned string should be the same length as text.

Return the string after rearranging the spaces.

 

Example 1:

Input: text = "  this   is  a sentence "
Output: "this   is   a   sentence"
Explanation: There are a total of 9 spaces and 4 words. We can evenly divide the 9 spaces between the words: 9 / (4-1) = 3 spaces.
Example 2:

Input: text = " practice   makes   perfect"
Output: "practice   makes   perfect "
Explanation: There are a total of 7 spaces and 3 words. 7 / (3-1) = 3 spaces plus 1 extra space. We place this extra space at the end of the string.
 

Constraints:

1 <= text.length <= 100
text consists of lowercase English letters and ' '.
text contains at least one word.

```

思路：忘了...做这道题都是好久以前的了

Python 版解法如下：

```Python

class Solution:
    def reorderSpaces(self, text: str) -> str:
        
        words=text.strip().split()
        space_count = len(text)-sum(len(word) for word in words)
        words_count = len(words)

        if words_count>1:
            avg_space,extra = space_count//(words_count-1),space_count%(words_count-1)
        else:
            avg_space,extra = 0,space_count
            
        res = (" "*avg_space).join(words)
        return res+" "*extra

```

// TODO: 增加 Golang 版本解法