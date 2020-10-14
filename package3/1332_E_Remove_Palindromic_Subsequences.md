
The difference between `subarray & subsequence` :

subarray must be consecutive
subsequence doesnot have to be consecutive

so we can remove all `a` firstly and then remove `b`

```Java
class Solution {
    public int removePalindromeSub(String s) {
        if(s==null || s.length()==0)
            return 0;
        // sure , you can use two pointers here to implement the basic compare palindromic value
        if(s.equals(new StringBuilder(s).reverse().toString()))
           return 1;
        
         return 2;
    }
}

```