
Problem description :

```
Given an integer n, return the nth digit of the infinite integer sequence [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, ...].

 

Example 1:

Input: n = 3
Output: 3
Example 2:

Input: n = 11
Output: 0
Explanation: The 11th digit of the sequence 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, ... is a 0, which is part of the number 10.

```

Basic idea :

自己一开始看到这道题的时候还有点迷惑 (:-

这道题的思路就是尽可能逼近 target 的数字

首先是这样：

"""
1 - 9 : 9 numbers
10-99 : 90 numbers
100-999:900 numbers

"""

1 - 9 有 9 个数字，每个数字是 1 位，所以共有 9*1=9 位
10-99 有 90个数字，每个数字是 2 位，所以共有 90*2=180 位
100-999有900个数字，每个数字是3位，所以共有 900*3=2700 位

依此类推。我们用 length来代表 1-2-3(每次+1)，用 count来代表 9-90-900(每次×10)：
当  n>length*count 满足后，再用：

"""
added = (n-1)//length
start += added
n -= added * length
"""
来逼近。

注意条件一定是：`n>length*count` 而非 `n>=length*count`，比如输入的 n 是 9，
如果按照 `n>=length*count` 计算的话就会直接跑到第 10 个去。

Python 解法如下：

```Python
class Solution:
    def findNthDigit(self, n: int) -> int:
        """
        1 - 9 : 9 numbers
        10-99 : 90 numbers
        100-999:900 numbers
        
        """
        if n<=9:
            return n
        
        length,count = 1,9
        start = 1
        
        while n>length*count:
            n-= length*count
            length += 1
            count *= 10
            start *= 10
        
        # trying to be close again
        added = (n-1)//length
        start += added
        n -= added * length
        
        # we know target number must be in next start number
        return str(start)[n-1]
```

同理，Golang 解法如下：

```Golang

func findNthDigit(n int) int {
    
    length,count:=9,1
    start:= 1
    
    for n-length*count>0 {
        n -= length*count
        count += 1
        length *= 10
        start *= 10
    }
    
    added := (n-1)/count
    start += added
    n -= added*count

    res,_ := strconv.Atoi(strconv.Itoa(start)[n-1:n])
    return res
}


```