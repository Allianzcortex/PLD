
Java Solution :

This is my initial solution, it works, but obiviously its
too heavy.

```Java

class Solution {
    public String reverseStr(String s, int k) {
        char[] arr = s.toCharArray();
        int len = s.length();
        int count = len/(2*k);
        for(int i=0;i<count+1;i++) {
            swapPart(arr,2*k*i,k);
        }
        return String.valueOf(arr);
    }
    
    public void swapPart(char[] arr,int start,int k) {
        if(start>arr.length-1)
            return;
        int end = 0;
        if(start+k>=arr.length) {
            end = arr.length-1;
        } else {
            end = Math.min(arr.length-1,start+k-1);
        }
        
        // swap all parts : from start -> end
        while(start<=end) {
            char temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }
}

```

---

A better approach will be :

The logic is pretty clear.

```Java

class Solution {
    public String reverseStr(String s, int k) {
        char[] arr=s.toCharArray();
        int n = s.length();
        int i=0;
        while(i<n) {
            int j = Math.min(i+k-1,n-1);
            swap(arr,i,j);
            i = i+2*k;
        }
        return String.valueOf(arr);
    }
    
    public void swap(char[] arr,int left,int right) {
        while(left<=right) {
            char temp = arr[left];
            arr[left++] = arr[right];
            arr[right--] = temp;
        }
    }
}


```