
My Solution is here :

```Java
class Solution {
    public int rotatedDigits(int N) {
        
        int res = 0;
        for(int i=2;i<=N;i++) {
            if(isValid(i))
                res+=1;
        }
        
        return res;
    }
    
    public boolean isValid(int N) {
        boolean flag = false;
        while(N>0) {
            int temp = N%10;
            if(temp==2 || temp==5 || temp==6 || temp==9)
                flag = true;
            else if(!(temp==0 || temp==1 || temp==8))
                return false;
            N/=10;
        }
        
        return flag;
    }
    
    
}

```

It's not so effective. Another will be to use `Math.pow()` 

will add it later and add Python solution