
Problem Description:

```
Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

An input string is valid if:

Open brackets must be closed by the same type of brackets.
Open brackets must be closed in the correct order.
 

Example 1:

Input: s = "()"
Output: true
Example 2:

Input: s = "()[]{}"
Output: true
Example 3:

Input: s = "(]"
Output: false
Example 4:

Input: s = "([)]"
Output: false
Example 5:

Input: s = "{[]}"
Output: true

```

Basic Idea:

这道题是 stack 最简单的体型。但还是有一些 trick

Java 解法如下：

```Java

class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        String right = ")}]";
        for(char ch:s.toCharArray()) {
            if(right.indexOf(ch)!=-1) {
                if(!stack.isEmpty() && isMatch(stack.peek(),ch)){
                    stack.pop();
                    continue;
                }
                else
                    return false;
            } else {
                stack.push(ch);
            }
        }

        return stack.isEmpty();
    }

    public boolean isMatch(char ch1,char ch2) {
        return (ch1=='(' && ch2==')') || (ch1=='[' && ch2==']') || (ch1=='{' && ch2=='}');
    }
}


```

---

Python 解法如下：

```Python

class Solution:
    def isValid(self, s: str) -> bool:
        stack = []
        pairs = {"(":")","{":"}","[":"]"}
        for ch in s:
            if ch in pairs.keys():
                stack.append(ch)
            elif ch in pairs.values():
                # 这里主要是预防第一个 ch 就是 empty
                # 每次 stack pop 前都要想该 stack 是否有可能置空
                if not stack or pairs[stack.pop()]!=ch:
                    return False
        # 这里是为了预防 input 为 "(" 的情况，只有栈为空才说明括号互相 match            
        return stack==[]

```

another Python solution , same idea

```Python
class Solution:
    def isValid(self, s: str) -> bool:
        stack = []
        left_part = "({["
        right_part = ")}]"
        
        for ch in s:
            if ch in left_part:
                stack.append(ch)
            else:
                # check whether it's valid
                if stack==[]:
                    return False
                if right_part[left_part.find(stack.pop())]!=ch:
                    return False
        
        return stack == []

```