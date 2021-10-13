
Problem description:

```
A sentence is a string of single-space separated words where each word consists only of lowercase letters.

A word is uncommon if it appears exactly once in one of the sentences, and does not appear in the other sentence.

Given two sentences s1 and s2, return a list of all the uncommon words. You may return the answer in any order.

 

Example 1:

Input: s1 = "this apple is sweet", s2 = "this apple is sour"
Output: ["sweet","sour"]
Example 2:

Input: s1 = "apple apple", s2 = "banana"
Output: ["banana"]
 

Constraints:

1 <= s1.length, s2.length <= 200
s1 and s2 consist of lowercase English letters and spaces.
s1 and s2 do not have leading or trailing spaces.
All the words in s1 and s2 are separated by a single space.

```

Basic idea:

这道题其实有两个思维陷阱：

1. 只有 amount 足够找零是不够的。比如有 2 张 10 元，这时候再来一个 10 元
需要找零 5 元，这时候是找不出来的。

2. 来了一个 20 元，需要找 15 元，这时候有两种找零方法：a. 一张 10 元 + 一张 5 元
b. 三张 5 元。同时优先用方法 a，因为 5 元可以组成 10 元，但 10 元无法自己变成 2 张 5 元

Python 代码如下：

```Python

class Solution:
    def lemonadeChange(self, bills: List[int]) -> bool:
        
        amount5=amount10=amount20=0
        
        for bill in bills:
            if bill==5:
                amount5+=1
            elif bill==10:
                if amount5<1:
                    return False
                amount5-=1
                amount10+=1
            elif bill==20:
                if amount5>0 and amount10>0:
                    amount5-=1
                    amount10-=1
                    amount20+=1
                    continue
                elif amount5>=3:
                    amount5-=3
                    amount20+=1
                    continue
                return False
            
        return True

```