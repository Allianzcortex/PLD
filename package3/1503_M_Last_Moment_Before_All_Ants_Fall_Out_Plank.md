```Java
class Solution {
    public int getLastMoment(int n, int[] left, int[] right) {
        int leftCount=0;
        for(int i=0;i<left.length;i++)
            leftCount=Math.max(leftCount,left[i]);
        
        int rightCount=0;
        boolean flag=false;
        while(true) {
            // change in[] to stream()
            // Effective java8 lambda solution
            // https://stackify.com/streams-guide-java-8/
            // allMatch & any filters
            if(Arrays.stream(right).allMatch(x->x>=n)) {
                break;
            }
            for(int i=0;i<right.length;i++) {
                right[i]+=1;
            }
            rightCount+=1;
        }
     
        return Math.max(leftCount,rightCount);
    }
}

```