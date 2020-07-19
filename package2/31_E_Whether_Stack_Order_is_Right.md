
```Java

class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        if(pushed.length!=popped.length)
            return false;
        Stack<Integer> s=new Stack<Integer>();
        int index=0;
        for(int i=0;i<pushed.length;i++) {
            s.push(pushed[i]);
            while(!s.isEmpty() && s.peek()==popped[index]) {
                s.pop();
                index+=1;
            }
        }

        return s.isEmpty();
    }   
}

```