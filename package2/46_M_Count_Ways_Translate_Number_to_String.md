
Problem description:

```
给定一个数字，我们按照如下规则把它翻译为字符串：0 翻译成 “a” ，1 翻译成 “b”，……，11 翻译成 “l”，……，25 翻译成 “z”。一个数字可能有多个翻译。请编程实现一个函数，用来计算一个数字有多少种不同的翻译方法。

 

示例 1:

输入: 12258
输出: 5
解释: 12258有5种不同的翻译，分别是"bccfi", "bwfi", "bczi", "mcfi"和"mzi"

```

basic idea :

这道题就是 decode ways 的变种，用 DP 解决

Python 解法如下：
注意的是第一位是 [1]，而非 [0]。
在这上面翻了跟头

```Python

class Solution:
    def translateNum(self, num: int) -> int:
        """
        It's like decode way
        0 -> "a"
        1 -> "b"
        ...
        25 -> "z"
        """
        num = str(num)
        dp = [1] + [0]*(len(num))
        
        for index,val in enumerate(num):
            if index==0:
                dp[index+1] = 1
                continue
            
            # for single digit
            dp[index+1] += dp[index]
            # for 2 digits
            if 10<=int(num[index-1:index+1])<=25:
                dp[index+1] += dp[index-1]

        return dp[-1]
```

Java 解法如下：

```Java

class Solution {
    public int translateNum(int num) {
        String number = String.valueOf(num);
        return solve(number,0);
    }

    public int solve(String number,int index) {
        if(index>=number.length())
            return 1;
        int res=1;
        res*=solve(number,index+1);
        if(index+1<number.length() && Integer.parseInt(number.substring(index,index+2))<=25 && Integer.parseInt(number.substring(index,index+2))>=10){
            int tempRes=1*solve(number,index+2);
            res+=tempRes;
        }
        return res;
    }
}

```