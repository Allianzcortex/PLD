
Problem description:

```
Implement pow(x, n), which calculates x raised to the power n (i.e., xn).

 

Example 1:

Input: x = 2.00000, n = 10
Output: 1024.00000
Example 2:

Input: x = 2.10000, n = 3
Output: 9.26100
Example 3:

Input: x = 2.00000, n = -2
Output: 0.25000
Explanation: 2-2 = 1/22 = 1/4 = 0.25
 

Constraints:

-100.0 < x < 100.0
-231 <= n <= 231-1
-104 <= xn <= 104

```

Basic idea:

这道题初看起来非常基本，就是求 pow(x,n) 用 `divide and conquer` 
很容易做，但一个隐藏的陷阱就是负数的 `overflow` 问题：

就如 input 所说：`n` 的范围是在 [-2141483468 - 2141483467] 之间，
对最大负数 `-2141483468`，我们：

1. 直接变成正数 -> 2141483468 会超出范围
2. 变成正数 -1 -> 变成 1/(x*(x**2141483467)) 也会超出范围
3. 需要变成 1/x * (1/x**2141483467)

Python 解法如下：

```Python
class Solution:
    def myPow(self, x: float, n: int) -> float:
        
        if n==0:
            return 1
        
        if n<0:
            """
            x**(-3) = 1/(x**3)
            """
            # below is invalid,which still exceed
            # return 1/(x*self.myPow(x,-1*n-1)
            # we should return
            return (1/x)*(self.myPow(1/x,-1*n-1))
        
        return self.myPow(x**2,n//2) if n%2==0 else x*self.myPow(x**2,n//2)

```


```Java
class Solution {
    public double myPow(double x, int n) {
        if(n==0)
            return 1;
        if(n<0)
            return 1/x*(myPow(1/x,-(n+1)));
        return n%2==0?myPow(x*x,n/2):x*myPow(x*x,n/2);
    }
}

```