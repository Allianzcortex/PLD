
This is the 1st way :

```Java

class Solution {
    public int[] sortArrayByParity(int[] A) {
        int i=0,j=A.length-1;
        while(i<=j) {
            while(i<=j && A[i]%2==0)
                i++;
            while(i<=j && A[j]%2==1)
                j--;
            if(i<=j)
                swap(A,i,j);
        }
        
        return A;
    }
    
    public void swap(int[] A,int i,int j) {
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }
}

```

This is the 2nd way :

Everytime only iterate once so avoid possible outofBound Exception

Notice the key condition is `i<j` rather than `i<=j`

```Java

class Solution {
    public int[] sortArrayByParity(int[] A) {
        int i=0,j=A.length-1;
        
        while(i<j) {
            if(A[i]%2==0)
                i++;
            else {
                if(A[j]%2==1)
                    j--;
                if(A[j]%2==0) {
                    // odd even
                    swap(A,i++,j--);
                }
            }
        }
        
        return A;
    }
    
    public void swap(int[] A,int i,int j) {
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }
}

```