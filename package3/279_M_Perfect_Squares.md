

Solution :

1. DP :

```Java
class Solution {
    public int numSquares(int n) {
        int[] dp = new int[n+1];
        Arrays.fill(dp,Integer.MAX_VALUE);
        dp[0] = 0;
        for(int i=1;i<=n;i++) {
            for(int j=1;j*j<=i;j++) {
                dp[i] = Math.min(dp[i],dp[i-j*j]+1);
            }
        }
        return dp[n];
        
    }
}

```

2.  BFS :

This is another solution. And will check it later :

`Java BFS implementation: Start from node 0 in queue, and keep pushing in perfect square number + curr value, once we reach number n, we found the solution.`

```Java

public int numSquares(int n) {
    Queue<Integer> q = new LinkedList<>();
    Set<Integer> visited = new HashSet<>();
    q.offer(0);
    visited.add(0);
    int depth = 0;
    while(!q.isEmpty()) {
        int size = q.size();
        depth++;
        while(size-- > 0) {
            int u = q.poll();
            for(int i = 1; i*i <= n; i++) {
                int v = u+i*i;
                if(v == n) {
                    return depth;
                }
                if(v > n) {
                    break;
                }
                if(!visited.contains(v)) {
                    q.offer(v);
                    visited.add(v);
                }
            }
        }
    }
    return depth;
}

```

TODO : add Python Solution