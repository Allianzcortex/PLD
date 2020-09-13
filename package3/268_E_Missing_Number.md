
Here we provide 3 kinds of solutions:

1. Two Binary Search

I still haven't proven it officially.

```Java

class Solution {
    public int missingNumber(int[] nums) {
     // 0 1 2
    //  1 2 3
        Arrays.sort(nums);
        int left=0,right=nums.length-1;
        
        while(left<=right) {
            int middle = left + (right-left)/2;
            if(nums[middle]>middle)
                right = middle -1;
            else
                left = middle +1;
        }
        
        return left;
    }
}

```

2.  Sum

```Java

class Solution {
    public int missingNumber(int[] nums) {
        int len=nums.length;
        int sum=len*(len+1)/2;
        for(int num:nums)
            sum -= num;
        
        return sum;
    }
}

```

3. Using bit manipulation. Will do it later.

```
If anyone needs explanation for XOR solution, a number XOR itself will become 0, any number XOR with 0 will stay unchanged. So if every number from 1...n XOR with itself except the missing number, the result will be the missing number.

Example:
1..4 missing 3



 1^2  ^4




^1^2^3^4



 0^0^3^0 => 3

 ```