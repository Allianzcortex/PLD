


This problem seems easy the 1st time,but actually need to take more 
time and caution to sovle it !

This is initially what I want to do:

```Java
class Solution {
    public boolean checkPalindromeFormation(String a, String b) {
        if(isPalindrome(a) || isPalindrome(b))
            return true;
        
        int len = a.length();
        int left1=0,right1=len-1;
        int left2=0,right2=len-1;
        boolean flag1=true,flag2=true;
        while((left1<right1 || left2<right2) && (flag1 || flag2)) {
            if(flag1) {
                if(a.charAt(left1)==b.charAt(right1)){
                    left1++;
                    right1--;
                } else {
                    flag1 = false;
                }
            }
            
            if(flag2) {
                if(a.charAt(right2)==b.charAt(left2)) {
                    right2--;
                    left2++;
                } else {
                    flag2 = false;
                }
            }
        }
        return flag1 || flag2;
        
    }
    
    public boolean isPalindrome(String str) {
        if(str==null || str.length()==0)
            return true;
        int left=0,right=str.length()-1;
        while(left<right) {
            if(str.charAt(left++)!=str.charAt(right--))
                return false;
        }
        
        return true;
    }
}

```

To compare 2 indexes , but it cannot work for the following 2 reasons:

```
1. edge case is too complex
2. Cannot handle the case like :

ulabbxyz
jizcdalu

```

The solution(two-pointers) will be like :

```Java

class Solution {
    public boolean checkPalindromeFormation(String a, String b) {
        return validate(a,b) || validate(b,a);
    }
    
    public boolean validate(String a,String b) {
        int left=0,right=a.length()-1;
        
        while(left<right) {
            if(a.charAt(left)==b.charAt(right)) {
                left++;
                right--;
            } else {
                break;
            }
        }
        
        return isPalindrome(a,left,right) || isPalindrome(b,left,right);
    }
    
    
    public boolean isPalindrome(String s,int left,int right) {
        if(left>=right)
            return true;
        while(left<right) {
            if(s.charAt(left++)!=s.charAt(right--))
                return false;
        }
        
        return true;
    }
}

```

The explanation is here :

```

l
ulabbxyz
jizcdalu
       r

// Same, l++, r— 

 l
ulabbxyz
jizcdalu
      r
	   
// Same, l++, r— 

  l
ulabbxyz
jizcdalu
     r

// Same, l++, r— 

   l
ulabbxyz
jizcdalu
    r
	
// the trick is here, “b” and “d” are different. 
// That means we have two choice to make it possible
// Either cut at l in string a, or cut at r in string b. 

// try those 2 approaches
    lr
ula bb ... // <- need check if [l,r] in string a is palindrome
..... alu
// or 
ula .....
... cd alu  // <- need check if [l,r] in string b is palindrome
    lr
    
```
