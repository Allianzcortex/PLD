Problem Description : 

```
Given two arrays A and B of equal size, the advantage of A with respect to B is the number of indices i for which A[i] > B[i].

Return any permutation of A that maximizes its advantage with respect to B.

 

Example 1:

Input: A = [2,7,11,15], B = [1,10,4,11]
Output: [2,11,7,15]
Example 2:

Input: A = [12,24,8,32], B = [13,25,32,11]
Output: [24,32,8,12]
 

Note:

1 <= A.length = B.length <= 10000
0 <= A[i] <= 10^9
0 <= B[i] <= 10^9

```

LOL classic Tianji horse race story ( :

Python solution : 

"""
a. sort both
b. compare smallest one in a with smallest one in b
c. if a>b,means we win the match with the smallest cost
   else: because b can only be larger,so there is no chance
   a will win over b,and we want to get the hugest profit,i.e.
   use a to replace the biggest one in b
"""

```Python

class Solution:
    def advantageCount(self, A: List[int], B: List[int]) -> List[int]:
        res = [None] * len(A)
        
        queue = collections.deque(sorted([b,i] for i,b in enumerate(B)))
        
        for a in sorted(A):
            if a>queue[0][0]:
                res[queue.popleft()[1]] = a
            else:
                res[queue.pop()[1]] = a
            
        
        return res

```

And will need to update java solution later :

https://leetcode.com/problems/advantage-shuffle/discuss/149822/JAVA-Greedy-6-lines-with-Explanation

Will need to implement it later