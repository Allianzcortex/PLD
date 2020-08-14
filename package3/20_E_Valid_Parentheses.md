
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