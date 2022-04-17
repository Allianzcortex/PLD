
Problem description:

```

Given a string s, we can transform every letter individually to be lowercase or uppercase to create another string.

Return a list of all possible strings we could create. You can return the output in any order.

 

Example 1:

Input: s = "a1b2"
Output: ["a1b2","a1B2","A1b2","A1B2"]
Example 2:

Input: s = "3z4"
Output: ["3z4","3Z4"]
Example 3:

Input: s = "12345"
Output: ["12345"]
Example 4:

Input: s = "0"
Output: ["0"]
 

Constraints:

s will be a string with length between 1 and 12.
s will consist only of letters or digits.

```

Basic idea:

这道题虽然是 medium 但没什么难的，就是最基本的分门别类处理就好了

自己所做的 Python 解法如下：

```Python

class Solution:
    def letterCasePermutation(self, s: str) -> List[str]:
        
        if not s:
            return []
        
        res = [""]

        for ch in s:
            if ch.isdigit():
                
                res=[prev+ch for prev in res]
            else:
                temp = res[::]
                lowerSet = [prev+ch.lower() for prev in temp]
                upperSet = [prev+ch.upper() for prev in temp]
                
                res=lowerSet+upperSet
       
        return res

```

当然用 Python 的 list comprehension 是有办法来简化的：

```Python

 for ch in s:
    if ch.isalpha():
        res=[prev+w for prev in res for w in [ch.lower(),ch.upper()]]
    else:
        res=[prev+ch for prev in res]
```

#### TODO

后续添加 Golang 实现