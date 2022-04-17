
Problem description:

```
We have n chips, where the position of the ith chip is position[i].

We need to move all the chips to the same position. In one step, we can change the position of the ith chip from position[i] to:

position[i] + 2 or position[i] - 2 with cost = 0.
position[i] + 1 or position[i] - 1 with cost = 1.
Return the minimum cost needed to move all the chips to the same position.

 

Example 1:


Input: position = [1,2,3]
Output: 1
Explanation: First step: Move the chip at position 3 to position 1 with cost = 0.
Second step: Move the chip at position 2 to position 1 with cost = 1.
Total cost is 1.
Example 2:


Input: position = [2,2,2,3,3]
Output: 2
Explanation: We can move the two chips at position  3 to position 2. Each move has cost = 1. The total cost = 2.
Example 3:

Input: position = [1,1000000000]
Output: 1
 

Constraints:

1 <= position.length <= 100
1 <= position[i] <= 10^9

```

Basic idea:

这道题初看有点像用 DP 的思路，要列举所有可能的情况，但这道题是一个 easy 难度的题，
细想的话思路如下：

1. 从奇数位置移动到奇数位置，消耗为 0；从偶数位置移动到偶数位置，消耗为 0
2. 所以所有的奇数点都可以最终移动到同一个位置；所有的偶数点都可以最终移动到同一个位置
3. 然后就是比较是把所有奇数点移动到偶数点还是把所有偶数点移动到技术点

Python 解法如下：

```Python

class Solution:
    def minCostToMoveChips(self, position: List[int]) -> int:
        
        odd_cnt,even_cnt = 0,0
        
        for pos in position:
            if pos%2==0:
                even_cnt += 1
            else:
                odd_cnt += 1
        
        return min(even_cnt,odd_cnt)

```

Golang 解法如下：

```Golang

func minCostToMoveChips(position []int) int {
    
    oddCnt,evenCnt := 0,0
    
    for _,pos := range position {
        
        if pos%2==0 {
            evenCnt += 1
        } else {
            oddCnt += 1
        }
    }
    
    return min(oddCnt,evenCnt)
}


func min(a,b int) int {
    if(a<b) {
        return a
    }
    
    return b
}

```