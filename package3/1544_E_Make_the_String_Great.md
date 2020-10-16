
Java Solution :

```Java

class Solution {
    public String makeGood(String s) {
        Stack<Character> stack = new Stack<>();
        for(char ch:s.toCharArray()) {
            if(!stack.isEmpty() && judge(stack.peek(),ch)) {
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
    
    public boolean judge(char ch1,char ch2) {
        // return ch1!=ch2 && Character.toUpperCase(ch1)==Character.toUpperCase(ch2);
        return Math.abs(ch1-ch2)==32;
    }
}

```

TODO : Add Python Solution later