
Problem description:

```

Given an integer n, return the number of trailing zeroes in n!.

Note that n! = n * (n - 1) * (n - 2) * ... * 3 * 2 * 1.

 

Example 1:

Input: n = 3
Output: 0
Explanation: 3! = 6, no trailing zero.
Example 2:

Input: n = 5
Output: 1
Explanation: 5! = 120, one trailing zero.
Example 3:

Input: n = 0
Output: 0
 

Constraints:

0 <= n <= 104
 

Follow up: Could you write a solution that works in logarithmic time complexity?

```

Basic idea: 思路很明确

The matter is to count the number of 5.
2 will always be ample.

但中间在计算 1...n 中有多少个 `5` 时需要用到一些 trick.

```Java
class Solution {
    public int trailingZeroes(int n) {
        int res = 0;
        while(n>0) {
            res+=n/5;
            n/=5;
        }
        return res;
        
    }
}

```