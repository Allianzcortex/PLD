
Problem I :

```Java

class Solution {
    public int[] twoSum(int[] nums, int target) {
        int left=0,right=nums.length-1;
        while(left<=right) {
            int sum=nums[left]+nums[right];
            if(sum==target)
                return new int[]{nums[left],nums[right]};
            else if(sum<target)
                left+=1;
            else 
                right-=1;
        }

        return new int[]{-1,-1};
    }
}

```

---

Problem II :

Slding Window:
List<>.toArray() is a good usage.

```Java
class Solution {
    public int[][] findContinuousSequence(int target) {
        int[] pre=new int[target/2+1];
        int i=1,j=1;
        List<int[]> res = new ArrayList<>();
        int sum=1;
        while(i<=target/2) {
            if(sum<target){
                j++;
                sum+=j;
            } else if(sum>target) {
                sum-=i;
                i++;
            } else {
                int[] temp = new int[j-i+1];
                for(int k=i;k<=j;k++)
                    temp[k-i]=k;
                res.add(temp);
                sum-=i;
                i+=1;
            }
        }

        return res.toArray(new int[res.size()][]);
    }
}


```