
Problem description:

```

Given an integer array nums, move all the even integers at the beginning of the array followed by all the odd integers.

Return any array that satisfies this condition.

 

Example 1:

Input: nums = [3,1,2,4]
Output: [2,4,3,1]
Explanation: The outputs [4,2,3,1], [2,4,1,3], and [4,2,1,3] would also be accepted.
Example 2:

Input: nums = [0]
Output: [0]

```

Basic idea:

这道题有很多种解法，比如自己一开始一次 AC 的方法，就很直观

```Python

class Solution:
    def sortArrayByParity(self, nums: List[int]) -> List[int]:
        
        index = 0
        
        for i in range(len(nums)):
            if nums[i]%2==0:
                nums[i],nums[index] = nums[index],nums[i]
                index+=1
        
        return nums

```

但有一个问题就是如果这个数组全是偶数，那么效率就不够高。第二种思路是用 two pointers，
两个指针分别找奇数和偶数，解法如下：

```Java

class Solution {
    public int[] sortArrayByParity(int[] A) {
        int i=0,j=A.length-1;
        while(i<=j) {
            while(i<=j && A[i]%2==0)
                i++;
            while(i<=j && A[j]%2==1)
                j--;
            if(i<=j)
                swap(A,i,j);
        }
        
        return A;
    }
    
    public void swap(int[] A,int i,int j) {
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }
}

```

This is the 2nd way :

Everytime only iterate once so avoid possible outofBound Exception

Notice the key condition is `i<j` rather than `i<=j`

```Java

class Solution {
    public int[] sortArrayByParity(int[] A) {
        int i=0,j=A.length-1;
        
        while(i<j) {
            if(A[i]%2==0)
                i++;
            else {
                if(A[j]%2==1)
                    j--;
                if(A[j]%2==0) {
                    // odd even
                    swap(A,i++,j--);
                }
            }
        }
        
        return A;
    }
    
    public void swap(int[] A,int i,int j) {
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }
}

```