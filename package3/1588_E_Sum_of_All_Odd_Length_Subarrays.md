
Problem description:

```
Given an array of positive integers arr, return the sum of all possible odd-length subarrays of arr.

A subarray is a contiguous subsequence of the array.

 

Example 1:

Input: arr = [1,4,2,5,3]
Output: 58
Explanation: The odd-length subarrays of arr and their sums are:
[1] = 1
[4] = 4
[2] = 2
[5] = 5
[3] = 3
[1,4,2] = 7
[4,2,5] = 11
[2,5,3] = 10
[1,4,2,5,3] = 15
If we add all these together we get 1 + 4 + 2 + 5 + 3 + 7 + 11 + 10 + 15 = 58
Example 2:

Input: arr = [1,2]
Output: 3
Explanation: There are only 2 subarrays of odd length, [1] and [2]. Their sum is 3.
Example 3:

Input: arr = [10,11,12]
Output: 66
 

Constraints:

1 <= arr.length <= 100
1 <= arr[i] <= 1000

```

基本解法：

这道题看评论里是涉及到了很多技巧性的东西，但如果允许暴力解法的话那么其实不难

所以首先看 Python 的穷举解法：

```Python

class Solution:
    def sumOddLengthSubarrays(self, arr: List[int]) -> int:
        
        res = 0
        length = len(arr)
        
        for i in range(length):
            prev = arr[i]
            last_index = i
            while last_index<length:
                res+=prev
                if last_index+2<length:
                    prev+=(arr[last_index+1]+arr[last_index+2])
                    last_index+=2
                else:
                    break
        
        return res

```

其次看 Golang 的解法,Golang 的解法就是卡边界，设置 i 是左边界，j 是右边界(j 每次 +=2 来确保是奇数长度)，
k 是在 i 和 j 中间的变量，这样每次循环都重复把中间的数字加上。

```Golang

func sumOddLengthSubarrays(arr []int) int {
    
    res:=0
    length:=len(arr)
    
    for i:=0;i<length;i++ {
        for j:=i;j<length;j+=2 {
            for k:=i;k<=j;k++ {
                res += arr[k]
            }
        }
    }
    
    return res
}

```
