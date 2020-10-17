
A very classic problem :

Java Solution

```Java
class Solution {
    
    /**
    0 : Zero
    1-9 : One Two Nine
    10-19:Ten Eleven ... Nineteen
    20-99 : Twenty Thirty Ninety
    100-999: * Hundred + 
    1000-(1000000-1):* thousand
    1000000 - 1000000000:* million
    
    123 -> 1 Hunderd + 23 -> Twenty + 3 -> 3
    12345
    
    **/
    
    private final String[] less_than_10={"One","Two","Three","Four","Five","Six","Seven","Eight",
                                        "Nine"};
    private final String[] less_than_20={"Ten","Eleven","Twelve","Thirteen","Fourteen","Fifteen","Sixteen",
                                        "Seventeen","Eighteen","Nineteen"};
    private final String[] less_than_100={"Ten","Twenty","Thirty","Forty","Fifty","Sixty","Seventy",
                                        "Eighty","Ninety"};
    
    public String numberToWords(int num) {
        if(num==0)
            return "Zero";
        return solve(num);
    }
    
    public String solve(int num) {
        StringBuilder res = new StringBuilder();
        if(num==0){
            return "";
        }
        else if(num<10){
            res.append(less_than_10[num-1]);
        } else if(num<20){
            res.append(less_than_20[num-10]);
        } else if(num<100){
            res.append(less_than_100[num/10-1]+" "+solve(num%10));
        } else if(num<1000){
            res.append(less_than_10[num/100-1]+" Hundred "+solve(num%100));
        } else if(num<1000000){
            res.append(solve(num/1000)+" Thousand "+solve(num%1000));
        } else if(num<10_0000_0000){
            res.append(solve(num/100_0000)+" Million "+solve(num%100_0000));
        } else {
            res.append(solve(num/10_0000_0000)+" Billion "+solve(num%10_0000_0000));
        }
        
        return res.toString().trim();
    }
}

```

TODO : Add Python Solution later