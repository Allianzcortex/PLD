
```Java

class Solution {
    public int findNthDigit(int n) {
        /**
        0 - 9 : 10;
        10 - 99 : 90*2=180;
        100 - 999 : 900*3=2700;
        **/
      int digit = 1;
        long start = 1;
        long count = 9;
        while (n > count) { // 1.
            n -= count;
            digit += 1;
            start *= 10;
            count = digit * start * 9;
        }
        long num = start + (n - 1) / digit; // 2.
        return Long.toString(num).charAt((n - 1) % digit) - '0'; // 3.

    }
}

```