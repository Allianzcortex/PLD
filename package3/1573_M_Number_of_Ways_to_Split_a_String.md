
Problem description:

```

Given a binary string s (a string consisting only of '0's and '1's), we can split s into 3 non-empty strings s1, s2, s3 (s1+ s2+ s3 = s).

Return the number of ways s can be split such that the number of characters '1' is the same in s1, s2, and s3.

Since the answer may be too large, return it modulo 10^9 + 7.

 

Example 1:

Input: s = "10101"
Output: 4
Explanation: There are four ways to split s in 3 parts where each part contain the same number of letters '1'.
"1|010|1"
"1|01|01"
"10|10|1"
"10|1|01"
Example 2:

Input: s = "1001"
Output: 0
Example 3:

Input: s = "0000"
Output: 3
Explanation: There are three ways to split s in 3 parts.
"0|0|00"
"0|00|0"
"00|0|0"
Example 4:

Input: s = "100100010100110"
Output: 12

```

Basic idea:

这道题问的是 number of ways of split，而不是要求所有组合的方式
所以这道题的逻辑方式是：

1. 求出每个 block 需要的 count (`s.count('1')//3`)

2. 假设从 0 到 index1 中 `1` 的数量等于 count，之后到 index2 再遇到一个 `1`，那么
(index2-index1) 就等于第一个 block 的所有可能分裂方式

3. 第二个 block 也同理可知

4. 要注意 1 的数量为 0 这种情况，这时候 3 个 block 任意平均分都可以

Python 解法如下：

```Python

class Solution:
    def numWays(self, s: str) -> int:
        
        countOne = s.count('1')
        n = len(s)
        
        if countOne==0:
            return int((n-2)*(n-1)//2 %(1e9+7))
        
        if countOne%3!=0:
            return 0
        
        eachOneInBlock = countOne // 3
        count = splitFirstBlockCount = splitSecondBlockCount = 0
        
        for ch in s:
            if ch == '1':
                count += 1
            if count == eachOneInBlock:
                splitFirstBlockCount += 1
            if count == eachOneInBlock*2:
                splitSecondBlockCount += 1
        
        return int(splitFirstBlockCount*splitSecondBlockCount%(1e9+7))

```