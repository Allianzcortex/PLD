Classic Problem.
There are different solutions

1. Solution 1 Recursive
``` Java
// recursive
class Solution {
    public boolean isPowerOfTwo(int n) {
        return n>0 && (n==1 || (n%2==0 && isPowerOfTwo(n/2)));
    }
}

```

2. Solution 2 Use while loop to calculate recursively

``` Java
class Solution {
    public boolean isPowerOfTwo(int n) {
        if(n<=0)
            return false;
        while(n%2==0)
            n/=2;
        return n==1;
    }
}

```

3. Solution 3 Bit Manipulation

for binary , the unit will be : 8 4 2 1 0
take an example, if its 4,then will be : `1 0 0 0`
And 3 will be `0 1 1 1`
If we do the AND operation then all bits should be zero.

```Java
class Solution {
    public boolean isPowerOfTwo(int n) {
        if(n<=0)
            return false;
        return (n&(n-1))==0;
    }
}
```