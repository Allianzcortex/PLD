
If we donot use built-in function,then basic idea will be :

1. Reverse the whole string

2. Reverse each word

3. clean up middle spaces between words

```Java
class Solution {
    public String reverseWords(String s) {
        char[] arr = s.toCharArray();
        int i=0,j=0;
        reverse(arr,0,arr.length-1);
        while(j<arr.length) {
            while(j<arr.length && arr[j]==' ')
                j++;
            if(j>=arr.length)
                j-=1;
            i = j;
            while(j<arr.length && arr[j]!=' ')
                j++;
        
            reverse(arr,i,j-1);
            j+=1;
        }
        
        i=0;
        j=arr.length-1;
        while(i<j && arr[i]==' ')
            i++;
        while(i<j && arr[j]==' ')
            j--;
        
        return cleanSpace(arr,i,j);
        // return String.valueOf(arr).substring(i,j+1);
    }
    
    public String cleanSpace(char[] arr,int left,int right) {
        if(left>right)
            return "";
        int i=left,j=left;
        while(j<=right) {
            while(j<=right && arr[j]==' ') j++;
            while(j<=right && arr[j]!=' ') arr[i++]=arr[j++];
            while(j<=right && arr[j]==' ') j++;
            if(j<=right) arr[i++]=' ';
        }
        
        return String.valueOf(arr).substring(left,i);
    }
    
    
    public void reverse(char[] arr,int left,int right) {
        while(left<right) {
            char temp = arr[left];
            arr[left++] = arr[right];
            arr[right--] = temp;
        }
    }
}


```

while if we use the built-in part :

```Java

class Solution {
    public String reverseWords(String s) {
        String[] words = s.trim().split("\\s+");
        // or we can use a StringBuilder
        /**
        for (int i = parts.length - 1; i > 0; i--) {
               out += parts[i] + " ";
            }
        **/
        Collections.reverse(Arrays.asList(words));
        return String.join(" ",words);
    }
}

```