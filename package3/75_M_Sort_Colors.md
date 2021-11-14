
Problem description:

```
Given an array nums with n objects colored red, white, or blue, sort them in-place so that objects of the same color are adjacent, with the colors in the order red, white, and blue.

We will use the integers 0, 1, and 2 to represent the color red, white, and blue, respectively.

You must solve this problem without using the library's sort function.

 

Example 1:

Input: nums = [2,0,2,1,1,0]
Output: [0,0,1,1,2,2]
Example 2:

Input: nums = [2,0,1]
Output: [0,1,2]
Example 3:

Input: nums = [0]
Output: [0]
Example 4:

Input: nums = [1]
Output: [1]
 

Constraints:

n == nums.length
1 <= n <= 300
nums[i] is 0, 1, or 2.
 

Follow up: Could you come up with a one-pass algorithm using only constant extra space?

```

Basic idea:

这道题很有趣，基本思路是用最小 index 表示 red index，用最大 index 表示 blue index，然后在一次迭代的过程中：

- 如果发现 nums[index] 为 red，就和 red index 交换，之后 red index ++,white index++

- 如果发现 nums[index] 为 blue, 就和 blue index 交换，但因为不确定换回来的值是什么新值，所以 blue--，而 white 不变，等待下一次迭代时再次判断

对应的 Java 解法如下：

```Java
class Solution {
    public void sortColors(int[] nums) {
        int low=0,high=nums.length-1;
        for(int i=0;i<=high;i++) {
            if(nums[i]==0){
                swap(nums,i,low++);
            } else if(nums[i]==2){
                swap(nums,i--,high--);
            } 
        }
    }
    
    public void swap(int[] nums,int left,int right) {
        int temp=nums[left];
        nums[left]=nums[right];
        nums[right]=temp;
    }
}
```

而 Python 解法如下，用更有可读性的变量来命名：

```Python

class Solution:
    def sortColors(self, nums: List[int]) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        white,blue = 0,len(nums)-1
        red = 0
        
        # red -> white -> blue
        while white<=blue:

            if nums[white]==0:
                nums[red],nums[white] = nums[white],nums[red]
                red += 1
                white += 1
            elif nums[white]==1:
                white += 1
            else:
                nums[white],nums[blue] = nums[blue],nums[white]
                blue -= 1

```