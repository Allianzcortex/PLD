
Porblem Description:

```

一个长度为n-1的递增排序数组中的所有数字都是唯一的，并且每个数字都在范围0～n-1之内。在范围0～n-1内的n个数字中有且只有一个数字不在该数组中，请找出这个数字。

示例 1:

输入: [0,1,3]
输出: 2
示例 2:

输入: [0,1,2,3,4,5,6,7,9]
输出: 8


```

Idea: 这道题可以划分为左右两部分：
左半部分为顺序序列，右半部分为非顺序序列，要找的是右半部分的第一个数字对应下标

关键部分就是找中点，然后拿中点的值和中点的下标比较。如果相同，说明左半部分是有序的，
left = middle +1 去找右半部分；如果不同说明左半部分是无序的，right = middle -1
去找左半部分。


Python 解法如下：

```Python

class Solution:
    def missingNumber(self, nums: List[int]) -> int:

        left,right = 0,len(nums)-1

        while left<=right:
            middle = left+(right-left)//2
            if middle-left == nums[middle]-nums[left]:
                left = middle+1
            else:
                right = middle-1
        
        return left

```

Golang 解法如下：

```Golang

func missingNumber(nums []int) int {

    left,right:=0,len(nums)-1

    for left<=right {
        middle:=left+(right-left)/2

        if nums[middle]==middle {
            left = middle+1
        } else {
            right = middle-1
        }
    }

    return left
}

```