
This is my solution here :

```Java

class Solution {
    public String reverseOnlyLetters(String S) {
        char[] arr = S.toCharArray();
        int left=0,right=arr.length-1;
        
        while(left<right) {
            while(left<right && !Character.isLetter(arr[left]))
                left++;
            while(left<right && !Character.isLetter(arr[right]))
                right--;
            if(left<right)
                swap(arr,left++,right--);
        }
        
        return String.valueOf(arr);
    }
    
    public void swap(char[] arr,int left,int right) {
        char temp = arr[left];
        arr[left] = arr[right];
        arr[right] = temp;
    }
}

```


TODO : check other solutions later