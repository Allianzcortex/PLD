
Problem description:

```

Given the root of a binary tree, return all duplicate subtrees.

For each kind of duplicate subtrees, you only need to return the root node of any one of them.

Two trees are duplicate if they have the same structure with the same node values.

 

Example 1:


Input: root = [1,2,3,4,null,2,4,null,null,4]
Output: [[2,4],[4]]
Example 2:


Input: root = [2,1,1]
Output: [[1]]
Example 3:


Input: root = [2,2,2,3,null,3,null]
Output: [[2,3],[3]]
 

Constraints:

The number of the nodes in the tree will be in the range [1, 10^4]
-200 <= Node.val <= 200

```

Basic idea:

这道题自己思路是正确的，这就是很典型的递归问题，应该在已有这个思路的时候
脑子里就浮现出基本的解题框架来。

关键还是做的太少，想的太少。

自己已经想到了先判断左右子树是否相等
再结合 root.val 判断整个树是否相等，所以要用 postorder 来解决。

解法如下：

```Java

class Solution {
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        Map<String,Integer> map = new HashMap<>();
        List<TreeNode> res = new ArrayList<>();
        
        traverse(root,map,res);
        return res;
    }
    
    private String traverse(TreeNode root,Map<String,Integer> map,List<TreeNode> res) {
        if(root==null) {
            return "#";
        }
        
        String uniqueId =  traverse(root.left,map,res)+","+traverse(root.right,map,res)+","+ root.val;
        map.put(uniqueId,map.getOrDefault(uniqueId,0)+1);
        
        // 为什么要先增加值在用 map.get(uniqueId)==2？因为如果有 3 个乃至
        // 更多的 subtree 相等时，也只返回一个
        if(map.get(uniqueId)==2) {
            res.add(root);
            return uniqueId;
        }
        
        return uniqueId;
    }
}

```



