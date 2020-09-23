
Since it's a BST,so certainly we will do in-order traverse and compare
two adjacent nodes.

This is iteration version :

```Java
class Solution {
    public int[] findMode(TreeNode root) {
       
        Integer prev=null;
        int count = 1;
        int maxFreq = 0;
        List<Integer> res = new ArrayList<>();
        
        Deque<TreeNode> stack = new ArrayDeque<>();
        
        while(!stack.isEmpty() || root!=null) {
            while(root!=null) {
                stack.push(root);
                root = root.left;
            }
            
            root = stack.pop();
            if(prev!=null) {
                // 2 cases
                if(root.val==prev) {
                    count+=1;
                } else {
                    count = 1;
                }
            }
         
            if(count>maxFreq)  {
                maxFreq = count;
                    res.clear();
                    res.add(root.val);

                } else if(count==maxFreq) {
                        res.add(root.val);
            }
            prev = root.val;
            root = root.right;
        }
    
    return res.stream().mapToInt(Integer::intValue).toArray();
    }   
}

```

TODO : add DFS version and Python version