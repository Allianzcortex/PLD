
Problem description:

```
The array-form of an integer num is an array representing its digits in left to right order.

For example, for num = 1321, the array form is [1,3,2,1].
Given num, the array-form of an integer, and an integer k, return the array-form of the integer num + k.

 

Example 1:

Input: num = [1,2,0,0], k = 34
Output: [1,2,3,4]
Explanation: 1200 + 34 = 1234
Example 2:

Input: num = [2,7,4], k = 181
Output: [4,5,5]
Explanation: 274 + 181 = 455
Example 3:

Input: num = [2,1,5], k = 806
Output: [1,0,2,1]
Explanation: 215 + 806 = 1021
Example 4:

Input: num = [9,9,9,9,9,9,9,9,9,9], k = 1
Output: [1,0,0,0,0,0,0,0,0,0,0]
Explanation: 9999999999 + 1 = 10000000000
 

Constraints:

1 <= num.length <= 104
0 <= num[i] <= 9
num does not contain any leading zeros except for the zero itself.
1 <= k <= 104

```

Basic idea:

这道题就是 `add two numbers` 的变种嘛。`sum_` 的来源有 3 个：

- val1 来自 `k` 所以条件 1 为 `k!=0`

- val2 来自 `num[index]` 所以条件 2 为 `index>=0`

- val3 来自 `carry` 所以条件 3 为 `carry!=0`

解法如下：

```Python

class Solution:
    def addToArrayForm(self, num: List[int], k: int) -> List[int]:

        res = []
        carry,index = 0,len(num)-1
        
        while k!=0 or index>=0 or carry>0:
            
            val1 = k%10
            k //= 10
            
            val2 = num[index] if index>=0 else 0

            index -= 1
            
            sum_ = val1+val2+carry
            res.append(sum_ %10)
            carry = sum_ // 10
        
        return res[::-1]

```