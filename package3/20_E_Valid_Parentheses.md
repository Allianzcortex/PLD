
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

The key for this problem is to avoid complex boilerplate

My Solution

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

```Python

class Solution:
    def isValid(self, s: str) -> bool:
        stack = []
        pairs = {"(":")","{":"}","[":"]"}
        for ch in s:
            if ch in pairs.keys():
                stack.append(ch)
            elif ch in pairs.values():
                if stack==[] or pairs[stack.pop()]!=ch:
                    return False
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