
Problem description:

```

You are given two jugs with capacities jug1Capacity and jug2Capacity liters. There is an infinite amount of water supply available. Determine whether it is possible to measure exactly targetCapacity liters using these two jugs.

If targetCapacity liters of water are measurable, you must have targetCapacity liters of water contained within one or both buckets by the end.

Operations allowed:

Fill any of the jugs with water.
Empty any of the jugs.
Pour water from one jug into another till the other jug is completely full, or the first jug itself is empty.
 

Example 1:

Input: jug1Capacity = 3, jug2Capacity = 5, targetCapacity = 4
Output: true
Explanation: The famous Die Hard example 
Example 2:

Input: jug1Capacity = 2, jug2Capacity = 6, targetCapacity = 5
Output: false
Example 3:

Input: jug1Capacity = 1, jug2Capacity = 2, targetCapacity = 3
Output: true
 

Constraints:

1 <= jug1Capacity, jug2Capacity, targetCapacity <= 106

```

Basic idea:

坦言，这道题我都想不出来自己当时是怎么做的：

```Java

class Solution {
    public boolean canMeasureWater(int x, int y, int z) {
            // only use 1 or 2
            if(x+y<z)
                return false;
            Queue<int[]> queue = new LinkedList<int[]>();
            Set<List<Integer>> set = new HashSet<List<Integer>>();

            int[] start=new int[]{0,0};
            queue.offer(start);

            while(!queue.isEmpty()) {
                int[] curState = queue.poll();
                
                List<Integer> array = new ArrayList<Integer>();
                for(int i:curState)
                    array.add(i);
                if(set.contains(array))
                    continue;

                int remainX=curState[0],remainY=curState[1];
                if(remainX==z || remainY==z || remainX+remainY==z)
                    return true;
        
                // set cannot use put
                // set.add(Arrays.asList(curState));
                set.add(array);
                /**
                把 X 壶的水灌进 Y 壶，直至灌满或倒空；
把 Y 壶的水灌进 X 壶，直至灌满或倒空；
把 X 壶灌满；
把 Y 壶灌满；
把 X 壶倒空；
把 Y 壶倒空。
                **/

                // case 1  put full to x
                queue.offer(new int[]{x,remainY});
                // case 2 put full to y
                queue.offer(new int[]{remainX,y});
                // case 3 empty x
                queue.offer(new int[]{0,remainY});
                // case 4 empty y
                queue.offer(new int[]{remainX,0});
                // case 5 put X to Y until Y is full or x is empty
                if(remainX>(y-remainY))
                    queue.offer(new int[]{remainX-y+remainY,y});
                else 
                    queue.offer(new int[]{0,remainY+remainX});
                // case 6 put Y to X until X is full or y is empty
                if(remainY>(x-remainX))
                    queue.offer(new int[]{x,remainY-x+remainX});
                else 
                    queue.offer(new int[]{remainX+remainY,0});
            }

            return false;
    }
}

```