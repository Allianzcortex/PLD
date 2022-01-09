
Problem description:

```
Given a singly linked list, return a random node's value from the linked list. Each node must have the same probability of being chosen.

Implement the Solution class:

Solution(ListNode head) Initializes the object with the integer array nums.
int getRandom() Chooses a node randomly from the list and returns its value. All the nodes of the list should be equally likely to be choosen.
 

Example 1:


Input
["Solution", "getRandom", "getRandom", "getRandom", "getRandom", "getRandom"]
[[[1, 2, 3]], [], [], [], [], []]
Output
[null, 1, 3, 2, 2, 3]

Explanation
Solution solution = new Solution([1, 2, 3]);
solution.getRandom(); // return 1
solution.getRandom(); // return 3
solution.getRandom(); // return 2
solution.getRandom(); // return 2
solution.getRandom(); // return 3
// getRandom() should return either 1, 2, or 3 randomly. Each element should have equal probability of returning.
 

Constraints:

The number of nodes in the linked list will be in the range [1, 104].
-104 <= Node.val <= 104
At most 104 calls will be made to getRandom.
 

Follow up:

What if the linked list is extremely large and its length is unknown to you?
Could you solve this efficiently without using extra space?

```

Basic idea:

这道题自己的解法如下，是获得了所有长度以后再生成一个随机数来取值，
根据解法可以看到是有随机取样的数学方法来确保得到一个随机值

Python 解法如下：

```Python

from random import randint

class Solution:

    def __init__(self, head: Optional[ListNode]):
        
        index = head
        self.length = 0
        
        while index:
            index = index.next
            self.length += 1
        
        self.head = head

    def getRandom(self) -> int:
        
        steps = randint(0,self.length-1)
        # print(f"{self.length-1} : {steps}")
        index = self.head
        while steps>0:
            steps-=1
            index = index.next
        
        return index.val

```