
Problem description:

```

Given two integers a and b, return the sum of the two integers without using the operators + and -.

 

Example 1:

Input: a = 1, b = 2
Output: 3
Example 2:

Input: a = 2, b = 3
Output: 5
 

Constraints:

-1000 <= a, b <= 1000

```

Basic idea:

不用 operator 来实现加法，就只能用位运算来做：

Java 解法如下

```Java

public class Solution {
    public int getSum(int a, int b) {
        // 1+2=3
        // 01 + 10 = 11
        return b==0?a:getSum(a^b,(a&b)<<1);
    }
}

```