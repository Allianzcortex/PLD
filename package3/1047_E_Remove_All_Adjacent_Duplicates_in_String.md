
Classic using stack to eliminate duplicates problem

Solution 1 : Using Stack directly

```Java
class Solution {
    public String removeDuplicates(String S) {
        Deque<Character> stack = new ArrayDeque<>();
        for(char ch:S.toCharArray()) {
            if(!stack.isEmpty() && stack.peek()==ch) {
                stack.pop();
            } else {
                stack.push(ch);
            }
        }
        
        StringBuilder res = new StringBuilder();
        while(!stack.isEmpty())
            res.append(stack.pop());
        return res.reverse().toString();
    }
}


```

---

Solution 2 : Using StringBuilder to mock the stack

```Java
class Solution {
    public String removeDuplicates(String S) {
        
        StringBuilder res = new StringBuilder();
        for(char ch:S.toCharArray()) {
            int len = res.length();
            if(len>0 && res.charAt(len-1)==ch) {
                res.deleteCharAt(len-1);
                // or we can just setLength,and it's more effective
                // res.setLength(len-1);
            } else {
                res.append(ch);
            }
        }
        
        return res.toString();
    }
}

```

---

TODO add Python Solution
