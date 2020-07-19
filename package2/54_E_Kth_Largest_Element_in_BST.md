
This is not the optimal solution for it doesnot make the use of
[BST]

```Java
class Solution {
    public int kthLargest(TreeNode root, int k) {
        List<Integer> res=new ArrayList<Integer>();
        solve(root,res);
        return res.get(res.size()-k);
    }

    public void solve(TreeNode root,List<Integer> res) {
        if(root==null)
            return;
        solve(root.left,res);
        res.add(root.val);
        solve(root.right,res);
    }
}

```