
Problem Description:

```

Given an integer array nums sorted in non-decreasing order, remove some duplicates in-place such that each unique element appears at most twice. The relative order of the elements should be kept the same.

Since it is impossible to change the length of the array in some languages, you must instead have the result be placed in the first part of the array nums. More formally, if there are k elements after removing the duplicates, then the first k elements of nums should hold the final result. It does not matter what you leave beyond the first k elements.

Return k after placing the final result in the first k slots of nums.

Do not allocate extra space for another array. You must do this by modifying the input array in-place with O(1) extra memory.

Custom Judge:

The judge will test your solution with the following code:

int[] nums = [...]; // Input array
int[] expectedNums = [...]; // The expected answer with correct length

int k = removeDuplicates(nums); // Calls your implementation

assert k == expectedNums.length;
for (int i = 0; i < k; i++) {
    assert nums[i] == expectedNums[i];
}
If all assertions pass, then your solution will be accepted.

 

Example 1:

Input: nums = [1,1,1,2,2,3]
Output: 5, nums = [1,1,2,2,3,_]
Explanation: Your function should return k = 5, with the first five elements of nums being 1, 1, 2, 2 and 3 respectively.
It does not matter what you leave beyond the returned k (hence they are underscores).
Example 2:

Input: nums = [0,0,1,1,1,1,2,3,3]
Output: 7, nums = [0,0,1,1,2,3,3,_,_]
Explanation: Your function should return k = 7, with the first seven elements of nums being 0, 0, 1, 1, 2, 3 and 3 respectively.
It does not matter what you leave beyond the returned k (hence they are underscores).
 

Constraints:

1 <= nums.length <= 3 * 104
-104 <= nums[i] <= 104
nums is sorted in non-decreasing order.

```


Basic Idea:
这是一开始写的 Java 解法，好吧我现在也不知道是什么意思

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

然后这里有人给出一个非常简洁的解法，但我临场时候估计是想不到的：

```Python

def removeDuplicates(self, nums):
    i = 0
    for n in nums:
        if i < 2 or n > nums[i-2]:
            nums[i] = n
            i += 1
    return i

```

---

这里提供一下我的 2 种解法：

第一种是最符合思路的，但很容易有陷阱，比如最后是 return left 还是 return left + 1

```Python

class Solution:
    def removeDuplicates(self, nums: List[int]) -> int:
        left,right = 0,0

        while right<len(nums):
            # 如果是最后一个，赋值，然后 break
            if right==len(nums)-1:
                nums[left]=nums[right]
                left += 1
                break
            if nums[right]==nums[right+1]:
                for _ in range(2):
                    nums[left]=nums[right]
                    right+=1
                    left+=1
                while right<len(nums) and nums[right]==nums[right-1]:
                    right += 1
            else:
                nums[left]=nums[right]
                right+=1
                left+=1
        
        return left

```

第二种就比较好，也是临场可以想出来的。

```Python
class Solution:
    def removeDuplicates(self, nums: List[int]) -> int:
        left,right = 0,0
        while right<len(nums):
            # 第一种情况，对数组前两个元素而言，left 和 right 肯定是
            # 一直相等的
            if right<=1:
                nums[left]=nums[right]
                left+=1
                right+=1
            # 然后等到前两个数组走完，我们假设前 3 个数是 1,1,1 
            # 这时候 left 和 right 都走到最后一个 1 上
            # 如果这时候 right 和 left-2 的数相等，那么就意味着
            # 必然有 3 个连续元素，left 不动，right 往右走
            elif nums[right]==nums[left-2]:
                # duplicate
                right+=1
            # 如果不相等的话，就把 right 的值赋值给 left
            elif nums[right]!=nums[left-2]:
                # should replace left with right
                nums[left]=nums[right]
                left+=1
                right+=1
        return left

```

临场写出上面的代码后，再优化总结一下：

```Python

class Solution:
    def removeDuplicates(self, nums: List[int]) -> int:
        left,right = 0,0
        while right<len(nums):

            if right<=1 or nums[right]!=nums[left-2]:
                nums[left]=nums[right]
                left+=1
                
            elif nums[right]!=nums[left-2]:
                nums[left]=nums[right]
                left+=1
            
            right+=1
        
        return left

```