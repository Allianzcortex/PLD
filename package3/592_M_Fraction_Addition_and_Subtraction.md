
Problem description:

```

Given a string expression representing an expression of fraction addition and subtraction, return the calculation result in string format.

The final result should be an irreducible fraction. If your final result is an integer, say 2, you need to change it to the format of a fraction that has a denominator 1. So in this case, 2 should be converted to 2/1.

 

Example 1:

Input: expression = "-1/2+1/2"
Output: "0/1"
Example 2:

Input: expression = "-1/2+1/2+1/3"
Output: "1/3"
Example 3:

Input: expression = "1/3-1/2"
Output: "-1/6"
Example 4:

Input: expression = "5/3+1/3"
Output: "2/1"
 

Constraints:

The input string only contains '0' to '9', '/', '+' and '-'. So does the output.
Each fraction (input and output) has the format ±numerator/denominator. If the first input fraction or the output is positive, then '+' will be omitted.
The input only contains valid irreducible fractions, where the numerator and denominator of each fraction will always be in the range [1, 10]. If the denominator is 1, it means this fraction is actually an integer in a fraction format defined above.
The number of given fractions will be in the range [1, 10].
The numerator and denominator of the final result are guaranteed to be valid and in the range of 32-bit int.

```

Basic idea:

这道题先说一个自己犯的很明显的错误吧：

要想办法把一个 string 里的 input 分隔成好几个分数，自己一开始想的是找到一个符号位(`+`/`-`) 后进行切片，写出的是类似下面的代码：

```Python
stack.append(flag+expression[i:i+3])
```
但遇上 `"-5/2+10/3+7/9"` 这样的切片就错了，因为 `10/3` 要占用 4 位

先上一下自己 AC 的代码：

```Python

class Solution:
    def fractionAddition(self, expression: str) -> str:
        """
        1/2 + 1/3 = 3/6 + 2/6 = 5/6
        
        """
        
        stack = []
        i = 0
        # step 1 : get all fraction
        while i<len(expression):
            flag="+"
            if expression[i]=='+':
                i+=1
            elif expression[i]=='-':
                flag="-"
                i+=1
            index = i+1
            while index<len(expression) and not (expression[index] in ('+','-')):
                index+=1
            stack.append(flag+expression[i:index])
            i=index
        
        while len(stack)!=1:
            first,second = stack.pop(),stack.pop()
            stack.append(self.add(first,second))
        
        res = stack.pop()
        return self.simplify(res)
    
    def simplify(self,string):
        
        def gcd(a,b):
            if b==0:
                return a
            
            return gcd(b,a%b)
        
        n,d = [int(item) for item in string.split("/")]
        divider = gcd(n,d)
        return f"{n//divider}/{d//divider}"
    
    def add(self,first,second):
        val1,val2 = first.split("/")
        val3,val4 = second.split("/")
        
        numerator1 = int(val1)*int(val4)
        numerator2 = int(val3)*int(val2)
        
        return f"{numerator1+numerator2}/{int(val2)*int(val4)}"

```

其他的解法也不错，但很多用到了 regex 或者 split 的 tricky 方法，还不如
上面的更直接：

numertor : 分子
denominator : 分母