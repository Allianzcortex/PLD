
The key here is to avoid the overflow

```java
class Solution {
    public int reverse(int x) {
        int res = 0;
        int prev = 0;
        while(x!=0) {
            res = prev*10+x%10;
            if((res-x%10)/10!=prev)
                return 0;
            prev = res;
            x/=10;
        }
        
        return res;
    }
}

```

Python Solution

```Python

class Solution:
    def reverse(self, x: int) -> int:
        res = 0
        sign = -1 if x<0 else 1
        x = abs(x)
        while(x!=0):
            res = res*10 + x%10
            x = x//10
        
        # or we can use : return res if (res<2**31 and res>-2**31-1) else 0
        return 0 if res>pow(2,31) else res*sign

```