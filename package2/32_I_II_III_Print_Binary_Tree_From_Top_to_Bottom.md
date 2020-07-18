
Problem I

```Java

class Solution {
    public int[] levelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        List<Integer> res=new ArrayList<Integer>();
        // Queue API
        // https://www.geeksforgeeks.org/queue-interface-java/
        while(!queue.isEmpty()) {
            TreeNode currentNode=queue.poll();
            if(currentNode==null)
                continue;
            res.add(currentNode.val);
            queue.add(currentNode.left);
            queue.add(currentNode.right);
        }

        int[] n=new int[res.size()];
        for(int i=0;i<res.size();i++)
            n[i] = res.get(i);
        return n;
    }
}

```


---

Problem II

```Java

class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res=new ArrayList<List<Integer>>();
        traverse(root,res,1);
        return res;
    }

    public void traverse(TreeNode root,List<List<Integer>> res,int level) {
        if(root==null)
            return;
        if(level>res.size())
            res.add(new ArrayList<Integer>());
        res.get(level-1).add(root.val);
        traverse(root.left,res,level+1);
        traverse(root.right,res,level+1);   
    }
}

```

---

Problem III

Not the optimal one

```Java

class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res=new ArrayList<List<Integer>>();
        traverse(root,res,1);
        return res;
    }

    public void traverse(TreeNode root,List<List<Integer>> res,int level) {
        if(root==null)
            return;
        if(level>res.size())
            res.add(new ArrayList<Integer>());
        if(level%2==1){
        res.get(level-1).add(root.val);
        } else {
            res.get(level-1).add(0,root.val);
        }

        traverse(root.left,res,level+1);
        traverse(root.right,res,level+1);   
        
    }
}

```