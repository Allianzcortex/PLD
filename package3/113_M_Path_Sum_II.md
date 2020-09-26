
Just add Basic DFS solution

```Java

class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<>();
        if(root==null)
            return res;
        
        List<Integer> path = new ArrayList<>();
        path.add(root.val);
        traverse(root,sum,res,path);
        return res;
    }

    public void traverse(TreeNode root,int sum,List<List<Integer>> res,List<Integer> path) {
        if(root==null)
            return;
        sum -= root.val;
        if(root.left==null && root.right==null && sum==0) {
            res.add(new ArrayList<>(path));
            return;
        }
        if(root.left!=null) {
            path.add(root.left.val);
            traverse(root.left,sum,res,path);
            path.remove(path.size()-1);
        }
        if(root.right!=null) {
            path.add(root.right.val);
            traverse(root.right,sum,res,path);
            path.remove(path.size()-1);
        }
    }
}

```

Will add iterative / Python solution later