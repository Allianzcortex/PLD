
Problem description:

```
Given two integers left and right, return the count of numbers in the inclusive range [left, right] having a prime number of set bits in their binary representation.

Recall that the number of set bits an integer has is the number of 1's present when written in binary.

For example, 21 written in binary is 10101, which has 3 set bits.
 

Example 1:

Input: left = 6, right = 10
Output: 4
Explanation:
6  -> 110 (2 set bits, 2 is prime)
7  -> 111 (3 set bits, 3 is prime)
8  -> 1000 (1 set bit, 1 is not prime)
9  -> 1001 (2 set bits, 2 is prime)
10 -> 1010 (2 set bits, 2 is prime)
4 numbers have a prime number of set bits.
Example 2:

Input: left = 10, right = 15
Output: 5
Explanation:
10 -> 1010 (2 set bits, 2 is prime)
11 -> 1011 (3 set bits, 3 is prime)
12 -> 1100 (2 set bits, 2 is prime)
13 -> 1101 (3 set bits, 3 is prime)
14 -> 1110 (3 set bits, 3 is prime)
15 -> 1111 (4 set bits, 4 is not prime)
5 numbers have a prime number of set bits.
 

Constraints:

1 <= left <= right <= 106
0 <= right - left <= 104

```

---

Basic idea:

把所有的 bit manipulation 题目都当作 string 题目来做 (:-

Python 解法如下：

```Python

class Solution:
    def countPrimeSetBits(self, left: int, right: int) -> int:
        
        def isPrime(num):
            
            if num==1:
                return False
            for i in range(2,min(int(sqrt(num))+1,num)):
                if num%i==0:
                    return False
            
            return True
        
        bits = [str(bin(num))[2:] for num in range(left,right+1)]
       
        return len([bit for bit in bits if isPrime(bit.count('1')) ])

```

当然也有另外一种方法是一位内 `In the constraints it says that L and R are at most 1,000,000, so the numbers can be at most 20 bits.`，所以可以直接比较：

```Python

class Solution:
    def countPrimeSetBits(self, L, R):

        primes = {2, 3, 5, 7, 11, 13, 17, 19}
        return sum(map(lambda x: bin(x).count('1') in primes, range(L, R+1)))

```