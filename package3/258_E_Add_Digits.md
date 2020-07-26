
Soluiton 1 :

Use String to loop through the string based on requirement

```Java

class Solution {
    public int addDigits(int num) {
        String sb=String.valueOf(num);
        
        while(sb.length()!=1) {
            int res=0;
            for(char ch:sb.toCharArray()) {
                res+=(ch-'0');
            }
            sb = String.valueOf(res);
        }
        
        return Integer.parseInt(sb);
    }
}

```

---

Solution 2 :

Use math to get basic understanding

```
(1+2+3+4+5)%9 = (1*10000+2*1000+3*100+4*10+5)%9 = 12345%9


```

``` Java

class Solution {
    public int addDigits(int num) {
        if(num==0)
            return 0;
        if(num%9==0)
            return 9;
        return num%9;
    }
}

```