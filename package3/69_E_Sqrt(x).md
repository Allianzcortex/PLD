
This is the classic two pointer problem

```java

class Solution {
    public int mySqrt(int x) {
        if(x==0)
            return 0;
        int left=1,right=x;
        int middle=0;
        int ans=0;
        while(left<=right){
            middle=left+(right-left)/2;
            if(middle*middle==x)
                return middle;
            else if(middle*middle<x){
                left=middle+1;
            } else {
                right=middle-1;
            }
        }
        
        return middle;
    }
}

```
But there are some drawbacks:

1. middle*middle==x , it may be overflow
2. for 10,11,12,all of their sqrt results are 3.
But we donot know which branch they will enter finally,so sometimes
they can be 3, sometimes they can be 4.

This is the fixed solution:

```Java
class Solution {
    public int mySqrt(int x) {
        int left=1,right=x;
        int ans = 0;
        while(left<=right) {
            int middle = left+(right-left)/2;
            if(middle<=x/middle) {
                ans = middle;
                left = middle + 1;
            } else {
                right = middle-1;
            }
        }
        
        return ans;
    }
}


```