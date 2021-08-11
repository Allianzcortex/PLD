
Problem description:

```

A binary string is monotone increasing if it consists of some number of 0's (possibly none), followed by some number of 1's (also possibly none).

You are given a binary string s. You can flip s[i] changing it from 0 to 1 or from 1 to 0.

Return the minimum number of flips to make s monotone increasing.

 

Example 1:

Input: s = "00110"
Output: 1
Explanation: We flip the last digit to get 00111.
Example 2:

Input: s = "010110"
Output: 2
Explanation: We flip to get 011111, or alternatively 000111.
Example 3:

Input: s = "00011000"
Output: 2
Explanation: We flip to get 00000000.

```

Idea : 这道题自己一开始的思路是正确的

从左往右，要让数组符合要求，那么就有两种方式：

- 或者把 0 变 1

- 或者把 1 变 0

所以我们只要记录两个变量：`cnt_0_to_1` 和 `cnt_1_to_0` :

情景如下：

- 当遇到一个为 `0` 的字符时，对从 1->0 的操作没有任何影响，而对从 0->1 的操作，要 + 1
同时我们要注意到要追求的是全局最优，也就是在这个 0->1 操作之前，可以是从 0->1，也可以是 
从 1->0 ，所以 `cnt_0_to_1 = min(cnt_1_to_0,cnt_0_to_1) + 1`

- 当遇到一个为 `1` 的字符时

对 `0->1` 操作来说，前面有可能是

对 `1->0` 操作，恩，还是有点乱

Python 解法如下：

```Python

class Solution:
    def minFlipsMonoIncr(self, s: str) -> int:
        """
        010110
        
        There can be 2 cases:
        
        1. flip left 1 to 0
        
        2. flip right 0 to 1
        """
        
        cnt_1_to_0 = 0
        
        cnt_0_to_1 = 0
        
        for index,val in enumerate(s):
            if val =='0':
                cnt_0_to_1 = min(cnt_1_to_0,cnt_0_to_1) + 1
            else:
                # comes with 1
                cnt_0_to_1 = min(cnt_1_to_0,cnt_0_to_1)
                cnt_1_to_0 += 1

                
        return min(cnt_1_to_0,cnt_0_to_1)

```