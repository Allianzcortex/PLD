
Problem description:

```

You are given a string title consisting of one or more words separated by a single space, where each word consists of English letters. Capitalize the string by changing the capitalization of each word such that:

If the length of the word is 1 or 2 letters, change all letters to lowercase.
Otherwise, change the first letter to uppercase and the remaining letters to lowercase.
Return the capitalized title.

 

Example 1:

Input: title = "capiTalIze tHe titLe"
Output: "Capitalize The Title"
Explanation:
Since all the words have a length of at least 3, the first letter of each word is uppercase, and the remaining letters are lowercase.
Example 2:

Input: title = "First leTTeR of EACH Word"
Output: "First Letter of Each Word"
Explanation:
The word "of" has length 2, so it is all lowercase.
The remaining words have a length of at least 3, so the first letter of each remaining word is uppercase, and the remaining letters are lowercase.
Example 3:

Input: title = "i lOve leetcode"
Output: "i Love Leetcode"
Explanation:
The word "i" has length 1, so it is lowercase.
The remaining words have a length of at least 3, so the first letter of each remaining word is uppercase, and the remaining letters are lowercase.
 

Constraints:

1 <= title.length <= 100
title consists of words separated by a single space without any leading or trailing spaces.
Each word consists of uppercase and lowercase English letters and is non-empty.

```



这道题的思路很直观了，Python 解法如下，用的都是默认的 `API` :

```Python

class Solution:
    def capitalizeTitle(self, title: str) -> str:
        """
        1. words : 1 or 2, all lower
        2. words : >2 , be capitalized
        """
        
        res = []
        for word in title.split(" "):
            word = word.lower()
            
            if len(word)>2:
                word = word.capitalize()
            
            res.append(word)
        
        return " ".join(res)

```

Golang 解法如下：

```Golang

func capitalizeTitle(title string) string {
    
    res:=strings.Split(title, " ")
    
    for i,word :=range res {
        if(len(word)<=2) {
            res[i] = strings.ToLower(word)
        } else {
            res[i] = strings.ToUpper(word)[:1] + strings.ToLower(word)[1:]
        }
    }
    
    return strings.Join(res," ")
    
}

```