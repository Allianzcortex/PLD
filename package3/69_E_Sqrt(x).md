
Problem description:

```
Given a non-negative integer x, compute and return the square root of x.

Since the return type is an integer, the decimal digits are truncated, and only the integer part of the result is returned.

Note: You are not allowed to use any built-in exponent function or operator, such as pow(x, 0.5) or x ** 0.5.

 

Example 1:

Input: x = 4
Output: 2
Example 2:

Input: x = 8
Output: 2
Explanation: The square root of 8 is 2.82842..., and since the decimal part is truncated, 2 is returned.
 

Constraints:

0 <= x <= 231 - 1

```

Basic idea:

这道题是很经典的二分搜索题，关键陷阱在于：

比如对 Input 为 10，left 和 right 可能的值为 3,4
因为 3*3==9,4*4==16, 所以我们想要的是 3 而不是 4
也就是在每次 lower bound 的时候更新一下 ans，对应 Python 解法如下：

```Python

class Solution:
    def mySqrt(self, x: int) -> int:
        
        left,right = 1,x
        ans = 0
        
        while left<=right:
            middle = left+(right-left)//2
            
            if middle==x//middle:
                return middle
            elif middle<x//middle:
                ans = middle
                left = middle+1
            else:
                right = middle-1
        
        return ans

```

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