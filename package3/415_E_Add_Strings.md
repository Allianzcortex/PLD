
This is my solution:

```Java
class Solution {
    public String addStrings(String num1, String num2) {
        /**
        123
    +   456
    =   579
        **/
    int l1=num1.length()-1,l2=num2.length()-1;
    int carry = 0;
    StringBuilder res = new StringBuilder();
    while(l1>=0 || l2>=0 || carry>0) {
        int val1 = l1>=0?num1.charAt(l1--)-'0':0;
        int val2 = l2>=0?num2.charAt(l2--)-'0':0;
        int sum = val1 + val2 + carry;
        // Cannot use append(0,sum%10) (: 
        res.insert(0,sum%10);
        carry = sum / 10;
    }
    return res.toString();
  }
}

```