
The basic idea is simple : 

1. Use 1st while loop to pass the whole word

2. Use 2nd while loop to skip the white space

```Java
class Solution {
    public String reverseWords(String s) {
        char[] arr = s.toCharArray();
        int left=0,right = 0;
        while(right<arr.length) {
            while(right<arr.length && arr[right]!=' ')
                right++;
            reverseWord(arr,left,right-1);
            while(right<arr.length && arr[right]==' ')
                right++;
            left = right;
        }
        
        return String.valueOf(arr);
    }

    public void reverseWord(char[] arr,int left,int right) {
        if(left>=right)
            return;
        
        while(left<right) {
            char temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
    }
}

```