
Problem Description:

```
Given a string s which represents an expression, evaluate this expression and return its value. 

The integer division should truncate toward zero.

Note: You are not allowed to use any built-in function which evaluates strings as mathematical expressions, such as eval().

 

Example 1:

Input: s = "3+2*2"
Output: 7
Example 2:

Input: s = " 3/2 "
Output: 1
Example 3:

Input: s = " 3+5 / 2 "
Output: 5
 

Constraints:

1 <= s.length <= 3 * 105
s consists of integers and operators ('+', '-', '*', '/') separated by some number of spaces.
s represents a valid expression.
All the integers in the expression are non-negative integers in the range [0, 231 - 1].
The answer is guaranteed to fit in a 32-bit integer.

```

Since there are no brackets so only one stack is enough.

```Java

class Solution {
    public int calculate(String s) {
        Stack<Integer> stack=new Stack<Integer>();
        s=s.replaceAll(" ","");
        int res = 0;
        char[] arr=s.toCharArray();
        for(int i=0;i<arr.length;i++) {
        //    System.out.println(i +" index "+arr[i]);
           char op = i==0?'+':arr[i-1];
           while(i<arr.length && Character.isDigit(arr[i])) {
               res=res*10+arr[i]-'0';
               i++;
           }
           
           switch(op) {
               case '-':
                res = -res;
                break;
               case '*':
                res=stack.pop()*res;
                break;
               case '/':
                 res=stack.pop()/res;
                 break;
                default:
                  break;
           }
           stack.push(res);
           res = 0;
        }
        int sum=0;
        while(!stack.isEmpty())
            sum+=stack.pop();
        return sum;
    }
}

```

```
Idea : The key is : use `1*32` as an example:

a. We can get the first number is 1,

b. then we know the operation is '*',but here we don't know the next value
we need to update current operator to '*',and continue next iteration.

c. then we calculate until we meet another operator(+-*/) or reach the end of string,
now we know current value is 32 and we calculate value based on previously stored op:
we know it's '*', so it's time to multiple them and add the result inot new stack

```

Here is Python Solution

```Python

class Solution:
    def calculate(self, s: str) -> int:
        """
        3+2*2
        
        (2*32)+4
        
        num = 2
        char = '*' : get 2 values -> stack.pop()->2,num=32
        
        stack = []
        op = '+'
        tempRes = 0
        
        iteration 1:num = 3
                  2:'+': stack=[3] op='+'
                  3:2  : stack=[3] num = 2
                  4: * : stack[3,2] op='*'
                  5: 2 : stack[3,2] op='*' num=2
                  6: last : op='*' -> 2*2 = 4
                  [3,4] = sum([3,4]) = 7
        
        """
        stack,res = [],0
        op = '+'
        
        for index,ch in enumerate(s):
            if ch.isnumeric():
                res = res*10 + int(ch)

            if ch in '+-*/' or index == len(s)-1:
                # judge op
                if op=='+':
                    stack.append(res)
                elif op=='-':
                    stack.append(-1*res)
                elif op=='*':
                    stack.append(stack.pop()*res)
                elif op=='/':
                    stack.append(int(stack.pop()/res))
                op,res = ch,0

        return sum(stack)

```
