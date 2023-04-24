
Problem description:


```

Given an alphanumeric string s, return the second largest numerical digit that appears in s, or -1 if it does not exist.

An alphanumeric string is a string consisting of lowercase English letters and digits.

 

Example 1:

Input: s = "dfa12321afd"
Output: 2
Explanation: The digits that appear in s are [1, 2, 3]. The second largest digit is 2.
Example 2:

Input: s = "abc1111"
Output: -1
Explanation: The digits that appear in s are [1]. There is no second largest digit. 
 

Constraints:

1 <= s.length <= 500
s consists of only lowercase English letters and/or digits.

```

Basic Idea:

第一种解法就是直接用 Python 的 built-in 库

```Python

class Solution:
    def secondHighest(self, s: str) -> int:
        nums = list(set([int(ch) for ch in s if ch.isdigit()]))
        return -1 if len(nums)<2 else sorted(nums)[-2]

```

第二种解法就是很典型的第 K 大数字，是既然要找第二大的，那么就定义 2 个最大的数然后依次比较

Python 解法如下:

```Python

class Solution:
    def secondHighest(self, s: str) -> int:
        
        first_l,second_l = -1,-1

        for ch in s:
           
            if ch.isdigit():
                num = int(ch)
                if num>first_l:
                    second_l = first_l
                    first_l = num
                elif first_l>num>second_l:
                    second_l = num

        return second_l

```