
Problem description:

```

Given an array of digit strings nums and a digit string target, return the number of pairs of indices (i, j) (where i != j) such that the concatenation of nums[i] + nums[j] equals target.

 

Example 1:

Input: nums = ["777","7","77","77"], target = "7777"
Output: 4
Explanation: Valid pairs are:
- (0, 1): "777" + "7"
- (1, 0): "7" + "777"
- (2, 3): "77" + "77"
- (3, 2): "77" + "77"
Example 2:

Input: nums = ["123","4","12","34"], target = "1234"
Output: 2
Explanation: Valid pairs are:
- (0, 1): "123" + "4"
- (2, 3): "12" + "34"
Example 3:

Input: nums = ["1","1","1"], target = "11"
Output: 6
Explanation: Valid pairs are:
- (0, 1): "1" + "1"
- (1, 0): "1" + "1"
- (0, 2): "1" + "1"
- (2, 0): "1" + "1"
- (1, 2): "1" + "1"
- (2, 1): "1" + "1"

```

这道题自己一开始是用遍历的方法来做的，虽然也 AC 但效率很低：

```Python

class Solution:
    def numOfPairs(self, nums: List[str], target: str) -> int:
        
        res = 0
        
        for i in range(len(nums)):
            for j in range(len(nums)):
                if i==j or len(nums[i])+len(nums[j])!=len(target):
                    continue
                
                if nums[i]+nums[j]==target:
                    res += 1
        
        return res
```

更好的方法是用 HashMap 来做到用空间换时间，代码如下：

要注意的是遇到 `["77","77"], target = "7777"]` 这种情况

如果 prefix 和 suffix 相同的话，会产生 n*n 种排列，但我们只需要
n*(n-1) 种排列，所以 n*n-n*(n-1)=n 要再减去 n

```Python

class Solution:
    def numOfPairs(self, nums: List[str], target: str) -> int:
        
        counter = Counter(nums)
        res = 0
        
        for prefix,freq in counter.items():
            
            if target.startswith(prefix):
                suffix = target[len(prefix):]
                
                if counter[suffix]!=0:
                    res += freq*counter[suffix]
                
                if prefix==suffix:
                    res -= freq
        
        return res

```