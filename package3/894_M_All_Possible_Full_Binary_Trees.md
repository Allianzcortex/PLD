

Very similar with the problem 95 : Unique Binary Search Tree II

```Java

class Solution {
    public List<TreeNode> allPossibleFBT(int N) {
        List<TreeNode> res = new ArrayList<>();
        if(N==0)
            return res;
        if(N==1) {
            res.add(new TreeNode(0));
            return res;
        }
        
        N-=1;
        for(int i=1;i<N;i+=2) {
            List<TreeNode> leftNodes = allPossibleFBT(i);
            List<TreeNode> rightNodes = allPossibleFBT(N-i);
            
            for(TreeNode left:leftNodes) {
                for(TreeNode right:rightNodes) {
                     TreeNode root = new TreeNode(0);
                     root.left = left;
                     root.right = right;
                    res.add(root);
                }
            }
        }
        
        return res;
    }
}

```

TODO : add cache/hashmap solutions && add python solution