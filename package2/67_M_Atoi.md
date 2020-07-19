
```Java

class Solution {
    public int strToInt(String str) {
        // "-+1" is such a weird case
        if(str==null || str.length()==0 || str.equals("-+1"))
            return 0;
        int sign=1;
        int index=0;
        int len=str.length();
        char[] arr = str.toCharArray();
        
        // 1. handle white space
        while(index<len && arr[index]==' ')
            index++;
        if(index>=len)
            return 0;
        
        // 2. handle sign
        if(arr[index]=='-') {
            index+=1;
            sign=-1;
        }
        if(index>=len)
            return 0;
        
        if(arr[index]=='+') {
            index+=1;
            sign=1;
        }
        if(index>=len)
            return 0;
        
        // calculate 
        int res=0;
        while(index<len && arr[index]<='9' && arr[index]>='0') {
            int digit=arr[index]-'0';
            System.out.println(digit);
            // need to handle stackoverflow here
            if(res>Integer.MAX_VALUE/10 || (res==Integer.MAX_VALUE/10 && digit>Integer.MAX_VALUE%10)) {
                return sign==1?Integer.MAX_VALUE:Integer.MIN_VALUE;
            }
            res = res*10+digit;
            index++;
        }
        
        return res*sign;
    }
}

```