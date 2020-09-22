
Not sure whether there are other good solutions though.

```Java
class Solution {
    public String tree2str(TreeNode t) {
        if(t==null)
            return "";
        StringBuilder res = new StringBuilder();
        res.append(t.val);
        if(t.left!=null || t.right!=null)
            res.append("(").append(tree2str(t.left)).append(")");
        if(t.right!=null)
            res.append("(").append(tree2str(t.right)).append(")");
        
        return res.toString();
    }
}

```

TODO : check discussions & add Python 