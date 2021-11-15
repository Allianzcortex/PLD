
Problem description:

```

We are playing the Guess Game. The game is as follows:

I pick a number from 1 to n. You have to guess which number I picked.

Every time you guess wrong, I will tell you whether the number I picked is higher or lower than your guess.

You call a pre-defined API int guess(int num), which returns 3 possible results:

-1: The number I picked is lower than your guess (i.e. pick < num).
1: The number I picked is higher than your guess (i.e. pick > num).
0: The number I picked is equal to your guess (i.e. pick == num).
Return the number that I picked.

 

Example 1:

Input: n = 10, pick = 6
Output: 6
Example 2:

Input: n = 1, pick = 1
Output: 1
Example 3:

Input: n = 2, pick = 1
Output: 1
Example 4:

Input: n = 2, pick = 2
Output: 2
 

Constraints:

1 <= n <= 231 - 1
1 <= pick <= n

```

Basic idea:

还是自己 2017 年时候做的题...

基本思路是用二分搜索，Java 解法如下：

```Java

public class Solution extends GuessGame {
    public int guessNumber(int n) {
        int i=1,j=n;
        while(i<j){
            int middle = i+(j-i)/2;
            int target=guess(middle);
            if(target==0)
                return middle;
            else if(target<0)
                j=middle-1;
            else
                i=middle+1;
            
        }
        return i;
    }
}

```