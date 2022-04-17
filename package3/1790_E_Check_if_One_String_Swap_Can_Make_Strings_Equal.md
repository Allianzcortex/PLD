
Problem description:

```

You are given two strings s1 and s2 of equal length. A string swap is an operation where you choose two indices in a string (not necessarily different) and swap the characters at these indices.

Return true if it is possible to make both strings equal by performing at most one string swap on exactly one of the strings. Otherwise, return false.

 

Example 1:

Input: s1 = "bank", s2 = "kanb"
Output: true
Explanation: For example, swap the first character with the last character of s2 to make "bank".
Example 2:

Input: s1 = "attack", s2 = "defend"
Output: false
Explanation: It is impossible to make them equal with one string swap.
Example 3:

Input: s1 = "kelb", s2 = "kelb"
Output: true
Explanation: The two strings are already equal, so no string swap operation is required.
Example 4:

Input: s1 = "abcd", s2 = "dcba"
Output: false

```

这道题是 Easy 难度的题，但做起来却不顺利。

- 首先是题意。说的是交换同一个字符里的两个 index

先看下自己最直接印象做出的 AC 解答：

```Python

class Solution:
    def areAlmostEqual(self, s1: str, s2: str) -> bool:
        
        if not s1 or not s2 or len(s1)!=len(s2):
            return False
        
        index = 0
        swap_index1 = -1
        swap_flag = True
        
        for index in range(len(s1)):
            if s1[index]!=s2[index]:
                if swap_index1==-1:
                    swap_index1 = index
                    swap_flag = False
                else:
                    # case 1
                    new_s1 = list(s1)
                    new_s1[swap_index1],new_s1[index] = new_s1[index],new_s1[swap_index1]
                    if ''.join(new_s1)==s2:
                        swap_flag = True
                        continue
                    
                    # case 2
                    new_s2 = list(s2)
                    new_s2[swap_index1],new_s2[index] = new_s2[index],new_s2[swap_index1]
                    if ''.join(new_s2)==s1:
                        swap_flag = True
                        continue
                                        
                    return False

        return swap_flag

```

这个解法真的是太 tricky 了，因为每一次都实质性改变了 string，实际根本没必要，只需要
比较交换的两个 character 是否在另一个 string 中存在就行了，代码如下：

```Python

class Solution:
    def areAlmostEqual(self, s1: str, s2: str) -> bool:
        
        if not s1 or not s2 or len(s1)!=len(s2):
            return False
        
        swapIndexes = []
        for i in range(len(s1)):
            if s1[i]!=s2[i]:
                swapIndexes.append(i)
        
        if len(swapIndexes)==0:
            return True
        
        if len(swapIndexes)==2:
            i,j = swapIndexes
            if s1[i]==s2[j] and s1[j]==s2[i]:
                return True
        
        return False

```