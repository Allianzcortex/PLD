
Problem description:

```

Given an array of integers arr, return true if we can partition the array into three non-empty parts with equal sums.

Formally, we can partition the array if we can find indexes i + 1 < j with (arr[0] + arr[1] + ... + arr[i] == arr[i + 1] + arr[i + 2] + ... + arr[j - 1] == arr[j] + arr[j + 1] + ... + arr[arr.length - 1])

 

Example 1:

Input: arr = [0,2,1,-6,6,-7,9,1,2,0,1]
Output: true
Explanation: 0 + 2 + 1 = -6 + 6 - 7 + 9 + 1 = 2 + 0 + 1
Example 2:

Input: arr = [0,2,1,-6,6,7,9,-1,2,0,1]
Output: false
Example 3:

Input: arr = [3,3,6,5,-2,2,5,1,-9,4]
Output: true
Explanation: 3 + 3 = 6 = 5 - 2 + 2 + 5 + 1 - 9 + 4
 

Constraints:

3 <= arr.length <= 5 * 104
-104 <= arr[i] <= 104

```

Basic idea:

其实思路还挺简单的，就是 search & count

不过有意思的是对 `0,0,0,0`/3 这种输入，最后得到的结果是 4，所以判断返回
语句里用的是 `cnt>=3` 而不是 `cnt>3`

Python 解法如下：

```Python

class Solution:
    def canThreePartsEqualSum(self, arr: List[int]) -> bool:
        
        sum_ = sum(arr)
        
        if sum_%3!=0:
            return False
        
        target = sum_//3
        cnt = 0
        curr,j = 0,0
        
        while j<len(arr):
            curr += arr[j]
            if curr==target:
                cnt += 1
                curr = 0
            
            j+= 1
            
        return cnt>=3

```