Many ways to implement the basic sort function.

This is my quick-sort choice : 

```Java
class Solution {
    public int[] sortArray(int[] nums) {
        if(nums==null || nums.length==0)
            return new int[]{};
        quickSort(nums,0,nums.length-1);
        return nums;
    }
    
    public void quickSort(int[] nums,int left,int right){
        if(left>=right)
            return;
        int pivot = findPivot(nums,left,right);
        quickSort(nums,left,pivot-1);
        quickSort(nums,pivot+1,right);
        
    }
    
    public int findPivot(int[] nums,int left,int right) {
        int pivot = nums[left];
        while(left<right) {
            while(left<right && nums[right]>=pivot)
                right-=1;
            nums[left]=nums[right];
            
            while(left<right && nums[left]<=pivot)
                left+=1;
            nums[right]=nums[left];
            swap(nums,left,right);
        }
        nums[left]=pivot;
        return left;
    }
    
    public void swap(int[] nums,int left,int right) {
        int temp=nums[left];
        nums[left]=nums[right];
        nums[right]=temp;
    }
}

```

This is Merge Sort 

```Java
class Solution {
    public int[] sortArray(int[] nums) {
        mergeSort(nums,0,nums.length-1);
        return nums;
    }
    
    public void mergeSort(int[] nums,int left,int right) {
        if(left>=right)
            return;
        int middle = left + (right-left)/2;
        mergeSort(nums,left,middle);
        mergeSort(nums,middle+1,right);
        merge(nums,left,middle,right);
    }
    
    public void merge(int[] nums,int left,int middle,int right) {
        int[] temp = new int[right-left+1];
        int i=left,j=middle+1;
        int index = 0;
        while(i<=middle && j<=right) {
            if(nums[i]<nums[j])
                temp[index++]=nums[i++];
            else
                temp[index++]=nums[j++];
        }
        
        while(i<=middle)
            temp[index++]=nums[i++];
        while(j<=right)
            temp[index++]=nums[j++];
        
        for(i=0;i<temp.length;i++)
            nums[left+i]=temp[i];
    }
}

```

This is bubble sort 

```Java

class Solution {
    public int[] sortArray(int[] nums) {
        // 3 5 4 1 2
        // * * * * 5
        // * * * 4 5
        // * * 3 4 5
        int n=nums.length;
        for(int i=0;i<n;i++) {
            for(int j=0;j<n-i-1;j++) {
                if(nums[j]>nums[j+1])
                    swap(nums,j,j+1);
            }
        }
        
        return nums;
    }
    
    public void swap(int[] nums,int i,int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}

```

---

The same idea with Python quicksort implementation , and it becomes
TLE with the new test metrics.

```Python

class Solution:
    def sortArray(self, nums: List[int]) -> List[int]:
        self.quickSort(nums,0,len(nums)-1)
        return nums
    
    def quickSort(self, nums, left,right):
        if(left>=right):
            return
        pivot = self.findPivot(nums,left,right)
        self.quickSort(nums,left,pivot-1)
        self.quickSort(nums,pivot+1,right)
    
    def findPivot(self,nums,left,right):
        pivot = nums[left]
        while(left<right):
            while(left<right and nums[right]>=pivot):
                right-=1
            nums[left]=nums[right]
            while(left<right and nums[left]<=pivot):
                left+=1
            nums[right]=nums[left]
            nums[left],nums[right] = nums[right],nums[left]
        nums[left]=pivot
        return left
```

And here is Golang quicksort implementation:

```Golang

func sortArray(nums []int) []int {
    
    if nums==nil || len(nums)==0 {
        return nums
    }
    
    quickSort(nums,0,len(nums)-1)
    return nums
}

func quickSort(nums []int,left int,right int) {
    
    if left>=right {
        return
    }
    
    pivot := findPivot(nums,left,right)
    quickSort(nums,left,pivot-1)
    quickSort(nums,pivot+1,right)
}


func findPivot(nums[] int,left int,right int) int {
    
    pivot:=nums[left]
    
    for left<right {
        
        // search from right to left,find the element that is smaller than pivot
        for left<right && nums[right]>=pivot {
            right -= 1
        }
        nums[left] = nums[right]
        
        // search from left to right,find the element that is greater than pivot
        for left<right && nums[left]<=pivot {
            left += 1
        }
        nums[right] = nums[left]
        
        // swap left,right
        nums[left],nums[right] = nums[right],nums[left]
        
    }
    
    nums[left] = pivot
    return left
    
}
```