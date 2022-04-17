
Mock the buy behaviour

```Java

class Solution {
    public int numWaterBottles(int numBottles, int numExchange) {
        int res=0;
        int emptyBottles=0;
        while(numBottles>0) {
            if(numBottles>0) {
                res+=numBottles;
                emptyBottles+=numBottles;
                numBottles=0;
               
            }

            if(emptyBottles>=numExchange) {
                numBottles+=(emptyBottles/numExchange);
                emptyBottles%=numExchange;
            }
        }
        
        return res;
    }
}

```