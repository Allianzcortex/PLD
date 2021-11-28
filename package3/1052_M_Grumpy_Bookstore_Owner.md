
Problem description:

```
There is a bookstore owner that has a store open for n minutes. Every minute, some number of customers enter the store. You are given an integer array customers of length n where customers[i] is the number of the customer that enters the store at the start of the ith minute and all those customers leave after the end of that minute.

On some minutes, the bookstore owner is grumpy. You are given a binary array grumpy where grumpy[i] is 1 if the bookstore owner is grumpy during the ith minute, and is 0 otherwise.

When the bookstore owner is grumpy, the customers of that minute are not satisfied, otherwise, they are satisfied.

The bookstore owner knows a secret technique to keep themselves not grumpy for minutes consecutive minutes, but can only use it once.

Return the maximum number of customers that can be satisfied throughout the day.

 

Example 1:

Input: customers = [1,0,1,2,1,1,7,5], grumpy = [0,1,0,1,0,1,0,1], minutes = 3
Output: 16
Explanation: The bookstore owner keeps themselves not grumpy for the last 3 minutes. 
The maximum number of customers that can be satisfied = 1 + 1 + 1 + 1 + 7 + 5 = 16.
Example 2:

Input: customers = [1], grumpy = [0], minutes = 1
Output: 1
 

Constraints:

n == customers.length == grumpy.length
1 <= minutes <= n <= 2 * 104
0 <= customers[i] <= 1000
grumpy[i] is either 0 or 1.

```

Basic idea:

这道题题目很长，关键在于转换思路：
题意用另一种方法来描述，就是：

求一个 sliding window，这个 sliding window 里不满足的人最多。
然后我们将这个区间里的人都满足了，那么总的满意人数也就最多

Python Sliding Window 实现如下：

```Python

class Solution:
    def maxSatisfied(self, customers: List[int], grumpy: List[int], minutes: int) -> int:
        """
        关键是转换思路，变成要求：
        一个滑动窗口内无效值最大和的方法
        """
        
        max_right = 0 # append left ,right index
        left,right = 0,0
        sum_ = 0
        max_res = float('-inf')
        
        while right<len(customers):
            
            while(right-left>minutes-1):
                if(grumpy[left]==1):
                    sum_ -= customers[left]
                left += 1
            
            sum_ += (0 if grumpy[right]==0 else customers[right])
            
            if(sum_>max_res):
                max_res = sum_
                max_right = right
            
            right += 1
            
        
        max_left = max(0,max_right-minutes+1)
        
        res = 0
        # print(f"{max_left} : {max_right}")
        for i in range(len(customers)):
            if max_left<=i<=max_right:
                res += customers[i]
            else:
                res += 0 if grumpy[i]==1 else customers[i]
        
        return res

```

TODO : 复习 && 增加更多其他方法实现