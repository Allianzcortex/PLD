
Problem description:

```

You are playing the following Nim Game with your friend:

Initially, there is a heap of stones on the table.
You and your friend will alternate taking turns, and you go first.
On each turn, the person whose turn it is will remove 1 to 3 stones from the heap.
The one who removes the last stone is the winner.
Given n, the number of stones in the heap, return true if you can win the game assuming both you and your friend play optimally, otherwise return false.

Example 1:

Input: n = 4
Output: false
Explanation: These are the possible outcomes:
1. You remove 1 stone. Your friend removes 3 stones, including the last stone. Your friend wins.
2. You remove 2 stones. Your friend removes 2 stones, including the last stone. Your friend wins.
3. You remove 3 stones. Your friend removes the last stone. Your friend wins.
In all outcomes, your friend wins.
Example 2:

Input: n = 1
Output: true
Example 3:

Input: n = 2
Output: true

```

Basic idea:

这道题是一道典型的逻辑题目，属于数学归纳法的应用：

任何人有 1-3 的时候必赢
任何人有 4   的时候必输，因为对方可以让自己有 1-3
任何人有 5-7 的时候必赢，因为可以让对方有 4
任何人有 8   的时候必输，因为对方可以让自己有 5-7
依此类推

Python 解法如下：

```Python

class Solution:
    def canWinNim(self, n: int) -> bool:
        """
        1-3 : I win
        4: no matter how I do,I will fail
        5: I win, I can let stones be 4.
        6: I still win,I can let stones be 4.
        7: I still win,I can let stones be 4.
        8: no matter what I do, my friend will have 5-7,he wins
        9: I still win,I can let sones be 8
        
        """
        
        return n%4!=0

```