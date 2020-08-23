
There are 3 solutions :

1. Build the min heap

```Java

class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((n1,n2)->(n1-n2));
        for(int num:nums) {
            pq.offer(num);
            if(pq.size()>k)
                pq.poll();
        }
        
        return pq.peek();
    }
}

```

2. Build the max heap 

```Java
class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((n1,n2)->(n2-n1));
        for(int num:nums) {
            pq.offer(num);
        }
        
        while(k-->1)
            pq.poll();
        
        return pq.peek();
    }
}

```

3. use quick sort method

```Java


class Solution {
    public int findKthLargest(int[] nums, int k) {
        return quickSortKth(nums,k,0,nums.length-1);
    }
    
    public int quickSortKth(int[] nums,int k,int left,int right) {
        int start = left,end = right;
        int pivot = nums[left];
        while(left<right) {
            while(left<right && nums[right]>=pivot)
                right -=1;
            nums[left] = nums[right];
            while(left<right && nums[left]<=pivot)
                left+=1;
            nums[right] = nums[left];
            swap(nums,left,right);
        }
        // 1 2 3 4 5
        nums[left] = pivot;
        // smalled the pivot is in the left,bigger than pivot is in the right
        if(nums.length-left==k) {
            return nums[left];
        } else if(nums.length-left<k) {
            return quickSortKth(nums,k,start,left-1);
        } else {
            return quickSortKth(nums,k,left+1,end);
        }
    }
    
    public void swap(int[] nums,int left,int right) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }
}

```