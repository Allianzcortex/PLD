
Problem description :

```

Given an integer array nums, return an array answer such that answer[i] is equal to the product of all the elements of nums except nums[i].

The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.

You must write an algorithm that runs in O(n) time and without using the division operation.

 

Example 1:

Input: nums = [1,2,3,4]
Output: [24,12,8,6]
Example 2:

Input: nums = [-1,1,0,-3,3]
Output: [0,0,9,0,0]
 

```

思路很简单

  1 2 3 4
        
1 2*3*4
2 1*3*4
3 1*2*4
4 1*2*3

对第一个元素，结果为 2*3*4，可以立即为左边元素为 1，右边元素为 2*3*4
对第二个元素，结果为 1*3*4，可以立即为左边元素为 1，右边元素为 3*4
对第三个元素，结果为 1*2*4，可以立即为左边元素为 1*2，右边元素为 4
对第四个元素，结果为 2*3*4，可以立即为左边元素为 1*2*3，右边元素为 1


所以就可以用两个数组分别存储左右两边的计算结果：

```Python

class Solution:
    def productExceptSelf(self, nums: List[int]) -> List[int]:

        row = len(nums)
        left,right = [1]*len(nums) , [1]*len(nums)
        
        
        for i in range(1,row):
            # if i==1:
            #     left[i] = nums[i-1]
            # else:
                left[i] = nums[i-1]*(left[i-1])
        
        for i in range(row-2,-1,-1):
            # if i==row-2:
            #     right[i] = nums[-1]
            # else:
                right[i] = right[i+1]*nums[i+1]

        return [left[i]*right[i] for i in range(row)]

```

但上面的空间复杂度为 O(n)，我们可以分别只用一个变量来存储左右的计算结果，那么
空间复杂度就为 O(1):

解法如下：

```Python

class Solution:
    def productExceptSelf(self, nums: List[int]) -> List[int]:        
        # first of all , calculate the left part
        row = len(nums)
        res = [1 for _ in range(row)]
        
        left_sum = 1
        for i in range(1,row):
            left_sum *= nums[i-1]
            res[i] = left_sum
        

        right_sum = 1
        for i in range(row-2,-1,-1):
            right_sum *= nums[i+1]
            res[i]*=right_sum
        
        return res

```

