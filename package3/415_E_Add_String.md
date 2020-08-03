
Classic Java solution with two-pointers


```Java
class Solution {
    public String addStrings(String num1, String num2) {
        /**
        123
        456
        **/
        int i=num1.length()-1,j=num2.length()-1,carry=0;
        StringBuilder res = new StringBuilder();
        while(i>=0 || j>=0 || carry!=0) {
            int temp1 = i>=0?num1.charAt(i--)-'0':0;
            int temp2 = j>=0?num2.charAt(j--)-'0':0;
            int sum = temp1+temp2+carry;
            res.append(sum%10);
            carry = sum/10;
        }

        return res.reverse().toString();
    }
}

```

---

```Python

class Solution:
    def addStrings(self, num1: str, num2: str) -> str:
        i,j,carry = len(num1)-1,len(num2)-1,0
        res = ""
        while i>=0 or j>=0 or carry!=0:
            temp1 = int(num1[i]) if i>=0 else 0
            temp2 = int(num2[j]) if j>=0 else 0
            sum = temp1+temp2+carry
            res=str(sum%10)+res
            carry = sum//10
            # Python does not support auto-increment/decrement ++/-- 
            i,j=i-1,j-1
        
        return res

```