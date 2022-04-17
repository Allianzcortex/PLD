
Problem description:

```

Given an integer array arr, return the length of a maximum size turbulent subarray of arr.

A subarray is turbulent if the comparison sign flips between each adjacent pair of elements in the subarray.

More formally, a subarray [arr[i], arr[i + 1], ..., arr[j]] of arr is said to be turbulent if and only if:

For i <= k < j:
arr[k] > arr[k + 1] when k is odd, and
arr[k] < arr[k + 1] when k is even.
Or, for i <= k < j:
arr[k] > arr[k + 1] when k is even, and
arr[k] < arr[k + 1] when k is odd.
 

Example 1:

Input: arr = [9,4,2,10,7,8,8,1,9]
Output: 5
Explanation: arr[1] > arr[2] < arr[3] > arr[4] < arr[5]
Example 2:

Input: arr = [4,8,12,16]
Output: 2
Example 3:

Input: arr = [100]
Output: 1

```

Basic idea:

这道题一开始自己没有注意到 subArray 和 subSequence 的区别，
如果是 subSequence 的话会很麻烦，但是 subArray 就很简单

思路是用两个变量：upLength 和 downLength 来分别表示【从前一个
到这一个是增】和【从前一个到这一个是减】

对应的 Python 代码如下：

```Python

class Solution:
    def maxTurbulenceSize(self, arr: List[int]) -> int:
        
        if not arr:
            return 0
        
        upLength,downLength = 1,1
        res = 1
        
        for index,val in enumerate(arr):
            if index==0:
                continue
            
            if arr[index]>arr[index-1]:
                upLength = downLength + 1
                downLength = 1
            elif arr[index]<arr[index-1]:
                downLength = upLength + 1
                upLength = 1
            else:
                upLength = 1
                downLength = 1
            
            res = max([res,upLength,downLength])
        return res

```

---

对应的 Golang 代码如下：

```Golang

func maxTurbulenceSize(arr []int) int {
    
    if arr==nil || len(arr)==0 {
        return 0
    }
    
    up,down := 1,1
    res := 1
    
    for i:=1;i<len(arr);i++ {
        if arr[i]>arr[i-1] {
            up = down+1
            down = 1
        } else if arr[i]<arr[i-1] {
            down = up+1
            up = 1
        } else {
            up,down = 1,1
        }
        
        res = max(res,max(up,down))
    }
    
    return res
}


func max(a,b int) int {
    
    if(a>b) {
        return a
    }
    
    return b
}

```