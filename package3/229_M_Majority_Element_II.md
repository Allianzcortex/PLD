
The follow-up of 169 : Majority Element

Java Solution

Solution 1 :

Use HashMap to calculate and count.

```Java

class Solution {
    public List<Integer> majorityElement(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();
        List<Integer> res = new ArrayList<>();
        for(int num:nums)
            map.put(num,map.getOrDefault(num,0)+1);
        for(int num:map.keySet()) {
            if(map.get(num)>nums.length/3)
                res.add(num);
        }
        
        return res;
    }
}

```

Solution 2 : Moore Voting Algorithm

```Java

class Solution {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> res = new ArrayList<>();
        if(nums==null || nums.length==0)
            return res;
        
        int num1=nums[0],num2=nums[0],cnt1=0,cnt2=0;
        for(int i=0;i<nums.length;i++) {
            if(nums[i]==num1)
                cnt1+=1;
            else if(nums[i]==num2)
                cnt2+=1;
            else if(cnt1==0) {
                num1=nums[i];
                cnt1+=1;
            } else if(cnt2==0) {
                num2=nums[i];
                cnt2+=1;
            } else {
                cnt1-=1;
                cnt2-=1;
            }
        }
        
        cnt1=0;
        cnt2=0;
        for(int i=0;i<nums.length;i++) {
            if(nums[i]==num1)
                cnt1+=1;
            else if(nums[i]==num2)
                cnt2+=1;
        }
        
        if(cnt1>nums.length/3)
            res.add(num1);
        if(cnt2>nums.length/3)
            res.add(num2);
        
        return res;
    }
}

```

TODO : need to take some time to fully understand the moore voting algorithm

TODO : add Python solution

