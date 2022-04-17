
Problem Description:

```
You are given two strings order and s. All the words of order are unique and were sorted in some custom order previously.

Permute the characters of s so that they match the order that order was sorted. More specifically, if a character x occurs before a character y in order, then x should occur before y in the permuted string.

Return any permutation of s that satisfies this property.

 

Example 1:

Input: order = "cba", s = "abcd"
Output: "cbad"
Explanation: 
"a", "b", "c" appear in order, so the order of "a", "b", "c" should be "c", "b", and "a". 
Since "d" does not appear in order, it can be at any position in the returned string. "dcba", "cdba", "cbda" are also valid outputs.
Example 2:

Input: order = "cbafg", s = "abcd"
Output: "cbad"
 

Constraints:

1 <= order.length <= 26
1 <= s.length <= 200
order and s consist of lowercase English letters.
All the characters of order are unique.

```

This problem is not so hard :

My idea is to match the order/sequence with s and sort t.

Belos is Python solution :

```Python

class Solution:
    def customSortString(self, order: str, s: str) -> str:
        # match = {}
        # for index,char in enumerate(order):
        #     match[char] = index
        match = {v:k for k,v in enumerate(order)}
        res = sorted(s,key=lambda x:match.get(x,-1))
        return ''.join(res)

```

Some people in other solutions come up with ideas of `counting` , still can't figure out 
why it can be used like that, maybe check it later.
