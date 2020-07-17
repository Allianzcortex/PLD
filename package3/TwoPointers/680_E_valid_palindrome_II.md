```Java
class Solution {
      int delCount=0;
      public boolean validPalindrome(String s) {
          if(s==null || s.length()==0)
                return false;
           int i=0,j=s.length()-1;
           while(i<=j) {
               if(s.charAt(i)==s.charAt(j)){
                   i++;
                   j--;
               } else {
                   if(delCount==0){
                       delCount+=1;
                    return validPalindrome(s.substring(i,j)) || validPalindrome(s.substring(i+1,j+1));
                   }
                   return false;
               }
           }

           return true;
      }
}

```