
Problem description:

```
We have two special characters:

The first character can be represented by one bit 0.
The second character can be represented by two bits (10 or 11).
Given a binary array bits that ends with 0, return true if the last character must be a one-bit character.

 

Example 1:

Input: bits = [1,0,0]
Output: true
Explanation: The only way to decode it is two-bit character and one-bit character.
So the last character is one-bit character.
Example 2:

Input: bits = [1,1,1,0]
Output: false
Explanation: The only way to decode it is two-bit character and two-bit character.
So the last character is not one-bit character.
 

Constraints:

1 <= bits.length <= 1000
bits[i] is either 0 or 1.

```

---

Basic idea:

自己一开始的解法是用递归来做：

```Python
class Solution:
    def isOneBitCharacter(self, bits: List[int]) -> bool:
        
        if not bits:
            return False
        
        if len(bits)==1:
            return bits[0]==0
        
        flag = False
        if bits[0]==0:
            flag = flag or self.isOneBitCharacter(bits[1:])
        if bits[0]==1:
            flag = flag or self.isOneBitCharacter(bits[2:])
        
        return flag

```

用迭代也可以：

```Python

class Solution:
    def isOneBitCharacter(self, bits: List[int]) -> bool:
        
        index,length = 0,len(bits)-1
        
        while index<=length:
            if index==length:
                return True
            
            if bits[index]==0:
                index+=1
            else:
                index+=2
        
        return False

```