
Problem description:

```
An ugly number is a positive integer whose prime factors are limited to 2, 3, and 5.

Given an integer n, return the nth ugly number.

 

Example 1:

Input: n = 10
Output: 12
Explanation: [1, 2, 3, 4, 5, 6, 8, 9, 10, 12] is the sequence of the first 10 ugly numbers.
Example 2:

Input: n = 1
Output: 1
Explanation: 1 has no prime factors, therefore all of its prime factors are limited to 2, 3, and 5.

```

Basic Idea :

这道题自己已经做过很多次了，但每次好像都不顺利。要点如下：

a. 要用一个数组来存储每一次的最小数字

b. 用 factor_2,factor_3,factor_5 来表示每一次系数：
对 factor_2，计算结果为：factor_2 = 2 * (当前最小的 ugly number)
对 factor_3，计算结果为：factor_2 = 3 * (当前最小的 ugly number)
对 factor_5，计算结果为：factor_2 = 5 * (当前最小的 ugly number)

c. 所以如果要对每一个系数得到当前最小的 ugly number，那么就要对每一个
factor 计算一个 index

d. factor_2/factor_3/factor_5 存在可能相等的情况，所以不能用 if-else，而是用
if。

---

Python 代码如下：

```Python

class Solution:
    def nthUglyNumber(self, n: int) -> int:
        
        index_2,index_3,index_5 = 0,0,0
        factor_2,factor_3,factor_5 = 2,3,5
        
        res = [1] * n
        
        for index in range(1,n):
            print(f"{index_2} {index_3} {index_5}")
            print(f"{factor_2} : {factor_3} : {factor_5}")
            min_val = min(min(factor_2,factor_3),factor_5)
            res[index] = min_val
            if min_val == factor_2:
                factor_2 = 2*res[index_2+1]
                index_2 += 1
            if min_val == factor_3:
                factor_3 = 3*res[index_3+1]
                index_3 += 1
            if min_val == factor_5:
                factor_5 = 5*res[index_5+1]
                index_5 += 1
        
        return res[n-1]
```

---

Golang 代码如下：

```Golang

func nthUglyNumber(n int) int {

    factor2,factor3,factor5 := 2,3,5
    index2,index3,index5 := 1,1,1
    
    res:=make([]int,n)
    
    res[0] = 1
    
    for i:=1;i<n;i++ {
        minNum := min(min(factor2,factor3),factor5)
        res[i] = minNum
        
        if minNum==factor2 {
            factor2 = res[index2]*2
            index2 += 1
        }
        
        if minNum==factor3 {
            factor3 = res[index3]*3
            index3 += 1
        }
        
        if minNum==factor5 {
            factor5 = res[index5]*5
            index5 += 1
        }
    }
    
    return res[n-1]
}


func min(a,b int) int {
    if (a<b) {
        return a
    }
    
    return b
}

```

