
Problem Description:

```

Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.

Notice that the solution set must not contain duplicate triplets.

 

Example 1:

Input: nums = [-1,0,1,2,-1,-4]
Output: [[-1,-1,2],[-1,0,1]]
Example 2:

Input: nums = []
Output: []
Example 3:

Input: nums = [0]
Output: []
 

Constraints:

0 <= nums.length <= 3000
-105 <= nums[i] <= 105

```


这道题就是 two sum II 的变种，关键是避免重复要怎么避免。给定的结果会包含 3 个元素
[(i,j,k)]

1. 对元素 i， 在移动的时候检查是否和前一个相等

```Python
if i>0 and nums[i]==nums[i-1]:
                continue
```

2. 对元素 j 和 k，就是在找到一个满足的例子时，要依次一直向右找和一直向左找

```Python
left += 1
while left<right and nums[left]==nums[left-1]:
    left += 1

right -= 1
while right>left and nums[right]==nums[right+1]:
    right-=1
```



Java 解法如下 :

```Java

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        for(int i=0;i<nums.length-2;i++) {
            if(nums[i]>0)
                break;
            if(i>0 && nums[i]==nums[i-1])
                continue;
            
            int low = i+1,high=nums.length-1,target = -nums[i];
            while(low<high) {
                if(nums[low]+nums[high]==target){
                    res.add(Arrays.asList(nums[i],nums[low],nums[high]));
                    low+=1;
                    high-=1;
                    
                    while(low<high && nums[low]==nums[low-1])
                        low+=1;
                    while(low<high && nums[high]==nums[high+1])
                        high-=1;
                } else if (nums[low]+nums[high]>target) {
                    high -= 1;
                }else {
                    low += 1;
                }
            }
        }
        
        return res;
    }
}

```

Python 解法如下 :

```Python

class Solution:
    def threeSum(self, nums: List[int]) -> List[List[int]]:
        # convert this problem to 2Sum II _ Input Sorted Array
        nums.sort()
        res = []

        for i in range(len(nums)-2):
            if(i>0 and nums[i]==nums[i-1]):
                continue

            left,right = i+1,len(nums)-1
            target = 0-nums[i]

            while left < right:
                sum_ = nums[left]+nums[right]
                if sum_==target:
                    res.append([nums[i],nums[left],nums[right]])
                    left += 1
                    while left<right and nums[left]==nums[left-1]:
                        left += 1
                    right -= 1
                    while left<right and nums[right]==nums[right+1]:
                        right -= 1
                elif sum_<target:
                    left+=1
                else:
                    right-=1
        
        return res

```