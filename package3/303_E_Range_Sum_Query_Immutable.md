

Classic Prefix sum solution

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