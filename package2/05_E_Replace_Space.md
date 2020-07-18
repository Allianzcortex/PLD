```java

class Solution {
    public String replaceSpace(String s) {
        if(s==null || s.length()==0)
            return s;
        int spaceCount = 0;
        for(int i=0;i<s.length();i++)
            if(s.charAt(i)==' ')
                spaceCount+=1;
        char[] res=new char[s.length()+spaceCount*2];
        for(int i=s.length()-1,j=res.length-1;i>=0;i--) {
            if(s.charAt(i)==' ') {
                // insert 20%
                res[j--]='0';
                res[j--]='2';
                res[j--]='%';
            } else {
                res[j--]=s.charAt(i);
            }
        }

        return String.valueOf(res);
    }
}

```