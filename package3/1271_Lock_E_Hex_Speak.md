
Description :

```
You have a decimal number, please follow this rule to turn it into a "hexadecimal magic number": first turn it into a capital hex string, and then all the numbers0 Into lettersO , The number1 Into lettersI 。

If a number contains only after conversion{"A", "B", "C", "D", "E", "F", "I", "O"} , Then we think this conversion is effective.

Give you a stringnum , Which represents a decimal numberN, If its hexadecimal magic number conversion is valid, please return the converted result, otherwise return"ERROR" 。

Example 1:

Input: num = "257"
 Output: "IOI"
 Explanation: The hexadecimal representation of 257 is 101.
1
2
3
Example 2:

Input: num = "3"
 Output: "ERROR"
1
2
prompt:

1 <= N <= 10^12
The given string will not have leading 0s.
All letters in the result should be capital letters.

```

Since its a lock problem, so still not valited

Mainly using built-in API :

Java Solution :

```Java

class Solution {
    public String toHexspeak(String num) {
        String s = Long.toHexString(Long.parseLong(num)).  
                replace('1', 'I').  
                replace('0', 'O').   
                toUpperCase();  
        List<Character> list = Arrays.asList('A', 'B', 'C', 'D', 'E', 'F', 'I', 'O');
        for (int i = 0; i < s.length(); i++) {
            if (!list.contains(s.charAt(i))) {
                return "ERROR";
            }
        }
        return s;
    }
}

```

---

Python Solution :

```Python

    def toHexspeak(self, num: str) -> str:
        target_set = {"A", "B", "C", "D", "E", "F", "I", "O"}
        ans = hex(int(num))[2:].upper()
        ans = ans.replace('1', "I").replace("0", "O")

        if set(ans) - target_set:
            return "ERROR"
        return ans

```