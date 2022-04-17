```Java

class Solution {
    public boolean canMakeArithmeticProgression(int[] arr) {
        if(arr==null || arr.length<=1)
            return false;
        Arrays.sort(arr);
        int gap = arr[1]-arr[0];
        for(int i=1;i<arr.length;i++)
            if(arr[i]-arr[i-1]!=gap)
                return false;
        return true;
    }
}

```