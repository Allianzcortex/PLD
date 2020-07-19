
```Java

class Solution {
    public int translateNum(int num) {
        String number = String.valueOf(num);
        return solve(number,0);
    }

    public int solve(String number,int index) {
        if(index>=number.length())
            return 1;
        int res=1;
        res*=solve(number,index+1);
        if(index+1<number.length() && Integer.parseInt(number.substring(index,index+2))<=25 && Integer.parseInt(number.substring(index,index+2))>=10){
            int tempRes=1*solve(number,index+2);
            res+=tempRes;
        }
        return res;
    }
}

```