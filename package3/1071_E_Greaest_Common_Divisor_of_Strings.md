
My Java Solution :

I donot read it the 2nd time

TODO : add Python solution

```Java
class Solution {
    public String gcdOfStrings(String str1, String str2) {
        if(str1.length()==0 || str2.length()==0)
            return "";
        String res = "";
        for(int i=1;i<=str2.length();i++) {
            if(str1.length()%i==0 && str2.length()%i==0) {
                String temp = str2.substring(0,i);
                if(isEqual(str1,temp,i) && isEqual(str2,temp,i))
                    res=temp;
            }
        }
        
        return res;   
    }
    
    public boolean isEqual(String s1,String s2,int len) {
        if(s1.length()==0)
            return true;
        return s1.substring(0,len).equals(s2) &&(isEqual(s1.substring(len),s2,len));
    }
}

```