
This is my solution here:

```Java

class Solution {
    public String thousandSeparator(int n) {
        if(n==0)
            return "0";
        int cnt = 0;
        StringBuilder res = new StringBuilder();
        
        while(n!=0) {
            if(cnt==3) {
                res.append(".");
                cnt = 0;
            }
            
            res.append(n%10);
            n/=10;
            cnt += 1;
        }
        
        return res.reverse().toString();
    }
}

```

TODO : may check other solutions later