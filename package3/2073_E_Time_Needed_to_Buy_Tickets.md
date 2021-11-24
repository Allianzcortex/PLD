
Problem description:

```

There are n people in a line queuing to buy tickets, where the 0th person is at the front of the line and the (n - 1)th person is at the back of the line.

You are given a 0-indexed integer array tickets of length n where the number of tickets that the ith person would like to buy is tickets[i].

Each person takes exactly 1 second to buy a ticket. A person can only buy 1 ticket at a time and has to go back to the end of the line (which happens instantaneously) in order to buy more tickets. If a person does not have any tickets left to buy, the person will leave the line.

Return the time taken for the person at position k (0-indexed) to finish buying tickets.

 

Example 1:

Input: tickets = [2,3,2], k = 2
Output: 6
Explanation: 
- In the first pass, everyone in the line buys a ticket and the line becomes [1, 2, 1].
- In the second pass, everyone in the line buys a ticket and the line becomes [0, 1, 0].
The person at position 2 has successfully bought 2 tickets and it took 3 + 3 = 6 seconds.
Example 2:

Input: tickets = [5,1,1,1], k = 0
Output: 8
Explanation:
- In the first pass, everyone in the line buys a ticket and the line becomes [4, 0, 0, 0].
- In the next 4 passes, only the person in position 0 is buying tickets.
The person at position 0 has successfully bought 5 tickets and it took 4 + 1 + 1 + 1 + 1 = 8 seconds.
 

Constraints:

n == tickets.length
1 <= n <= 100
1 <= tickets[i] <= 100
0 <= k < n

```

Basic idea:

首先是一个最经典的暴力解法，依次循环，遇到 `0` 就跳过，因为
只要买票才花时间，队列里移动不花时间

Python 解法如下：

```Python

class Solution:
    def timeRequiredToBuy(self, tickets: List[int], k: int) -> int:
        """
        1 2 1   (3
        0 1 0   (3   
        """
        
        steps = 0
        
        while True:
            for i in range(len(tickets)):
                if(tickets[i]==0):
                    continue
                tickets[i]-=1
                steps += 1
                if(i==k and tickets[i]==0):
                    return steps

```

但是找出规律的话很容易做，比如：

对 `i<=k`，所用的时间是 `min(A[i],A[k])`
对 `i>k`， 所用的时间是 `min(A[i-1,A[k]])`，如 `[5,7]`
第一个数 5 会消耗 5 秒，第二个数 7 会消耗 4 秒

所以优化版本的 O(N) 解法如下：

```Python

class Solution:
    def timeRequiredToBuy(self, tickets: List[int], k: int) -> int:
        
        steps = 0
        
        for i in range(len(tickets)):
            if(i<=k):
                steps += min(tickets[i],tickets[k])
            else:
                steps += min(tickets[i],tickets[k]-1)
        
        return steps

```