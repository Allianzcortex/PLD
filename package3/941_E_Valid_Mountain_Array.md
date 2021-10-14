
Problem description:

```
Given an array of integers arr, return true if and only if it is a valid mountain array.

Recall that arr is a mountain array if and only if:

arr.length >= 3
There exists some i with 0 < i < arr.length - 1 such that:
arr[0] < arr[1] < ... < arr[i - 1] < arr[i]
arr[i] > arr[i + 1] > ... > arr[arr.length - 1]

 

Example 1:

Input: arr = [2,1]
Output: false
Example 2:

Input: arr = [3,5,5]
Output: false
Example 3:

Input: arr = [0,3,2,1]
Output: true
 

Constraints:

1 <= arr.length <= 104
0 <= arr[i] <= 104

```

---

Basic idea:

这是自己的解法：就是用一个 flag 来判断是否下降，一旦下降就

```Python

class Solution:
    def validMountainArray(self, arr: List[int]) -> bool:
        
        if len(arr)<3:
            return False
        
        """
        # flag=0 means it's up , flag=1 means it' down
        We need to handle 2 edge case1:
        1. from 0th-1st , it must be up
        2. if there is a down inside the array,it should not down again
        3. it must be down at the end(ie flag must be 1)
        """
        flag = 0
        i = 1
        
        while i<len(arr):
            if i==1 and arr[i]<arr[i-1]:
                return False
            else:
                if arr[i]<arr[i-1]:
                    flag = 1
                if flag==1 and arr[i]>arr[i-1]:
                    return False
            
            if arr[i]==arr[i-1]:
                return False
            i+=1
        
        return flag==1

```

另外一种解法更优雅一点，计算 peak 和 valley 的个数，这样很好处理了
两个数相等的情况

```Python

class Solution:
    def validMountainArray(self, A: List[int]) -> bool:
        peak, valley = 0, 0
        for i in range(1, len(A) - 1):
            if A[i - 1] < A[i] > A[i + 1]:
                peak += 1
            if A[i - 1] >= A[i] <= A[i + 1]:
                valley += 1
        return peak == 1 and valley == 0

```