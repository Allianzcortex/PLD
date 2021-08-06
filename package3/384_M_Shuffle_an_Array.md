
Problem description:

```

Given an integer array nums, design an algorithm to randomly shuffle the array. All permutations of the array should be equally likely as a result of the shuffling.

Implement the Solution class:

Solution(int[] nums) Initializes the object with the integer array nums.
int[] reset() Resets the array to its original configuration and returns it.
int[] shuffle() Returns a random shuffling of the array.
 

Example 1:

Input
["Solution", "shuffle", "reset", "shuffle"]
[[[1, 2, 3]], [], [], []]
Output
[null, [3, 1, 2], [1, 2, 3], [1, 3, 2]]

Explanation
Solution solution = new Solution([1, 2, 3]);
solution.shuffle();    // Shuffle the array [1,2,3] and return its result.
                       // Any permutation of [1,2,3] must be equally likely to be returned.
                       // Example: return [3, 1, 2]
solution.reset();      // Resets the array back to its original configuration [1,2,3]. Return [1, 2, 3]
solution.shuffle();    // Returns the random shuffling of array [1,2,3]. Example: return [1, 3, 2]

```

Idea :

这道题要实现两个函数：reset() 和 shuffle()

1. 对 reset() 函数: 只要在一开始初始化的时候保留备份就可以了

2. 对 shuffle() 函数：关键是定义好随机打乱的算法。这里用一个最简单实用的方法：

对 第一个元素 ，从 `input[0:]` 里随机挑选一个
对 第二个元素，从 `input[1:]` 里随机挑选一个
对 第三个元素，从 `input[2:]` 里随机挑选一个

依此类推，直到把整个元组填满

Python 解法如下：

```Python

class Solution:

    def __init__(self, nums: List[int]):
        
        self.original_nums = nums
        self.nums = nums
        

    def reset(self) -> List[int]:
        """
        Resets the array to its original configuration and return it.
        """
        
        return self.original_nums
        

    def shuffle(self) -> List[int]:
        """
        Returns a random shuffling of the array.
        """
        
        from random import randint
        
        res = self.nums[:]
        
        for i in range(len(res)):
            index = randint(i,len(res)-1)
            res[i],res[index] = res[index],res[i]
        
        return res

```