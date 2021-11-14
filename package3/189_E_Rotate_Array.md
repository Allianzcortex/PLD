
Problem description:

```

Given an array, rotate the array to the right by k steps, where k is non-negative.

 

Example 1:

Input: nums = [1,2,3,4,5,6,7], k = 3
Output: [5,6,7,1,2,3,4]
Explanation:
rotate 1 steps to the right: [7,1,2,3,4,5,6]
rotate 2 steps to the right: [6,7,1,2,3,4,5]
rotate 3 steps to the right: [5,6,7,1,2,3,4]
Example 2:

Input: nums = [-1,-100,3,99], k = 2
Output: [3,99,-1,-100]
Explanation: 
rotate 1 steps to the right: [99,-1,-100,3]
rotate 2 steps to the right: [3,99,-1,-100]
 

Constraints:

1 <= nums.length <= 105
-231 <= nums[i] <= 231 - 1
0 <= k <= 105
 

Follow up:

Try to come up with as many solutions as you can. There are at least three different ways to solve this problem.
Could you do it in-place with O(1) extra space?

```

Basic idea:

这道题如果用模拟的方法来做的话并不难，但 follow-up 里要求用 O(1) extra space 的话就只有用
三次 reverse 这样的方法，但面试里也很难想起。anyway 这道题不做要求吧

There solutions 1:

1. Best one :

reverse 3 times:

```Java
class Solution {
    
    /**
    [1,2,3,4,5,6,7], k = 3
    
    [1,2,3,4,5,6,7]
           |
    [7,6,5,4,3,2,1]
           |
    [5,6,7,4,3,2,1]
           |
    [5,6,7,1,2,3,4]
    
    **/
    public void rotate(int[] nums, int k) {
        int len = nums.length;
        k=k%len;
        reverse(nums,0,len-1);
        reverse(nums,0,k-1);
        reverse(nums,k,len-1);
    }
    
    public void reverse(int[] arr,int left,int right) {
        int temp;
        while(left<right) {
            temp = arr[right];
            arr[right--]=arr[left];
            arr[left++]=temp;
        }
    }
}

```

2. Solution2 copy the old array and find the relation

```Java
class Solution {
    public void rotate(int[] nums, int k) {
        int len =nums.length;
        int[] oldNums = nums.clone();
        k%=len;
        
        for(int i=0;i<len;i++) {
            nums[(i+k)%len] = oldNums[i];
        }
        
    }
}

```

3. Mock the move behaviour

```Java

class Solution {
    public void rotate(int[] nums, int k) {
        int len = nums.length;
        k%=len;
        for(int i=0;i<k;i++) {
            int temp = nums[len-1];
            for(int j=len-2;j>=0;j--)
                nums[j+1]=nums[j];
            nums[0]=temp;
        }
    }
}


```

---


TODO add python solution