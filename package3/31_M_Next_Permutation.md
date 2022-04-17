
Problem description:

```

Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.

If such an arrangement is not possible, it must rearrange it as the lowest possible order (i.e., sorted in ascending order).

The replacement must be in place and use only constant extra memory.

 

Example 1:

Input: nums = [1,2,3]
Output: [1,3,2]
Example 2:

Input: nums = [3,2,1]
Output: [1,2,3]
Example 3:

Input: nums = [1,1,5]
Output: [1,5,1]
Example 4:

Input: nums = [1]
Output: [1]
 

Constraints:

1 <= nums.length <= 100
0 <= nums[i] <= 100

```

Basic idea :

1. from right to left,find the first value that satisfies arr[i]<arr[i+1]

if such a value doesnot exist,it means we have the last permutation and just need to reverse the whole array.

2. from right to left,find the first value that satisfies arr[j]>arr[i]

3. swap the value arr[i] and arr[j]

4. reverse the array[j+1:]

---

Take `[2,3,6,5,4,1]` as an example :

1. Find i : index will be 1, value will be 3
2. find j : index will be 4, value will be 4
3. swap(i,j) : then array will be `[2,4,6,5,3,1]`
4. reverse(i+1:) : then array will be `[2,4,1,3,5,6]`



```Java

class Solution {
    public void nextPermutation(int[] nums) {
        int len=nums.length;
        int leftIndex = -1,leftValue = 0;
        
        for(int i=len-2;i>=0;i--) {
            if(nums[i]<nums[i+1]) {
                leftIndex = i;
                leftValue = nums[i];
                break;
            }
        }
        
        if(leftIndex==-1) {
            // This is the last permutation
            // We just need to return the 1st one
            reverse(nums,0,len-1);
            return;
        }
        
        for(int i=len-1;i>leftIndex;i--) {
            if(nums[i]>leftValue) {
                swap(nums,leftIndex,i);
                break;
            }
        }
        
        reverse(nums,leftIndex+1,len-1);
    }
    
    public void swap(int[] nums,int left,int right) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }
    
    public void reverse(int[] nums,int left,int right) {
        while(left<right) {
            swap(nums,left++,right--);
        }
    }
}

```

TODO add Python solution