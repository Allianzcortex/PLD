```Java

class Solution {
    public boolean verifyPostorder(int[] postorder) {
        if(postorder==null || postorder.length==0)
            return true;
        return validate(postorder,0,postorder.length-1);
    }

    public boolean validate(int[] postorder,int left,int right) {
        if(left>=right)
            return true;
        int pivot = postorder[right];
        int i=left,j=right-1;
        // cannot handle the case like [5,4,3,2,1] , only increasing
        // while(i<right && postorder[i]<pivot)
        //     i++;
        // while(j>left && postorder[j]>pivot)
        //     j--;
        // return i==j+1 && validate(postorder,left,j) && validate(postorder,i,right-1);

        while(i<=right && postorder[i]<pivot)
            i++;
        int middle=i;
        while(i<=right && postorder[i]>pivot)
            i++;
        return i==right && validate(postorder,left,middle-1) && validate(postorder,middle,right-1);
    }
    
}

```