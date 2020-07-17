We have 2 ways to solve this problem :

1. Heap

2. Quick Select(with the same idea as quick sort)


Solution 1：use pq to build a minheap

```Java
class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int num:nums) {
            pq.offer(num);
            if(pq.size()>k)
                pq.poll();
        }
        return pq.poll();
    }
}
```

Solution 2: use quicksort to find the partition

```Java
class Solution {
    public int findKthLargest(int[] nums, int k) {
        return findNumber(nums,k,0,nums.length-1);
    }

    public void swap(int[] nums,int left,int right) {
        int temp=nums[left];
        nums[left]=nums[right];
        nums[right]=temp;
    }

    public int findNumber(int[] nums,int index,int left,int right) {
        int start = left , end = right;
        int pivot = nums[left];
        while(left<right) {
            while(left<right && nums[right]>=pivot)
                right -= 1;
            nums[left]=nums[right];
            while(left<right && nums[left]<=pivot)
                left+=1;
            nums[right]=nums[left];
            swap(nums,left,right);
        }
        // left will be index, 2 1 3 5 6 4
        nums[left]=pivot;
        if(left==nums.length-index){
            return pivot;
        } else if(left<nums.length-index){
            return findNumber(nums,index,left+1,end);
        } else {
            return findNumber(nums,index,start,left-1);
        }
    }
}

```