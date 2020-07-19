```Java

class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        traverse(res,new ArrayList<Integer>(),root,0,sum);
        return res;
    }

    public void traverse(List<List<Integer>> res,List<Integer> current,TreeNode root,int currentSum, int sum) {
        if(root==null)
            return;
        if(root.left==null && root.right==null && currentSum+root.val==sum){
            current.add(root.val);
           // copy & remove again,this is the key step
            res.add(new ArrayList(current));
            current.remove(current.size()-1);
            return;
        }
        
        current.add(root.val);
        traverse(res,current,root.left,currentSum+root.val,sum);
        traverse(res,current,root.right,currentSum+root.val,sum);
        current.remove(current.size()-1);
    }
}

```