The same with 231

Solution 1

```Java
class Solution {
    public boolean isPowerOfTwo(int n) {
        if(n<=0)
            return false;
        return (n&(n-1))==0;
    }
}

```

Solution 2

``` Java
class Solution {
    public boolean isPowerOfThree(int n) {
        if(n>1) {
            while(n%3==0)
                n/=3;
        }
        return n==1;
    }
}

```