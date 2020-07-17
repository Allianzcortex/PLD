```Java

class Solution {
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people,(a,b)->(a[0]==b[0]?a[1]-b[1]:b[0]-a[0]));
        List<int[]> queue = new LinkedList<>();
        
        for(int[] p:people) {
            queue.add(p[1],p);
        }
        int[][] res =new int[people.length][2];
        for(int i=0;i<queue.size();i++) {
            res[i][0]=queue.get(i)[0];
            res[i][1]=queue.get(i)[1];
        }
        
        return res;
        
        }
}


```