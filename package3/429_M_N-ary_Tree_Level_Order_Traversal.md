

straight-forward solution

```Java

class Solution {
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root==null)
            return res;
        
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()) {
            List<Integer> temp = new ArrayList<>();
            int size = queue.size();
            for(int i=0;i<size;i++) {
                Node cur = queue.poll();
                temp.add(cur.val);
                for(Node node:cur.children) {
                    queue.add(node);
                }
            }
            res.add(temp);
        }
        
        return res;
    }
}


```