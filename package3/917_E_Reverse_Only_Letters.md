
Problem description :

```
Given a string s, reverse the string according to the following rules:

All the characters that are not English letters remain in the same position.
All the English letters (lowercase or uppercase) should be reversed.
Return s after reversing it.

 

Example 1:

Input: s = "ab-cd"
Output: "dc-ba"
Example 2:

Input: s = "a-bC-dEf-ghIj"
Output: "j-Ih-gfE-dCba"
Example 3:

Input: s = "Test1ng-Leet=code-Q!"
Output: "Qedo1ct-eeLg=ntse-T!";

```

Basic idea : 就是很典型的 two pointers 问题

Python 解法如下：

```Python

class Solution:
    def reverseOnlyLetters(self, s: str) -> str:
        
        input_ = list(s)
        
        left,right = 0,len(input_)-1
        
        while left<right:
            while left<right and not input_[left].isalpha():
                left += 1
            
            while left<right and not input_[right].isalpha():
                right -= 1
            
            # if left<right:
            input_[left],input_[right] = input_[right],input_[left]
            
            left += 1
            right -= 1
        
        return ''.join(input_)

```

Java 解法如下

```Java

class Solution {
    public String reverseOnlyLetters(String S) {
        char[] arr = S.toCharArray();
        int left=0,right=arr.length-1;
        
        while(left<right) {
            while(left<right && !Character.isLetter(arr[left]))
                left++;
            while(left<right && !Character.isLetter(arr[right]))
                right--;
            if(left<right)
                swap(arr,left++,right--);
        }
        
        return String.valueOf(arr);
    }
    
    public void swap(char[] arr,int left,int right) {
        char temp = arr[left];
        arr[left] = arr[right];
        arr[right] = temp;
    }
}

```


TODO : check other solutions later