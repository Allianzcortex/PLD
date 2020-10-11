

This is my solution

```Java

class Solution {
    public int removeDuplicates(int[] nums) {
        int index=0;
        int count = 0;
        int prevIndex = 0;
        
        while(index<nums.length) {
           
            int left = index,right = index;
            while(right+1<nums.length && nums[right]==nums[right+1]) {
                right += 1;
            }
            
            int len = (right-left+1>=2?2:right-left+1);
            count+= len;
            for(int i=0;i<len;i++) {
                nums[prevIndex+i] = nums[index];
            }
            prevIndex += len;
            index = right+1;
        }
        
        return count;
    }
}

```
And as for this one :

???

This solution is so genius

```Java

class Solution {
    public int removeDuplicates(int[] A) {
        int i = 2;
        for (int j = 2; j < A.length; j++)
            if (A[j] != A[i-2])
                A[i++] = A[j];
        return i;
    }
}

```

This problem is like problem 26 : can be generalized to at-most k digits:

```Java
class Solution {
    public int removeDuplicates(int[] A) {
        int i = k;
        for (int j = k; j < A.length; j++)
            if (A[j] != A[i-k])
                A[i++] = A[j];
        return i;
    }
}

```

What a brilliant solution...