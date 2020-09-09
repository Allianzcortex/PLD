``` Java
class Solution {
    public boolean judgeSquareSum(int c) {
        int left=0,right=(int)Math.sqrt(c);
        // need to clarify whether a and b can be duplicated
        while(left<=right) {
            int powSum = left*left + right*right;
            if(powSum==c){
                return true;
            } else if(powSum>c){
                right-=1;
            } else {
                left+=1;
            }
        }
        
        return false;
    }
}

```