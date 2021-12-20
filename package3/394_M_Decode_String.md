
Problem description:

```

Given an encoded string, return its decoded string.

The encoding rule is: k[encoded_string], where the encoded_string inside the square brackets is being repeated exactly k times. Note that k is guaranteed to be a positive integer.

You may assume that the input string is always valid; No extra white spaces, square brackets are well-formed, etc.

Furthermore, you may assume that the original data does not contain any digits and that digits are only for those repeat numbers, k. For example, there won't be input like 3a or 2[4].

 

Example 1:

Input: s = "3[a]2[bc]"
Output: "aaabcbc"
Example 2:

Input: s = "3[a2[c]]"
Output: "accaccacc"
Example 3:

Input: s = "2[abc]3[cd]ef"
Output: "abcabccdcdcdef"
Example 4:

Input: s = "abc3[cd]xyz"
Output: "abccdcdcdxyz"
 

Constraints:

1 <= s.length <= 30
s consists of lowercase English letters, digits, and square brackets '[]'.
s is guaranteed to be a valid input.
All the integers in s are in the range [1, 300].

```

Basic idea:

这道题属于一看就知道是要用 Stack 来解但具体细节不太好处理的题

整个 string 被分为 3 部分：`prevString` / `prevNum` / `curString`

遇到 `[` 时：curString 就会被转化为 `prevString`，和 prevNum 一起被压入栈
遇到 `]` 时：从栈中弹出 prevNum 和 prevString，和 curString 一起生成最新的
curString : curString = prevString + prevNum * curString
遇到 `digit` 时：更新 curNum
遇到其他情况，就说明是普通字符，更新 `curString`

用 Python 解法如下：

```Python

class Solution:
    def decodeString(self, s: str) -> str:
        
        stack,curNum = [],0
        curString = ""
        
        for ch in s:
            if ch=='[':
                stack.append(curNum)
                stack.append(curString)
                curNum = 0
                curString = ""
            elif ch==']':
                prevString = stack.pop()
                prevNum = stack.pop()
                curString = prevString + prevNum*curString
            elif ch.isdigit():
                curNum = curNum*10+int(ch)
            else:
                curString += ch
        
        return curString

```