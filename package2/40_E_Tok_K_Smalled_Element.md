
There are multiple solutions.
I just pickup heap.
More solutions will be added later.

```Java

class Solution {
    public int[] getLeastNumbers(int[] arr, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->(b-a));
        for(int num:arr) {
            pq.offer(num);
            if(pq.size()>k)
                pq.poll();
        }
        int[] res = new int[k];
        for(int i=0;i<k;i++)
            res[i] = pq.poll();
        return res;
    }
}

```