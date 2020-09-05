There solutions 1:

1. Best one :

reverse 3 times:

```Java
class Solution {
    
    /**
    [1,2,3,4,5,6,7], k = 3
    
    [1,2,3,4,5,6,7]
           |
    [7,6,5,4,3,2,1]
           |
    [5,6,7,4,3,2,1]
           |
    [5,6,7,1,2,3,4]
    
    **/
    public void rotate(int[] nums, int k) {
        int len = nums.length;
        k=k%len;
        reverse(nums,0,len-1);
        reverse(nums,0,k-1);
        reverse(nums,k,len-1);
    }
    
    public void reverse(int[] arr,int left,int right) {
        int temp;
        while(left<right) {
            temp = arr[right];
            arr[right--]=arr[left];
            arr[left++]=temp;
        }
    }
}

```

2. Solution2 copy the old array and find the relation

```Java
class Solution {
    public void rotate(int[] nums, int k) {
        int len =nums.length;
        int[] oldNums = nums.clone();
        k%=len;
        
        for(int i=0;i<len;i++) {
            nums[(i+k)%len] = oldNums[i];
        }
        
    }
}

```

3. Mock the move behaviour

```Java

class Solution {
    public void rotate(int[] nums, int k) {
        int len = nums.length;
        k%=len;
        for(int i=0;i<k;i++) {
            int temp = nums[len-1];
            for(int j=len-2;j>=0;j--)
                nums[j+1]=nums[j];
            nums[0]=temp;
        }
    }
}


```

---


TODO add python solution