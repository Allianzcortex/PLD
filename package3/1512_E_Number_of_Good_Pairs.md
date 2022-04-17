```Java
class Solution {
    public int numIdenticalPairs(int[] nums) {
        Map<Integer,Integer> map=new HashMap<Integer,Integer>();
        for(int num:nums) {
            map.put(num,map.getOrDefault(num,0)+1);
        }
        int sum = 0;
        for(Map.Entry<Integer,Integer> entry:map.entrySet()) {
            int count=entry.getValue();
            int res=1;
            for(int i=count;i>=(count-1);i--)
                res*=i;
            sum+=res/2;
        }
        return sum;
    }
}

```

Actually a simple formulation will be enough :

n*(n-1)/2.