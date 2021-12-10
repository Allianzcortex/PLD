
Problem description:

```

You are given a sorted unique integer array nums.

Return the smallest sorted list of ranges that cover all the numbers in the array exactly. That is, each element of nums is covered by exactly one of the ranges, and there is no integer x such that x is in one of the ranges but not in nums.

Each range [a,b] in the list should be output as:

"a->b" if a != b
"a" if a == b
 

Example 1:

Input: nums = [0,1,2,4,5,7]
Output: ["0->2","4->5","7"]
Explanation: The ranges are:
[0,2] --> "0->2"
[4,5] --> "4->5"
[7,7] --> "7"
Example 2:

Input: nums = [0,2,3,4,6,8,9]
Output: ["0","2->4","6","8->9"]
Explanation: The ranges are:
[0,0] --> "0"
[2,4] --> "2->4"
[6,6] --> "6"
[8,9] --> "8->9"
Example 3:

Input: nums = []
Output: []
Example 4:

Input: nums = [-1]
Output: ["-1"]
Example 5:

Input: nums = [0]
Output: ["0"]
 

Constraints:

0 <= nums.length <= 20
-231 <= nums[i] <= 231 - 1
All the values of nums are unique.
nums is sorted in ascending order.

```

Basic idea:

这道题就是很典型的 two pointers 解法

Python 解法如下：

```Python

class Solution:
    def summaryRanges(self, nums: List[int]) -> List[str]:
        start = 0
        length = len(nums)
        res = []
    
        while start<=length-1:
            end = start

            while end<length-1 and nums[end]==nums[end+1]-1:
                end += 1
            
            if start==end:
                res.append(str(nums[start]))
            else:
                res.append(f"{nums[start]}->{nums[end]}")

            start = end + 1

        return res

```

Java 解法如下：

```Java

class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> res = new ArrayList<>();
        if(nums==null || nums.length==0)
            return res;
        
        int start=0,end=0;
        for(int i=0;i<nums.length;) {
            int j=i;
            while(j+1<nums.length && nums[j+1]-nums[j]==1)
                j+=1;
            if(i==j)
                res.add(String.valueOf(nums[i++]));
            else {
                res.add(""+nums[i]+"->"+nums[j]);
                i = j+1;
            }
        }
        
        return res;
    }
}

```