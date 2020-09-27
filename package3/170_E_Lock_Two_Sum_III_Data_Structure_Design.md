
There are 3 ways to do it , and there will be different
time&space complexities.

```
Design and implement a TwoSum class. It should support the following operations: add and find.

add - Add the number to an internal data structure.
find - Find if there exists any pair of numbers which sum is equal to the value.

Example 1:

add(1); add(3); add(5);
find(4) -> true
find(7) -> false
Example 2:

add(3); add(1); add(2);
find(3) -> true
```

O(n) & O(1) --

```Java

public class TwoSum {
    Map<Integer, Integer> map = new HashMap<Integer, Integer>();
    
	public void add(int number) {
	    if(map.containsKey(number)) {
	        map.put(number, map.get(number) + 1);
	    } else {
	        map.put(number, 1);
	    }
	}
 
	public boolean find(int value) {
	    for(int key : map.keySet()) {
	        int another = value - key;
	        if(another == key && map.get(key) > 1) {
	            return true;
	        } else if(another != key && map.containsKey(another)) {
	            return true;
	        }
	    }
	    return false;
	}
}
```