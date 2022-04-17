
Problem description:

```

The Tribonacci sequence Tn is defined as follows: 

T0 = 0, T1 = 1, T2 = 1, and Tn+3 = Tn + Tn+1 + Tn+2 for n >= 0.

Given n, return the value of Tn.

 

Example 1:

Input: n = 4
Output: 4
Explanation:
T_3 = 0 + 1 + 1 = 2
T_4 = 1 + 1 + 2 = 4
Example 2:

Input: n = 25
Output: 1389537

```

Basic idea :

经典问题斐波那契数列的变种

Python 第一种解法：

```Python

class Solution:
    def tribonacci(self, n: int) -> int:
        
        if n==0:
            return 0
        if n==1 or n==2:
            return 1
        
        array = [0]*(n+1)
        array[1]=array[2]=1
        
        for i in range(3,n+1):
            array[i] = array[i-1]+array[i-2]+array[i-3]
        
        return array[-1]

```

---

Python 第二种解法，简化空间复杂度：

```Python

class Solution:
    def tribonacci(self, n: int) -> int:
        
        if n<2:
            return n
        
        first,second,third = 0,1,1
        
        for _ in range(n-2):
            sum_ = first+second+third
            first = second
            second = third
            third = sum_
        
        return third

```