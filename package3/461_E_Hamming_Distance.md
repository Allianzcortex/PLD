
Problem description:

```

The Hamming distance between two integers is the number of positions at which the corresponding bits are different.

Given two integers x and y, return the Hamming distance between them.

 

Example 1:

Input: x = 1, y = 4
Output: 2
Explanation:
1   (0 0 0 1)
4   (0 1 0 0)
       ↑   ↑
The above arrows point to positions where the corresponding bits are different.
Example 2:

Input: x = 3, y = 1
Output: 1
 

Constraints:

0 <= x, y <= 231 - 1

```

---

Basic idea:

这道题是位操作，找出很久以前(4 年前) 自己的解法来着：

```Java

public class Solution {
    public int hammingDistance(int x, int y) {
        int res=0,xor=x^y;
        while(xor!=0){
            res+=(xor & 1);
            xor=xor>>1;
        }
        return res;
    }
}

```