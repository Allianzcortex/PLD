
All those 2 problems are related with bit operations.

Not very necessary to check.

Problem I :

```Java

class Solution {
    public int[] singleNumbers(int[] nums) {
        
        int k = 0;
        
        for(int num: nums) {
            k ^= num;
        }
        
        // get the lowest digit
        int mask = 1;

        //or use mask = k & (-k)
        while((k & mask) == 0) {
            mask <<= 1;
        }
        
        int a = 0;
        int b = 0;
        
        for(int num: nums) {
            if((num & mask) == 0) {
                a ^= num;
            } else {
                b ^= num;
            }
        }
        
        return new int[]{a, b};
    }
}

```

---

Problem II : 

```Go

func singleNumber(nums []int) int {
    m:=make(map[int]int)
    for _,v:=range(nums) {
        m[v]+=1;
    }
    for i,v:=range(m) {
        if(v==1) {
            return i;
        }
    }
    return -1;
}


```