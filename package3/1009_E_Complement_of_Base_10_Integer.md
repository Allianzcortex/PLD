
This is my stupid yet intuitive solution.

```Java

class Solution {
    public int bitwiseComplement(int N) {
        int res = 0;
        String binary = int2Binary(N);
        for(int i=0;i<binary.length();i++) {
                res = res*2 + 1-(binary.charAt(i)-'0');
        }
        
        return res;
    }
    
    public String int2Binary(int N) {
        StringBuilder res = new StringBuilder();
        int index = 1;
        if(N==0)
            return "0";
        while(N>0) {
            res.append(N%2==0?"0":"1");
            N/=2;
        }
        
        return res.reverse().toString();
    }
}

```

---

While a better solution is to use bit-manipulation...

I will add it later