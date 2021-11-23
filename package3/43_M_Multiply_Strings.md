
Problem description:

```
Given two non-negative integers num1 and num2 represented as strings, return the product of num1 and num2, also represented as a string.

Note: You must not use any built-in BigInteger library or convert the inputs to integer directly.

 

Example 1:

Input: num1 = "2", num2 = "3"
Output: "6"
Example 2:

Input: num1 = "123", num2 = "456"
Output: "56088"
 

Constraints:

1 <= num1.length, num2.length <= 200
num1 and num2 consist of digits only.
Both num1 and num2 do not contain any leading zero, except the number 0 itself.

```

Basic idea:



This graph has explained the whole process clearly

![image](https://drscdn.500px.org/photo/130178585/m%3D2048/300d71f784f679d5e70fadda8ad7d68f)

This is my Java Solution

```Java
class Solution {
    public String multiply(String num1, String num2) {
        /**
            5 2 3
              4 5
        =   6 1 5   1
         2 0  9 2
        **/

        int l1=num1.length(),l2=num2.length();
        int[] res = new int[l1 + l2];

        for(int i=l1-1;i>=0;i--) {
            for(int j=l2-1;j>=0;j--) {
                int val1 = num1.charAt(i)-'0';
                int val2 = num2.charAt(j)-'0';
                res[i+j+1] += (val1*val2);
                res[i+j] += res[i+j+1]/10;
                res[i+j+1] %= 10;
            }
        }
        
        for(int i=0;i<res.length;i++) {
            if(!(output.length()==0 && res[i]==0))
                output.append(res[i]);
        }

        return output.length()==0?"0":output.toString();
    }
}


```