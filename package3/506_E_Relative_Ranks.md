
Problem description:

```
You are given an integer array score of size n, where score[i] is the score of the ith athlete in a competition. All the scores are guaranteed to be unique.

The athletes are placed based on their scores, where the 1st place athlete has the highest score, the 2nd place athlete has the 2nd highest score, and so on. The placement of each athlete determines their rank:

The 1st place athlete's rank is "Gold Medal".
The 2nd place athlete's rank is "Silver Medal".
The 3rd place athlete's rank is "Bronze Medal".
For the 4th place to the nth place athlete, their rank is their placement number (i.e., the xth place athlete's rank is "x").
Return an array answer of size n where answer[i] is the rank of the ith athlete.

 

Example 1:

Input: score = [5,4,3,2,1]
Output: ["Gold Medal","Silver Medal","Bronze Medal","4","5"]
Explanation: The placements are [1st, 2nd, 3rd, 4th, 5th].
Example 2:

Input: score = [10,3,8,9,4]
Output: ["Gold Medal","5","Bronze Medal","Silver Medal","4"]
Explanation: The placements are [1st, 5th, 3rd, 2nd, 4th].

 

Constraints:

n == score.length
1 <= n <= 104
0 <= score[i] <= 106
All the values in score are unique.

```
---

Basic idea:

这道题一开始以为只是求前三名，那么用 O(N) 时间复杂度和 O(1) 空间复杂度有一个很好的方法：

```Python

#         val1=val2=val3=float('-inf')
        
#         for s in score:
#             if s>val1:
#                 s,val1 = val1,s
            
#             if s>val2:
#                 s,val2 = val2,s
            
#             if s>val3:
#                 s,val3 = val3,s
        # for s in score:
        #     if s==val1:
        #         res.append("Gold Medal")
        #     elif s==val2:
        #         res.append("Silver Medal")
        #     elif s==val3:
        #         res.append("Bronze Medal")
        #     else:
        #         res.append(s)

```

但题目还要求前三名以后的具体名次，那么就需要求出每个 val 对应的 rank，就需要先排序
对此的 AC 方法如下：

```Python

class Solution:
    def findRelativeRanks(self, score: List[int]) -> List[str]:

        target = sorted(score,reverse=True)
        maps2={val:rank for rank,val in enumerate(target)}
        res = []
        for i,s in enumerate(score):
            rank = maps2[s]
            if rank==0:
                res.append("Gold Medal")
            elif rank==1:
                res.append("Silver Medal")
            elif rank==2:
                res.append("Bronze Medal")
            else:
                res.append(str(rank+1))
        
        return res

```