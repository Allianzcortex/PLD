
This is my solution :

There is no need to think about overflow issues for :

1. If it is overflowed,then it will never be palindrome.
2. If it is overflowed,then the final res will become a negative number
which means it will be false. Its exactly what we need then.

```Java

class Solution {
    public boolean isPalindrome(int x) {
        if(x<0)
            return false;
        int res = 0;
        int input = x;
        
        while(x!=0) {
            int temp = x%10;
            res=res*10+temp;
            x/=10;
        }
        return res==input;
    }
}

```

---

If you wnat to be cautious, then we can use the following solution
which only compare half of the numbers :

link : https://leetcode.com/problems/palindrome-number/discuss/5127/9-line-accepted-Java-code-without-the-need-of-handling-overflow

code :

```Java

public boolean isPalindrome(int x) {
    if (x<0 || (x!=0 && x%10==0)) return false;
    int rev = 0;
    while (x>rev){
    	rev = rev*10 + x%10;
    	x = x/10;
    }
    return (x==rev || x==rev/10);
}

```