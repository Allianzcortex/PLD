
DP 101 problem

```Java
class Solution {
    public int fib(int N) {
        if(N==0)
            return 0;
        if(N==1)
            return 1;
        int prev=0,cur=1;
        for(int i=0;i<N-1;i++) {
            int sum = prev+cur;
            prev = cur;
            cur = sum;
        }
        
        return cur;
    }   
}

```