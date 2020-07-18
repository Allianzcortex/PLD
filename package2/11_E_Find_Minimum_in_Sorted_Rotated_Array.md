There are lots of similar questions and all are benefical :

- 189 : Rotate Array    
- 34 : Find First and Last Position of Element in Sorted Array    
- 33 : Search in Rotated Sorted Array    
- 81 : Search in Rotated Sorted Array II    
- 153 : Find Minimum in Rotated Sorted Array    
- 154 : Find Minimum in Rotated Sorted Array II    


My Solution:

```Java
class Solution {
    public int minArray(int[] numbers) {
        int left=0,right=numbers.length-1;

        while(left<right) {
            int middle = left+(right-left)/2;
            if(numbers[middle]<numbers[right]) {
                    right = middle;
            } else if(numbers[middle]>numbers[right]){
                left = middle+1;
            } else {
                right-=1;
            }
        }

        return numbers[left];
        
    }
}

```