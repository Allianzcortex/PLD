
Problem description:

```

Given an array of strings words and a width maxWidth, format the text such that each line has exactly maxWidth characters and is fully (left and right) justified.

You should pack your words in a greedy approach; that is, pack as many words as you can in each line. Pad extra spaces ' ' when necessary so that each line has exactly maxWidth characters.

Extra spaces between words should be distributed as evenly as possible. If the number of spaces on a line does not divide evenly between words, the empty slots on the left will be assigned more spaces than the slots on the right.

For the last line of text, it should be left-justified and no extra space is inserted between words.

Note:

A word is defined as a character sequence consisting of non-space characters only.
Each word's length is guaranteed to be greater than 0 and not exceed maxWidth.
The input array words contains at least one word.
 

Example 1:

Input: words = ["This", "is", "an", "example", "of", "text", "justification."], maxWidth = 16
Output:
[
   "This    is    an",
   "example  of text",
   "justification.  "
]
Example 2:

Input: words = ["What","must","be","acknowledgment","shall","be"], maxWidth = 16
Output:
[
  "What   must   be",
  "acknowledgment  ",
  "shall be        "
]
Explanation: Note that the last line is "shall be    " instead of "shall     be", because the last line must be left-justified instead of fully-justified.
Note that the second line is also left-justified becase it contains only one word.
Example 3:

Input: words = ["Science","is","what","we","understand","well","enough","to","explain","to","a","computer.","Art","is","everything","else","we","do"], maxWidth = 20
Output:
[
  "Science  is  what we",
  "understand      well",
  "enough to explain to",
  "a  computer.  Art is",
  "everything  else  we",
  "do                  "
]
 

Constraints:

1 <= words.length <= 300
1 <= words[i].length <= 20
words[i] consists of only English letters and symbols.
1 <= maxWidth <= 100
words[i].length <= maxWidth

```

Basic idea:

这道题题意倒是很直观，但也有写的不清楚的地方，比如什么是：

```
If the number of spaces on a line does not divide evenly between words, the empty slots on the left will be assigned more spaces than the slots on the right.
```

原来它的意思是如果 4 个单词之间 space 总和为 5，那么分别为：[2,2,1] 而不是
[3,1,1]

这道题难就难在有太多的 corner case 需要考虑：

先上一个自己的解法，虽然 AC 了但显然太复杂......
需要找一个不那么复杂的解法去理解... TODO

```Python

class Solution:
    def fullJustify(self, words: List[str], maxWidth: int) -> List[str]:
        
        res = []
        i = 0
        
        # step 1 : use greedy to get as many items as we can in one-line
        temp = []
        curr_length = 0
        while i<len(words):
            
            new_length = curr_length+len(words[i])
            if curr_length!=0:
                new_length += 1
            
            if new_length<maxWidth:
                temp.append(words[i])
                curr_length = new_length
                i += 1
            elif new_length==maxWidth:
                temp.append(words[i])
                res.append(temp[:])
                temp = []
                curr_length = 0
                i += 1
            else:
                res.append(temp[:])
                temp = []
                curr_length = 0
        
        if temp:
            res.append(temp)
        output = self.justifyArray(res,maxWidth)
        return output
    
    def justifyArray(self,res,maxWidth):
        length = len(res)
        output = []
        
        for i in range(length):
            # if it's the last line:
            temp = []
            all_width = sum(len(item) for item in res[i])
            if i==length-1:
                output.append(' '.join(res[i])+' '*(maxWidth-len(res[i])+1-all_width))

            else:
                # distribute it evenly , put more slots on left
                cnt = len(res[i])
                all_width = maxWidth-all_width
                if cnt==1:
                    space = all_width
                    left_additional_space = 0
                else:
                    space = all_width//(cnt-1)
                    left_additional_space = all_width % (cnt-1)
                
                j = 0
                
                if cnt==1:
                    temp.append(res[i][j])
                    temp.extend([' ']*(space+left_additional_space))
                    output.append(''.join(temp))
                else:
                    while j<cnt:
                        temp.append(res[i][j])
                        temp.extend([' ']*(space))
                        if left_additional_space!=0:
                            temp.append(' ')
                            left_additional_space -= 1
                        j += 1
                
                    output.append(''.join(temp).strip())
        
        return output

```