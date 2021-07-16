
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

The key is to avoid duplicated results :

we need to do it for both `i` and `left/right` :

case 1 for i :

```Python
if i>0 and nums[i]==nums[i-1]:
                continue
```

case 2 for left/right :

```Python
left += 1
while left<right and nums[left]==nums[left-1]:
    left += 1

right -= 1
while right>left and nums[right]==nums[right+1]:
    right-=1
```

Overall solutions will be :

Java Solution :

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

Python Solution :

```Python

class Solution:
    def threeSum(self, nums: List[int]) -> List[List[int]]:
        """a b c d"""
        nums.sort()

        res = []
        for i in range(0,len(nums)-2):
            left,right = i+1,len(nums)-1
            
            if i>0 and nums[i]==nums[i-1]:
                continue
            
            while left<right:

                _sum = nums[left]+nums[right]+nums[i]
                if _sum==0:
                    
                    res.append([nums[i],nums[left],nums[right]])
                    left += 1
                    while left<right and nums[left]==nums[left-1]:
                        left += 1
                    right -= 1
                    while right>left and nums[right]==nums[right+1]:
                        right-=1

                elif _sum<0:
                    left += 1
                else:
                    right -= 1
        
        return res

```