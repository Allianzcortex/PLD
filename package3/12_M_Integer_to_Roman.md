
Basic Caluation , should be pretty straight-forward

Java Solution :

```Java

class Solution {
    public String intToRoman(int num) {
        int[] value={1000,900,500,400,100,90,50,40,10,9,5,4,1};
        String[] words={"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};

        StringBuilder res = new StringBuilder();
        int i=0;
        while(num>0) {
            while(num>=value[i]) {
                num-=value[i];
                res.append(words[i]);
            }
            i++;
        }
                        
        return res.toString();
    }
}

```

Python Solution, very similar idea :

```Python

class Solution:
    def intToRoman(self, num: int) -> str:
        """
        I             1
        V             5
        X             10
        L             50
        C             100
        D             500
        M             1000
        """
        
        vals = [1000,900,500,400,100,90,50,40,10,9,5,4,1]
        nums = ["M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"]
        res = ""
        for v,n in zip(vals,nums):
            res += (num//v)*n
            num %= v
        
        return res
        

```