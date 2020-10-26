

This really looks like a question that can be solved by `stack`......

Java Solution :


I'm still a little confused about the whole flow,need to check it later

```Java

class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        // there will be explosion only when: positive left, negative right
        Stack<Integer> stack = new Stack<>();
        for(int i=0;i<asteroids.length;i++) {
            if(stack.isEmpty() || asteroids[i]>0) {
                stack.push(asteroids[i]);
            } else {
                while(true) {
                    int prev=stack.peek();
                    if(prev<0) {
                        stack.push(asteroids[i]);
                        break;
                    }
                    if(prev+asteroids[i]==0){
                        stack.pop();
                        break;
                    } else if(prev+asteroids[i]>0){
                        break;
                    } else {
                        stack.pop();
                        if(stack.isEmpty()) {
                            stack.push(asteroids[i]);
                            break;
                        }
                    }
                }
            }
        }
        
        int[] res = new int[stack.size()];
        for(int i=stack.size()-1;i>=0;i--)
            res[i] = stack.pop();
        return res;
       
    }
}

```

TODO : add Python Solution
This link can be useful : https://leetcode.com/problems/asteroid-collision/discuss/109694/JavaC%2B%2B-Clean-Code