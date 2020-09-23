
Prerequites :

if `sum(gas)` >= `sum(cost)`, then there must be one path to travel through the whole circle.

```Java

class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int sumGas=0,sumCost=0,start=0,tank=0;
        
        for(int i=0;i<gas.length;i++) {
            sumGas += gas[i];
            sumCost += cost[i];
            tank+=(gas[i]-cost[i]);
            if(tank<0) {
                tank = 0;
                start = i+1;
            }
        }
        
        return sumGas<sumCost?-1:start;
    }
}

```