
Problem description:

```

Evaluate the value of an arithmetic expression in Reverse Polish Notation.

Valid operators are +, -, *, and /. Each operand may be an integer or another expression.

Note that division between two integers should truncate toward zero.

It is guaranteed that the given RPN expression is always valid. That means the expression would always evaluate to a result, and there will not be any division by zero operation.

 

Example 1:

Input: tokens = ["2","1","+","3","*"]
Output: 9
Explanation: ((2 + 1) * 3) = 9
Example 2:

Input: tokens = ["4","13","5","/","+"]
Output: 6
Explanation: (4 + (13 / 5)) = 6
Example 3:

Input: tokens = ["10","6","9","3","+","-11","*","/","*","17","+","5","+"]
Output: 22
Explanation: ((10 * (6 / ((9 + 3) * -11))) + 17) + 5
= ((10 * (6 / (12 * -11))) + 17) + 5
= ((10 * (6 / -132)) + 17) + 5
= ((10 * 0) + 17) + 5
= (0 + 17) + 5
= 17 + 5
= 22

```

---

Idea : 经典的逆波兰序解法，每次遇到数字就压入，遇到操作符就从栈里压出两个操作符进行计算
再压入栈内

Python 解法：

一个有点坑的地方是 Python 的 `isdigit()` 不能识别负数

```Python

class Solution:
    def evalRPN(self, tokens: List[str]) -> int:
        s1 = []
        
        res = 0
        
        for ch in tokens:
            if ch not in '+-*/':
                s1.append(int(ch))
            else:
                val1,val2 = s1.pop(),s1.pop()
                if ch=='+':
                    s1.append(val1+val2)
                elif ch=='-':
                    s1.append(val2-val1)
                elif ch=='*':
                    s1.append(val1*val2)
                else:
                    s1.append(int(val2/val1))
        
        return s1.pop()

```

---

Golang 解法：

```Golang

func evalRPN(tokens []string) int {
    stack:=make([]int,0)
    
    var num1,num2 int
    
    for _,v := range tokens {
        if len(v)==1 && strings.ContainsAny(v,"+-*/") {
            num1 = stack[len(stack)-1]
            num2 = stack[len(stack)-2]
            stack = stack[:len(stack)-2]
            
            switch v {
            case "+":
                stack = append(stack,num1+num2)
            case "-":
                stack = append(stack,num2-num1)
            case "*":
                stack = append(stack,num1*num2)
            case "/":
                stack = append(stack,num2/num1)
            }
        } else {
            num,_ := strconv.Atoi(v)
            stack = append(stack,num)
        }
    }
    
    return stack[0]
}

```