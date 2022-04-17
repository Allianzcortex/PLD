
Problem description:

```

You are given a sorted array consisting of only integers where every element appears exactly twice, except for one element which appears exactly once.

Return the single element that appears only once.

Your solution must run in O(log n) time and O(1) space.

 

Example 1:

Input: nums = [1,1,2,3,3,4,4,8,8]
Output: 2
Example 2:

Input: nums = [3,3,7,7,10,11,11]
Output: 10
 

Constraints:

1 <= nums.length <= 105
0 <= nums[i] <= 105

```

当这道题看到 O(logN) 的时间复杂度要求时就知道要用二分搜索了

但整体判断条件这里我还是有点困惑，为什么 index 是偶数时候要和
后一位比较，而 index 是奇数时候要和前一位比较。看起来很直观对吧，但
实际上并没那么容易...


Java 解法如下：

```Java

class Solution {
    public int singleNonDuplicate(int[] nums) {
        
        int left=0;
        int right=nums.length-1;
        
        
        while(left<right) {
            int middle = left + (right-left)/2;
            
            if(middle%2==0) {
                // middle is even
                if(nums[middle]==nums[middle+1]) {
                    left = middle+2;
                } else { 
                    right = middle;
                }
            } else {
                // middle is odd
                if(nums[middle]==nums[middle-1]) {
                    // left part is all with pairs
                    left = middle+1;
                } else {
                    right = middle;
                }
            }
        }
        
        return nums[left];
    }
}

```