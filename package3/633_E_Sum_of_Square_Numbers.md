
Problem description:

```
Given a non-negative integer c, decide whether there're two integers a and b such that a2 + b2 = c.

 

Example 1:

Input: c = 5
Output: true
Explanation: 1 * 1 + 2 * 2 = 5
Example 2:

Input: c = 3
Output: false
Example 3:

Input: c = 4
Output: true
Example 4:

Input: c = 2
Output: true
Example 5:

Input: c = 1
Output: true

```

Idea: 这道题是很经典的 two-pointer 问题

左端肯定是 0，右端是 sqrt(x)，然后逼近

Python 解法如下：

```Python

class Solution:
    def judgeSquareSum(self, c: int) -> bool:
        
        left,right = 0,int(math.sqrt(c))
        
        while left<=right:
            sum_ = left**2 + right**2
            
            if sum_==c:
                return True
            elif sum_<c:
                left += 1
            else:
                right -= 1
        
        return False

```

Golang 解法如下：

注意 Go 的 sqrt() 只支持 float64，所以要先把 int 变成 float64
再转化为 int.

```Golang

func judgeSquareSum(c int) bool {
    
    left,right := 0,int(math.Sqrt(float64(c)))
    
    for left<=right {
        sum:=left*left + right*right
        
        if sum==c {
            return true
        } else if sum<c {
            left += 1
        } else {
            right -= 1
        }
    }
    
    return false
}

```

Java 的解法如下：


``` Java
class Solution {
    public boolean judgeSquareSum(int c) {
        int left=0,right=(int)Math.sqrt(c);
        // need to clarify whether a and b can be duplicated
        while(left<=right) {
            int powSum = left*left + right*right;
            if(powSum==c){
                return true;
            } else if(powSum>c){
                right-=1;
            } else {
                left+=1;
            }
        }
        
        return false;
    }
}

```