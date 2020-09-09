``` Java
class Solution {
    public String reverseVowels(String s) {
        /**
        A E I O U
        U O I E A
        **/
        if(s==null || s.length()==0)
            return s;
        int left=0,right=s.length()-1;
        char[] arr = s.toCharArray();
        
        // Notice that vowels contain both a & A
        String vowels = "aeiouAEIOU";
        
        while(left<right) {
            while(left<right && vowels.indexOf(arr[left])==-1)
                left+=1;
            while(left<right && vowels.indexOf(arr[right])==-1)
                right-=1;
        
            if(left!=right){
                swap(arr,left++,right--);
            }
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