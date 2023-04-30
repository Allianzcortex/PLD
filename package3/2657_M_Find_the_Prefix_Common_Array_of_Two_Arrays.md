
Problem Description:

```

You are given two 0-indexed integer permutations A and B of length n.

A prefix common array of A and B is an array C such that C[i] is equal to the count of numbers that are present at or before the index i in both A and B.

Return the prefix common array of A and B.

A sequence of n integers is called a permutation if it contains all integers from 1 to n exactly once.

 

Example 1:

Input: A = [1,3,2,4], B = [3,1,2,4]
Output: [0,2,3,4]
Explanation: At i = 0: no number is common, so C[0] = 0.
At i = 1: 1 and 3 are common in A and B, so C[1] = 2.
At i = 2: 1, 2, and 3 are common in A and B, so C[2] = 3.
At i = 3: 1, 2, 3, and 4 are common in A and B, so C[3] = 4.
Example 2:

Input: A = [2,3,1], B = [3,1,2]
Output: [0,1,3]
Explanation: At i = 0: no number is common, so C[0] = 0.
At i = 1: only 3 is common in A and B, so C[1] = 1.
At i = 2: 1, 2, and 3 are common in A and B, so C[2] = 3.
 

Constraints:

1 <= A.length == B.length == n <= 50
1 <= A[i], B[i] <= n
It is guaranteed that A and B are both a permutation of n integers.

```

Basic Idea:

这道题仍然是出现在 Weekly Contest 中，基本思路是找规律(or DP)，设最终结果
为 res[]，那么 res[i] = res[i-1] + x，其中 x 有 3 种情况:

1. 如果 A[i] 出现在 B[0:i-1] 中，那么 x+=1 
2. 如果 B[i] 出现在 A[0:i-1] 中，那么 x 也 += 1
3. 如果 A[i] 和 B[i] 都没有出现过，但 A[i]=B[i]，那么仍然要 +=1 (条件是 present at or before )

第 3 种情况第一次写的时候没有考虑到，写完 review 的时候加上了，果然还是正确率+讲解重要，而不是简单的
写完一个解法就跑，不对再加条件，面试时候绝对不会有平常练习这么多机会

提交后一次 AC

Python 解法如下：

```Python

class Solution:
    def findThePrefixCommonArray(self, A: List[int], B: List[int]) -> List[int]:
        
        pre_A,pre_B={},{}
        res = []
        
        for i in range(len(A)):
            pre_cnt = 0 if i==0 else res[i-1]
            if A[i] in pre_B:
                pre_cnt += 1
            if B[i] in pre_A:
                pre_cnt += 1
            if A[i] == B[i]:
                pre_cnt += 1
            
            pre_A[A[i]]=True
            pre_B[B[i]]=True
        
            res.append(pre_cnt)
        
        return res

```

题解里提到的另一种解法是用一个数组来同时存储遍历过的数组，这样时间复杂度仍然是 O(N)，但空间
复杂度大大降低。

TODO：后续添加这种解法