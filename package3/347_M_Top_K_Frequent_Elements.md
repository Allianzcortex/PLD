There are 3 solutions

1. Bucket Sort

2. Build a MaxHeap/MinHeap

3. use treeMap(Map with order)


1. Solution 1. Bucket Sort 

The most intuitive solution, use Array to store the 
frequency of words and iterate(reversely order) through
the array.

```Java
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int num:nums) {
            map.put(num,map.getOrDefault(num,0)+1);
        }
    
    // defin an array consisting of pure List.
    List<Integer>[] res = new List[nums.length+1];
    for(int num:map.keySet()) {
        int freq = map.get(num);
        if(res[freq]==null)
            res[freq] = new LinkedList<Integer>();
        res[freq].add(num);
    }
    int[] output = new int[k];
    for(int i=res.length-1;i>=0 && k>0;i--) {
        if(res[i]!=null) {
            // unfortunately we cannot use lambda here
            //  res[i].forEach(x->{output[--k]=x;});
            for(int num:res[i]) {
                output[--k] = num;
            }
        }
    }
    
    return output;
        
    }
}

```


2. Solution 2 MaxHeap

``` Java

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int num:nums)
            map.put(num,map.getOrDefault(num,0)+1);
        
        PriorityQueue<Map.Entry<Integer,Integer>> maxHeap = 
            new PriorityQueue<>((a,b)->(b.getValue()-a.getValue()));
        for(Map.Entry<Integer,Integer> entry:map.entrySet()) {
            maxHeap.add(entry);
        }
        
        int[] output = new int[k];
        for(int i=0;i<k;i++)
            output[i] = maxHeap.poll().getKey();
        return output;
    }
}

```

3. Solution 3 TreeMap 

