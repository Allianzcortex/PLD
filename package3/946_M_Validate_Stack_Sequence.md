
Classic and high frequency problem

Mock the stack behaviour

```Java

class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        if(pushed==null || popped==null || pushed.length!=popped.length)
            return false;
        
        Stack<Integer> s = new Stack<>();
        int index = 0;
        
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