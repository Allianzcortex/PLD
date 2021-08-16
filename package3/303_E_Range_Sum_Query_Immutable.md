
problem description:

```

Given an integer array nums, handle multiple queries of the following type:

Calculate the sum of the elements of nums between indices left and right inclusive where left <= right.
Implement the NumArray class:

NumArray(int[] nums) Initializes the object with the integer array nums.
int sumRange(int left, int right) Returns the sum of the elements of nums between indices left and right inclusive (i.e. nums[left] + nums[left + 1] + ... + nums[right]).
 

Example 1:

Input
["NumArray", "sumRange", "sumRange", "sumRange"]
[[[-2, 0, 3, -5, 2, -1]], [0, 2], [2, 5], [0, 5]]
Output
[null, 1, -1, -3]

Explanation
NumArray numArray = new NumArray([-2, 0, 3, -5, 2, -1]);
numArray.sumRange(0, 2); // return (-2) + 0 + 3 = 1
numArray.sumRange(2, 5); // return 3 + (-5) + 2 + (-1) = -1
numArray.sumRange(0, 5); // return (-2) + 0 + 3 + (-5) + 2 + (-1) = -3

```

Idea : 这是很经典的 prefix sum 问题

Python 解法如下：

```Python

class NumArray:

    def __init__(self, nums: List[int]):
        
        self.nums = nums
        self.prefix = [0]+[0]*len(nums)
        
        for i in range(len(nums)):
            self.prefix[i+1] = self.prefix[i]+nums[i]


    def sumRange(self, left: int, right: int) -> int:
        return self.prefix[right+1]-self.prefix[left]

```

Golang 解法如下：注意看它是如何调用的

```Go

type NumArray struct {
    prefix []int;
}


func Constructor(nums []int) NumArray {

    prefix:=make([]int,len(nums)+1)
    for i:=0;i<len(nums);i++ {
        prefix[i+1] = nums[i]+prefix[i]
    }
    
    return NumArray{prefix:prefix}
}


func (this *NumArray) SumRange(left int, right int) int {
    
    return this.prefix[right+1]-this.prefix[left]
}


/**
 * Your NumArray object will be instantiated and called as such:
 * obj := Constructor(nums);
 * param_1 := obj.SumRange(left,right);
 */


```

---

Java 解法如下：

```Java

class NumArray {
    
    private int[] res;
    public NumArray(int[] nums) {
        int len=nums.length;
        res = new int[len+1];
        for(int i=1;i<=len;i++) {
            res[i]=res[i-1]+nums[i-1];
        }
        
    }
    
    public int sumRange(int i, int j) {
        return res[j+1]-res[i];
    }
}


```