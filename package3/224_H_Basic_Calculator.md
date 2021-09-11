
Problem description:

```
Given a string s representing a valid expression, implement a basic calculator to evaluate it, and return the result of the evaluation.

Note: You are not allowed to use any built-in function which evaluates strings as mathematical expressions, such as eval().

 

Example 1:

Input: s = "1 + 1"
Output: 2
Example 2:

Input: s = " 2-1 + 2 "
Output: 3
Example 3:

Input: s = "(1+(4+5+2)-3)+(6+8)"
Output: 23

```

---

Basic idea :

这道题就是很经典的用 Stack 来解决问题，具体来说就是对每一个数字，用 curr 表示它的值。
同时用 res 来表示下面的值：

1. 对每一个 () 内的值
2. 比如 a+b，当计算到 b 的时候，res 就表示 a 的值

sign 表示的是前一个元素是 +1 还是 -1，这和 `Basic Calculator II` 这道题一样。所以就可以整理出下面的思路

a. 如果遇到的是数字，更新 curr 就行

b. 如果遇到的是 +/-，说明 curr 的值要被加到 res 里，`res += curr*sign`，然后把 curr 清零(`curr=0`)，而这时的 `+`/`-` 要作为下一个数字的 sign 来重新计算：
`sign = 1 if ch=='+' else -1`

c. 如果遇到的是 `(`，说明要开始一个新的部分，这时候理论上应该再次把 res 再更新：`res+=sin*curr` 但需要考虑的是，`(` 或者是在字符串的开始，或者前面会跟一个
`+/-`，也就是说 res 的值早都被更新过了。这里只需要把 res 和 sign 都压入到堆栈
里面，`stack.append(res)` & `stack.append(sign)`(这里的 res 是上一段计算的值，这里的 sign 是接下来 `()` 对应的符号)，然后再把 res,sign,curr 都初始化：`res,sign = 0,1` & `curr = 0`，因为我们要重新开始一个计算了

d. 如果遇到的是 `)`，就说明一段计算已经结束，要把遇到的 `()` 里的数加进去。
第一步是更新 res `res+=sign*curr`，然后把这时候计算的 `res` 和在 `c` 阶段
保持的符号结合起来，`res*=stack.pop()`，再把 `()`里计算的内容和前一步计算结果加起来
`res+=stack.pop()`,再初始化准备下一步的计算 `curr,sign=0,1`

---

Python 解法如下：

```Python

class Solution:
    def calculate(self, s: str) -> int:
        """
        Input: s = "(1+(4+5+2)-3)+(6+8)"
        Output: 23
        """
        
        stack,sign = [],1
        res,curr = 0,0
        
        for ch in s:
            # case 1 : for digit , we add it to current value
            if ch.isdigit():
                curr = curr*10+int(ch)
            
            # case 2 : for character, we add prev value to res , and reset
            # current value and sign
            elif ch in ("+","-"):
                res += curr*sign
                curr = 0
                sign = 1 if ch=='+' else -1
            
            # case 3 : for left brackets,we need to add prev value to stack
            elif ch == '(':
                # there is no need to recaluculate for 
                # the ch before `(` is usually +/-,it calculated in case 2
                # res += curr*sign
                
                stack.append(res)
                stack.append(sign)
                res,sign = 0,1
                curr = 0
            
            elif ch == ')':
                res += sign*curr
                res*=stack.pop()
                res += stack.pop()
                curr,sign = 0,1
        
        
        return res + sign*curr

```

TODO: 添加 Golang 解法

