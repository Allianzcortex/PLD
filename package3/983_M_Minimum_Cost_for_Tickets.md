
Java Solution

```Java

class Solution {
    public int mincostTickets(int[] days, int[] costs) {
        // set to 366+30 for the extreme case is : 365 + 30. we need to judge from last day of year
        int[] dp = new int[366+30];
        boolean[] time = new boolean[366];
        for(int day:days)
            time[day] = true;
        int len = days.length;
        int maxDay = days[len-1],minDay = days[0];
        for(int d=maxDay;d>=minDay;d--) {
            if(time[d]) {
                dp[d]=Math.min(dp[d+1]+costs[0],dp[d+7]+costs[1]);
                dp[d]=Math.min(dp[d],dp[d+30]+costs[2]);
            } else
                dp[d]=dp[d+1];
        }
        
        return dp[minDay];
    }
}

```

---

TODO: Python Implementation