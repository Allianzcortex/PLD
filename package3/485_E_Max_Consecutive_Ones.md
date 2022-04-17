
Problem description:

```

Given a binary array nums, return the maximum number of consecutive 1's in the array.

 

Example 1:

Input: nums = [1,1,0,1,1,1]
Output: 3
Explanation: The first two digits or the last three digits are consecutive 1s. The maximum number of consecutive 1s is 3.
Example 2:

Input: nums = [1,0,1,1,0,1]
Output: 2

```

Basic idea :

这就是一道典型的 easy 题，遍历找到 0 的时候重新置数，记住循环结束到最后的时候还要再
比较一次大小

Python 解法如下：

```Python

class Solution:
    def findMaxConsecutiveOnes(self, nums: List[int]) -> int:
        res,cur = 0,0
        
        for num in nums:
            if num==1:
                cur += 1
            else:
                res = max(res,cur)
                cur = 0
        
        return max(res,cur)

```

---

Golang 解法如下：

```Golang

func findMaxConsecutiveOnes(nums []int) int {
    
    res,count := 0,0
    
    for _,num := range nums {
        
        if(num==1) {
            count += 1
        } else {
            res = max(res,count)
            count = 0
        }
    }
    
    return max(res,count)
}

func max(a,b int) int {
    if (a<b) {
        return b
    }
    
    return a
}

```