
problem description:

```
The count-and-say sequence is a sequence of digit strings defined by the recursive formula:

countAndSay(1) = "1"
countAndSay(n) is the way you would "say" the digit string from countAndSay(n-1), which is then converted into a different digit string.
To determine how you "say" a digit string, split it into the minimal number of groups so that each group is a contiguous section all of the same character. Then for each group, say the number of characters, then say the character. To convert the saying into a digit string, replace the counts with a number and concatenate every saying.

For example, the saying and conversion for digit string "3322251":


Given a positive integer n, return the nth term of the count-and-say sequence.

 

Example 1:

Input: n = 1
Output: "1"
Explanation: This is the base case.
Example 2:

Input: n = 4
Output: "1211"
Explanation:
countAndSay(1) = "1"
countAndSay(2) = say "1" = one 1 = "11"
countAndSay(3) = say "11" = two 1's = "21"
countAndSay(4) = say "21" = one 2 + one 1 = "12" + "11" = "1211"

```

Below is Java Solution :

```Java
class Solution {
    public String countAndSay(int n) {
        if(n==1)
            return "1";
        String prev = countAndSay(n-1);
        char[] arr = prev.toCharArray();
        StringBuilder res = new StringBuilder();
        for(int i=0;i<arr.length;) {
            int count = 1;
            while(i<arr.length-1 && arr[i]==arr[i+1]) {
                i++;
                count++;
            }
            // if(i==arr.length)
            //     i-=1;
            res.append(count).append(arr[i]);
            i+=1;
        }
        
        return res.toString();
    }
}

```

And this will be Python solution,same idea but a bit difference
in implementation

```Python

class Solution:
    def countAndSay(self, n: int) -> str:
        if n==1:
            return "1"
        
        prev = self.countAndSay(n-1)
        
        res = ""
        index = 0
        while index<len(prev):
            cnt = 1
            while index<len(prev)-1 and prev[index]==prev[index+1]:
                index += 1
                cnt += 1
            
            res+=f"{cnt}{prev[index]}"
            index += 1
        
        return res

```