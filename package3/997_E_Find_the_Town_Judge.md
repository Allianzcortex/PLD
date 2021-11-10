
Problem description:

```

In a town, there are n people labeled from 1 to n. There is a rumor that one of these people is secretly the town judge.

If the town judge exists, then:

The town judge trusts nobody.
Everybody (except for the town judge) trusts the town judge.
There is exactly one person that satisfies properties 1 and 2.
You are given an array trust where trust[i] = [ai, bi] representing that the person labeled ai trusts the person labeled bi.

Return the label of the town judge if the town judge exists and can be identified, or return -1 otherwise.

 

Example 1:

Input: n = 2, trust = [[1,2]]
Output: 2
Example 2:

Input: n = 3, trust = [[1,3],[2,3]]
Output: 3
Example 3:

Input: n = 3, trust = [[1,3],[2,3],[3,1]]
Output: -1
Example 4:

Input: n = 3, trust = [[1,2],[2,3]]
Output: -1
Example 5:

Input: n = 4, trust = [[1,3],[1,4],[2,3],[2,4],[4,3]]
Output: 3
 

Constraints:

1 <= n <= 1000
0 <= trust.length <= 104
trust[i].length == 2
All the pairs of trust are unique.
ai != bi
1 <= ai, bi <= n

```

Basic idea:

这是自己刚开始做的时候 Java 解法：

Easy 题，也没必要计较太多

```Java

class Solution {
    public int findJudge(int N, int[][] trust) {
        
        if(trust==null)
            return -1;
        
        int[] indegree=new int[N];
        int[] outdegree=new int[N];
        
        for(int[] pairs:trust) {
            indegree[pairs[0]-1]+=1;
            outdegree[pairs[1]-1]+=1;
        }
        
        for(int i=0;i<N;i++) {
            if(indegree[i]==0 && outdegree[i]==N-1)
                return i+1;
        }
        
        return -1;
    }
}

```