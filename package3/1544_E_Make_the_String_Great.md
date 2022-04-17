

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
        // we can also compare ascii value directly
        // ASCII value of a is 97 and A is 65 , 97-65 = 32
        // return Math.abs(ch1-ch2)==32;
        return ch1!=ch2 && Character.toUpperCase(ch1)==Character.toUpperCase(ch2);
    }
}

```

While this is my initial thought, using StringBuilder, I will only say : 

WTF ? ? ?

```Java

class Solution {
    
    public void judge(StringBuilder res,char ch) {
        int len = res.length();
        if(len==0) {
            res.append(ch);
            return;
        }
      if(res.charAt(len-1)!=ch && Character.toUpperCase(res.charAt(len-1))==Character.toUpperCase(ch)) {
                res.setLength(len-1);
                    } else {
                        res.append(ch);
                    }
    }
    
    public String makeGood(String s) {
        
        StringBuilder res = new StringBuilder();
        char[] arr = s.toCharArray();
        for(int i=0;i<=arr.length-2;) {
            if(arr[i]!=arr[i+1] && Character.toUpperCase(arr[i])==Character.toUpperCase(arr[i+1])) {
                i+=2;
            } else {
                if(res.length()==0)
                    res.append(arr[i++]);
                else {
                    // two cases
                    judge(res,arr[i++]);   
                }
            }
        }
        
        judge(res,s.charAt(s.length()-1));
        
        return res.toString();
    }
}

```