
Pretty Straightforward.
The code can be more concise though.

```Java

class Solution {
    public String addBinary(String a, String b) {
        if(a==null && b==null)
            return null;
        if(a==null || b==null)
            return a==null?b:a;
        StringBuilder res = new StringBuilder();
        int carry=0;
        int index1=a.length()-1,index2=b.length()-1;
        while(index1>=0 || index2>=0 || carry!=0) {
            
            int x=index1>=0?a.charAt(index1--)-'0':0;
            int y=index2>=0?b.charAt(index2--)-'0':0;
            int sum = x+y+carry;
            res.append(sum%2);
            carry=sum/2;
        }
        
        return res.reverse().toString();
    }
}

```