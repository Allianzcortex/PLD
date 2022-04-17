
Problem description :

```
A complex number can be represented as a string on the form "real+imaginaryi" where:

real is the real part and is an integer in the range [-100, 100].
imaginary is the imaginary part and is an integer in the range [-100, 100].
i2 == -1.
Given two complex numbers num1 and num2 as strings, return a string of the complex number that represents their multiplications.

 

Example 1:

Input: num1 = "1+1i", num2 = "1+1i"
Output: "0+2i"
Explanation: (1 + i) * (1 + i) = 1 + i2 + 2 * i = 2i, and you need convert it to the form of 0+2i.
Example 2:

Input: num1 = "1+-1i", num2 = "1+-1i"
Output: "0+-2i"
Explanation: (1 - i) * (1 - i) = 1 + i2 - 2 * i = -2i, and you need convert it to the form of 0+-2i.
 

Constraints:

num1 and num2 are valid complex numbers.
```

Idea : Complex 在中文翻译里是复数
整个结果就是要对两个复数进行乘法，很基本的运算。

自己一开始想得太复杂是觉得还要对 "+-" 做操作，其实完全不用，按 "+" 分割成两部分
依次计算就好了

---

Python 解法，第一次做，不是最优的办法：

```Python

class Solution:
    def complexNumberMultiply(self, num1: str, num2: str) -> str:
        r1,i1 = num1.split('+')
        r1 = int(r1)
        i1 = int(i1[:-1])
        
        r2,i2 = num2.split('+')
        r2 = int(r2)
        i2 = int(i2[:-1])
        
        res_r = 0
        res_r += r1*r2
        res_i = r1*i2+r2*i1
        res_r += -1*(i1*i2)
        
        return f"{res_r}+{res_i}i"
```

---

Golang 解法就系统很多，如下：

```Golang

func complexNumberMultiply(num1 string, num2 string) string {
    
    r1,i1 := parse(num1)
    r2,i2 := parse(num2)
    
    resR:= r1*r2-i1*i2
    resI:= r1*i2+r2*i1
    
    return fmt.Sprintf("%d+%di",resR,resI)
}

func parse(num string) (int,int) {
    
    res:=strings.Split(num,"+")
    
    r,_ := strconv.Atoi(res[0])
    i,_ := strconv.Atoi(res[1][:len(res[1])-1])
    
    return r,i
}

```